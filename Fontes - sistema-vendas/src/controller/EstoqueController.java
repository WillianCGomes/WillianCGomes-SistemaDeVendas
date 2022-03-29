/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.EstoqueView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados do objeto Estoque
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class EstoqueController {
    private MenuController menuController;
    private EstoqueView estoqueView;
    

    public EstoqueController(EstoqueView tela) {
        this.estoqueView = tela;
    }

    /*
     * método para carregar a ação do botão novo
     */
    public void acaoBotaoNovo() {
        this.estoqueView.getBtNovo().setEnabled(false);
        this.estoqueView.getBtAlterar().setEnabled(false);
        this.estoqueView.getBtExcluir().setEnabled(false);
        this.estoqueView.getBtSair().setEnabled(false);
        this.estoqueView.getBtSalvarEstoque().setEnabled(true);
        this.estoqueView.getBtCancelar().setEnabled(true);
        desbloquearCampos();
    }

    public void acaoBotaoAlterar() {
        this.estoqueView.getBtNovo().setEnabled(false);
        this.estoqueView.getBtAlterar().setEnabled(false);
        this.estoqueView.getBtExcluir().setEnabled(false);
        this.estoqueView.getBtSair().setEnabled(false);
        this.estoqueView.getBtSalvarEstoque().setEnabled(true);
        this.estoqueView.getBtCancelar().setEnabled(true);
    }

    public void acaoBotaoExcluir() {

    }

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.estoqueView.dispose();
    }

    public void acaoBotaoSalvar() {

    }

    public void acaoBotaoCancelar() {
        this.estoqueView.getBtNovo().setEnabled(true);
        this.estoqueView.getBtAlterar().setEnabled(true);
        this.estoqueView.getBtExcluir().setEnabled(true);
        this.estoqueView.getBtSair().setEnabled(true);
        this.estoqueView.getBtSalvarEstoque().setEnabled(false);
        this.estoqueView.getBtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void bloqueioInicial() {
        this.estoqueView.getBtNovo().setEnabled(true);
        this.estoqueView.getBtAlterar().setEnabled(true);
        this.estoqueView.getBtExcluir().setEnabled(true);
        this.estoqueView.getBtSair().setEnabled(true);
        this.estoqueView.getBtSalvarEstoque().setEnabled(false);
        this.estoqueView.getBtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.estoqueView.getTfQuantidadeMinima().setEditable(false);
        this.estoqueView.getTfQuantidadeEstoque().setEditable(false);
        this.estoqueView.getCbxProdutoFornecedor().setEnabled(false);
    }
  
    
    public void desbloquearCampos() {
        this.estoqueView.getTfQuantidadeMinima().setEditable(true);
        this.estoqueView.getTfQuantidadeEstoque().setEditable(true);
        this.estoqueView.getCbxProdutoFornecedor().setEnabled(true);
    }

    public void limparCampos() {
        this.estoqueView.getTfQuantidadeMinima().setText(null);
        this.estoqueView.getTfQuantidadeEstoque().setText(null);
        this.estoqueView.getCbxProdutoFornecedor().setSelectedIndex(0);
    }

  

}
