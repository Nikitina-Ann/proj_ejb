/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "bids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bids.findAll", query = "SELECT b FROM Bids b"),
    @NamedQuery(name = "Bids.findById", query = "SELECT b FROM Bids b WHERE b.id = :id"),
    @NamedQuery(name = "Bids.findByClientId", query = "SELECT b FROM Bids b WHERE b.clientId = :clientId"),
    @NamedQuery(name = "Bids.findByManagerId", query = "SELECT b FROM Bids b WHERE b.managerId = :managerId"),
    @NamedQuery(name = "Bids.findByFinancierId", query = "SELECT b FROM Bids b WHERE b.financierId = :financierId"),
    @NamedQuery(name = "Bids.findByDate", query = "SELECT b FROM Bids b WHERE b.date = :date"),
    @NamedQuery(name = "Bids.findByResponseClient", query = "SELECT b FROM Bids b WHERE b.responseClient = :responseClient"),
    @NamedQuery(name = "Bids.findBySum", query = "SELECT b FROM Bids b WHERE b.sum = :sum"),
    @NamedQuery(name = "Bids.findByAgreementId", query = "SELECT b FROM Bids b WHERE b.agreementId = :agreementId")})
public class Bids implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "client_id")
    private int clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manager_id")
    private int managerId;
    @Column(name = "financier_id")
    private Integer financierId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "responseClient")
    private Boolean responseClient;
    @Column(name = "sum")
    private Integer sum;
    @Column(name = "agreement_id")
    private Integer agreementId;

    public Bids() {
    }

    public Bids(Integer id) {
        this.id = id;
    }

    public Bids(Integer id, int clientId, int managerId) {
        this.id = id;
        this.clientId = clientId;
        this.managerId = managerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Integer getFinancierId() {
        return financierId;
    }

    public void setFinancierId(Integer financierId) {
        this.financierId = financierId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getResponseClient() {
        return responseClient;
    }

    public void setResponseClient(Boolean responseClient) {
        this.responseClient = responseClient;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Integer agreementId) {
        this.agreementId = agreementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bids)) {
            return false;
        }
        Bids other = (Bids) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.Bids[ id=" + id + " ]";
    }
    
}
