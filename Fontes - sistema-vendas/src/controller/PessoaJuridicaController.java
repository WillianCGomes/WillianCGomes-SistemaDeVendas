package controller;

import dao.PessoaJuridicaDAO;
import javax.swing.JOptionPane;
import model.PessoaJuridica;
import util.Mensagens;
import util.Titulos;

/**
 * Classe responsável por armazenar os métodos de manutenção da base de dados
 * @author willian Carlos Gomes
 * @since 01/04/2021
 * @version 1.0
 */
public class PessoaJuridicaController {
    
    /*
    * método para salvar um objeto no banco de dados
    */
    public void salvar(PessoaJuridica pessoa) {
        try {
            new PessoaJuridicaDAO().salvar(pessoa);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Mensagens.PessoaJuridicaErro, Titulos.cadastroPessoaJuridica, 0);
        }
    }
    
     /*
    * Método para excluir um objeto
    */
    public void excluir(PessoaJuridica pessoa) {
       
        try {
            new PessoaJuridicaDAO().excluir(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, Mensagens.pjExcluirErro, Titulos.cadastroPessoaJuridica, 0);
        }
        
    }
    
}
