/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.bean;

import appBank.entity.*;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author ann
 */
@Local
public interface ManagerSessionBeanLocal {
    boolean setFinancierForBid(String bidId, String financierId);
    Managers getManagerById(int id);
    Set<RestrBids> getRestrBidsForManager(Managers manager);
    List<Financiers> getAllFinanciers();
    List<Clients> getAllClients();
    Financiers getFinancierById(int id);
    boolean enterAgreementBid(String bidId);
    boolean enterAgreementSpecOffer(String clientOfferId);
    List<ClientOffer> getAllClientOffers();
    List<Specialoffers> getAllSpecialoffers();
    boolean sendSpecialOffer(String clientId, String specialofferId);
}
