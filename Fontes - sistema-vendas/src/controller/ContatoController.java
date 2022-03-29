package controller;

import dao.ContatoDAO;
import javax.swing.JOptionPane;
import model.Contato;
import util.Mensagens;
import util.Titulos;

/**
 * Classe responsável por armazenar os métodos de manutenção da base de dados
 * @author willian Carlos Gomes
 * @since 01/04/2021
 * @version 1.0
 */
public class ContatoController {
    
    /*
    * método para salvar um objeto no banco de dados
    */
    public void salvar(Contato contato) {
        try {
            new ContatoDAO().salvar(contato);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Mensagens.contatoErro, Titulos.cadastroContato, 0);
        }
    }
    
    /*
    * Método para excluir um objeto
    */
    public void excluir(Contato contato) {
       
        try {
            new ContatoDAO().excluir(contato);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, Mensagens.contatoExcluirErro, Titulos.cadastroContato, 0);
        }
        
    }
    
    
}
