package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.ContasReceber;
import model.Funcionario;
import model.ItemVenda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, String> formaPagamento;
    public static volatile SingularAttribute<Venda, String> data;
    public static volatile SingularAttribute<Venda, Double> valor;
    public static volatile SingularAttribute<Venda, Funcionario> funcionarioIdFuncionario;
    public static volatile SingularAttribute<Venda, Cliente> clienteIdCliente;
    public static volatile ListAttribute<Venda, ItemVenda> itemVendaList;
    public static volatile ListAttribute<Venda, ContasReceber> contasReceberList;
    public static volatile SingularAttribute<Venda, Integer> idVenda;

}