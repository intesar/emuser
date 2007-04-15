/*
 * ResumeExperience.java
 *
 * Created on April 14, 2007, 7:49 PM
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
 * Entity class ResumeExperience
 * 
 * @author shannan
 */
@Entity
@Table(name = "resume_experience")
@NamedQueries( {
        @NamedQuery(name = "ResumeExperience.findById", query = "SELECT r FROM ResumeExperience r WHERE r.id = :id"),
        @NamedQuery(name = "ResumeExperience.findByVersionId", query = "SELECT r FROM ResumeExperience r WHERE r.versionId = :versionId"),
        @NamedQuery(name = "ResumeExperience.findByCompany", query = "SELECT r FROM ResumeExperience r WHERE r.company = :company"),
        @NamedQuery(name = "ResumeExperience.findByTitle", query = "SELECT r FROM ResumeExperience r WHERE r.title = :title"),
        @NamedQuery(name = "ResumeExperience.findByStartDate", query = "SELECT r FROM ResumeExperience r WHERE r.startDate = :startDate"),
        @NamedQuery(name = "ResumeExperience.findByEndDate", query = "SELECT r FROM ResumeExperience r WHERE r.endDate = :endDate"),
        @NamedQuery(name = "ResumeExperience.findByCreationDate", query = "SELECT r FROM ResumeExperience r WHERE r.creationDate = :creationDate"),
        @NamedQuery(name = "ResumeExperience.findByCreatedUser", query = "SELECT r FROM ResumeExperience r WHERE r.createdUser = :createdUser"),
        @NamedQuery(name = "ResumeExperience.findByLastModifiedDate", query = "SELECT r FROM ResumeExperience r WHERE r.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "ResumeExperience.findByLastModifiedUser", query = "SELECT r FROM ResumeExperience r WHERE r.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "ResumeExperience.findByResumeId", query = "SELECT r FROM ResumeExperience r WHERE r.resumeId = :resumeId")
    })
public class ResumeExperience implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "startDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "endDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

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

    @Column(name = "resumeId", nullable = false)
    private int resumeId;

    /** Creates a new instance of ResumeExperience */
    public ResumeExperience() {
    }

    /**
     * Creates a new instance of ResumeExperience with the specified values.
     * @param id the id of the ResumeExperience
     */
    public ResumeExperience(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of ResumeExperience with the specified values.
     * @param id the id of the ResumeExperience
     * @param versionId the versionId of the ResumeExperience
     * @param company the company of the ResumeExperience
     * @param title the title of the ResumeExperience
     * @param startDate the startDate of the ResumeExperience
     * @param endDate the endDate of the ResumeExperience
     * @param creationDate the creationDate of the ResumeExperience
     * @param createdUser the createdUser of the ResumeExperience
     * @param lastModifiedDate the lastModifiedDate of the ResumeExperience
     * @param lastModifiedUser the lastModifiedUser of the ResumeExperience
     * @param resumeId the resumeId of the ResumeExperience
     */
    public ResumeExperience(Integer id, int versionId, String company, String title, Date startDate, Date endDate, Date creationDate, String createdUser, Date lastModifiedDate, String lastModifiedUser, int resumeId) {
        this.id = id;
        this.versionId = versionId;
        this.company = company;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.resumeId = resumeId;
    }

    /**
     * Gets the id of this ResumeExperience.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this ResumeExperience to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this ResumeExperience.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this ResumeExperience to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the company of this ResumeExperience.
     * @return the company
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * Sets the company of this ResumeExperience to the specified value.
     * @param company the new company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the title of this ResumeExperience.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of this ResumeExperience to the specified value.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the startDate of this ResumeExperience.
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the startDate of this ResumeExperience to the specified value.
     * @param startDate the new startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the endDate of this ResumeExperience.
     * @return the endDate
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the endDate of this ResumeExperience to the specified value.
     * @param endDate the new endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the creationDate of this ResumeExperience.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this ResumeExperience to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this ResumeExperience.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this ResumeExperience to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this ResumeExperience.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this ResumeExperience to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this ResumeExperience.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this ResumeExperience to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the resumeId of this ResumeExperience.
     * @return the resumeId
     */
    public int getResumeId() {
        return this.resumeId;
    }

    /**
     * Sets the resumeId of this ResumeExperience to the specified value.
     * @param resumeId the new resumeId
     */
    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
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
     * Determines whether another object is equal to this ResumeExperience.  The result is 
     * <code>true</code> if and only if the argument is not null and is a ResumeExperience object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumeExperience)) {
            return false;
        }
        ResumeExperience other = (ResumeExperience)object;
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
        return "com.abbt.crm.base.entity.ResumeExperience[id=" + id + "]";
    }

}
