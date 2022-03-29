/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ConfirmaVendaPrazoView;
import view.VendaView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados das vendas
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class VendasController {
    private MenuController menuController;
    private VendaView vendaView;

    public VendasController(VendaView tela) {
        this.vendaView = tela;
    }

    /*
     * método para desbloquear o botão cancelar
     */
    public void desbloqueiaBotaoCancelar() {
        this.vendaView.getBtCancelarVenda().setEnabled(true);
    }
    
    public void bloqueiaCbxClienteFuncionario() {
        this.vendaView.getCbxClientes().setEnabled(false);
        this.vendaView.getCbxFuncionarios().setEnabled(false);
    }

    /*
     * método para desbloquear a combo de funcionários e botão cancelar
     */
    public void desbloqueiaCbxFuncionarios() {
        this.vendaView.getCbxFuncionarios().setEnabled(true);
        this.vendaView.getBtCancelarVenda().setEnabled(true);
    }

    /*
     * método para desbloquear o botão iniciar venda
     */
    public void desbloqueiaBtIniciarVenda() {
        this.vendaView.getBtIniciarVenda().setEnabled(true);
    }

    public void desbloqueiaComboProdutos(){
        this.vendaView.getCbxProdutos().setEnabled(true);
    }
    
    /*
     * método para desbloquear o painel de produtos
     */
    public void desbloqueiaProdutos() {
        this.vendaView.getTfQuantidade().setEditable(true);
        this.vendaView.getTfDescontoProduto().setEditable(true);
        this.vendaView.getBtSalvarProduto().setEnabled(true);
        this.vendaView.getBtExcluirProduto().setEnabled(true);

    }

    /*
     * método para gerar a ação do botão Salvar Produto
     */
    public void acaoSalvarProduto() {
        // desbloqueando campos do painel de pagamento
        this.vendaView.getCbxFormaPagamento().setEnabled(true);
        this.vendaView.getTfDescontoPagamento().setEditable(true);
       

    }
    /*
     * método para desbloquear os botões de incluir e excluir
     */

    public void desbloqueiaIncluirExcluir() {
        this.vendaView.getBtIncluir().setEnabled(true);
        this.vendaView.getBtExcluirPagamento().setEnabled(true);
    }

    
    /*
     * método para desbloquear o botão de confirmar e excluir
     */
    public void desbloqueiaConfirmar() {
        this.vendaView.getBtConfirmarVenda().setEnabled(true);
    }

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.vendaView.dispose();
    }

    public void acaoBotaoCancelar() {
        this.vendaView.getCbxClientes().setEnabled(true);
        limparCampos();
        bloquearCampos();
    }
    
    public void acaoBotaoConfirmar(){
        new ConfirmaVendaPrazoView().setVisible(true);
    }

    public void bloqueioInicial() {

        bloquearCampos();
    }

    public void bloquearCampos() {
        this.vendaView.getBtCancelarVenda().setEnabled(false);
        this.vendaView.getCbxFuncionarios().setEnabled(false);
        this.vendaView.getBtIniciarVenda().setEnabled(false);
        this.vendaView.getCbxProdutos().setEnabled(false);
        this.vendaView.getTfQuantidade().setEditable(false);
        this.vendaView.getTfDescontoProduto().setEditable(false);
        this.vendaView.getBtSalvarProduto().setEnabled(false);
        this.vendaView.getBtExcluirProduto().setEnabled(false);
        this.vendaView.getCbxFormaPagamento().setEnabled(false);
        this.vendaView.getTfDescontoPagamento().setEditable(false);
        this.vendaView.getBtIncluir().setEnabled(false);
        this.vendaView.getBtExcluirPagamento().setEnabled(false);
        this.vendaView.getBtConfirmarVenda().setEnabled(false);
    }

    public void limparCampos() {
        this.vendaView.getCbxClientes().setSelectedIndex(0);
        this.vendaView.getCbxFuncionarios().setSelectedIndex(0);
        this.vendaView.getCbxProdutos().setSelectedIndex(0);
        this.vendaView.getTfQuantidade().setText(null);
        this.vendaView.getTfDescontoProduto().setText(null);
        this.vendaView.getCbxFormaPagamento().setSelectedIndex(0);
        this.vendaView.getTfDescontoPagamento().setText(null);
    }

}
