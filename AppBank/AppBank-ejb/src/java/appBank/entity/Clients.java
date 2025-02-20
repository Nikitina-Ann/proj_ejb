/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name"),
    @NamedQuery(name = "Clients.findByRating", query = "SELECT c FROM Clients c WHERE c.rating = :rating"),
    @NamedQuery(name = "Clients.findByRevenue", query = "SELECT c FROM Clients c WHERE c.revenue = :revenue")})
public class Clients implements Serializable {

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
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "revenue")
    private Integer revenue;
        
    
    @OneToMany(mappedBy = "client")
    private Set<Bids> bids = new HashSet<Bids>();
    public Set<Bids> getBids() {
        return this.bids;
    }

    public Set<ClientOffer> getClientOffer() {
        return clientOffer;
    }

    public void setClientOffer(Set<ClientOffer> clientOffer) {
        this.clientOffer = clientOffer;
    }
    
    @OneToMany(mappedBy = "client")
    private Set<ClientOffer> clientOffer = new HashSet<ClientOffer>();
 
    public void setBids(Set<Bids> bids) {
        this.bids = bids;
    }   
    
    public void addBid(Bids bids) {
        this.bids.add(bids);
    }  
    
    public boolean containsSpecialoffer(Specialoffers specialoffer){
        for (ClientOffer clientOffer:this.clientOffer){
            if(clientOffer.getSpecialoffer() == specialoffer)
                return true;
        }
        return false;
    }
    
    public void addClientOffer(ClientOffer clientOffer) {
        this.clientOffer.add(clientOffer);
    } 
    
    public Clients() {
    }

    public Clients(Integer id) {
        this.id = id;
    }

    public Clients(Integer id, String name) {
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.Clients[ id=" + id + " ]";
    }
    
}
