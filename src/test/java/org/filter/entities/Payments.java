/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filter.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author infragile
 */
@Entity
@Table(name = "PAYMENTS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CUSTOMERNUMBER", "CHECKNUMBER"})})
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p"),
    @NamedQuery(name = "Payments.findByCustomernumber", query = "SELECT p FROM Payments p WHERE p.paymentsPK.customernumber = :customernumber"),
    @NamedQuery(name = "Payments.findByChecknumber", query = "SELECT p FROM Payments p WHERE p.paymentsPK.checknumber = :checknumber"),
    @NamedQuery(name = "Payments.findByPaymentdate", query = "SELECT p FROM Payments p WHERE p.paymentdate = :paymentdate"),
    @NamedQuery(name = "Payments.findByAmount", query = "SELECT p FROM Payments p WHERE p.amount = :amount")})
public class Payments implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentsPK paymentsPK;
    @Column(name = "PAYMENTDATE")
    @Temporal(TemporalType.DATE)
    private Date paymentdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT", precision = 52)
    private Double amount;
    @JoinColumn(name = "CUSTOMERNUMBER", referencedColumnName = "CUSTOMERNUMBER", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customers customers;

    public Payments() {
    }

    public Payments(PaymentsPK paymentsPK) {
        this.paymentsPK = paymentsPK;
    }

    public Payments(int customernumber, String checknumber) {
        this.paymentsPK = new PaymentsPK(customernumber, checknumber);
    }

    public PaymentsPK getPaymentsPK() {
        return paymentsPK;
    }

    public void setPaymentsPK(PaymentsPK paymentsPK) {
        this.paymentsPK = paymentsPK;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentsPK != null ? paymentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.paymentsPK == null && other.paymentsPK != null) || (this.paymentsPK != null && !this.paymentsPK.equals(other.paymentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Payments[ paymentsPK=" + paymentsPK + " ]";
    }
    
}