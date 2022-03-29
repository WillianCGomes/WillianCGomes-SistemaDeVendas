package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Fornecedor;
import model.Funcionario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Contato.class)
public class Contato_ { 

    public static volatile ListAttribute<Contato, Cliente> clienteList;
    public static volatile SingularAttribute<Contato, String> telefone;
    public static volatile ListAttribute<Contato, Funcionario> funcionarioList;
    public static volatile SingularAttribute<Contato, Integer> idContato;
    public static volatile SingularAttribute<Contato, String> celular;
    public static volatile ListAttribute<Contato, Fornecedor> fornecedorList;
    public static volatile SingularAttribute<Contato, String> email;

}