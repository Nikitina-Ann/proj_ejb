/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "agreements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agreements.findAll", query = "SELECT a FROM Agreements a"),
    @NamedQuery(name = "Agreements.findById", query = "SELECT a FROM Agreements a WHERE a.id = :id"),
    @NamedQuery(name = "Agreements.findByExtinguished", query = "SELECT a FROM Agreements a WHERE a.extinguished = :extinguished"),
    @NamedQuery(name = "Agreements.findByResidualAmount", query = "SELECT a FROM Agreements a WHERE a.residualAmount = :residualAmount")})
public class Agreements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "extinguished")
    private Boolean extinguished;
    @Column(name = "residualAmount")
    private Integer residualAmount;

    @OneToOne(mappedBy="agreement", optional = false)
    private Bids bid;
    
    @OneToOne(mappedBy="agreement", optional = false)
    private ClientOffer clientOffer;

    public ClientOffer getClientOffer() {
        return clientOffer;
    }

    public void setClientOffer(ClientOffer clientOffer) {
        this.clientOffer = clientOffer;
    }

    public Bids getBid() {
        return bid;
    }

    public void setBid(Bids bid) {
        this.bid = bid;
    }
    
    public Agreements() {
    }

    public Agreements(Integer id) {
        this.id = id;
    }
    
    public Agreements(Bids bid) {
        this.residualAmount = bid.getSum();
        this.bid = bid;
        this.extinguished = false;
    }
    
    public Agreements(ClientOffer clientOffer) {
        this.residualAmount = clientOffer.getSpecialoffer().getSum();
        this.clientOffer = clientOffer;
        this.extinguished = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getExtinguished() {
        return extinguished;
    }

    public void setExtinguished(Boolean extinguished) {
        this.extinguished = extinguished;
    }

    public Integer getResidualAmount() {
        return residualAmount;
    }

    public void setResidualAmount(Integer residualAmount) {
        this.residualAmount = residualAmount;
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
        if (!(object instanceof Agreements)) {
            return false;
        }
        Agreements other = (Agreements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.Agreements[ id=" + id + " ]";
    }
    
}
