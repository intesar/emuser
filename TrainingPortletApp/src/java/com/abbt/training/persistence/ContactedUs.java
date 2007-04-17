/*
 * ContactedUs.java
 *
 * Created on April 16, 2007, 6:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.persistence;

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
 * Entity class ContactedUs
 * 
 * @author shannan
 */
@Entity
@Table(name = "contacted_us")
@NamedQueries( {
        @NamedQuery(name = "ContactedUs.findById", query = "SELECT c FROM ContactedUs c WHERE c.id = :id"),
        @NamedQuery(name = "ContactedUs.findByFirstname", query = "SELECT c FROM ContactedUs c WHERE c.firstname = :firstname"),
        @NamedQuery(name = "ContactedUs.findByLastname", query = "SELECT c FROM ContactedUs c WHERE c.lastname = :lastname"),
        @NamedQuery(name = "ContactedUs.findByLocation", query = "SELECT c FROM ContactedUs c WHERE c.location = :location"),
        @NamedQuery(name = "ContactedUs.findByEmail", query = "SELECT c FROM ContactedUs c WHERE c.email = :email"),
        @NamedQuery(name = "ContactedUs.findByPhone", query = "SELECT c FROM ContactedUs c WHERE c.phone = :phone"),
        @NamedQuery(name = "ContactedUs.findBySummary", query = "SELECT c FROM ContactedUs c WHERE c.summary = :summary"),
        @NamedQuery(name = "ContactedUs.findByContactedDate", query = "SELECT c FROM ContactedUs c WHERE c.contactedDate = :contactedDate")
    })
public class ContactedUs implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "location")
    private String location;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "summary", nullable = false)
    private String summary;

    @Column(name = "contactedDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date contactedDate;

    /** Creates a new instance of ContactedUs */
    public ContactedUs() {
    }

    /**
     * Creates a new instance of ContactedUs with the specified values.
     * @param id the id of the ContactedUs
     */
    public ContactedUs(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of ContactedUs with the specified values.
     * @param id the id of the ContactedUs
     * @param firstname the firstname of the ContactedUs
     * @param lastname the lastname of the ContactedUs
     * @param email the email of the ContactedUs
     * @param summary the summary of the ContactedUs
     * @param contactedDate the contactedDate of the ContactedUs
     */
    public ContactedUs(Integer id, String firstname, String lastname, String email, String summary, Date contactedDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.summary = summary;
        this.contactedDate = contactedDate;
    }

    /**
     * Gets the id of this ContactedUs.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this ContactedUs to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the firstname of this ContactedUs.
     * @return the firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Sets the firstname of this ContactedUs to the specified value.
     * @param firstname the new firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the lastname of this ContactedUs.
     * @return the lastname
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Sets the lastname of this ContactedUs to the specified value.
     * @param lastname the new lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the location of this ContactedUs.
     * @return the location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location of this ContactedUs to the specified value.
     * @param location the new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the email of this ContactedUs.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this ContactedUs to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone of this ContactedUs.
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets the phone of this ContactedUs to the specified value.
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the summary of this ContactedUs.
     * @return the summary
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * Sets the summary of this ContactedUs to the specified value.
     * @param summary the new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the contactedDate of this ContactedUs.
     * @return the contactedDate
     */
    public Date getContactedDate() {
        return this.contactedDate;
    }

    /**
     * Sets the contactedDate of this ContactedUs to the specified value.
     * @param contactedDate the new contactedDate
     */
    public void setContactedDate(Date contactedDate) {
        this.contactedDate = contactedDate;
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
     * Determines whether another object is equal to this ContactedUs.  The result is 
     * <code>true</code> if and only if the argument is not null and is a ContactedUs object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactedUs)) {
            return false;
        }
        ContactedUs other = (ContactedUs)object;
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
        return "com.abbt.training.persistence.ContactedUs[id=" + id + "]";
    }

}
