/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filter.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author infragile
 */
@Embeddable
public class OrderdetailsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ORDERNUMBER", nullable = false)
    private int ordernumber;
    @Basic(optional = false)
    @Column(name = "PRODUCTCODE", nullable = false, length = 15)
    private String productcode;

    public OrderdetailsPK() {
    }

    public OrderdetailsPK(int ordernumber, String productcode) {
        this.ordernumber = ordernumber;
        this.productcode = productcode;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ordernumber;
        hash += (productcode != null ? productcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderdetailsPK)) {
            return false;
        }
        OrderdetailsPK other = (OrderdetailsPK) object;
        if (this.ordernumber != other.ordernumber) {
            return false;
        }
        if ((this.productcode == null && other.productcode != null) || (this.productcode != null && !this.productcode.equals(other.productcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.OrderdetailsPK[ ordernumber=" + ordernumber + ", productcode=" + productcode + " ]";
    }
    
}
