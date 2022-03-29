package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.EstoquePK;
import model.Produto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Estoque.class)
public class Estoque_ { 

    public static volatile SingularAttribute<Estoque, EstoquePK> estoquePK;
    public static volatile SingularAttribute<Estoque, Produto> produto;
    public static volatile SingularAttribute<Estoque, Integer> quantidadeMinima;
    public static volatile SingularAttribute<Estoque, Integer> quantidadeAtual;

}