package appBank.entity;

import appBank.entity.ClientOffer;
import appBank.entity.Financiers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-15T18:56:48")
@StaticMetamodel(Specialoffers.class)
public class Specialoffers_ { 

    public static volatile SingularAttribute<Specialoffers, Financiers> financier;
    public static volatile SingularAttribute<Specialoffers, Integer> sum;
    public static volatile SingularAttribute<Specialoffers, Integer> persent;
    public static volatile SingularAttribute<Specialoffers, Integer> id;
    public static volatile SingularAttribute<Specialoffers, Integer> time;
    public static volatile SetAttribute<Specialoffers, ClientOffer> clientOffer;

}