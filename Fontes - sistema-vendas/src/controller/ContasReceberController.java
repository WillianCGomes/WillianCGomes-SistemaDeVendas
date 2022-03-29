/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ContasReceberView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados da view de contas a receber
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class ContasReceberController {

    private MenuController menuController;
    private ContasReceberView contasReceberView;

    public ContasReceberController(ContasReceberView tela) {
        this.contasReceberView = tela;
    }

    /*
     * método para carregar a ação do botão novo
     */
    public void acaoBotaoAlterar() {
        this.contasReceberView.getBtAlterar().setEnabled(false);
        this.contasReceberView.getBtSair().setEnabled(false);
        this.contasReceberView.getBtSalvar().setEnabled(false);
        this.contasReceberView.getBtCancelar().setEnabled(true);
        desbloquearCampos();
    }

    public void acaoBotaoSalvar() {

    }

    public void acaoBotaoCancelar() {
        this.contasReceberView.getBtAlterar().setEnabled(true);
        this.contasReceberView.getBtSair().setEnabled(true);
        this.contasReceberView.getBtSalvar().setEnabled(false);
        this.contasReceberView.getBtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.contasReceberView.dispose();
    }

    public void bloqueioInicial() {
        this.contasReceberView.getBtAlterar().setEnabled(false);
        this.contasReceberView.getBtCancelar().setEnabled(false);
        this.contasReceberView.getBtSalvar().setEnabled(false);
        this.contasReceberView.getRbPagoNao().setEnabled(false);
        this.contasReceberView.getRbPagoSim().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.contasReceberView.getTfDataPagamento().setEditable(false);
        this.contasReceberView.getTfDataVencimento().setEditable(false);
    }

    public void desbloquearCampos() {
        this.contasReceberView.getTfDataPagamento().setEditable(true);
        this.contasReceberView.getTfDataVencimento().setEditable(true);
    }

    public void limparCampos() {
        this.contasReceberView.getTfDataPagamento().setValue(null);
        this.contasReceberView.getTfDataVencimento().setValue(null);
    }

}
