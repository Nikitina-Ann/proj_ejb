/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.Query;

/**
 *
 * @author ann
 */
@Local
public interface AppBankBeanLocal {
    String getClientNameById(int id);
    List<Bids> getBidsForClient(int id);
    List<ClientOffer> getSpecialOffersForClient(int id);
    
}
