package appBank.entity;

import appBank.entity.Bids;
import appBank.entity.Financiers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-15T18:56:48")
@StaticMetamodel(RestrBids.class)
public class RestrBids_ { 

    public static volatile SingularAttribute<RestrBids, Date> date;
    public static volatile SingularAttribute<RestrBids, Boolean> agreement;
    public static volatile SingularAttribute<RestrBids, Financiers> financier;
    public static volatile SingularAttribute<RestrBids, Boolean> responseClient;
    public static volatile SingularAttribute<RestrBids, String> doc;
    public static volatile SingularAttribute<RestrBids, Integer> persent;
    public static volatile SingularAttribute<RestrBids, Integer> id;
    public static volatile SingularAttribute<RestrBids, Integer> time;
    public static volatile SingularAttribute<RestrBids, Bids> bid;
    public static volatile SingularAttribute<RestrBids, Boolean> responseFinancier;

}