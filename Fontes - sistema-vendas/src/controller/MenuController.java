package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import util.Mensagens;
import util.Titulos;
import view.BackgroundPanel;
import view.ClienteView;
import view.CompraView;
import view.ContasPagarView;
import view.ContasReceberView;
import view.EstoqueView;
import view.FornecedorView;
import view.FuncionarioView;
import view.LoginView;
import view.MenuView;
import view.ProdutoView;
import view.VendaView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de menu do objeto Menu
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class MenuController {

    private LoginView telaLogin = new LoginView();
    private static MenuView menu;
    private Date data = new Date();
    private LoginController loginController = new LoginController();

    public MenuController() {
    }

    public MenuController(MenuView menu) {
        this.menu = menu;
    }

    public void horario() {
        Timer timer = new Timer(1000, new hora());
        timer.start();
    }

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            menu.getLbHora().setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }

    public void data() {
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatar.format(data);
        this.menu.getLbData().setText(dataFormatada);
    }

    public void logout() throws SQLException {
        int opcao = JOptionPane.showConfirmDialog(null, Mensagens.logout, Titulos.atencao, JOptionPane.YES_OPTION,
                JOptionPane.CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            menu.dispose();
            new LoginView().setVisible(true);
        }

    }

    public void botaoSair() {
        int opcao = JOptionPane.showConfirmDialog(null, Mensagens.sairSistema, Titulos.atencao, JOptionPane.YES_OPTION,
                JOptionPane.CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    /*
     * Método para carregar o plano de fundo
     */

    public void carregaBackground() {
        BackgroundPanel planoFundo = new BackgroundPanel();
        menu.getPainelBackground().add(planoFundo);
        planoFundo.setVisible(true);

    }

    /*
     * Método para exibir no rodapé o nome de usuário logado
     */
    public void usuarioLogado() {
        menu.getLbNomeDoUsuario().setText(loginController.getNomeFuncionario());
    }

    /*
     * Método para bloquear o menu principal
     */
    public static void bloquearMenu() {
        menu.getjMenuCadastro().setEnabled(false);
        menu.getjMenuEstoque().setEnabled(false);
        menu.getjMenuCompras().setEnabled(false);
        menu.getjMenuContas().setEnabled(false);
        menu.getjMenuVendas().setEnabled(false);
        menu.getjMenuSistema().setEnabled(false);
        menu.getBtClientes().setEnabled(false);
        menu.getBtCompras().setEnabled(false);
        menu.getBtFornecedor().setEnabled(false);
        menu.getBtFuncionarios().setEnabled(false);
        menu.getBtLogout().setEnabled(false);
        menu.getBtProdutos().setEnabled(false);
        menu.getBtSair().setEnabled(false);
        menu.getBtVendas().setEnabled(false);
    }

    /*
     * Método para desbloquear o menu principal
     */
    public static void desbloquearMenu() {
        menu.getjMenuCadastro().setEnabled(true);
        menu.getjMenuEstoque().setEnabled(true);
        menu.getjMenuCompras().setEnabled(true);
        menu.getjMenuContas().setEnabled(true);
        menu.getjMenuVendas().setEnabled(true);
        menu.getjMenuSistema().setEnabled(true);
        menu.getBtClientes().setEnabled(true);
        menu.getBtCompras().setEnabled(true);
        menu.getBtFornecedor().setEnabled(true);
        menu.getBtFuncionarios().setEnabled(true);
        menu.getBtLogout().setEnabled(true);
        menu.getBtProdutos().setEnabled(true);
        menu.getBtSair().setEnabled(true);
        menu.getBtVendas().setEnabled(true);
    }

    /*
     * Métodos para abrir as janelas
     */
    public void janelaFornecedor() {
        bloquearMenu();
        new FornecedorView().setVisible(true);
    }

    public void janelaCliente() {
        bloquearMenu();
        new ClienteView().setVisible(true);
    }

    public void janelaFuncionario() {
        bloquearMenu();
        new FuncionarioView().setVisible(true);
    }

    public void janelaProdutos() {
        bloquearMenu();
        new ProdutoView().setVisible(true);
    }

    public void janelaVendas() {
        bloquearMenu();
        new VendaView().setVisible(true);
    }

    public void janelaCompras() {
        bloquearMenu();
        new CompraView().setVisible(true);
    }

    public void janelaEstoque() {
        bloquearMenu();
        new EstoqueView().setVisible(true);
    }

    public void janelaContasAPagar() {
        bloquearMenu();
        new ContasPagarView().setVisible(true);
    }

    public void janelaContasAReceber() {
        bloquearMenu();
        new ContasReceberView().setVisible(true);
    }

}
