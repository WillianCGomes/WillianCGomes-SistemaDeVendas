/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cidade;
import model.Contato;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.PessoaFisica;
import util.Mensagens;
import util.Titulos;
import util.Util;
import util.Valida;
import view.FuncionarioView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados do objeto Funcionario
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class FuncionarioController {

    private FuncionarioView funcionarioView;
    private ArrayList<Estado> listaEstados;
    private ArrayList<Cidade> listaCidades;
    private MenuController menuController;
    private ArrayList<Funcionario> listaFuncionarios;

    private PessoaFisica pessoa;
    private Endereco endereco;
    private Contato contato;
    private Funcionario funcionario;
    private boolean alterar;

    public FuncionarioController(FuncionarioView tela) {
        this.funcionarioView = tela;
    }

    public FuncionarioController() {
    }

    /*
     * método para esconder ou mostrar a senha
     */
    public void botaoMostrarSenha() {
        if (funcionarioView.getCkbxMostrarSenha().isSelected()) {
            funcionarioView.getPfSenha().setEchoChar((char) 0);
        } else {
            funcionarioView.getPfSenha().setEchoChar('*');
            funcionarioView.getPfConfirmaSenha().setEchoChar('*');
        }

    }

    /*
     * método para carregar a ação do botão novo
     */
    public void acaoBotaoNovo() {
        alterar = false;
        this.funcionarioView.getBtNovo().setEnabled(false);
        this.funcionarioView.getBtAlterar().setEnabled(false);
        this.funcionarioView.getBtExcluir().setEnabled(false);
        this.funcionarioView.getBtSair().setEnabled(false);
        this.funcionarioView.getBtSalvarFuncionario().setEnabled(true);
        this.funcionarioView.getBtCancelar().setEnabled(true);
        desbloquearCampos();
    }

    public void acaoBotaoAlterar() {
        alterar = true;
        if (funcionarioView.getTabelaFuncionarios().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.selecioneFuncionario, Titulos.cadastroFuncionario, 0);
        } else {
            funcionario = listaFuncionarios.get(funcionarioView.getTabelaFuncionarios().getSelectedRow());
            bloqueioAlterar();
            carregarTela();
        }
    }

    public void acaoBotaoExcluir() {
        alterar = true;
        if (funcionarioView.getTabelaFuncionarios().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.selecioneFuncionario, Titulos.cadastroFuncionario, 0);
        } else {
            int opcao = JOptionPane.showConfirmDialog(funcionarioView, Mensagens.excluirFuncionario, Titulos.cadastroFuncionario, 2);
            if (opcao == JOptionPane.YES_OPTION) {
                funcionario = listaFuncionarios.get(funcionarioView.getTabelaFuncionarios().getSelectedRow());

                new FuncionarioDAO().excluir(funcionario);
                new ContatoController().excluir(funcionario.getContatoIdContato());
                new EnderecoController().excluir(funcionario.getEnderecoIdEndereco());
                new PessoaFisicaController().excluir(funcionario.getPessoaFisicaIdPessoaFisica());

                JOptionPane.showMessageDialog(funcionarioView, Mensagens.funcionarioExcluido, Titulos.cadastroFuncionario, 1);
                carregarTabela();
            }
        }
    }

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.funcionarioView.dispose();
    }

    public void acaoBotaoSalvar() {
        if (validarDados()) {
            if (alterar) {
                pessoa = funcionario.getPessoaFisicaIdPessoaFisica();
                endereco = funcionario.getEnderecoIdEndereco();
                contato = funcionario.getContatoIdContato();
            } else { //incluir
                pessoa = new PessoaFisica();
                endereco = new Endereco();
                contato = new Contato();
                funcionario = new Funcionario();
            }
            pessoa = getPessoaFisica();
            endereco = getEndereco();
            contato = getContato();
            funcionario = getFuncionario();

            new PessoaFisicaController().salvar(pessoa);
            new EnderecoController().salvar(endereco);
            new ContatoController().salvar(contato);

            funcionario.setPessoaFisicaIdPessoaFisica(pessoa);
            funcionario.setEnderecoIdEndereco(endereco);
            funcionario.setContatoIdContato(contato);

            try {
                new FuncionarioDAO().salvar(funcionario);
                JOptionPane.showMessageDialog(funcionarioView, Mensagens.funcionarioSalvo, Titulos.cadastroFuncionario, 1);
                limparCampos();
                bloqueioInicial();
                carregarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(funcionarioView, Mensagens.funcionarioErro, Titulos.cadastroFuncionario, 1);
            }
        }
    }

    public void acaoBotaoCancelar() {
        this.funcionarioView.getBtNovo().setEnabled(true);
        this.funcionarioView.getBtAlterar().setEnabled(true);
        this.funcionarioView.getBtExcluir().setEnabled(true);
        this.funcionarioView.getBtSair().setEnabled(true);
        this.funcionarioView.getBtSalvarFuncionario().setEnabled(false);
        this.funcionarioView.getBtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void bloqueioInicial() {
        this.funcionarioView.getBtNovo().setEnabled(true);
        this.funcionarioView.getBtAlterar().setEnabled(true);
        this.funcionarioView.getBtExcluir().setEnabled(true);
        this.funcionarioView.getBtSair().setEnabled(true);
        this.funcionarioView.getBtSalvarFuncionario().setEnabled(false);
        this.funcionarioView.getBtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.funcionarioView.getFtfCpf().setEditable(false);
        this.funcionarioView.getFtfRg().setEditable(false);
        this.funcionarioView.getTfNome().setEditable(false);
        this.funcionarioView.getFtfDataNasc().setEditable(false);
        this.funcionarioView.getTfEnd().setEditable(false);
        this.funcionarioView.getTfNumero().setEditable(false);
        this.funcionarioView.getTfComplemento().setEditable(false);
        this.funcionarioView.getTfBairro().setEditable(false);
        this.funcionarioView.getFtfCep().setEditable(false);
        this.funcionarioView.getFtfCelular().setEditable(false);
        this.funcionarioView.getFtfTelefone().setEditable(false);
        this.funcionarioView.getTfEmail().setEditable(false);
        this.funcionarioView.getTfLogin().setEditable(false);
        this.funcionarioView.getPfSenha().setEditable(false);
        this.funcionarioView.getPfConfirmaSenha().setEditable(false);
        this.funcionarioView.getCbxCidade().setEnabled(false);
        this.funcionarioView.getCbxEstado().setEnabled(false);
        this.funcionarioView.getCkbxMostrarSenha().setEnabled(false);

    }

    public void desbloquearCampos() {

        this.funcionarioView.getFtfCpf().setEditable(true);
        this.funcionarioView.getFtfRg().setEditable(true);
        this.funcionarioView.getTfNome().setEditable(true);
        this.funcionarioView.getFtfDataNasc().setEditable(true);
        this.funcionarioView.getTfEnd().setEditable(true);
        this.funcionarioView.getTfNumero().setEditable(true);
        this.funcionarioView.getTfComplemento().setEditable(true);
        this.funcionarioView.getTfBairro().setEditable(true);
        this.funcionarioView.getFtfCep().setEditable(true);
        this.funcionarioView.getFtfCelular().setEditable(true);
        this.funcionarioView.getFtfTelefone().setEditable(true);
        this.funcionarioView.getTfEmail().setEditable(true);
        this.funcionarioView.getTfLogin().setEditable(true);
        this.funcionarioView.getPfSenha().setEditable(true);
        this.funcionarioView.getPfConfirmaSenha().setEditable(true);
        this.funcionarioView.getCbxEstado().setEnabled(true);
        this.funcionarioView.getCkbxMostrarSenha().setEnabled(true);

    }

    public void limparCampos() {
        this.funcionarioView.getFtfCpf().setValue(null);
        this.funcionarioView.getFtfRg().setValue(null);
        this.funcionarioView.getTfNome().setText(null);
        this.funcionarioView.getFtfDataNasc().setValue(null);
        this.funcionarioView.getTfEnd().setText(null);
        this.funcionarioView.getTfNumero().setText(null);
        this.funcionarioView.getTfComplemento().setText(null);
        this.funcionarioView.getTfBairro().setText(null);
        this.funcionarioView.getFtfCep().setValue(null);
        this.funcionarioView.getFtfCelular().setValue(null);
        this.funcionarioView.getFtfTelefone().setValue(null);
        this.funcionarioView.getTfEmail().setText(null);
        this.funcionarioView.getTfLogin().setText(null);
        this.funcionarioView.getPfSenha().setText(null);
        this.funcionarioView.getPfConfirmaSenha().setText(null);
        this.funcionarioView.getCbxCidade().setSelectedIndex(0);
        this.funcionarioView.getCbxEstado().setSelectedIndex(0);
        this.funcionarioView.getCkbxMostrarSenha().setSelected(false);
    }

    /*
     * método para carregar a combo de estado
     */
    public void carregaComboEstado() {

        listaEstados = new EstadoController().buscarTodos();
        this.funcionarioView.getCbxEstado().addItem("- SELECIONAR -");
        for (Estado estado : listaEstados) {
            this.funcionarioView.getCbxEstado().addItem(estado.getNome());
        }

    }

    /*
     * método para carregar a combo de cidade
     */
    public void carregaComboCidade() {

        int indice = this.funcionarioView.getCbxEstado().getSelectedIndex() - 1;
        if (indice >= 0) {
            try {
                listaCidades = new CidadeController().buscarPorEstado(listaEstados.get(indice));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(funcionarioView, Mensagens.erroConsultaCidades, Titulos.carregamentoDados, 0);
                Logger.getLogger(FornecedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //removendo todos os dados da combo
            this.funcionarioView.getCbxCidade().removeAllItems();
            this.funcionarioView.getCbxCidade().addItem("- SELECIONAR -");
            for (Cidade cidade : listaCidades) {
                this.funcionarioView.getCbxCidade().addItem(cidade.getNome());
            }
            this.funcionarioView.getCbxCidade().setEnabled(true);
        }

    }

    /*
     * método para validar dados
     */
    private boolean validarDados() {

        //Validando o nome
        if (Valida.isEmptyOrNull(this.funcionarioView.getTfNome().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.nomeVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfNome().grabFocus();
            return false;
        }
        if (!Valida.isOnlyText(this.funcionarioView.getTfNome().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.nomeInvalido, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfNome().grabFocus();
            return false;
        }

        //validando o CPF
        if (Valida.isCpfVazio(this.funcionarioView.getFtfCpf().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.cpfVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getFtfCpf().grabFocus();
            return false;

        } else if (Valida.isCpfInvalido(this.funcionarioView.getFtfCpf().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.cpfInvalido, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getFtfCpf().grabFocus();
            return false;
        }

        //validando o email
        if (Valida.isEmptyOrNull(this.funcionarioView.getTfEmail().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.emailVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfEmail().grabFocus();
            return false;
        }

        //validando o RG
        if (Valida.isRgVazio(this.funcionarioView.getFtfRg().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.rgVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getFtfRg().grabFocus();
            return false;
        }

        //validando o endereço
        if (Valida.isEmptyOrNull(this.funcionarioView.getTfEnd().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.enderecoVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfEnd().grabFocus();
            return false;
        }

        //validando a data de nascimento
        if (Valida.isDataVazia(this.funcionarioView.getFtfDataNasc().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.dataNascimentoVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getFtfDataNasc().grabFocus();
            return false;
        } else if (Valida.isDataInvalida(this.funcionarioView.getFtfDataNasc().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.dataNascimentoInvalida, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getFtfDataNasc().grabFocus();
            return false;
        }

        // validando o celular
        if (Valida.isCelularVazio(this.funcionarioView.getFtfCelular().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.celularVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getFtfCelular().grabFocus();
            return false;
        }

        //validando o estado
        if (Valida.isComboInvalida(this.funcionarioView.getCbxEstado().getSelectedIndex())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.estadoVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getCbxEstado().grabFocus();
            return false;
        }

        //validando a cidade
        if (Valida.isComboInvalida(this.funcionarioView.getCbxCidade().getSelectedIndex())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.cidadeVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getCbxCidade().grabFocus();
            return false;
        }

        //validando o número
        if (Valida.isEmptyOrNull(this.funcionarioView.getTfNumero().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.numeroVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfNumero().grabFocus();
            return false;
        } else if (!Valida.isInteger(this.funcionarioView.getTfNumero().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.numeroEnderecoInvalido, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfNumero().grabFocus();
            return false;
        }

        // validando o cep
        if (Valida.isCepVazio(this.funcionarioView.getFtfCep().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.cepVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getFtfCep().grabFocus();
            return false;
        }

        //validando o bairro
        if (Valida.isEmptyOrNull(this.funcionarioView.getTfBairro().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.bairroVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfBairro().grabFocus();
            return false;
        }

        //validando o campo Login
        if (Valida.isEmptyOrNull(this.funcionarioView.getTfLogin().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.loginVazio, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getTfLogin().grabFocus();
            return false;
        }

        //validando o campo de senha
        if (Valida.isEmptyOrNull(this.funcionarioView.getPfSenha().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.senhaVazia, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getPfSenha().grabFocus();
            return false;
        }

        //validando o campo de confirmação de senha
        if (Valida.isEmptyOrNull(this.funcionarioView.getPfConfirmaSenha().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.confirmaSenhaVazia, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getPfConfirmaSenha().grabFocus();
            return false;
        } else if (!this.funcionarioView.getPfConfirmaSenha().getText().equals(this.funcionarioView.getPfSenha().getText())) {
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.confirmaSenhaInvalida, Titulos.cadastroFuncionario, 0);
            this.funcionarioView.getPfConfirmaSenha().grabFocus();
            return false;
        }

        return true;
    }

    /*
     * Método para carregar a tela com os dados do funcionario
     */
    private void carregarTela() {
        funcionarioView.getFtfCpf().setText(funcionario.getPessoaFisicaIdPessoaFisica().getCpf());
        funcionarioView.getFtfRg().setText(funcionario.getPessoaFisicaIdPessoaFisica().getRg());
        funcionarioView.getTfNome().setText(funcionario.getPessoaFisicaIdPessoaFisica().getNome());
        funcionarioView.getFtfDataNasc().setText(funcionario.getPessoaFisicaIdPessoaFisica().getDataNascimento());
        funcionarioView.getTfEnd().setText(funcionario.getEnderecoIdEndereco().getNome());
        funcionarioView.getTfNumero().setText(funcionario.getEnderecoIdEndereco().getNumero() + "");
        funcionarioView.getTfComplemento().setText(funcionario.getEnderecoIdEndereco().getComplemento());
        funcionarioView.getTfBairro().setText(funcionario.getEnderecoIdEndereco().getBairro());
        funcionarioView.getCbxEstado().setSelectedItem(funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getEstadoIdEstado().getNome());
        funcionarioView.getCbxCidade().setSelectedItem(funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome());
        funcionarioView.getFtfCep().setText(funcionario.getEnderecoIdEndereco().getCep());
        funcionarioView.getFtfCelular().setText(funcionario.getContatoIdContato().getCelular());
        funcionarioView.getFtfTelefone().setText(funcionario.getContatoIdContato().getTelefone());
        funcionarioView.getTfEmail().setText(funcionario.getContatoIdContato().getEmail());
        funcionarioView.getTfLogin().setText(funcionario.getLogin());

    }

    /*
     * método para bloquear os campos ao selecionar o botão alterar
     */
    private void bloqueioAlterar() {
        this.funcionarioView.getBtSalvarFuncionario().setEnabled(true);
        this.funcionarioView.getBtCancelar().setEnabled(true);
        this.funcionarioView.getBtNovo().setEnabled(false);
        this.funcionarioView.getBtAlterar().setEnabled(false);
        this.funcionarioView.getBtExcluir().setEnabled(false);
        this.funcionarioView.getBtSair().setEnabled(false);
        this.funcionarioView.getTfEnd().setEditable(true);
        this.funcionarioView.getTfNumero().setEditable(true);
        this.funcionarioView.getTfComplemento().setEditable(true);
        this.funcionarioView.getTfBairro().setEditable(true);
        this.funcionarioView.getFtfCep().setEditable(true);
        this.funcionarioView.getFtfCelular().setEditable(true);
        this.funcionarioView.getFtfTelefone().setEditable(true);
        this.funcionarioView.getTfEmail().setEditable(true);
        this.funcionarioView.getTfLogin().setEditable(false);
        this.funcionarioView.getPfSenha().setEditable(true);
        this.funcionarioView.getPfConfirmaSenha().setEditable(true);
        this.funcionarioView.getCbxEstado().setEnabled(true);
        this.funcionarioView.getCkbxMostrarSenha().setEnabled(true);
    }

    /*
     * Método responsável por chamar o DAO e carregar funcionários cadastrados no banco de dados
     */
    private ArrayList<Funcionario> buscarTodos() {
        try {
            return listaFuncionarios = new FuncionarioDAO().buscarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.consultaFornecedorErro, Titulos.cadastroFuncionario, 0);
        }
        return null;
    }

    /*
     * Método para carregar a tabela com os funcionários cadastrados
     */
    public void carregarTabela() {
        buscarTodos();
        DefaultTableModel modelo = (DefaultTableModel) funcionarioView.getTabelaFuncionarios().getModel();
        //limpar a tabela
        modelo.setRowCount(0);
        //carregar a tabela
        for (Funcionario funcionario : listaFuncionarios) {
            modelo.addRow(new String[]{funcionario.getPessoaFisicaIdPessoaFisica().getNome(),
                funcionario.getEnderecoIdEndereco().getCidadeIdCidade().getNome(),
                funcionario.getContatoIdContato().getTelefone(),
                funcionario.getContatoIdContato().getCelular()});
        }
    }

    /*
     * método psra retornar um novo objeto
     */
    private PessoaFisica getPessoaFisica() {
        pessoa.setCpf(this.funcionarioView.getFtfCpf().getText());
        pessoa.setRg(this.funcionarioView.getFtfRg().getText());
        pessoa.setNome(this.funcionarioView.getTfNome().getText());
        pessoa.setDataNascimento(this.funcionarioView.getFtfDataNasc().getText());
        return pessoa;
    }

    /*
     * método psra retornar um novo objeto
     */
    private Endereco getEndereco() {
        endereco.setNome(this.funcionarioView.getTfEnd().getText());
        endereco.setNumero(Util.getInteger(this.funcionarioView.getTfNumero().getText()));
        endereco.setComplemento(this.funcionarioView.getTfComplemento().getText());
        endereco.setBairro(this.funcionarioView.getTfBairro().getText());
        endereco.setCep(this.funcionarioView.getFtfCep().getText());
        endereco.setCidadeIdCidade(listaCidades.get(this.funcionarioView.getCbxCidade().getSelectedIndex() - 1));
        return endereco;
    }

    /*
     * método psra retornar um novo objeto
     */
    private Contato getContato() {
        contato.setTelefone(this.funcionarioView.getFtfTelefone().getText());
        contato.setCelular(this.funcionarioView.getFtfCelular().getText());
        contato.setEmail(this.funcionarioView.getTfEmail().getText());
        return contato;
    }

    /*
     * método psra retornar um novo objeto
     */
    private Funcionario getFuncionario() {
        funcionario.setLogin(this.funcionarioView.getTfLogin().getText());
        funcionario.setSenha(this.funcionarioView.getPfSenha().getText());
        return funcionario;
    }

    public ArrayList<Funcionario> buscarPorLogin(String login) {
        try {
            return new FuncionarioDAO().buscarPorLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(funcionarioView, Mensagens.consultaFuncionarioErro, Titulos.erro, 0);
        }
        return null;
    }
}
