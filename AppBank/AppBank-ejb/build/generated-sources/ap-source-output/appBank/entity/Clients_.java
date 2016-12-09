package appBank.entity;

import appBank.entity.Bids;
import appBank.entity.ClientOffer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-09T11:01:29")
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile SingularAttribute<Clients, Integer> revenue;
    public static volatile SingularAttribute<Clients, String> name;
    public static volatile SingularAttribute<Clients, Integer> rating;
    public static volatile SetAttribute<Clients, Bids> bids;
    public static volatile SingularAttribute<Clients, Integer> id;
    public static volatile SetAttribute<Clients, ClientOffer> clientOffer;

}