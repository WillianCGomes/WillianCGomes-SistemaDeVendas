package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Estoque;
import model.Fornecedor;
import model.ItemCompra;
import model.ItemVenda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile ListAttribute<Produto, ItemCompra> itemCompraList;
    public static volatile SingularAttribute<Produto, Fornecedor> fornecedorIdFornecedor;
    public static volatile ListAttribute<Produto, Estoque> estoqueList;
    public static volatile SingularAttribute<Produto, Double> valorCusto;
    public static volatile SingularAttribute<Produto, Integer> idProduto;
    public static volatile SingularAttribute<Produto, Double> valorVenda;
    public static volatile ListAttribute<Produto, ItemVenda> itemVendaList;
    public static volatile SingularAttribute<Produto, String> descricao;

}