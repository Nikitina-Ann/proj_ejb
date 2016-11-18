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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "specialoffers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialoffers.findAll", query = "SELECT s FROM Specialoffers s"),
    @NamedQuery(name = "Specialoffers.findById", query = "SELECT s FROM Specialoffers s WHERE s.id = :id"),
    @NamedQuery(name = "Specialoffers.findBySum", query = "SELECT s FROM Specialoffers s WHERE s.sum = :sum"),
    @NamedQuery(name = "Specialoffers.findByPersent", query = "SELECT s FROM Specialoffers s WHERE s.persent = :persent"),
    @NamedQuery(name = "Specialoffers.findByTime", query = "SELECT s FROM Specialoffers s WHERE s.time = :time")})
public class Specialoffers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sum")
    private Integer sum;
    @Column(name = "persent")
    private Integer persent;
    @Column(name = "time")
    private Integer time;

    public Specialoffers() {
    }

    public Specialoffers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getPersent() {
        return persent;
    }

    public void setPersent(Integer persent) {
        this.persent = persent;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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
        if (!(object instanceof Specialoffers)) {
            return false;
        }
        Specialoffers other = (Specialoffers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.Specialoffers[ id=" + id + " ]";
    }
    
}
