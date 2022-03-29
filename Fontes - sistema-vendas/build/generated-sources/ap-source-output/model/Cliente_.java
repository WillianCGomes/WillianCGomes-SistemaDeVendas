package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Contato;
import model.Endereco;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Endereco> enderecoIdEndereco;
    public static volatile SingularAttribute<Cliente, String> tipoPessoa;
    public static volatile SingularAttribute<Cliente, PessoaJuridica> pessoaJuridicaIdPessoaJuridica;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile ListAttribute<Cliente, Venda> vendaList;
    public static volatile SingularAttribute<Cliente, Contato> contatoIdContato;
    public static volatile SingularAttribute<Cliente, PessoaFisica> pessoaFisicaIdPessoaFisica;

}