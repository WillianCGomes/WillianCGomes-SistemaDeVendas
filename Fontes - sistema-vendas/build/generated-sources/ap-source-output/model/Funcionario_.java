package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Compra;
import model.Contato;
import model.Endereco;
import model.LogUsuario;
import model.PessoaFisica;
import model.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, Endereco> enderecoIdEndereco;
    public static volatile SingularAttribute<Funcionario, String> senha;
    public static volatile ListAttribute<Funcionario, Venda> vendaList;
    public static volatile ListAttribute<Funcionario, LogUsuario> logUsuarioList;
    public static volatile SingularAttribute<Funcionario, Integer> idFuncionario;
    public static volatile SingularAttribute<Funcionario, String> login;
    public static volatile ListAttribute<Funcionario, Compra> compraList;
    public static volatile SingularAttribute<Funcionario, Contato> contatoIdContato;
    public static volatile SingularAttribute<Funcionario, PessoaFisica> pessoaFisicaIdPessoaFisica;

}