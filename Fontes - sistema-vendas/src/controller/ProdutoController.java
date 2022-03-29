/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cidade;
import model.Estado;
import model.Fornecedor;
import model.Produto;
import model.Produto_;
import util.Mensagens;
import util.Titulos;
import util.Valida;
import view.ProdutoView;

/**
 * Classe responsável por armazenar a inteligência de todos os processos de
 * controle de tela e banco de dados do objeto Produto
 *
 * @author Willian Carlos Gomes
 * @since 24/03/2021
 * @version 1.0
 */
public class ProdutoController {

    private MenuController menuController;
    private ProdutoView produtoView;
    private ArrayList<Produto> listaProdutos;
    private ArrayList<Fornecedor> listaFornecedores;

    private Fornecedor fornecedor;
    private Produto produto;
    private boolean alterar;

    public ProdutoController(ProdutoView tela) {
        this.produtoView = tela;
    }

    /*
     * método para carregar a ação do botão novo
     */
    public void acaoBotaoNovo() {
        alterar = false;
        this.produtoView.getBtNovo().setEnabled(false);
        this.produtoView.getBtAlterar().setEnabled(false);
        this.produtoView.getBtExcluir().setEnabled(false);
        this.produtoView.getBtSair().setEnabled(false);
        this.produtoView.getBtSalvarProduto().setEnabled(true);
        this.produtoView.getBtCancelar().setEnabled(true);
        desbloquearCampos();
    }

