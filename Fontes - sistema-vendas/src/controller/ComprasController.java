/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ConfirmaCompraPrazoView;
import view.CompraView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados das compras
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class ComprasController {
    private MenuController menuController;
    private CompraView compraView;

    public ComprasController(CompraView tela) {
        this.compraView = tela;
    }

    /*
     * método para desbloquear o botão cancelar
     */
    public void desbloqueiaBotaoCancelar() {
        this.compraView.getBtCancelar().setEnabled(true);
    }

    public void bloqueiaFuncionarioFornecedor() {
        this.compraView.getCbxFuncionarios().setEnabled(false);
        this.compraView.getCbxFornecedores().setEnabled(false);
    }

    /*
     * método para desbloquear a combo de fornecedor e botão cancelar
     */
    public void desbloqueiaCbxFonecedor() {
        this.compraView.getCbxFornecedores().setEnabled(true);
        this.compraView.getBtCancelar().setEnabled(true);
    }

    /*
     * método para desbloquear o botão iniciar compra
     */
    public void desbloqueiaBtIniciarCompra() {
        this.compraView.getBtIniciarCompra().setEnabled(true);
    }

    public void acaoBotaoIniciarCompra() {
        this.compraView.getCbxProdutos().setEnabled(true);
        this.compraView.getCbxFuncionarios().setEnabled(false);
        this.compraView.getCbxFornecedores().setEnabled(false);
    }

    /*
     * método para desbloquear o painel de produtos
     */
    public void desbloqueiaProdutos() {
        this.compraView.getBtSalvarProduto().setEnabled(true);
        this.compraView.getBtExcluirProduto().setEnabled(true);
        this.compraView.getTfQuantidade().setEditable(true);

    }

    /*
     * método para gerar a ação do botão Salvar Produto
     */
    public void acaoSalvarProduto() {
        // desbloqueando campos do painel de pagamento
        this.compraView.getCbxFormaPagamento().setEnabled(true);
    }

    /*
     * método para desbloquear os botões de incluir e excluir
     */
    public void desbloqueiaIncluirExcluir() {
        this.compraView.getBtIncluirPagamento().setEnabled(true);
        this.compraView.getBtExcluirPagamento().setEnabled(true);
        this.compraView.getBtConfirmar().setEnabled(true);
    }
    /*
     * método para desbloquear o botão de confirmar e excluir
     */

    public void desbloqueiaConfirmar() {
        this.compraView.getBtConfirmar().setEnabled(true);
    }

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.compraView.dispose();
    }

    public void acaoBotaoCancelar() {
        this.compraView.getCbxFuncionarios().setEnabled(true);
        limparCampos();
        bloquearCampos();
    }

    public void acaoBotaoConfirmar() {
        new ConfirmaCompraPrazoView().setVisible(true);
    }

    public void bloqueioInicial() {
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.compraView.getBtCancelar().setEnabled(false);
        this.compraView.getCbxFuncionarios().setEnabled(true);
        this.compraView.getCbxFornecedores().setEnabled(false);
        this.compraView.getBtIniciarCompra().setEnabled(false);
        this.compraView.getCbxProdutos().setEnabled(false);
        this.compraView.getTfQuantidade().setEditable(false);
        this.compraView.getBtSalvarProduto().setEnabled(false);
        this.compraView.getBtExcluirProduto().setEnabled(false);
        this.compraView.getCbxFormaPagamento().setEnabled(false);
        this.compraView.getBtIncluirPagamento().setEnabled(false);
        this.compraView.getBtExcluirPagamento().setEnabled(false);
        this.compraView.getBtConfirmar().setEnabled(false);
    }

    public void limparCampos() {
        this.compraView.getCbxFuncionarios().setSelectedIndex(0);
        this.compraView.getCbxFornecedores().setSelectedIndex(0);
        this.compraView.getCbxProdutos().setSelectedIndex(0);
        this.compraView.getTfQuantidade().setText(null);
        this.compraView.getCbxFormaPagamento().setSelectedIndex(0);
    }

}
