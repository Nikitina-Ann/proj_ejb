package appBank.entity;

import appBank.entity.Agreements;
import appBank.entity.Clients;
import appBank.entity.Specialoffers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-15T18:56:48")
@StaticMetamodel(ClientOffer.class)
public class ClientOffer_ { 

    public static volatile SingularAttribute<ClientOffer, Agreements> agreement;
    public static volatile SingularAttribute<ClientOffer, Specialoffers> specialoffer;
    public static volatile SingularAttribute<ClientOffer, Boolean> responseClient;
    public static volatile SingularAttribute<ClientOffer, Clients> client;
    public static volatile SingularAttribute<ClientOffer, Integer> id;

}