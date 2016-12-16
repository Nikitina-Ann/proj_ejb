package appBank.entity;

import appBank.entity.Agreements;
import appBank.entity.Clients;
import appBank.entity.Financiers;
import appBank.entity.Managers;
import appBank.entity.ResponseFinancier;
import appBank.entity.RestrBids;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-15T18:56:48")
@StaticMetamodel(Bids.class)
public class Bids_ { 

    public static volatile SingularAttribute<Bids, Date> date;
    public static volatile SingularAttribute<Bids, RestrBids> restrBids;
    public static volatile SingularAttribute<Bids, Agreements> agreement;
    public static volatile SingularAttribute<Bids, Financiers> financier;
    public static volatile SingularAttribute<Bids, Managers> manager;
    public static volatile SingularAttribute<Bids, Boolean> responseClient;
    public static volatile SingularAttribute<Bids, Clients> client;
    public static volatile SingularAttribute<Bids, Integer> sum;
    public static volatile SingularAttribute<Bids, Integer> id;
    public static volatile SingularAttribute<Bids, ResponseFinancier> responseFinancier;

}