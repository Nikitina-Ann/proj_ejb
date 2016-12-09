/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.bean;

import appBank.entity.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author ann
 */
@Stateless
public class ManagerSessionBean implements ManagerSessionBeanLocal {
    @PersistenceContext
    private EntityManager em;
    
    
    public boolean setFinancierForBid(String bidId, String financierId) {
       if (bidId == null || bidId == "" || financierId == null || financierId== "")
            return false;
        try {
            Bids bid = getBidById(Integer.parseInt(bidId));
            Financiers financier = getFinancierById(Integer.parseInt(financierId));
            bid.setFinancier(financier);
            financier.addBid(bid);
            em.persist(bid);
            em.merge(financier);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
     public Managers getManagerById(int id) {
        Query query = em.createNamedQuery("Managers.findById");
        query.setParameter("id", id);
        Managers managers = (Managers)query.getSingleResult();
        return managers;
    }
     
      public Set<RestrBids> getRestrBidsForManager(Managers manager) {
        Query query = em.createNamedQuery("RestrBids.findAll");
        List<RestrBids> restrBids = query.getResultList();
        Set<RestrBids> restrBidsMananger = new HashSet();
        for(RestrBids restrBid:restrBids){
            if (manager.getBids().contains(restrBid.getBid()) && restrBid.getFinancier() == null) {
                restrBidsMananger.add(restrBid);
            }
        }
        return restrBidsMananger;
    }
    
    public List<Financiers> getAllFinanciers() {
        Query query = em.createNamedQuery("Financiers.findAll");
        List<Financiers> financiers = query.getResultList();
        return financiers;
    }
    
    public List<Clients> getAllClients() {
        Query query = em.createNamedQuery("Clients.findAll");
        List<Clients> clients = query.getResultList();
        return clients;
    }
    
    public List<ClientOffer> getAllClientOffers() {
        Query query = em.createNamedQuery("ClientOffer.findAll");
        List<ClientOffer> clientOffer = query.getResultList();
        return clientOffer;
    }
    
     public List<Specialoffers> getAllSpecialoffers() {
        Query query = em.createNamedQuery("Specialoffers.findAll");
        List<Specialoffers> specialoffers = query.getResultList();
        return specialoffers;
    }
    
    public Financiers getFinancierById(int id) {
        Query query = em.createNamedQuery("Financiers.findById");
        query.setParameter("id", id);
        Financiers financier = (Financiers)query.getSingleResult();
        return financier;
    }
    
    public Bids getBidById(int bidId) {
        Query query = em.createNamedQuery("Bids.findById");
        query.setParameter("id", bidId);
        return (Bids)query.getSingleResult();
    }
    
     public boolean enterAgreementBid(String bidId) {
        if (bidId == null || bidId == "")
            return false;
        try{
            Bids bid = getBidById(Integer.parseInt(bidId));
            Agreements agreement = new Agreements(bid);
            bid.setAgreement(agreement);
            em.persist(agreement);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
     
    public boolean enterAgreementSpecOffer(String clientOfferId) {
        if (clientOfferId == null || clientOfferId == "")
            return false;
        try{
            ClientOffer clientOffer = getClientOfferById(Integer.parseInt(clientOfferId));
            Agreements agreement = new Agreements(clientOffer);
            clientOffer.setAgreement(agreement);
            em.persist(agreement);
            return true;
         }
        catch (Exception ex){
            return false;
        }
    }
     
     public boolean sendSpecialOffer(String clientId, String specialofferId) {
        if (clientId == null || clientId == "" || specialofferId == null || specialofferId== "")
            return false;
        try {
            Clients client = getClientById(Integer.parseInt(clientId));
            Specialoffers specialoffer = getSpecialoffersById(Integer.parseInt(specialofferId));
            ClientOffer clientOffer = new ClientOffer(client, specialoffer);
            client.addClientOffer(clientOffer);
            specialoffer.addClientOffer(clientOffer);
            em.persist(clientOffer);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
     
     public Clients getClientById(int id) {
        Query query = em.createNamedQuery("Clients.findById");
        query.setParameter("id", id);
        Clients clients = (Clients)query.getSingleResult();
        return clients;
    }
     
     public ClientOffer getClientOfferById(int id) {
        Query query = em.createNamedQuery("ClientOffer.findById");
        query.setParameter("id", id);
        ClientOffer clientOffer = (ClientOffer)query.getSingleResult();
        return clientOffer;
    }
     
     public Specialoffers getSpecialoffersById(int id) {
        Query query = em.createNamedQuery("Specialoffers.findById");
        query.setParameter("id", id);
        Specialoffers specialoffers = (Specialoffers)query.getSingleResult();
        return specialoffers;
    }
     

}
