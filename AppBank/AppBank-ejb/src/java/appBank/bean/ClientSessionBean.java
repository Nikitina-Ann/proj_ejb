/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.bean;

import appBank.entity.*;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;
/**
 *
 * @author ann
 */
@Stateless
public class ClientSessionBean implements ClientSessionBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    public Clients getClientById(int id) {
        Query query = em.createNamedQuery("Clients.findById");
        query.setParameter("id", id);
        Clients client = (Clients) query.getSingleResult();
        return client;
    }
    
    public boolean setResponseClientBid(boolean answer, String bidId) { 
        if (bidId == null || bidId == "")
            return false;
        try{ 
            Bids bid = getBidById(Integer.parseInt(bidId));
            bid.setResponseClient(answer);
            em.persist(bid);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
   
   public boolean createBid(Clients client, String bidSum) {
       if (bidSum == null || bidSum == "")
            return false;
        try {
            int sum = Integer.parseInt(bidSum);
            Date date = new Date();
            Managers manager = getRandomManager();
            Bids bid = new Bids(client, sum ,date, manager);
            client.addBid(bid);
            manager.addBid(bid);
            em.persist(bid);
            em.merge(bid.getClient());
            em.merge(bid.getManager());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
   
    public Managers getRandomManager() {
        Query query = em.createNamedQuery("Managers.findAll");
        List<Managers> managers= query.getResultList();
        int index = new Random().nextInt(managers.size());
        return managers.get(index);
    }
    
    public Bids getBidById(int bidId) {
        Query query = em.createNamedQuery("Bids.findById");
        query.setParameter("id", bidId);
        return (Bids)query.getSingleResult();
    }
    
    public boolean setResponseClientSpecOff(String clientOfferId, boolean answer){
         if (clientOfferId == null || clientOfferId == "")
            return false;
        try {
            ClientOffer clientOffer = getClientOfferById(Integer.parseInt(clientOfferId));
            clientOffer.setResponseClient(answer);
            em.persist(clientOffer);
            return true;
         } catch (Exception ex) {
            return false;
        }
    }
    
     public ClientOffer getClientOfferById(int id) {
        Query query = em.createNamedQuery("ClientOffer.findById");
        query.setParameter("id", id);
        ClientOffer clientOffer = (ClientOffer)query.getSingleResult();
        return clientOffer;
    }
}
