package controller;

import dao.FornecedorDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cidade;
import model.Contato;
import model.Endereco;
import model.Estado;
import model.Fornecedor;
import model.PessoaJuridica;
import util.Mensagens;
import util.Titulos;
import util.Util;
import util.Valida;
import view.FornecedorView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados do objeto Fornecedor
 *
 * @since 24/03/2021
 * @author Willian Carlos Gomes
 * @version 1.0
 */
public class FornecedorController {

    //objeto Aluno para incluir ou alterar
    private FornecedorView fornecedorView;
    private MenuController menuController;
    private ArrayList<Estado> listaEstados;
    private ArrayList<Cidade> listaCidades;
    private ArrayList<Fornecedor> listaFornecedores;

    private PessoaJuridica pessoa;
    private Endereco endereco;
    private Contato contato;
    private Fornecedor fornecedor;
    private boolean alterar;

    public FornecedorController(FornecedorView fornecedorView) {
        this.fornecedorView = fornecedorView;
    }

    public FornecedorController() {
    }

    
    /*
     * método para carregar a ação do botão novo
     */
    public void acaoBotaoNovo() {
        alterar = false;
        this.fornecedorView.getBtNovo().setEnabled(false);
        this.fornecedorView.getBtAlterar().setEnabled(false);
        this.fornecedorView.getBtExcluir().setEnabled(false);
        this.fornecedorView.getBtSair().setEnabled(false);
        this.fornecedorView.getBtSalvarFornecedor().setEnabled(true);
        this.fornecedorView.getBtCancelar().setEnabled(true);
        desbloquearCampos();
        this.fornecedorView.getFtfCnpj().grabFocus();
    }

