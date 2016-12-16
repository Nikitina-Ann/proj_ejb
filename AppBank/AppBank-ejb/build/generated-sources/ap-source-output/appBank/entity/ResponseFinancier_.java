package appBank.entity;

import appBank.entity.Bids;
import appBank.entity.Financiers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-15T18:56:48")
@StaticMetamodel(ResponseFinancier.class)
public class ResponseFinancier_ { 

    public static volatile SingularAttribute<ResponseFinancier, Boolean> answer;
    public static volatile SingularAttribute<ResponseFinancier, Financiers> financier;
    public static volatile SingularAttribute<ResponseFinancier, Integer> persent;
    public static volatile SingularAttribute<ResponseFinancier, Integer> id;
    public static volatile SingularAttribute<ResponseFinancier, Integer> time;
    public static volatile SingularAttribute<ResponseFinancier, Bids> bid;

}