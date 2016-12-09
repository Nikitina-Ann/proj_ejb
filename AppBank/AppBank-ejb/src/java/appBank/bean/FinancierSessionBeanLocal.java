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
import javax.persistence.Query;

/**
 *
 * @author ann
 */
@Local
public interface FinancierSessionBeanLocal {

    Financiers getFinancierById(int id);
    boolean setResponseFinancier(String bidId, String financierId, Boolean answer, String time, String persent);
    public Bids getBidById(int bidId);
    boolean createSpecialoffer(String financierId, String summa, String time, String persent);
    
}
