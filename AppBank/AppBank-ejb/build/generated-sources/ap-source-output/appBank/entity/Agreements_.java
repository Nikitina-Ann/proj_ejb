package appBank.entity;

import appBank.entity.Bids;
import appBank.entity.ClientOffer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-09T11:01:29")
@StaticMetamodel(Agreements.class)
public class Agreements_ { 

    public static volatile SingularAttribute<Agreements, Boolean> extinguished;
    public static volatile SingularAttribute<Agreements, Integer> residualAmount;
    public static volatile SingularAttribute<Agreements, Integer> id;
    public static volatile SingularAttribute<Agreements, Bids> bid;
    public static volatile SingularAttribute<Agreements, ClientOffer> clientOffer;

}