/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "client_offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientOffer.findAll", query = "SELECT c FROM ClientOffer c"),
    @NamedQuery(name = "ClientOffer.findById", query = "SELECT c FROM ClientOffer c WHERE c.id = :id"),
    @NamedQuery(name = "ClientOffer.findByClientId", query = "SELECT offerId FROM ClientOffer WHERE clientId = :clientId"),
    @NamedQuery(name = "ClientOffer.findByOfferId", query = "SELECT c FROM ClientOffer c WHERE c.offerId = :offerId"),
    @NamedQuery(name = "ClientOffer.findByResponseClient", query = "SELECT c FROM ClientOffer c WHERE c.responseClient = :responseClient"),
    @NamedQuery(name = "ClientOffer.findByAgreementId", query = "SELECT c FROM ClientOffer c WHERE c.agreementId = :agreementId")})
public class ClientOffer implements Serializable {

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
    @Column(name = "offer_id")
    private int offerId;
    @Column(name = "responseClient")
    private Boolean responseClient;
    @Column(name = "agreement_id")
    private Integer agreementId;

    public ClientOffer() {
    }

    public ClientOffer(Integer id) {
        this.id = id;
    }

    public ClientOffer(Integer id, int clientId, int offerId) {
        this.id = id;
        this.clientId = clientId;
        this.offerId = offerId;
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

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public Boolean getResponseClient() {
        return responseClient;
    }

    public void setResponseClient(Boolean responseClient) {
        this.responseClient = responseClient;
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
        if (!(object instanceof ClientOffer)) {
            return false;
        }
        ClientOffer other = (ClientOffer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.ClientOffer[ id=" + id + " ]";
    }
    
}
