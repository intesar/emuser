/*
 * EmployeeQuery.java
 *
 * Created on April 7, 2007, 1:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class EmployeeQuery
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "employee_query")
@NamedQueries( {
        @NamedQuery(name = "EmployeeQuery.findById", query = "SELECT e FROM EmployeeQuery e WHERE e.id = :id"),
        @NamedQuery(name = "EmployeeQuery.findByTo", query = "SELECT e FROM EmployeeQuery e WHERE e.to = :to"),
        @NamedQuery(name = "EmployeeQuery.findByFrom", query = "SELECT e FROM EmployeeQuery e WHERE e.from = :from"),
        @NamedQuery(name = "EmployeeQuery.findByMessage", query = "SELECT e FROM EmployeeQuery e WHERE e.message = :message"),
        @NamedQuery(name = "EmployeeQuery.findByCreationDate", query = "SELECT e FROM EmployeeQuery e WHERE e.creationDate = :creationDate")
    })
public class EmployeeQuery implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "to", nullable = false)
    private String to;

    @Column(name = "from", nullable = false)
    private String from;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    /** Creates a new instance of EmployeeQuery */
    public EmployeeQuery() {
    }

    /**
     * Creates a new instance of EmployeeQuery with the specified values.
     * @param id the id of the EmployeeQuery
     */
    public EmployeeQuery(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of EmployeeQuery with the specified values.
     * @param id the id of the EmployeeQuery
     * @param to the to of the EmployeeQuery
     * @param from the from of the EmployeeQuery
     * @param message the message of the EmployeeQuery
     */
    public EmployeeQuery(Integer id, String to, String from, String message) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.message = message;
    }

    /**
     * Gets the id of this EmployeeQuery.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this EmployeeQuery to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the to of this EmployeeQuery.
     * @return the to
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Sets the to of this EmployeeQuery to the specified value.
     * @param to the new to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the from of this EmployeeQuery.
     * @return the from
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Sets the from of this EmployeeQuery to the specified value.
     * @param from the new from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets the message of this EmployeeQuery.
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message of this EmployeeQuery to the specified value.
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the creationDate of this EmployeeQuery.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this EmployeeQuery to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this EmployeeQuery.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EmployeeQuery object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeQuery)) {
            return false;
        }
        EmployeeQuery other = (EmployeeQuery)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.crm.base.entity.EmployeeQuery[id=" + id + "]";
    }
    
}
