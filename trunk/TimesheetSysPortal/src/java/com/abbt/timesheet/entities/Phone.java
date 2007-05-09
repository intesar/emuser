/*
 * Phone.java
 *
 * Created on May 7, 2007, 11:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class Phone
 * 
 * @author shannan
 */
@Entity
@Table(name = "phone")
@NamedQueries( {
        @NamedQuery(name = "Phone.findById", query = "SELECT p FROM Phone p WHERE p.id = :id"),
        @NamedQuery(name = "Phone.findByNumber", query = "SELECT p FROM Phone p WHERE p.number = :number"),
        @NamedQuery(name = "Phone.findByType", query = "SELECT p FROM Phone p WHERE p.type = :type"),
        @NamedQuery(name = "Phone.findByIsEnabled", query = "SELECT p FROM Phone p WHERE p.isEnabled = :isEnabled"),
        @NamedQuery(name = "Phone.findByCreatedBy", query = "SELECT p FROM Phone p WHERE p.createdBy = :createdBy"),
        @NamedQuery(name = "Phone.findByCreatedDate", query = "SELECT p FROM Phone p WHERE p.createdDate = :createdDate")
    })
public class Phone implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "isEnabled")
    private Short isEnabled;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @OneToMany(mappedBy = "phone3")
    private Collection<Company> companyCollection;

    @OneToMany(mappedBy = "phone1")
    private Collection<Company> companyCollection1;

    @OneToMany(mappedBy = "phone2")
    private Collection<Company> companyCollection2;
    
    /** Creates a new instance of Phone */
    public Phone() {
    }

    /**
     * Creates a new instance of Phone with the specified values.
     * @param id the id of the Phone
     */
    public Phone(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Phone with the specified values.
     * @param id the id of the Phone
     * @param number the number of the Phone
     * @param type the type of the Phone
     */
    public Phone(Integer id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }

    /**
     * Gets the id of this Phone.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Phone to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the number of this Phone.
     * @return the number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Sets the number of this Phone to the specified value.
     * @param number the new number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets the type of this Phone.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this Phone to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the isEnabled of this Phone.
     * @return the isEnabled
     */
    public Short getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this Phone to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(Short isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the createdBy of this Phone.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this Phone to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this Phone.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this Phone to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the companyCollection of this Phone.
     * @return the companyCollection
     */
    public Collection<Company> getCompanyCollection() {
        return this.companyCollection;
    }

    /**
     * Sets the companyCollection of this Phone to the specified value.
     * @param companyCollection the new companyCollection
     */
    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
    }

    /**
     * Gets the companyCollection1 of this Phone.
     * @return the companyCollection1
     */
    public Collection<Company> getCompanyCollection1() {
        return this.companyCollection1;
    }

    /**
     * Sets the companyCollection1 of this Phone to the specified value.
     * @param companyCollection1 the new companyCollection1
     */
    public void setCompanyCollection1(Collection<Company> companyCollection1) {
        this.companyCollection1 = companyCollection1;
    }

    /**
     * Gets the companyCollection2 of this Phone.
     * @return the companyCollection2
     */
    public Collection<Company> getCompanyCollection2() {
        return this.companyCollection2;
    }

    /**
     * Sets the companyCollection2 of this Phone to the specified value.
     * @param companyCollection2 the new companyCollection2
     */
    public void setCompanyCollection2(Collection<Company> companyCollection2) {
        this.companyCollection2 = companyCollection2;
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
     * Determines whether another object is equal to this Phone.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Phone object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone)object;
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
        return "com.abbt.timesheet.entities.Phone[id=" + id + "]";
    }
    
}
