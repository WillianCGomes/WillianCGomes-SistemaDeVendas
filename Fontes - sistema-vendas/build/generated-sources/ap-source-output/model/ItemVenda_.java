package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ItemVendaPK;
import model.Produto;
import model.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Venda> venda;
    public static volatile SingularAttribute<ItemVenda, Double> desconto;
    public static volatile SingularAttribute<ItemVenda, ItemVendaPK> itemVendaPK;
    public static volatile SingularAttribute<ItemVenda, Double> valor;
    public static volatile SingularAttribute<ItemVenda, Integer> quantidade;
    public static volatile SingularAttribute<ItemVenda, Produto> produtoIdProduto;

}