    public void acaoBotaoAlterar() {
        alterar = true;
        if (fornecedorView.getFornecedoresTabela().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.selecioneFornecedor, Titulos.cadastroFornecedor, 0);
        } else {
            fornecedor = listaFornecedores.get(fornecedorView.getFornecedoresTabela().getSelectedRow());
            bloqueioAlterar();
            carregarTela();
        }
    }

    public void acaoBotaoExcluir() {
        if (fornecedorView.getFornecedoresTabela().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.selecioneFornecedor, Titulos.cadastroFornecedor, 0);
        } else {
            int opcao = JOptionPane.showConfirmDialog(fornecedorView, Mensagens.excluirFornecedor, Titulos.cadastroFornecedor, 2);
        if (opcao == JOptionPane.YES_OPTION) {
            fornecedor = listaFornecedores.get(fornecedorView.getFornecedoresTabela().getSelectedRow());
            
            new FornecedorDAO().excluir(fornecedor);
            new ContatoController().excluir(fornecedor.getContatoIdContato());
            new EnderecoController().excluir(fornecedor.getEnderecoIdEndereco());
            new PessoaJuridicaController().excluir(fornecedor.getPessoaJuridicaIdPessoaJuridica());
            
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.fornecedorExcluido, Titulos.cadastroFornecedor, 1);
            carregarTabela();
        }
        
        }
    }

    public void acaoBotaoSair() {
        this.fornecedorView.dispose();
        menuController.desbloquearMenu();
    }

    public void acaoBotaoSalvar() {
        if (validarDados()) {
            if (alterar) {
                pessoa = fornecedor.getPessoaJuridicaIdPessoaJuridica();
                endereco = fornecedor.getEnderecoIdEndereco();
                contato = fornecedor.getContatoIdContato();

            } else { //incluir
                pessoa = new PessoaJuridica();
                endereco = new Endereco();
                contato = new Contato();
                fornecedor = new Fornecedor();
            }
            pessoa = getPessoaJuridica();
            endereco = getEndereco();
            contato = getContato();

            new PessoaJuridicaController().salvar(pessoa);
            new EnderecoController().salvar(endereco);
            new ContatoController().salvar(contato);

            fornecedor.setContato(this.fornecedorView.getTfContato().getText());
            fornecedor.setPessoaJuridicaIdPessoaJuridica(pessoa);
            fornecedor.setEnderecoIdEndereco(endereco);
            fornecedor.setContatoIdContato(contato);

            try {
                new FornecedorDAO().salvar(fornecedor);
                JOptionPane.showMessageDialog(fornecedorView, Mensagens.fornecedorSalvo, Titulos.cadastroFornecedor, 1);
                limparCampos();
                bloqueioInicial();
                carregarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(fornecedorView, Mensagens.fornecedorErro, Titulos.cadastroFornecedor, 1);
            }
        }
    }

    public void acaoBotaoCancelar() {
        this.fornecedorView.getBtNovo().setEnabled(true);
        this.fornecedorView.getBtAlterar().setEnabled(true);
        this.fornecedorView.getBtExcluir().setEnabled(true);
        this.fornecedorView.getBtSair().setEnabled(true);
        this.fornecedorView.getBtSalvarFornecedor().setEnabled(false);
        this.fornecedorView.getBtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void bloqueioInicial() {
        this.fornecedorView.getBtNovo().setEnabled(true);
        this.fornecedorView.getBtAlterar().setEnabled(true);
        this.fornecedorView.getBtExcluir().setEnabled(true);
        this.fornecedorView.getBtSair().setEnabled(true);
        this.fornecedorView.getBtSalvarFornecedor().setEnabled(false);
        this.fornecedorView.getBtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.fornecedorView.getFtfCnpj().setEditable(false);
        this.fornecedorView.getTfRazaoSocial().setEditable(false);
        this.fornecedorView.getTfEnd().setEditable(false);
        this.fornecedorView.getTfComplemento().setEditable(false);
        this.fornecedorView.getFtfInscrEstadual().setEditable(false);
        this.fornecedorView.getFtfDataFundacao().setEditable(false);
        this.fornecedorView.getTfNumero().setEditable(false);
        this.fornecedorView.getTfBairro().setEditable(false);
        this.fornecedorView.getFtfCep().setEditable(false);
        this.fornecedorView.getTfContato().setEditable(false);
        this.fornecedorView.getFtfCelular().setEditable(false);
        this.fornecedorView.getFtfTelefone().setEditable(false);
        this.fornecedorView.getTfEmail().setEditable(false);
        this.fornecedorView.getCbxCidade().setEnabled(false);
        this.fornecedorView.getCbxEstado().setEnabled(false);

    }

    public void desbloquearCampos() {
        this.fornecedorView.getFtfCnpj().setEditable(true);
        this.fornecedorView.getTfRazaoSocial().setEditable(true);
        this.fornecedorView.getTfEnd().setEditable(true);
        this.fornecedorView.getTfComplemento().setEditable(true);
        this.fornecedorView.getFtfInscrEstadual().setEditable(true);
        this.fornecedorView.getFtfDataFundacao().setEditable(true);
        this.fornecedorView.getTfNumero().setEditable(true);
        this.fornecedorView.getTfBairro().setEditable(true);
        this.fornecedorView.getTfContato().setEditable(true);
        this.fornecedorView.getFtfCep().setEditable(true);
        this.fornecedorView.getFtfCelular().setEditable(true);
        this.fornecedorView.getFtfTelefone().setEditable(true);
        this.fornecedorView.getTfEmail().setEditable(true);
        this.fornecedorView.getCbxEstado().setEnabled(true);
    }

    public void limparCampos() {
        this.fornecedorView.getFtfCnpj().setValue(null);
        this.fornecedorView.getTfRazaoSocial().setText(null);
        this.fornecedorView.getTfEnd().setText(null);
        this.fornecedorView.getTfComplemento().setText(null);
        this.fornecedorView.getFtfInscrEstadual().setValue(null);
        this.fornecedorView.getFtfDataFundacao().setValue(null);
        this.fornecedorView.getTfNumero().setText(null);
        this.fornecedorView.getTfBairro().setText(null);
        this.fornecedorView.getTfContato().setText(null);
        this.fornecedorView.getFtfCep().setValue(null);
        this.fornecedorView.getFtfCelular().setValue(null);
        this.fornecedorView.getFtfTelefone().setValue(null);
        this.fornecedorView.getTfEmail().setText(null);
        this.fornecedorView.getCbxCidade().setSelectedIndex(0);
        this.fornecedorView.getCbxEstado().setSelectedIndex(0);
    }

    /*
     * método para carregar a combo de estado
     */
    public void carregaComboEstado() {

        listaEstados = new EstadoController().buscarTodos();
        this.fornecedorView.getCbxEstado().addItem("- SELECIONAR -");
        for (Estado estado : listaEstados) {
            this.fornecedorView.getCbxEstado().addItem(estado.getNome());
        }

    }

    /*
     * método para carregar a combo de cidade
     */
    public void carregaComboCidade() {

        int indice = this.fornecedorView.getCbxEstado().getSelectedIndex() - 1;
        if (indice >= 0) {
            try {
                listaCidades = new CidadeController().buscarPorEstado(listaEstados.get(indice));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(fornecedorView, Mensagens.erroConsultaCidades, Titulos.carregamentoDados, 0);
                Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //removendo todos os dados da combo
            this.fornecedorView.getCbxCidade().removeAllItems();
            this.fornecedorView.getCbxCidade().addItem("- SELECIONAR -");
            for (Cidade cidade : listaCidades) {
                this.fornecedorView.getCbxCidade().addItem(cidade.getNome());
            }
            this.fornecedorView.getCbxCidade().setEnabled(true);
        }

    }
    /*
     * método para validar dados
     */

    private boolean validarDados() {
        //validando o CNPJ
        if (Valida.isCnpjVazio(this.fornecedorView.getFtfCnpj().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.cnpjVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfCnpj().grabFocus();
            return false;

        } else if (Valida.isCnpjInvalido(this.fornecedorView.getFtfCnpj().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.cnpjInvalido, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfCnpj().grabFocus();
            return false;
        }
        //validando a Inscrição Estadual
        if (Valida.isInscricaoEstadualVazio(this.fornecedorView.getFtfInscrEstadual().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.inscricaoEstadualVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfInscrEstadual().grabFocus();
            return false;

        } else if (Valida.isInscricaoEstadualInvalido(this.fornecedorView.getFtfInscrEstadual().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.inscricaoEstadualInvalido, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfInscrEstadual().grabFocus();
            return false;
        }

        //Validando a Razão Social
        if (Valida.isEmptyOrNull(this.fornecedorView.getTfRazaoSocial().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.razaoSocialVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfRazaoSocial().grabFocus();
            return false;
        }

        //validando a Data de Fundação
        if (Valida.isDataVazia(this.fornecedorView.getFtfDataFundacao().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.dataFundacaoVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfDataFundacao().grabFocus();
            return false;

        } else if (Valida.isDataInvalida(this.fornecedorView.getFtfDataFundacao().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.dataFundacaoInvalida, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfDataFundacao().grabFocus();
            return false;
        }

        //validando o endereço
        if (Valida.isEmptyOrNull(this.fornecedorView.getTfEnd().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.enderecoVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfEnd().grabFocus();
            return false;
        }

        //validando o número
        if (Valida.isEmptyOrNull(this.fornecedorView.getTfNumero().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.numeroVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfNumero().grabFocus();
            return false;
        } else if (!Valida.isInteger(this.fornecedorView.getTfNumero().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.numeroEnderecoInvalido, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfNumero().grabFocus();
            return false;
        }

        //validando o bairro
        if (Valida.isEmptyOrNull(this.fornecedorView.getTfBairro().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.bairroVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfBairro().grabFocus();
            return false;
        }

        //validando o estado
        if (Valida.isComboInvalida(this.fornecedorView.getCbxEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.estadoVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getCbxEstado().grabFocus();
            return false;
        }

        //validando a cidade
        if (Valida.isComboInvalida(this.fornecedorView.getCbxCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.cidadeVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getCbxCidade().grabFocus();
            return false;
        }

        // validando o cep
        if (Valida.isCepVazio(this.fornecedorView.getFtfCep().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.cepVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfCep().grabFocus();
            return false;
        }

        // validando o celular
        if (Valida.isCelularVazio(this.fornecedorView.getFtfCelular().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.celularVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getFtfCelular().grabFocus();
            return false;
        }

        //validando o Contato
        if (Valida.isEmptyOrNull(this.fornecedorView.getTfContato().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.contatoVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfContato().grabFocus();
            return false;
        } else if (Valida.isInteger(this.fornecedorView.getTfContato().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.contatoInvalido, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfContato().grabFocus();
            return false;
        }

        //validando o email
        if (Valida.isEmptyOrNull(
                this.fornecedorView.getTfEmail().getText())) {
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.emailVazio, Titulos.cadastroFornecedor, 0);
            this.fornecedorView.getTfEmail().grabFocus();
            return false;
        }

        // Retornando verdadeiro para o método caso não existam discrepâncias
        return true;
    }

    /*
     * método psra retornar um novo objeto
     */
    private PessoaJuridica getPessoaJuridica() {
        pessoa.setCnpj(this.fornecedorView.getFtfCnpj().getText());
        pessoa.setInscricaoEstadual(this.fornecedorView.getFtfInscrEstadual().getText());
        pessoa.setRazaoSocial(this.fornecedorView.getTfRazaoSocial().getText());
        pessoa.setDataFundacao(this.fornecedorView.getFtfDataFundacao().getText());
        return pessoa;
    }

    /*
     * método psra retornar um novo objeto
     */
    private Endereco getEndereco() {
        endereco.setNome(this.fornecedorView.getTfEnd().getText());
        endereco.setNumero(Util.getInteger(this.fornecedorView.getTfNumero().getText()));
        endereco.setComplemento(this.fornecedorView.getTfComplemento().getText());
        endereco.setBairro(this.fornecedorView.getTfBairro().getText());
        endereco.setCep(this.fornecedorView.getFtfCep().getText());
        endereco.setCidadeIdCidade(listaCidades.get(this.fornecedorView.getCbxCidade().getSelectedIndex() - 1));
        return endereco;
    }

    /*
     * método psra retornar um novo objeto
     */
    private Contato getContato() {
        contato.setTelefone(this.fornecedorView.getFtfTelefone().getText());
        contato.setCelular(this.fornecedorView.getFtfCelular().getText());
        contato.setEmail(this.fornecedorView.getTfEmail().getText());
        return contato;
    }

    /*
     * Método responsável por chamar o DAO e carregar fornecedores cadastrados no banco de dados
     */
    public ArrayList<Fornecedor> buscarTodos() {
        try {
            return listaFornecedores = new FornecedorDAO().buscarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.consultaFornecedorErro, Titulos.cadastroFornecedor, 0);
        }
        return null;
    }
    
      /*
     * Método responsável por chamar o DAO e carregar fornecedores cadastrados no banco de dados
     */
    public ArrayList<Fornecedor> buscarTodosExternamente() {
        try {
            listaFornecedores = new FornecedorDAO().buscarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(fornecedorView, Mensagens.consultaFornecedorErro, Titulos.cadastroFornecedor, 0);
             Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaFornecedores;
    }

    /*
     * Método para carregar a tabela com os fornecedores cadastrados
     */
    public void carregarTabela() {
        buscarTodos();
        DefaultTableModel modelo = (DefaultTableModel) fornecedorView.getFornecedoresTabela().getModel();
        //limpar a tabela
        modelo.setRowCount(0);
        //carregar a tabela

        for (Fornecedor fornecedor : listaFornecedores) {
            modelo.addRow(new String[]{fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(),
                fornecedor.getContatoIdContato().getTelefone(),
                fornecedor.getContato(),
                fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome()});
        }
    }

    /*
     * Método para carregar a tela com os dados do fornecedor
     */
    private void carregarTela() {
        fornecedorView.getFtfCnpj().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getCnpj());
        fornecedorView.getFtfInscrEstadual().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
        fornecedorView.getTfRazaoSocial().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        fornecedorView.getFtfDataFundacao().setText(fornecedor.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
        fornecedorView.getTfEnd().setText(fornecedor.getEnderecoIdEndereco().getNome());
        fornecedorView.getTfNumero().setText(fornecedor.getEnderecoIdEndereco().getNumero() + "");
        fornecedorView.getTfComplemento().setText(fornecedor.getEnderecoIdEndereco().getComplemento());
        fornecedorView.getTfBairro().setText(fornecedor.getEnderecoIdEndereco().getBairro());
        fornecedorView.getCbxEstado().setSelectedItem(fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
        fornecedorView.getCbxCidade().setSelectedItem(fornecedor.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        fornecedorView.getFtfCep().setText(fornecedor.getEnderecoIdEndereco().getCep());
        fornecedorView.getFtfCelular().setText(fornecedor.getContatoIdContato().getCelular());
        fornecedorView.getFtfTelefone().setText(fornecedor.getContatoIdContato().getTelefone());
        fornecedorView.getTfContato().setText(fornecedor.getContato());
        fornecedorView.getTfEmail().setText(fornecedor.getContatoIdContato().getEmail());
    }

    /*
     * Método para bloquear os campos na ação de alterar
     */
    private void bloqueioAlterar() {
        this.fornecedorView.getBtNovo().setEnabled(false);
        this.fornecedorView.getBtAlterar().setEnabled(false);
        this.fornecedorView.getBtExcluir().setEnabled(false);
        this.fornecedorView.getBtSair().setEnabled(false);
        this.fornecedorView.getBtSalvarFornecedor().setEnabled(true);
        this.fornecedorView.getBtCancelar().setEnabled(true);
        this.fornecedorView.getTfRazaoSocial().setEditable(true);
        this.fornecedorView.getTfEnd().setEditable(true);
        this.fornecedorView.getTfComplemento().setEditable(true);
        this.fornecedorView.getTfNumero().setEditable(true);
        this.fornecedorView.getTfBairro().setEditable(true);
        this.fornecedorView.getTfContato().setEditable(true);
        this.fornecedorView.getFtfCep().setEditable(true);
        this.fornecedorView.getFtfCelular().setEditable(true);
        this.fornecedorView.getFtfTelefone().setEditable(true);
        this.fornecedorView.getTfEmail().setEditable(true);
        this.fornecedorView.getCbxEstado().setEnabled(true);

    }

}
