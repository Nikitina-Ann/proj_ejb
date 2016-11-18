package appBank;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T07:10:22")
@StaticMetamodel(Bids.class)
public class Bids_ { 

    public static volatile SingularAttribute<Bids, Date> date;
    public static volatile SingularAttribute<Bids, Integer> clientId;
    public static volatile SingularAttribute<Bids, Boolean> responseClient;
    public static volatile SingularAttribute<Bids, Integer> agreementId;
    public static volatile SingularAttribute<Bids, Integer> financierId;
    public static volatile SingularAttribute<Bids, Integer> sum;
    public static volatile SingularAttribute<Bids, Integer> id;
    public static volatile SingularAttribute<Bids, Integer> managerId;

}