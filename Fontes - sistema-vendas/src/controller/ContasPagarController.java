/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ContasPagarView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados da view de contas a pagar
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class ContasPagarController {

    private MenuController menuController;
    private ContasPagarView contasPagarView;

    public ContasPagarController(ContasPagarView tela) {
        this.contasPagarView = tela;
    }

    /*
     * método para carregar a ação do botão novo
     */
    public void acaoBotaoAlterar() {
        this.contasPagarView.getBtAlterar().setEnabled(false);
        this.contasPagarView.getBtSair().setEnabled(false);
        this.contasPagarView.getBtSalvar().setEnabled(false);
        this.contasPagarView.getBtCancelar().setEnabled(true);
        desbloquearCampos();
    }

    public void acaoBotaoSalvar() {

    }

    public void acaoBotaoCancelar() {
        this.contasPagarView.getBtAlterar().setEnabled(true);
        this.contasPagarView.getBtSair().setEnabled(true);
        this.contasPagarView.getBtSalvar().setEnabled(false);
        this.contasPagarView.getBtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.contasPagarView.dispose();
    }

    public void bloqueioInicial() {
        this.contasPagarView.getBtAlterar().setEnabled(false);
        this.contasPagarView.getBtCancelar().setEnabled(false);
        this.contasPagarView.getBtSalvar().setEnabled(false);
        this.contasPagarView.getRbPagoNao().setEnabled(false);
        this.contasPagarView.getRbPagoSim().setEnabled(false);
       
        bloquearCampos();
    }

    public void bloquearCampos() {
        //this.contasPagarView.getTfDataPagamento().setEditable(false);
        //this.contasPagarView.getTfDataVencimento().setEditable(false);
    }

    public void desbloquearCampos() {
        this.contasPagarView.getFtfDataPagamento().setEditable(true);
        this.contasPagarView.getFtfDataVencimento().setEditable(true);
    }

    public void limparCampos() {
        this.contasPagarView.getFtfDataPagamento().setValue(null);
        this.contasPagarView.getFtfDataVencimento().setValue(null);
    }

}
