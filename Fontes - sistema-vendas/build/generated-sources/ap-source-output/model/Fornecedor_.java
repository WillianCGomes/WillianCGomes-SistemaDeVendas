package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Compra;
import model.Contato;
import model.Endereco;
import model.PessoaJuridica;
import model.Produto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile SingularAttribute<Fornecedor, Endereco> enderecoIdEndereco;
    public static volatile SingularAttribute<Fornecedor, Integer> idFornecedor;
    public static volatile SingularAttribute<Fornecedor, PessoaJuridica> pessoaJuridicaIdPessoaJuridica;
    public static volatile ListAttribute<Fornecedor, Produto> produtoList;
    public static volatile ListAttribute<Fornecedor, Compra> compraList;
    public static volatile SingularAttribute<Fornecedor, Contato> contatoIdContato;
    public static volatile SingularAttribute<Fornecedor, String> contato;

}