    public void acaoBotaoAlterar() {
        alterar = true;
        if (produtoView.getTabelaProdutos().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.selecioneProduto, Titulos.cadastroProduto, 0);
        } else {
            produto = listaProdutos.get(produtoView.getTabelaProdutos().getSelectedRow());
            bloqueioAlterar();
            carregarTela();
        }
    }

    public void acaoBotaoExcluir() {
        if (produtoView.getTabelaProdutos().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.selecioneProduto, Titulos.cadastroProduto, 0);
        } else {
            int opcao = JOptionPane.showConfirmDialog(produtoView, Mensagens.excluirProduto, Titulos.cadastroProduto, 2);
            if (opcao == JOptionPane.YES_OPTION) {
                produto = listaProdutos.get(produtoView.getTabelaProdutos().getSelectedRow());
                new ProdutoDAO().excluir(produto);
                JOptionPane.showMessageDialog(produtoView, Mensagens.produtoExcluido, Titulos.cadastroProduto, 1);
                carregarTabela();
            }

        }

    } // Fim do método acaoBotaoExcluir

    public void acaoBotaoSair() {
        menuController.desbloquearMenu();
        this.produtoView.dispose();
    }

    public void acaoBotaoSalvar() {
        if (validarDados()) {
            if (alterar) {
                fornecedor = produto.getFornecedorIdFornecedor();
            } else { // incluir
                produto = new Produto();
            }
            produto = getProduto();
            try {
                new ProdutoDAO().salvar(produto);
                JOptionPane.showMessageDialog(produtoView, Mensagens.produtoSalvo, Titulos.cadastroProduto, 1);
                limparCampos();
                bloqueioInicial();
                carregarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(produtoView, Mensagens.produtoErro, Titulos.cadastroProduto, 1);
            }
        }

    }

    public void acaoBotaoCancelar() {
        this.produtoView.getBtNovo().setEnabled(true);
        this.produtoView.getBtAlterar().setEnabled(true);
        this.produtoView.getBtExcluir().setEnabled(true);
        this.produtoView.getBtSair().setEnabled(true);
        this.produtoView.getBtSalvarProduto().setEnabled(false);
        this.produtoView.getBtCancelar().setEnabled(false);
        limparCampos();
        bloquearCampos();
    }

    public void bloqueioInicial() {
        this.produtoView.getBtNovo().setEnabled(true);
        this.produtoView.getBtAlterar().setEnabled(true);
        this.produtoView.getBtExcluir().setEnabled(true);
        this.produtoView.getBtSair().setEnabled(true);
        this.produtoView.getBtSalvarProduto().setEnabled(false);
        this.produtoView.getBtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void bloquearCampos() {
        this.produtoView.getTfDescricao().setEditable(false);
        this.produtoView.getCbxFornecedores().setEnabled(false);
        this.produtoView.getTfValorCusto().setEditable(false);
        this.produtoView.getTfValorVenda().setEditable(false);
    }

    public void desbloquearCampos() {
        this.produtoView.getTfDescricao().setEditable(true);
        this.produtoView.getCbxFornecedores().setEnabled(true);
        this.produtoView.getTfValorCusto().setEditable(true);
        this.produtoView.getTfValorVenda().setEditable(true);
    }

    public void limparCampos() {
        this.produtoView.getTfDescricao().setText(null);
        this.produtoView.getCbxFornecedores().setSelectedIndex(0);;
        this.produtoView.getTfValorCusto().setText(null);
        this.produtoView.getTfValorVenda().setText(null);
    }

    /*
     * Método para validar os dados
     */
    private boolean validarDados() {

        // validando a descrição
        if (Valida.isEmptyOrNull(produtoView.getTfDescricao().getText())) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.descricaoVazia, Titulos.cadastroProduto, 0);
            this.produtoView.getTfDescricao().grabFocus();
            return false;
        }

        //validando o fornecedor
        if (Valida.isComboInvalida(produtoView.getCbxFornecedores().getSelectedIndex())) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.fornecedorVazio, Titulos.cadastroProduto, 0);
            this.produtoView.getCbxFornecedores().grabFocus();
            return false;
        }

        //validando o valor de custo
        if (Valida.isEmptyOrNull(produtoView.getTfValorCusto().getText())) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.valorCustoVazio, Titulos.cadastroProduto, 0);
            this.produtoView.getTfValorCusto().grabFocus();
            return false;
        } else if (!Valida.isDouble(produtoView.getTfValorCusto().getText())) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.valorCustoInvalido, Titulos.cadastroProduto, 0);
            this.produtoView.getTfValorCusto().grabFocus();
            return false;
        }

        //validando o valor de venda
        if (Valida.isEmptyOrNull(produtoView.getTfValorVenda().getText())) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.valorVendaVazio, Titulos.cadastroProduto, 0);
            this.produtoView.getTfValorVenda().grabFocus();
            return false;
        } else if (!Valida.isDouble(produtoView.getTfValorVenda().getText())) {
            JOptionPane.showMessageDialog(produtoView, Mensagens.valorVendaInvalido, Titulos.cadastroProduto, 0);
            this.produtoView.getTfValorVenda().grabFocus();
            return false;
        }

        return true;
    }

    /*
     * método para carregar combo fornecedores
     */
    public void carregarComboFornecedor() {
        listaFornecedores = new FornecedorController().buscarTodos();
        this.produtoView.getCbxFornecedores().addItem("- Selecione o Fornecedor -");
        for (Fornecedor fornecedor : listaFornecedores) {
            this.produtoView.getCbxFornecedores().addItem(fornecedor.getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        }
    }
    /*
     * Método responsável por chamar o DAO e carregar produtos cadastrados no banco de dados
     */

    private ArrayList<Produto> buscarTodos() {
        try {
            return listaProdutos = new ProdutoDAO().buscarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(produtoView, Mensagens.consultaProdutoErro, Titulos.cadastroProduto, 0);
        }
        return null;
    }

    /*
     * método para bloquear os campos ao selecionar o botão alterar
     */
    private void bloqueioAlterar() {
        this.produtoView.getBtNovo().setEnabled(false);
        this.produtoView.getBtAlterar().setEnabled(false);
        this.produtoView.getBtExcluir().setEnabled(false);
        this.produtoView.getBtSair().setEnabled(false);
        this.produtoView.getBtSalvarProduto().setEnabled(true);
        this.produtoView.getBtCancelar().setEnabled(true);
        this.produtoView.getTfDescricao().setEditable(true);
        this.produtoView.getCbxFornecedores().setEnabled(true);
        this.produtoView.getTfValorCusto().setEditable(true);
        this.produtoView.getTfValorVenda().setEditable(true);
    }

    /*
     * Método para carregar a tabela com os funcionários cadastrados
     */
    public void carregarTabela() {
        buscarTodos();
        DefaultTableModel modelo = (DefaultTableModel) produtoView.getTabelaProdutos().getModel();
        //limpar a tabela
        modelo.setRowCount(0);
        //carregar a tabela
        for (Produto produto : listaProdutos) {
            modelo.addRow(new String[]{produto.getDescricao(),
                produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial(),
                produto.getValorCusto() + "",
                produto.getValorVenda() + ""}
            );
        }
    }

    /*
     * Método para carregar a tela com os dados do produto
     */
    private void carregarTela() {
        produtoView.getTfDescricao().setText(produto.getDescricao());
        produtoView.getCbxFornecedores().setSelectedItem(produto.getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
        produtoView.getTfValorCusto().setText(produto.getValorCusto() + "");
        produtoView.getTfValorVenda().setText(produto.getValorVenda() + "");
    }

    /*
     * método psra retornar um novo objeto
     */
    private Produto getProduto() {
        produto.setDescricao(this.produtoView.getTfDescricao().getText());
        produto.setFornecedorIdFornecedor(listaFornecedores.get(this.produtoView.getCbxFornecedores().getSelectedIndex() - 1));
        produto.setValorCusto(Double.parseDouble(this.produtoView.getTfValorCusto().getText()));
        produto.setValorVenda(Double.parseDouble(this.produtoView.getTfValorVenda().getText()));
        return produto;
    }

}
