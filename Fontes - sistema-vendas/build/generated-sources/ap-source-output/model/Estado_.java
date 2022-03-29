package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cidade;
import model.Regiao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile ListAttribute<Estado, Cidade> cidadeList;
    public static volatile SingularAttribute<Estado, String> uf;
    public static volatile SingularAttribute<Estado, Integer> idEstado;
    public static volatile SingularAttribute<Estado, String> nome;
    public static volatile SingularAttribute<Estado, Integer> codigoUf;
    public static volatile SingularAttribute<Estado, Regiao> regiaoIdRegiao;

}