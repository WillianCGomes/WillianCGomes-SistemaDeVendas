package controller;

import dao.CidadeDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Estado;
import util.Mensagens;
import util.Titulos;

/**
 * Classe responsável por controlar os métodos de acesso a base de dados
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class CidadeController {
    
    /*
    * método para retornar os estados gravados na tabela
    */
    public ArrayList<Cidade> buscarPorEstado(Estado estado) {
        //lista auxiliar para retornar no método
        ArrayList<Cidade> retorno = null;
        
        try {
            retorno = new CidadeDAO().buscarPorEstado(estado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, Mensagens.erroConsultaCidades, Titulos.carregamentoDados, 0);
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
}