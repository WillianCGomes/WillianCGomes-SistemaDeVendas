package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cliente;
import model.Funcionario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(PessoaFisica.class)
public class PessoaFisica_ { 

    public static volatile ListAttribute<PessoaFisica, Cliente> clienteList;
    public static volatile ListAttribute<PessoaFisica, Funcionario> funcionarioList;
    public static volatile SingularAttribute<PessoaFisica, String> rg;
    public static volatile SingularAttribute<PessoaFisica, Integer> idPessoaFisica;
    public static volatile SingularAttribute<PessoaFisica, String> cpf;
    public static volatile SingularAttribute<PessoaFisica, String> nome;
    public static volatile SingularAttribute<PessoaFisica, String> dataNascimento;

}