package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ContaPagar;
import model.Fornecedor;
import model.Funcionario;
import model.ItemCompra;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, String> formaPagamento;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedorIdFornecedor;
    public static volatile ListAttribute<Compra, ItemCompra> itemCompraList;
    public static volatile ListAttribute<Compra, ContaPagar> contaPagarList;
    public static volatile SingularAttribute<Compra, String> data;
    public static volatile SingularAttribute<Compra, Integer> idCompra;
    public static volatile SingularAttribute<Compra, Double> valor;
    public static volatile SingularAttribute<Compra, Funcionario> funcionarioIdFuncionario;

}