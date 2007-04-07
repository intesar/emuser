/*
 * Opportunity.java
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
 * Entity class Opportunity
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "opportunity")
@NamedQueries( {
        @NamedQuery(name = "Opportunity.findById", query = "SELECT o FROM Opportunity o WHERE o.id = :id"),
        @NamedQuery(name = "Opportunity.findByVersionId", query = "SELECT o FROM Opportunity o WHERE o.versionId = :versionId"),
        @NamedQuery(name = "Opportunity.findByOpportunityId", query = "SELECT o FROM Opportunity o WHERE o.opportunityId = :opportunityId"),
        @NamedQuery(name = "Opportunity.findByTitle", query = "SELECT o FROM Opportunity o WHERE o.title = :title"),
        @NamedQuery(name = "Opportunity.findByDescription", query = "SELECT o FROM Opportunity o WHERE o.description = :description"),
        @NamedQuery(name = "Opportunity.findByClientCompany", query = "SELECT o FROM Opportunity o WHERE o.clientCompany = :clientCompany"),
        @NamedQuery(name = "Opportunity.findByRate", query = "SELECT o FROM Opportunity o WHERE o.rate = :rate"),
        @NamedQuery(name = "Opportunity.findByLevel", query = "SELECT o FROM Opportunity o WHERE o.level = :level"),
        @NamedQuery(name = "Opportunity.findByNext", query = "SELECT o FROM Opportunity o WHERE o.next = :next"),
        @NamedQuery(name = "Opportunity.findByStatus", query = "SELECT o FROM Opportunity o WHERE o.status = :status"),
        @NamedQuery(name = "Opportunity.findByCreationDate", query = "SELECT o FROM Opportunity o WHERE o.creationDate = :creationDate"),
        @NamedQuery(name = "Opportunity.findByCreatedUser", query = "SELECT o FROM Opportunity o WHERE o.createdUser = :createdUser"),
        @NamedQuery(name = "Opportunity.findByLastModifiedUser", query = "SELECT o FROM Opportunity o WHERE o.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Opportunity.findByLastModifiedDate", query = "SELECT o FROM Opportunity o WHERE o.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Opportunity.findByAccountId", query = "SELECT o FROM Opportunity o WHERE o.accountId = :accountId")
    })
public class Opportunity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "opportunityId", nullable = false)
    private String opportunityId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "clientCompany", nullable = false)
    private String clientCompany;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "next", nullable = false)
    private String next;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "lastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "accountId", nullable = false)
    private int accountId;
    
    /** Creates a new instance of Opportunity */
    public Opportunity() {
    }

    /**
     * Creates a new instance of Opportunity with the specified values.
     * @param id the id of the Opportunity
     */
    public Opportunity(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Opportunity with the specified values.
     * @param id the id of the Opportunity
     * @param versionId the versionId of the Opportunity
     * @param opportunityId the opportunityId of the Opportunity
     * @param title the title of the Opportunity
     * @param description the description of the Opportunity
     * @param clientCompany the clientCompany of the Opportunity
     * @param rate the rate of the Opportunity
     * @param level the level of the Opportunity
     * @param next the next of the Opportunity
     * @param status the status of the Opportunity
     * @param createdUser the createdUser of the Opportunity
     * @param lastModifiedUser the lastModifiedUser of the Opportunity
     * @param accountId the accountId of the Opportunity
     */
    public Opportunity(Integer id, int versionId, String opportunityId, String title, String description, String clientCompany, int rate, String level, String next, String status, String createdUser, String lastModifiedUser, int accountId) {
        this.id = id;
        this.versionId = versionId;
        this.opportunityId = opportunityId;
        this.title = title;
        this.description = description;
        this.clientCompany = clientCompany;
        this.rate = rate;
        this.level = level;
        this.next = next;
        this.status = status;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.accountId = accountId;
    }

    /**
     * Gets the id of this Opportunity.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Opportunity to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Opportunity.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Opportunity to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the opportunityId of this Opportunity.
     * @return the opportunityId
     */
    public String getOpportunityId() {
        return this.opportunityId;
    }

    /**
     * Sets the opportunityId of this Opportunity to the specified value.
     * @param opportunityId the new opportunityId
     */
    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    /**
     * Gets the title of this Opportunity.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of this Opportunity to the specified value.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of this Opportunity.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Opportunity to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the clientCompany of this Opportunity.
     * @return the clientCompany
     */
    public String getClientCompany() {
        return this.clientCompany;
    }

    /**
     * Sets the clientCompany of this Opportunity to the specified value.
     * @param clientCompany the new clientCompany
     */
    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    /**
     * Gets the rate of this Opportunity.
     * @return the rate
     */
    public int getRate() {
        return this.rate;
    }

    /**
     * Sets the rate of this Opportunity to the specified value.
     * @param rate the new rate
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * Gets the level of this Opportunity.
     * @return the level
     */
    public String getLevel() {
        return this.level;
    }

    /**
     * Sets the level of this Opportunity to the specified value.
     * @param level the new level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Gets the next of this Opportunity.
     * @return the next
     */
    public String getNext() {
        return this.next;
    }

    /**
     * Sets the next of this Opportunity to the specified value.
     * @param next the new next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * Gets the status of this Opportunity.
     * @return the status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Sets the status of this Opportunity to the specified value.
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the creationDate of this Opportunity.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Opportunity to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Opportunity.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Opportunity to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this Opportunity.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Opportunity to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Opportunity.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Opportunity to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the accountId of this Opportunity.
     * @return the accountId
     */
    public int getAccountId() {
        return this.accountId;
    }

    /**
     * Sets the accountId of this Opportunity to the specified value.
     * @param accountId the new accountId
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
     * Determines whether another object is equal to this Opportunity.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Opportunity object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opportunity)) {
            return false;
        }
        Opportunity other = (Opportunity)object;
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
        return "com.abbt.crm.base.entity.Opportunity[id=" + id + "]";
    }
    
}
