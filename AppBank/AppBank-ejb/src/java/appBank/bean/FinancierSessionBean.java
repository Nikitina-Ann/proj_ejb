/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.bean;

import appBank.entity.*;
import javax.ejb.*;
import javax.persistence.*;
import java.util.*;
import javax.ejb.*;
import appBank.bean.FinancierSessionBeanLocal;
/** Creates a new instance of

/**
 *
 * @author ann
 */
@Stateless

public class FinancierSessionBean implements FinancierSessionBeanLocal{

    @PersistenceContext
    private EntityManager em;
    //em = Persistence.createEntityManagerFactory("AppBank-ejbPU").createEntityManager();
    
    public Financiers getFinancierById(int id) {
        Query query = em.createNamedQuery("Financiers.findById");
        query.setParameter("id", id);
        Financiers financier = (Financiers)query.getSingleResult();
        return financier;
    }
    
    public boolean setResponseFinancier(String bidId, String financierId, Boolean answer, String time, String persent){
        if (bidId==null || bidId=="" || financierId==null || financierId=="")
            return false;
        try {
            Bids bid = getBidById(Integer.parseInt(bidId));
            Financiers financier = getFinancierById(Integer.parseInt(financierId));
            ResponseFinancier responseFinancier = ResponseFinancier.createResponseFinancier(bid, financier, answer, time, persent);
            bid.setResponseFinancier(responseFinancier);
            em.persist(responseFinancier);
            em.merge(bid);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public Bids getBidById(int bidId) {
        Query query = em.createNamedQuery("Bids.findById");
        query.setParameter("id", bidId);
        return (Bids)query.getSingleResult();
    }

    public boolean createSpecialoffer(String financierId, String summa, String time, String persent){
        if (summa==null || summa=="" || financierId==null || financierId==""
             || time==null || time=="" || persent==null || persent=="")
            return false;
        try {
            Financiers financier = getFinancierById(Integer.parseInt(financierId));
            Specialoffers specialoffer= new Specialoffers(financier, Integer.parseInt(summa),
                                                            Integer.parseInt(time), Integer.parseInt(persent));
            financier.addSpecialoffers(specialoffer);
            em.persist(specialoffer);
            em.merge(financier);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
