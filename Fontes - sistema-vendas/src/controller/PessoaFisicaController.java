package controller;

import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import javax.swing.JOptionPane;
import model.PessoaFisica;
import util.Mensagens;
import util.Titulos;

/**
 * Classe responsável por armazenar os métodos de manutenção da base de dados
 * @author willian Carlos Gomes
 * @since 01/04/2021
 * @version 1.0
 */
public class PessoaFisicaController {
    
    /*
    * método para salvar um objeto no banco de dados
    */
    public void salvar(PessoaFisica pessoa) {
        try {
            new PessoaFisicaDAO().salvar(pessoa);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Mensagens.PessoaFisicaErro, Titulos.cadastroPessoaFisica, 0);
        }
    }
    
     /*
    * Método para excluir um objeto
    */
    public void excluir(PessoaFisica pessoa) {
       
        try {
            new PessoaFisicaDAO().excluir(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, Mensagens.pfExcluirErro, Titulos.cadastroPessoaFisica, 0);
        }
        
    }
    
}
