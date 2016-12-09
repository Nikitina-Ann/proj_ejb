/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appBank.entity;

import appBank.entity.Agreements;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
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
    @NamedQuery(name = "Bids.findByDate", query = "SELECT b FROM Bids b WHERE b.date = :date"),
    @NamedQuery(name = "Bids.findByResponseClient", query = "SELECT b FROM Bids b WHERE b.responseClient = :responseClient"),
    @NamedQuery(name = "Bids.findBySum", query = "SELECT b FROM Bids b WHERE b.sum = :sum")})
public class Bids implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "responseClient")
    private Boolean responseClient;
    @Column(name = "sum")
    private Integer sum;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;
    
    @ManyToOne
    @JoinColumn(name = "financier_id")
    private Financiers financier;

    public Managers getManager() {
        return manager;
    }

    public void setManager(Managers manager) {
        this.manager = manager;
    }
    
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Managers manager;
    

    public Financiers getFinancier() {
        return financier;
    }

    public void setFinancier(Financiers financier) {
        if(this.responseFinancier != null || this.financier != null )
            throw new IllegalArgumentException("Exception: ResponseFinancier");
        this.financier = financier;
    }
    
    @OneToOne(mappedBy="bid")
    private ResponseFinancier responseFinancier;
    
    @OneToOne(mappedBy="bid")
    private RestrBids restrBids;

    public RestrBids getRestrBids() {
        return restrBids;
    }

    public void setRestrBids(RestrBids restrBids) {
        this.restrBids = restrBids;
    }
    
    @OneToOne ()
    @JoinColumn(name = "agreement_id")
    private Agreements agreement;

    public Agreements getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreements agreement) {
        if(this.responseClient==null || this.responseFinancier==null || this.agreement != null)
            throw new IllegalArgumentException("Exception! Bid:setAgreement()");
        else if (!this.responseClient || !this.responseFinancier.getAnswer()) 
            throw new IllegalArgumentException("Exception! Bid:setAgreement()");
        this.agreement =agreement;
    }
    
    public ResponseFinancier getResponseFinancier() {
        return responseFinancier;
    }

    public void setResponseFinancier(ResponseFinancier responseFinancier) {
        this.responseFinancier = responseFinancier;
    }
    
    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
    public Bids() {
    }

    public Bids(Integer id) {
        this.id = id;
    }
    
    public Bids(Clients client, Integer sum, Date date, Managers manager) {
        this.client = client;
        this.sum = sum;
        this.date = date;
        this.manager = manager;
    }
    
    
    public Bids(Integer id, Clients client, Managers manager) {
        this.id = id;
        this.client = client;
        this.manager = manager;
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

    public Boolean getResponseClient() {
        return responseClient;
    }

    public void setResponseClient(Boolean responseClient) {
        if (this.getAgreement() != null || this.getResponseFinancier()==null || !this.getResponseFinancier().getAnswer())
            throw new IllegalArgumentException("Exception! Bid:setResponseClient()");
        if(this.responseClient != null && this.responseClient == true)
            throw new IllegalArgumentException("Exception! Bid:setResponseClient()");
        this.responseClient = responseClient;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
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
