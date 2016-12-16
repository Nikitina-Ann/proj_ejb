package appBank.entity;

import appBank.entity.Bids;
import appBank.entity.ResponseFinancier;
import appBank.entity.RestrBids;
import appBank.entity.Specialoffers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-15T18:56:48")
@StaticMetamodel(Financiers.class)
public class Financiers_ { 

    public static volatile SetAttribute<Financiers, RestrBids> restrBids;
    public static volatile SetAttribute<Financiers, Specialoffers> specialoffers;
    public static volatile SingularAttribute<Financiers, String> name;
    public static volatile SetAttribute<Financiers, Bids> bids;
    public static volatile SingularAttribute<Financiers, Integer> id;
    public static volatile SingularAttribute<Financiers, ResponseFinancier> responseFinancier;

}