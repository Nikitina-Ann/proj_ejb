/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.entity;

import java.io.Serializable;
import javax.persistence.*;
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
    @NamedQuery(name = "ClientOffer.findByResponseClient", query = "SELECT c FROM ClientOffer c WHERE c.responseClient = :responseClient")})
public class ClientOffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Clients client;
    @ManyToOne(optional = false)
    @JoinColumn(name = "offer_id")
    private Specialoffers specialoffer;
    @Column(name = "responseClient")
    private Boolean responseClient;
    @OneToOne(optional = false)
    @JoinColumn(name =  "agreement_id")
    private Agreements agreement;

    public ClientOffer() {
    }

    public ClientOffer(Integer id) {
        this.id = id;
    }
    
    public ClientOffer(Clients client, Specialoffers specialoffer) {
        if(client.containsSpecialoffer(specialoffer))
             throw new IllegalArgumentException("Exception! ClientOffer:ClientOffer()");
        this.client = client;
        this.specialoffer = specialoffer;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Specialoffers getSpecialoffer() {
        return specialoffer;
    }

    public void setSpecialoffer(Specialoffers specialoffer) {
        this.specialoffer = specialoffer;
    }


    public Boolean getResponseClient() {
        return responseClient;
    }

    public void setResponseClient(Boolean responseClient) {
        if(this.responseClient != null && this.responseClient==true)
            throw new IllegalArgumentException("Exception! ClientOffer:setResponseClient()");
        this.responseClient = responseClient;
    }

    public Agreements getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreements agreement) {
        if (this.responseClient == null || !this.responseClient || this.agreement != null) 
            throw new IllegalArgumentException("Exception! ClientOffer:setAgreement()");
        this.agreement = agreement;
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
