/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "managers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Managers.findAll", query = "SELECT m FROM Managers m"),
    @NamedQuery(name = "Managers.findById", query = "SELECT m FROM Managers m WHERE m.id = :id"),
    @NamedQuery(name = "Managers.findByName", query = "SELECT m FROM Managers m WHERE m.name = :name")})
public class Managers implements Serializable {

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
    
    @OneToMany(mappedBy = "manager")
    private Set<Bids> bids = new HashSet<Bids>();

    public Set<Bids> getBids() {
        return bids;
    }

    public void setBids(Set<Bids> bids) {
        this.bids = bids;
    }
    
    public Managers() {
    }

    public Managers(Integer id) {
        this.id = id;
    }

    public Managers(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void addBid(Bids bids) {
        this.bids.add(bids);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Managers)) {
            return false;
        }
        Managers other = (Managers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.Managers[ id=" + id + " ]";
    }
    
}
