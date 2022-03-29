package controller;

import dao.EnderecoDAO;
import javax.swing.JOptionPane;
import model.Endereco;
import util.Mensagens;
import util.Titulos;

/**
 * Classe responsável por armazenar os métodos de manutenção da base de dados
 * @author willian Carlos Gomes
 * @since 01/04/2021
 * @version 1.0
 */
public class EnderecoController {
    
    /*
    * método para salvar um objeto no banco de dados
    */
    public void salvar(Endereco endereco) {
        try {
            new EnderecoDAO().salvar(endereco);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Mensagens.enderecoErro, Titulos.cadastroEndereco, 0);
        }
    }
    
     /*
    * Método para excluir um objeto
    */
    public void excluir(Endereco endereco) {
       
        try {
            new EnderecoDAO().excluir(endereco);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, Mensagens.enderecoExcluirErro, Titulos.cadastroEndereco, 0);
        }
        
    }
    
}
