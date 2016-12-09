package appBank.entity;

import appBank.entity.Bids;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-09T11:01:29")
@StaticMetamodel(Managers.class)
public class Managers_ { 

    public static volatile SingularAttribute<Managers, String> name;
    public static volatile SetAttribute<Managers, Bids> bids;
    public static volatile SingularAttribute<Managers, Integer> id;

}