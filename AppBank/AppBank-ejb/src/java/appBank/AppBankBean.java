/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank;

import javax.ejb.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Persistence;
import java.util.*;
import javax.ejb.*;

/** Creates a new instance of

/**
 *
 * @author ann
 */
@Stateless
public class AppBankBean implements AppBankBeanLocal {
    //@PersistenceContext
    private EntityManager em = Persistence.createEntityManagerFactory("AppBank-ejbPU").createEntityManager();
    
    public AppBankBean() {
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String getClientNameById(int id) {
        Query query = em.createNamedQuery("Clients.findById");
        query.setParameter("id", id);
        Clients addresses = (Clients)query.getSingleResult();
        em.close();
        if(addresses != null)
            return addresses.getName();
        else
            return "n/a";
    }
    
    public List<Bids> getBidsForClient(int id) {
        Query query = em.createNamedQuery("Bids.findByClientId");
        query.setParameter("clientId", id);
        List<Bids> clients = query.getResultList();
        em.close();
        return clients;
    }
 
    public List<ClientOffer> getSpecialOffersForClient(int id) {
        Query query = em.createNamedQuery("ClientOffer.findByClientId");
        query.setParameter("clientId", id);
        List<ClientOffer> clients = query.getResultList();
        em.close();
        return clients;
    }
}
