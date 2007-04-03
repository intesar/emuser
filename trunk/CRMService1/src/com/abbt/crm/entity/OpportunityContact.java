/*
 * OpportunityContact.java
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
 * Entity class OpportunityContact
 * 
 * @author shannan
 */
@Entity
@Table(name = "opportunity_contact")
@NamedQueries( {
        @NamedQuery(name = "OpportunityContact.findById", query = "SELECT o FROM OpportunityContact o WHERE o.id = :id"),
        @NamedQuery(name = "OpportunityContact.findByVersionId", query = "SELECT o FROM OpportunityContact o WHERE o.versionId = :versionId"),
        @NamedQuery(name = "OpportunityContact.findByOpportunityId", query = "SELECT o FROM OpportunityContact o WHERE o.opportunityId = :opportunityId"),
        @NamedQuery(name = "OpportunityContact.findByCreationDate", query = "SELECT o FROM OpportunityContact o WHERE o.creationDate = :creationDate"),
        @NamedQuery(name = "OpportunityContact.findByCreatedUser", query = "SELECT o FROM OpportunityContact o WHERE o.createdUser = :createdUser"),
        @NamedQuery(name = "OpportunityContact.findByLastModifiedUser", query = "SELECT o FROM OpportunityContact o WHERE o.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "OpportunityContact.findByLastModifiedDate", query = "SELECT o FROM OpportunityContact o WHERE o.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "OpportunityContact.findByContactId", query = "SELECT o FROM OpportunityContact o WHERE o.contactId = :contactId")
    })
public class OpportunityContact implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "opportunityId", nullable = false)
    private String opportunityId;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "contactId", nullable = false)
    private int contactId;

    /** Creates a new instance of OpportunityContact */
    public OpportunityContact() {
    }

    /**
     * Creates a new instance of OpportunityContact with the specified values.
     * @param id the id of the OpportunityContact
     */
    public OpportunityContact(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of OpportunityContact with the specified values.
     * @param id the id of the OpportunityContact
     * @param versionId the versionId of the OpportunityContact
     * @param opportunityId the opportunityId of the OpportunityContact
     * @param creationDate the creationDate of the OpportunityContact
     * @param createdUser the createdUser of the OpportunityContact
     * @param lastModifiedUser the lastModifiedUser of the OpportunityContact
     * @param lastModifiedDate the lastModifiedDate of the OpportunityContact
     * @param contactId the contactId of the OpportunityContact
     */
    public OpportunityContact(Integer id, int versionId, String opportunityId, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate, int contactId) {
        this.id = id;
        this.versionId = versionId;
        this.opportunityId = opportunityId;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.contactId = contactId;
    }

    /**
     * Gets the id of this OpportunityContact.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this OpportunityContact to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this OpportunityContact.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this OpportunityContact to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the opportunityId of this OpportunityContact.
     * @return the opportunityId
     */
    public String getOpportunityId() {
        return this.opportunityId;
    }

    /**
     * Sets the opportunityId of this OpportunityContact to the specified value.
     * @param opportunityId the new opportunityId
     */
    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    /**
     * Gets the creationDate of this OpportunityContact.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this OpportunityContact to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this OpportunityContact.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this OpportunityContact to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this OpportunityContact.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this OpportunityContact to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this OpportunityContact.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this OpportunityContact to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the contactId of this OpportunityContact.
     * @return the contactId
     */
    public int getContactId() {
        return this.contactId;
    }

    /**
     * Sets the contactId of this OpportunityContact to the specified value.
     * @param contactId the new contactId
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
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
     * Determines whether another object is equal to this OpportunityContact.  The result is 
     * <code>true</code> if and only if the argument is not null and is a OpportunityContact object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpportunityContact)) {
            return false;
        }
        OpportunityContact other = (OpportunityContact)object;
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
        return "com.abbt.crm.entity.OpportunityContact[id=" + id + "]";
    }

}
