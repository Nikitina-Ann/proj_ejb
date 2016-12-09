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
@Table(name = "responseFinancier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponseFinancier.findAll", query = "SELECT r FROM ResponseFinancier r"),
    @NamedQuery(name = "ResponseFinancier.findById", query = "SELECT r FROM ResponseFinancier r WHERE r.id = :id"),
    @NamedQuery(name = "ResponseFinancier.findByAnswer", query = "SELECT r FROM ResponseFinancier r WHERE r.answer = :answer"),
    @NamedQuery(name = "ResponseFinancier.findByPersent", query = "SELECT r FROM ResponseFinancier r WHERE r.persent = :persent"),
    @NamedQuery(name = "ResponseFinancier.findByTime", query = "SELECT r FROM ResponseFinancier r WHERE r.time = :time")})
public class ResponseFinancier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "answer")
    private Boolean answer;
    @Column(name = "persent")
    private Integer persent;
    @Column(name = "time")
    private Integer time;
    
    @OneToOne (optional = false)
    @JoinColumn(name = "financier_id")
    private Financiers financier;
    
    @OneToOne (optional = false)
    @JoinColumn(name = "bid_id")
    private Bids bid;

    public Bids getBid() {
        return bid;
    }

    public void setBid(Bids bid) {
        this.bid = bid;
    }
    
    public ResponseFinancier() {
    }

    public ResponseFinancier(Integer id) {
        this.id = id;
    }
    
    public ResponseFinancier(Bids bid, Financiers financier,Boolean answer, Integer time, Integer persent) {
        this.bid = bid;
        this.financier = financier;
        this.answer = answer;
        this.time = time;
        this.persent =persent;
    }
    
    public ResponseFinancier(Bids bid, Financiers financier,Boolean answer) {
        this.bid = bid;
        this.financier = financier;
        this.answer = answer;
    }
    
    static public ResponseFinancier createResponseFinancier(Bids bid, Financiers financier,Boolean answer, String time, String persent) {
        if(answer &&  time!=null && time!="" && persent!=null && persent!="")
            return new ResponseFinancier(bid, financier, answer, Integer.parseInt(time), Integer.parseInt(persent));
        else if(!answer)
           return new ResponseFinancier(bid, financier, answer);
        else
            throw new IllegalArgumentException("Exception: ResponseFinancier");
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Financiers getFinancier() {
        return financier;
    }

    public void setFinancier(Financiers financier) {
        this.financier = financier;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
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
        if (!(object instanceof ResponseFinancier)) {
            return false;
        }
        ResponseFinancier other = (ResponseFinancier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appBank.ResponseFinancier[ id=" + id + " ]";
    }
    
}
