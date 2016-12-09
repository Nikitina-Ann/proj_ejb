/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "financiers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financiers.findAll", query = "SELECT f FROM Financiers f"),
    @NamedQuery(name = "Financiers.findById", query = "SELECT f FROM Financiers f WHERE f.id = :id"),
    @NamedQuery(name = "Financiers.findByName", query = "SELECT f FROM Financiers f WHERE f.name = :name")})
public class Financiers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "financier")
    private Set<Specialoffers> specialoffers = new HashSet<Specialoffers>();

    public ResponseFinancier getResponseFinancier() {
        return responseFinancier;
    }

    public Set<Specialoffers> getSpecialoffers() {
        return specialoffers;
    }

    public void setSpecialoffers(Set<Specialoffers> specialoffers) {
        this.specialoffers = specialoffers;
    }
    
    public void addSpecialoffers(Specialoffers specialoffer) {
        this.specialoffers.add(specialoffer);
    }

    public void setResponseFinancier(ResponseFinancier responseFinancier) {
        this.responseFinancier = responseFinancier;
    }
    
    @OneToMany(mappedBy = "financier")
    private Set<Bids> bids = new HashSet<Bids>();

    @OneToMany(mappedBy = "financier")
    private Set<RestrBids> restrBids = new HashSet<RestrBids>();
    
    @OneToOne(mappedBy="financier")
    private ResponseFinancier responseFinancier;
    

    public Set<RestrBids> getRestrBids() {
        return restrBids;
    }

    public void setRestrBids(Set<RestrBids> restrBids) {
        this.restrBids = restrBids;
    }

    public Set<Bids> getBids() {
        return bids;
    }

    public void setBids(Set<Bids> bids) {
        this.bids = bids;
    }
    
    public void addBid(Bids bid) {
        this.bids.add(bid);
    }

    public Financiers() {
    }

    public Financiers(Integer id) {
        this.id = id;
    }

    public Financiers(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Set<Bids> getBidsWithoutResponseFinancier() {
       Set<Bids> bidsWithoutResponseFinancier = new HashSet<Bids>();
        for (Bids bid : bids){
            if (bid.getResponseFinancier() == null)
                bidsWithoutResponseFinancier.add(bid);
        }
        return bidsWithoutResponseFinancier;
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
        if (!(object instanceof Financiers)) {
            return false;
        }
        Financiers other = (Financiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.Financiers[ id=" + id + " ]";
    }
    
}
