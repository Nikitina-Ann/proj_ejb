/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ann
 */
@Entity
@Table(name = "restrBids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestrBids.findAll", query = "SELECT r FROM RestrBids r"),
    @NamedQuery(name = "RestrBids.findById", query = "SELECT r FROM RestrBids r WHERE r.id = :id"),
    @NamedQuery(name = "RestrBids.findByDate", query = "SELECT r FROM RestrBids r WHERE r.date = :date"),
    @NamedQuery(name = "RestrBids.findByPersent", query = "SELECT r FROM RestrBids r WHERE r.persent = :persent"),
    @NamedQuery(name = "RestrBids.findByTime", query = "SELECT r FROM RestrBids r WHERE r.time = :time"),
    @NamedQuery(name = "RestrBids.findByDoc", query = "SELECT r FROM RestrBids r WHERE r.doc = :doc"),
    @NamedQuery(name = "RestrBids.findByResponseFinancier", query = "SELECT r FROM RestrBids r WHERE r.responseFinancier = :responseFinancier"),
    @NamedQuery(name = "RestrBids.findByResponseClient", query = "SELECT r FROM RestrBids r WHERE r.responseClient = :responseClient"),
    @NamedQuery(name = "RestrBids.findByAgreement", query = "SELECT r FROM RestrBids r WHERE r.agreement = :agreement")})
public class RestrBids implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "persent")
    private Integer persent;
    @Column(name = "time")
    private Integer time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "doc")
    private String doc;
    @Column(name = "responseFinancier")
    private Boolean responseFinancier;
    @Column(name = "responseClient")
    private Boolean responseClient;
    @Column(name = "agreement")
    private Boolean agreement;

    @OneToOne (optional = false)
    @JoinColumn(name = "bid_id")
    private Bids bid;
 
    @ManyToOne ()
    @JoinColumn(name = "financier_id")
    private Financiers financier;

    public Financiers getFinancier() {
        return financier;
    }

    public void setFinancier(Financiers financier) {
        this.financier = financier;
    }
    
    public Bids getBid() {
        return bid;
    }

    public void setBid(Bids bid) {
        this.bid = bid;
    }
    
    public RestrBids() {
    }

    public RestrBids(Integer id) {
        this.id = id;
    }

    public RestrBids(Integer id, Bids bid, String doc) {
        this.id = id;
        this.bid = bid;
        this.doc = doc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Boolean getResponseFinancier() {
        return responseFinancier;
    }

    public void setResponseFinancier(Boolean responseFinancier) {
        this.responseFinancier = responseFinancier;
    }

    public Boolean getResponseClient() {
        return responseClient;
    }

    public void setResponseClient(Boolean responseClient) {
        this.responseClient = responseClient;
    }

    public Boolean getAgreement() {
        return agreement;
    }

    public void setAgreement(Boolean agreement) {
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
        if (!(object instanceof RestrBids)) {
            return false;
        }
        RestrBids other = (RestrBids) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.RestrBids[ id=" + id + " ]";
    }
    
}
