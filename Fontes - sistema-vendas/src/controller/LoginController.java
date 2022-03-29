package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Funcionario;
import util.Mensagens;
import util.Titulos;
import util.Valida;
import view.LoginView;
import view.MenuView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela do objeto Login
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class LoginController {

    private LoginView tela;
    public static String nomeFuncionario;
    private String usuarioLogado;

    public LoginController() {
    }

    public LoginController(LoginView tela) {
        this.tela = tela;
    }

    public void botaoMostrarSenha() {
        if (tela.getCkbxMostrarSenha().isSelected()) {
            tela.getPfSenha().setEchoChar((char) 0);
        } else {
            tela.getPfSenha().setEchoChar('*');
        }

    }

    public void botaoConfirma() {
        if (validarDados()) {
            efetuarLogin();
        }
    }

    public void botaoSair() throws SQLException {
        int opcao = JOptionPane.showConfirmDialog(null, Mensagens.sairSistema, Titulos.atencao, JOptionPane.YES_OPTION,
                JOptionPane.CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private boolean validarDados() {
        //Validando o campo de usuário
        if (Valida.isEmptyOrNull(tela.getTfLogin().getText())) {
            JOptionPane.showMessageDialog(tela, Mensagens.loginVazio, Titulos.logIn, 0);
            tela.getTfLogin().grabFocus();
            return false;

        }

        //Validando o campo de senha
        if (Valida.isEmptyOrNull(tela.getPfSenha().getText())) {
            JOptionPane.showMessageDialog(tela, Mensagens.senhaVazia, Titulos.logIn, 0);
            tela.getPfSenha().grabFocus();
            return false;

        }

        return true;
    }

    private void efetuarLogin() {
        String login = tela.getTfLogin().getText(),
                senha = tela.getPfSenha().getText();
        boolean localizouLogin = false,
                localizouSenha = false;

        for (Funcionario funcionario : new FuncionarioController().buscarPorLogin(login)) {
            localizouLogin = true;
            if (funcionario.getSenha().equals(senha)) {
                nomeFuncionario = funcionario.getPessoaFisicaIdPessoaFisica().getNome();
                tela.dispose();
                new MenuView().setVisible(true);
                localizouSenha = true;
                usuarioLogado = funcionario.getPessoaFisicaIdPessoaFisica().getNome();
                break;
            } else {
                localizouSenha = false;
            }
        }

        if (localizouLogin == false || localizouSenha == false) {
            JOptionPane.showMessageDialog(null, Mensagens.credenciaisInvalidas, Titulos.logIn, 2);
        }
    }

    public static String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public static void setNomeFuncionario(String nomeFuncionario) {
        LoginController.nomeFuncionario = nomeFuncionario;
    }
    
    
}
