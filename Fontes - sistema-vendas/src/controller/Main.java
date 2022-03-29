package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import util.ProgressBar;
import view.LoginView;

/**
 * Classe responsável por executar o programa
 *
 * @author Willian Carlos Gomes
 * @since 22/03/2021
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        
  
        
        
        try {
          //  Alteração nos parâmetros visuais da janela
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
      
        }
        new ProgressBar().progressBar();
        new LoginView().setVisible(true);

    }

}
