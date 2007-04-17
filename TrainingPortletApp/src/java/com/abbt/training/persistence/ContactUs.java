/*
 * ContactUs.java
 *
 * Created on April 16, 2007, 6:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class ContactUs
 * 
 * @author shannan
 */
@Entity
@Table(name = "contact_us")
@NamedQueries( {
        @NamedQuery(name = "ContactUs.findById", query = "SELECT c FROM ContactUs c WHERE c.id = :id"),
        @NamedQuery(name = "ContactUs.findByFirstname", query = "SELECT c FROM ContactUs c WHERE c.firstname = :firstname"),
        @NamedQuery(name = "ContactUs.findByLastname", query = "SELECT c FROM ContactUs c WHERE c.lastname = :lastname"),
        @NamedQuery(name = "ContactUs.findByEmail", query = "SELECT c FROM ContactUs c WHERE c.email = :email"),
        @NamedQuery(name = "ContactUs.findByPhone", query = "SELECT c FROM ContactUs c WHERE c.phone = :phone"),
        @NamedQuery(name = "ContactUs.findByMobile", query = "SELECT c FROM ContactUs c WHERE c.mobile = :mobile"),
        @NamedQuery(name = "ContactUs.findBySummary", query = "SELECT c FROM ContactUs c WHERE c.summary = :summary")
    })
public class ContactUs implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "summary")
    private String summary;

    /** Creates a new instance of ContactUs */
    public ContactUs() {
    }

    /**
     * Creates a new instance of ContactUs with the specified values.
     * @param id the id of the ContactUs
     */
    public ContactUs(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of ContactUs with the specified values.
     * @param id the id of the ContactUs
     * @param firstname the firstname of the ContactUs
     * @param lastname the lastname of the ContactUs
     * @param email the email of the ContactUs
     */
    public ContactUs(Integer id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    /**
     * Gets the id of this ContactUs.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this ContactUs to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the firstname of this ContactUs.
     * @return the firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Sets the firstname of this ContactUs to the specified value.
     * @param firstname the new firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the lastname of this ContactUs.
     * @return the lastname
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Sets the lastname of this ContactUs to the specified value.
     * @param lastname the new lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the email of this ContactUs.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this ContactUs to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone of this ContactUs.
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets the phone of this ContactUs to the specified value.
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the mobile of this ContactUs.
     * @return the mobile
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile of this ContactUs to the specified value.
     * @param mobile the new mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the summary of this ContactUs.
     * @return the summary
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * Sets the summary of this ContactUs to the specified value.
     * @param summary the new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
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
     * Determines whether another object is equal to this ContactUs.  The result is 
     * <code>true</code> if and only if the argument is not null and is a ContactUs object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactUs)) {
            return false;
        }
        ContactUs other = (ContactUs)object;
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
        return "com.abbt.training.persistence.ContactUs[id=" + id + "]";
    }

}
