/*
 * LeadPhone.java
 *
 * Created on April 2, 2007, 8:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.entity;

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
 * Entity class LeadPhone
 * 
 * @author shannan
 */
@Entity
@Table(name = "lead_phone")
@NamedQueries( {
        @NamedQuery(name = "LeadPhone.findById", query = "SELECT l FROM LeadPhone l WHERE l.id = :id"),
        @NamedQuery(name = "LeadPhone.findByVersionId", query = "SELECT l FROM LeadPhone l WHERE l.versionId = :versionId"),
        @NamedQuery(name = "LeadPhone.findByFaxNo", query = "SELECT l FROM LeadPhone l WHERE l.faxNo = :faxNo"),
        @NamedQuery(name = "LeadPhone.findByPhoneNo", query = "SELECT l FROM LeadPhone l WHERE l.phoneNo = :phoneNo"),
        @NamedQuery(name = "LeadPhone.findByCreationDate", query = "SELECT l FROM LeadPhone l WHERE l.creationDate = :creationDate"),
        @NamedQuery(name = "LeadPhone.findByCreatedUser", query = "SELECT l FROM LeadPhone l WHERE l.createdUser = :createdUser"),
        @NamedQuery(name = "LeadPhone.findByLastModifiedDate", query = "SELECT l FROM LeadPhone l WHERE l.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "LeadPhone.findByLastModifiedUser", query = "SELECT l FROM LeadPhone l WHERE l.lastModifiedUser = :lastModifiedUser")
    })
public class LeadPhone implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "faxNo", nullable = false)
    private int faxNo;

    @Column(name = "phoneNo", nullable = false)
    private String phoneNo;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    /** Creates a new instance of LeadPhone */
    public LeadPhone() {
    }

    /**
     * Creates a new instance of LeadPhone with the specified values.
     * @param id the id of the LeadPhone
     */
    public LeadPhone(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of LeadPhone with the specified values.
     * @param id the id of the LeadPhone
     * @param versionId the versionId of the LeadPhone
     * @param faxNo the faxNo of the LeadPhone
     * @param phoneNo the phoneNo of the LeadPhone
     * @param creationDate the creationDate of the LeadPhone
     * @param createdUser the createdUser of the LeadPhone
     * @param lastModifiedDate the lastModifiedDate of the LeadPhone
     * @param lastModifiedUser the lastModifiedUser of the LeadPhone
     */
    public LeadPhone(Integer id, int versionId, int faxNo, String phoneNo, Date creationDate, String createdUser, Date lastModifiedDate, String lastModifiedUser) {
        this.id = id;
        this.versionId = versionId;
        this.faxNo = faxNo;
        this.phoneNo = phoneNo;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the id of this LeadPhone.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this LeadPhone to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this LeadPhone.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this LeadPhone to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the faxNo of this LeadPhone.
     * @return the faxNo
     */
    public int getFaxNo() {
        return this.faxNo;
    }

    /**
     * Sets the faxNo of this LeadPhone to the specified value.
     * @param faxNo the new faxNo
     */
    public void setFaxNo(int faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * Gets the phoneNo of this LeadPhone.
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return this.phoneNo;
    }

    /**
     * Sets the phoneNo of this LeadPhone to the specified value.
     * @param phoneNo the new phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the creationDate of this LeadPhone.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this LeadPhone to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this LeadPhone.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this LeadPhone to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this LeadPhone.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this LeadPhone to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this LeadPhone.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this LeadPhone to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
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
     * Determines whether another object is equal to this LeadPhone.  The result is 
     * <code>true</code> if and only if the argument is not null and is a LeadPhone object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeadPhone)) {
            return false;
        }
        LeadPhone other = (LeadPhone)object;
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
        return "com.abbt.crm.entity.LeadPhone[id=" + id + "]";
    }

}
