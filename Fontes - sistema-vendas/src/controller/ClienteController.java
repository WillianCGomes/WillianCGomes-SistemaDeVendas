/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Cidade;
import model.Cliente;
import model.Contato;
import model.Endereco;
import model.Estado;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.Mensagens;
import util.Pessoa;
import util.Titulos;
import util.Valida;
import view.ClienteView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados do objeto Cliente
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class ClienteController {

    private MenuController menuController;
    private ClienteView clienteView;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Estado> listaEstados;
    private ArrayList<Cidade> listaCidades;

    private Cliente cliente;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
    private Endereco endereco;
    private Contato contato;

    private boolean alterar;

    public ClienteController(ClienteView tela) {
        this.clienteView = tela;
    }

    /*
     * método para carregar a ação do botão novo
     */
    public void acaoBotaoNovo() {
        alterar = false;
        this.clienteView.getBtNovo().setEnabled(false);
        this.clienteView.getBtAlterar().setEnabled(false);
        this.clienteView.getBtExcluir().setEnabled(false);
        this.clienteView.getBtSair().setEnabled(false);
        this.clienteView.getBtSalvarCliente().setEnabled(true);
        this.clienteView.getBtCancelar().setEnabled(true);
        desbloquearRadio();

    }

    public void acaoBotaoAlterar() {
        alterar = true;
        if (clienteView.getTabelaClientes().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(clienteView, Mensagens.selecioneCliente, Titulos.cadastroCliente, 0);
        } else {
            cliente = listaClientes.get(clienteView.getTabelaClientes().getSelectedRow());
            bloqueioAlterar();
            carregarTela();
        }
    }

    public void acaoBotaoExcluir() {
         if (clienteView.getTabelaClientes().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(clienteView, Mensagens.selecioneCliente, Titulos.cadastroCliente, 0);
        } else {
            int opcao = JOptionPane.showConfirmDialog(clienteView, Mensagens.excluirCliente, Titulos.cadastroCliente, 2);
        if (opcao == JOptionPane.YES_OPTION) {
            cliente = listaClientes.get(clienteView.getTabelaClientes().getSelectedRow());
            
            new ClienteDAO().excluir(cliente);
            new ContatoController().excluir(cliente.getContatoIdContato());
            new EnderecoController().excluir(cliente.getEnderecoIdEndereco());
            
            if (cliente.getTipoPessoa().equals(Pessoa.FISICO.getTipo())) {
                new PessoaJuridicaController().excluir(cliente.getPessoaJuridicaIdPessoaJuridica());
            } else {
                new PessoaFisicaController().excluir(cliente.getPessoaFisicaIdPessoaFisica());
            }
            
            JOptionPane.showMessageDialog(clienteView, Mensagens.clienteExcluido, Titulos.cadastroCliente, 1);
            carregarTabela();
        }
        
        }
    }

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.clienteView.dispose();
    }

    public void acaoBotaoSalvar() {
        if (validarDados()) {
            if (alterar) {
                //procedimento de alteração

                endereco = cliente.getEnderecoIdEndereco();
                contato = cliente.getContatoIdContato();

                if (cliente.getTipoPessoa().equals(Pessoa.FISICO.getTipo())) {
                    pessoaFisica = cliente.getPessoaFisicaIdPessoaFisica();
                    pessoaFisica = getPessoaFisica();
                } else {
                    pessoaJuridica = cliente.getPessoaJuridicaIdPessoaJuridica();
                    pessoaJuridica = getPessoaJuridica();
                }

            } else {
                //procedimento de inclusão
                cliente = new Cliente();
                endereco = new Endereco();
                contato = new Contato();

                if (clienteView.getRbFisica().isSelected()) {
                    pessoaFisica = new PessoaFisica();
                    pessoaFisica = getPessoaFisica();
                } else {
                    pessoaJuridica = new PessoaJuridica();
                    pessoaJuridica = getPessoaJuridica();
                }
            }
            endereco = getEndereco();
            contato = getContato();
            cliente = getCliente();

            if (clienteView.getRbFisica().isSelected()) {
                new PessoaFisicaController().salvar(pessoaFisica);
            } else {
                new PessoaJuridicaController().salvar(pessoaJuridica);
            }

            new EnderecoController().salvar(endereco);
            new ContatoController().salvar(contato);

            try {
                new ClienteDAO().salvar(cliente);
                JOptionPane.showMessageDialog(clienteView, Mensagens.clienteSalvo, Titulos.cadastroCliente, 1);
                acaoBotaoCancelar();
                carregarTabela();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(clienteView, Mensagens.clienteErro, Titulos.cadastroCliente, 0);
            }
        }
    }

    public void acaoBotaoCancelar() {
        this.clienteView.getBtNovo().setEnabled(true);
        this.clienteView.getBtAlterar().setEnabled(true);
        this.clienteView.getBtExcluir().setEnabled(true);
        this.clienteView.getBtSair().setEnabled(true);
        this.clienteView.getBtSalvarCliente().setEnabled(false);
        this.clienteView.getBtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void bloqueioInicial() {
        this.clienteView.getBtNovo().setEnabled(true);
        this.clienteView.getBtAlterar().setEnabled(true);
        this.clienteView.getBtExcluir().setEnabled(true);
        this.clienteView.getBtSair().setEnabled(true);
        this.clienteView.getBtSalvarCliente().setEnabled(false);
        this.clienteView.getBtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.clienteView.getRbFisica().setEnabled(false);
        this.clienteView.getRbJuridica().setEnabled(false);
        this.clienteView.getFtfCpfCnpj().setEditable(false);
        this.clienteView.getFtfRgIE().setEditable(false);
        this.clienteView.getTfNomeRazaoSocial().setEditable(false);
        this.clienteView.getFtfDatas().setEditable(false);
        this.clienteView.getTfEndereco().setEditable(false);
        this.clienteView.getTfNumero().setEditable(false);
        this.clienteView.getTfComplemento().setEditable(false);
        this.clienteView.getTfBairro().setEditable(false);
        this.clienteView.getFtfCep().setEditable(false);
        this.clienteView.getFtfCelular().setEditable(false);
        this.clienteView.getFtfTelefone().setEditable(false);
        this.clienteView.getTfEmail().setEditable(false);
        this.clienteView.getCbxCidade().setEnabled(false);
        this.clienteView.getCbxEstado().setEnabled(false);

    }

    public void desbloquearRadio() {
        this.clienteView.getRbFisica().setEnabled(true);
        this.clienteView.getRbJuridica().setEnabled(true);
    }

    public void desbloquearCampos() {

        this.clienteView.getFtfCpfCnpj().setEditable(true);
        this.clienteView.getFtfRgIE().setEditable(true);
        this.clienteView.getTfNomeRazaoSocial().setEditable(true);
        this.clienteView.getFtfDatas().setEditable(true);
        this.clienteView.getTfEndereco().setEditable(true);
        this.clienteView.getTfNumero().setEditable(true);
        this.clienteView.getTfComplemento().setEditable(true);
        this.clienteView.getTfBairro().setEditable(true);
        this.clienteView.getFtfCep().setEditable(true);
        this.clienteView.getFtfCelular().setEditable(true);
        this.clienteView.getFtfTelefone().setEditable(true);
        this.clienteView.getTfEmail().setEditable(true);
        this.clienteView.getCbxEstado().setEnabled(true);

    }

    public void limparCampos() {
        this.clienteView.getGrpTipoDePessoa().clearSelection();
        this.clienteView.getFtfCpfCnpj().setValue(null);
        this.clienteView.getFtfRgIE().setValue(null);
        this.clienteView.getTfNomeRazaoSocial().setText(null);
        this.clienteView.getFtfDatas().setValue(null);
        this.clienteView.getTfEndereco().setText(null);
        this.clienteView.getTfComplemento().setText(null);
        this.clienteView.getTfNumero().setText(null);
        this.clienteView.getTfBairro().setText(null);
        this.clienteView.getFtfCep().setValue(null);
        this.clienteView.getFtfCelular().setValue(null);
        this.clienteView.getFtfTelefone().setValue(null);
        this.clienteView.getTfEmail().setText(null);
        this.clienteView.getCbxCidade().setSelectedIndex(0);
        this.clienteView.getCbxEstado().setSelectedIndex(0);
    }

    public void cnpjMask() {
        this.clienteView.getFtfCpfCnpj().setValue(null);
        try {
            MaskFormatter cnpj = new MaskFormatter(Mensagens.cnpjMascara);
            this.clienteView.getFtfCpfCnpj().setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
            this.clienteView.getLbCpfCnpj().setText(Mensagens.cnpj);

        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cpfMask() {
        this.clienteView.getFtfCpfCnpj().setValue(null);
        try {
            MaskFormatter cpf = new MaskFormatter(Mensagens.cpfMascara);
            this.clienteView.getFtfCpfCnpj().setFormatterFactory(
                    new DefaultFormatterFactory(cpf));
            this.clienteView.getLbCpfCnpj().setText(Mensagens.cpf);

        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rgMask() {
        this.clienteView.getFtfRgIE().setValue(null);
        try {
            MaskFormatter rg = new MaskFormatter(Mensagens.rgMascara);
            this.clienteView.getFtfRgIE().setFormatterFactory(
                    new DefaultFormatterFactory(rg));
            this.clienteView.getLbRgIE().setText(Mensagens.rg);

        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ieMask() {
        this.clienteView.getFtfRgIE().setValue(null);
        try {
            MaskFormatter ie = new MaskFormatter(Mensagens.ieMascara);
            this.clienteView.getFtfRgIE().setFormatterFactory(
                    new DefaultFormatterFactory(ie));
            this.clienteView.getLbRgIE().setText(Mensagens.ie);

        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void razaoSocial() {
        this.clienteView.getLbNome().setText(Mensagens.razaoSocial);
        this.clienteView.getLbDatas().setText(Mensagens.dataFundacao);
    }

    public void nome() {
        this.clienteView.getLbNome().setText(Mensagens.nome);
        this.clienteView.getLbDatas().setText(Mensagens.dataNasc);
    }

    /*
     * método para carregar a combo de estado
     */
    public void carregaComboEstado() {

        listaEstados = new EstadoController().buscarTodos();
        this.clienteView.getCbxEstado().addItem("- SELECIONAR -");
        for (Estado estado : listaEstados) {
            this.clienteView.getCbxEstado().addItem(estado.getNome());
        }

    }

    /*
     * método para carregar a combo de cidade
     */
    public void carregaComboCidade() {

        int indice = this.clienteView.getCbxEstado().getSelectedIndex() - 1;
        if (indice >= 0) {
            try {
                listaCidades = new CidadeController().buscarPorEstado(listaEstados.get(indice));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, Mensagens.erroConsultaCidades, Titulos.carregamentoDados, 0);
                Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //removendo todos os dados da combo
            this.clienteView.getCbxCidade().removeAllItems();
            this.clienteView.getCbxCidade().addItem("- SELECIONAR -");
            for (Cidade cidade : listaCidades) {
                this.clienteView.getCbxCidade().addItem(cidade.getNome());
            }
            this.clienteView.getCbxCidade().setEnabled(true);
        }

    }

    /*
     * Método responsável por chamar o DAO e carregar clientes cadastrados no banco de dados
     */
    private ArrayList<Cliente> buscarTodos() {
        try {
            return listaClientes = new ClienteDAO().buscarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(clienteView, Mensagens.consultaClienteErro, Titulos.cadastroCliente, 0);
        }
        return null;
    }

    /*
     * Método para carregar a tabela com os clientes cadastrados
     */
    public void carregarTabela() {
        buscarTodos();
        DefaultTableModel modelo = (DefaultTableModel) clienteView.getTabelaClientes().getModel();
        //limpar a tabela
        modelo.setRowCount(0);
        //carregar a tabela
        for (Cliente cliente : listaClientes) {
            String nome = "";
            if (cliente.getTipoPessoa().equals(Pessoa.FISICO.getTipo())) {
                nome = cliente.getPessoaFisicaIdPessoaFisica().getNome();

            } else {

                nome = cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial();
            }
            modelo.addRow(new String[]{nome,
                cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome(),
                cliente.getContatoIdContato().getCelular(),
                cliente.getContatoIdContato().getEmail()});
        }
    }

    /*
     * Método para definir a ação de seleção do RadioButton de pessoa física
     */
    public void acaoBotaoPessoaFisica() {
        limparCampos();
        clienteView.getRbFisica().setSelected(true);
        clienteView.getCbxCidade().setEnabled(false);
        cpfMask();
        rgMask();
        nome();
        desbloquearCampos();
    }

    /*
     *Método para definir a ação de seleção do RadioButton de pessoa juridica
     */
    public void acaoBotaoPessoaJuridica() {
        limparCampos();
        clienteView.getRbJuridica().setSelected(true);
        clienteView.getCbxCidade().setEnabled(false);
        cnpjMask();
        ieMask();
        razaoSocial();
        desbloquearCampos();
    }
    /*
     * método para validar os dados da tela
     */

    private boolean validarDados() {
        // validações para tipo de pessoa: Física    
        if (clienteView.getRbFisica().isSelected()) {

            // validando o cpf
            if (Valida.isCpfVazio(clienteView.getFtfCpfCnpj().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.cpfVazio, Titulos.cadastroCliente, 0);
                clienteView.getFtfCpfCnpj().grabFocus();
                return false;
            } else if (Valida.isCpfInvalido(clienteView.getFtfCpfCnpj().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.cpfInvalido, Titulos.cadastroCliente, 0);
                clienteView.getFtfCpfCnpj().grabFocus();
                return false;
            }

            //validando o rg
            if (Valida.isRgVazio(clienteView.getFtfRgIE().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.rgVazio, Titulos.cadastroCliente, 0);
                clienteView.getFtfRgIE().grabFocus();
                return false;
            }
            // validando o nome
            if (Valida.isEmptyOrNull(clienteView.getTfNomeRazaoSocial().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.nomeVazio, Titulos.cadastroCliente, 0);
                clienteView.getTfNomeRazaoSocial().grabFocus();
                return false;
            } else if (!Valida.isOnlyText(clienteView.getTfNomeRazaoSocial().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.nomeInvalido, Titulos.cadastroCliente, 0);
                clienteView.getTfNomeRazaoSocial().grabFocus();
                return false;
            }

            //validando a data de nascimento
            if (Valida.isDataVazia(clienteView.getFtfDatas().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.dataNascimentoVazio, Titulos.cadastroCliente, 0);
                clienteView.getFtfDatas().grabFocus();
                return false;
            } else if (Valida.isDataInvalida(clienteView.getFtfDatas().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.dataNascimentoInvalida, Titulos.cadastroCliente, 0);
                clienteView.getFtfDatas().grabFocus();
                return false;
            }

            // validações para tipo de pessoa: Jurídica   
        } else if (clienteView.getRbJuridica().isSelected()) {
            // validando o cnpj
            if (Valida.isCnpjVazio(clienteView.getFtfCpfCnpj().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.cnpjVazio, Titulos.cadastroCliente, 0);
                clienteView.getFtfCpfCnpj().grabFocus();
                return false;
            } else if (Valida.isCnpjInvalido(clienteView.getFtfCpfCnpj().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.cnpjInvalido, Titulos.cadastroCliente, 0);
                clienteView.getFtfCpfCnpj().grabFocus();
                return false;
            }

            //validando a Inscrição Estadual
            if (Valida.isInscricaoEstadualVazio(clienteView.getFtfRgIE().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.inscricaoEstadualVazio, Titulos.cadastroCliente, 0);
                clienteView.getFtfRgIE().grabFocus();
                return false;
            } else if (Valida.isInscricaoEstadualInvalido(clienteView.getFtfRgIE().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.inscricaoEstadualInvalido, Titulos.cadastroCliente, 0);
                clienteView.getFtfRgIE().grabFocus();
                return false;
            }

            // validando a razão social
            if (Valida.isEmptyOrNull(clienteView.getTfNomeRazaoSocial().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.razaoSocialVazio, Titulos.cadastroCliente, 0);
                clienteView.getTfNomeRazaoSocial().grabFocus();
                return false;
            }

            //validando a data de fundação
            if (Valida.isDataVazia(clienteView.getFtfDatas().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.dataFundacaoVazio, Titulos.cadastroCliente, 0);
                clienteView.getFtfDatas().grabFocus();
                return false;
            } else if (Valida.isDataInvalida(clienteView.getFtfDatas().getText())) {
                JOptionPane.showMessageDialog(clienteView, Mensagens.dataFundacaoInvalida, Titulos.cadastroCliente, 0);
                clienteView.getFtfDatas().grabFocus();
                return false;
            }

        } else { // Caso o tipo de pessoa não tenha sido selecionado
            JOptionPane.showMessageDialog(clienteView, Mensagens.tipoPessoaVazio, Titulos.cadastroCliente, 0);
            return false;
        }

        // dados comuns - endereço e contato
        // validando o endereço
        if (Valida.isEmptyOrNull(this.clienteView.getTfEndereco().getText())) {
            JOptionPane.showMessageDialog(null, Mensagens.enderecoVazio, Titulos.cadastroCliente, 0);
            this.clienteView.getTfEndereco().grabFocus();
            return false;
        }

        // validando o numero
        if (!Valida.isInteger(this.clienteView.getTfNumero().getText())) {
            JOptionPane.showMessageDialog(null, Mensagens.numeroEnderecoInvalido, Titulos.cadastroCliente, 0);
            this.clienteView.getTfNumero().grabFocus();
            return false;
        }

        // validando o bairro
        if (Valida.isEmptyOrNull(this.clienteView.getTfBairro().getText())) {
            JOptionPane.showMessageDialog(null, Mensagens.bairroVazio, Titulos.cadastroCliente, 0);
            this.clienteView.getTfBairro().grabFocus();
            return false;
        }

        // validando o cep
        if (Valida.isCepVazio(this.clienteView.getFtfCep().getText())) {
            JOptionPane.showMessageDialog(null, Mensagens.cepVazio, Titulos.cadastroCliente, 0);
            this.clienteView.getFtfCep().grabFocus();
            return false;
        }

        // validando o estado
        if (Valida.isComboInvalida(this.clienteView.getCbxEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagens.estadoVazio, Titulos.cadastroCliente, 0);
            this.clienteView.getCbxEstado().grabFocus();
            return false;
        }

        // validando a cidade
        if (Valida.isComboInvalida(this.clienteView.getCbxCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(null, Mensagens.cidadeVazio, Titulos.cadastroCliente, 0);
            this.clienteView.getCbxCidade().grabFocus();
            return false;
        }

        // validando o celular
        if (Valida.isCelularVazio(this.clienteView.getFtfCelular().getText())) {
            JOptionPane.showMessageDialog(null, Mensagens.celularVazio, Titulos.cadastroCliente, 0);
            this.clienteView.getFtfCelular().grabFocus();
            return false;
        }

        // validando o email
        if (Valida.isEmptyOrNull(this.clienteView.getTfEmail().getText())) {
            JOptionPane.showMessageDialog(null, Mensagens.emailVazio, Titulos.cadastroCliente, 0);
            this.clienteView.getTfEmail().grabFocus();
            return false;
        }
        return true;

    }

    /*
     * método para retornar um novo objeto de Endereço
     */
    private Endereco getEndereco() {
        endereco.setNome(this.clienteView.getTfEndereco().getText());
        endereco.setNumero(Integer.parseInt(this.clienteView.getTfNumero().getText()));
        endereco.setComplemento(this.clienteView.getTfComplemento().getText());
        endereco.setBairro(this.clienteView.getTfBairro().getText());
        endereco.setCep(this.clienteView.getFtfCep().getText());
        endereco.setCidadeIdCidade(listaCidades.get(this.clienteView.getCbxCidade().getSelectedIndex() - 1));
        return endereco;
    }

    /*
     * método para retornar um novo objeto de contato
     */
    private Contato getContato() {
        contato.setTelefone(this.clienteView.getFtfTelefone().getText());
        contato.setCelular(this.clienteView.getFtfCelular().getText());
        contato.setEmail(this.clienteView.getTfEmail().getText());
        return contato;
    }

    /*
     * método para retornar um objeto de Pessoa Física
     */
    private PessoaFisica getPessoaFisica() {
        pessoaFisica.setNome(clienteView.getTfNomeRazaoSocial().getText());
        pessoaFisica.setRg(clienteView.getFtfRgIE().getText());
        pessoaFisica.setCpf(clienteView.getFtfCpfCnpj().getText());
        pessoaFisica.setDataNascimento(clienteView.getFtfDatas().getText());
        return pessoaFisica;
    }

    /*
     * método para retornar um objeto de Pessoa Jurídica
     */
    private PessoaJuridica getPessoaJuridica() {
        pessoaJuridica.setRazaoSocial(clienteView.getTfNomeRazaoSocial().getText());
        pessoaJuridica.setInscricaoEstadual(clienteView.getFtfRgIE().getText());
        pessoaJuridica.setCnpj(clienteView.getFtfCpfCnpj().getText());
        pessoaJuridica.setDataFundacao(clienteView.getFtfDatas().getText());
        return pessoaJuridica;
    }

    /*
     * método para retornar um objeto de Cliente
     */
    private Cliente getCliente() {
        if (clienteView.getRbFisica().isSelected()) {
            cliente.setTipoPessoa(Pessoa.FISICO.getTipo());
            cliente.setPessoaFisicaIdPessoaFisica(pessoaFisica);
        } else {
            cliente.setTipoPessoa(Pessoa.JURIDICO.getTipo());
            cliente.setPessoaJuridicaIdPessoaJuridica(pessoaJuridica);
        }
        cliente.setEnderecoIdEndereco(endereco);
        cliente.setContatoIdContato(contato);
        return cliente;
    }

    /*
     * método para bloquear os campos ao realizar uma alteração
     */
    public void bloqueioAlterar() {

        this.clienteView.getBtNovo().setEnabled(false);
        this.clienteView.getBtAlterar().setEnabled(false);
        this.clienteView.getBtExcluir().setEnabled(false);
        this.clienteView.getBtSair().setEnabled(false);
        this.clienteView.getBtSalvarCliente().setEnabled(true);
        this.clienteView.getBtCancelar().setEnabled(true);
        this.clienteView.getFtfCpfCnpj().setEditable(false);
        this.clienteView.getFtfRgIE().setEditable(false);
        this.clienteView.getTfNomeRazaoSocial().setEditable(true);
        this.clienteView.getFtfDatas().setEditable(false);
        this.clienteView.getTfEndereco().setEditable(true);
        this.clienteView.getTfNumero().setEditable(true);
        this.clienteView.getTfComplemento().setEditable(true);
        this.clienteView.getTfBairro().setEditable(true);
        this.clienteView.getFtfCep().setEditable(true);
        this.clienteView.getFtfCelular().setEditable(true);
        this.clienteView.getFtfTelefone().setEditable(true);
        this.clienteView.getTfEmail().setEditable(true);
        this.clienteView.getCbxEstado().setEnabled(true);
    }

    /*
     * método para carregar a tela com os dados do cliente
     */
    private void carregarTela() {
        if (cliente.getTipoPessoa().equals(Pessoa.FISICO.getTipo())) {
            limparCampos();
            clienteView.getCbxCidade().setEnabled(false);
            cpfMask();
            rgMask();
            nome();
            clienteView.getRbFisica().setSelected(true);
            clienteView.getFtfCpfCnpj().setText(cliente.getPessoaFisicaIdPessoaFisica().getCpf());
            clienteView.getFtfRgIE().setText(cliente.getPessoaFisicaIdPessoaFisica().getRg());
            clienteView.getTfNomeRazaoSocial().setText(cliente.getPessoaFisicaIdPessoaFisica().getNome());
            clienteView.getFtfDatas().setText(cliente.getPessoaFisicaIdPessoaFisica().getDataNascimento());

        } else {
            limparCampos();
            clienteView.getRbJuridica().setSelected(true);
            cnpjMask();
            ieMask();
            razaoSocial();
            clienteView.getFtfCpfCnpj().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getCnpj());
            clienteView.getFtfRgIE().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getInscricaoEstadual());
            clienteView.getTfNomeRazaoSocial().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
            clienteView.getFtfDatas().setText(cliente.getPessoaJuridicaIdPessoaJuridica().getDataFundacao());
        }

        clienteView.getTfEndereco().setText(cliente.getEnderecoIdEndereco().getNome());
        clienteView.getTfNumero().setText(cliente.getEnderecoIdEndereco().getNumero() + "");
        clienteView.getTfComplemento().setText(cliente.getEnderecoIdEndereco().getComplemento());
        clienteView.getTfBairro().setText(cliente.getEnderecoIdEndereco().getBairro());
        clienteView.getCbxEstado().setSelectedItem(cliente.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
        clienteView.getCbxCidade().setSelectedItem(cliente.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        clienteView.getFtfCep().setText(cliente.getEnderecoIdEndereco().getCep());
        clienteView.getFtfCelular().setText(cliente.getContatoIdContato().getCelular());
        clienteView.getFtfTelefone().setText(cliente.getContatoIdContato().getTelefone());
        clienteView.getTfEmail().setText(cliente.getContatoIdContato().getEmail());
    }

}
