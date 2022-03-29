package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cidade;
import model.Cliente;
import model.Fornecedor;
import model.Funcionario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile ListAttribute<Endereco, Cliente> clienteList;
    public static volatile ListAttribute<Endereco, Funcionario> funcionarioList;
    public static volatile SingularAttribute<Endereco, String> complemento;
    public static volatile SingularAttribute<Endereco, Integer> numero;
    public static volatile SingularAttribute<Endereco, Integer> idEndereco;
    public static volatile SingularAttribute<Endereco, String> bairro;
    public static volatile SingularAttribute<Endereco, String> nome;
    public static volatile ListAttribute<Endereco, Fornecedor> fornecedorList;
    public static volatile SingularAttribute<Endereco, Cidade> cidadeIdCidade;
    public static volatile SingularAttribute<Endereco, String> cep;

}