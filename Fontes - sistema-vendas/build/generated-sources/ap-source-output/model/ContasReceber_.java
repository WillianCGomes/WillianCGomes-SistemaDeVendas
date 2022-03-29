package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-08T14:36:19")
@StaticMetamodel(ContasReceber.class)
public class ContasReceber_ { 

    public static volatile SingularAttribute<ContasReceber, String> dataPagamento;
    public static volatile SingularAttribute<ContasReceber, Integer> idContasReceber;
    public static volatile SingularAttribute<ContasReceber, String> dataVencimento;
    public static volatile SingularAttribute<ContasReceber, String> vencida;
    public static volatile SingularAttribute<ContasReceber, Venda> vendaIdVenda;
    public static volatile SingularAttribute<ContasReceber, String> pagamento;

}