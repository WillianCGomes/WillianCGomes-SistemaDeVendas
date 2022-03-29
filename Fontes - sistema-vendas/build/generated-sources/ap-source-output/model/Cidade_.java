package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Endereco;
import model.Estado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Cidade.class)
public class Cidade_ { 

    public static volatile ListAttribute<Cidade, Endereco> enderecoList;
    public static volatile SingularAttribute<Cidade, Integer> idCidade;
    public static volatile SingularAttribute<Cidade, String> nome;
    public static volatile SingularAttribute<Cidade, Estado> estadoIdEstado;

}