
package controller;

import dao.EstadoDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Estado;
import util.Mensagens;
import util.Titulos;

/**
 ** Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados do objeto Estado
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class EstadoController {
    
    /*
    * método para retornar os estados gravados na tabela
    */
   public ArrayList<Estado> buscarTodos() {
       // lista auxiliar para retornar no método
       ArrayList<Estado> retorno = null;
       
       try {
           retorno = new EstadoDAO().buscarTodos();
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, Mensagens.erroConsultaEstados, Titulos.carregamentoDados, 0);
           Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
       }
       return retorno;
   } 
   
   
   
}
