/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.bean;

import appBank.entity.Bids;
import appBank.entity.Clients;
import appBank.entity.Managers;
import javax.ejb.Local;

/**
 *
 * @author ann
 */
@Local
public interface ClientSessionBeanLocal {
    Clients getClientById(int id);
    boolean setResponseClientBid(boolean answer, String bidId);
    boolean createBid(Clients client, String bidSum);
    Managers getRandomManager();
    Bids getBidById(int bidId);
    boolean setResponseClientSpecOff(String clientOfferId, boolean answer);
}
