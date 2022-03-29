package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Compra;
import model.ItemCompraPK;
import model.Produto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(ItemCompra.class)
public class ItemCompra_ { 

    public static volatile SingularAttribute<ItemCompra, ItemCompraPK> itemCompraPK;
    public static volatile SingularAttribute<ItemCompra, Compra> compra;
    public static volatile SingularAttribute<ItemCompra, Double> valor;
    public static volatile SingularAttribute<ItemCompra, Integer> quantidade;
    public static volatile SingularAttribute<ItemCompra, Produto> produtoIdProduto;

}