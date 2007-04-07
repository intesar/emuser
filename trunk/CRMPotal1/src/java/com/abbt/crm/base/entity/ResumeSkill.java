/*
 * ResumeSkill.java
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
 * Entity class ResumeSkill
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "resume_skill")
@NamedQueries( {
        @NamedQuery(name = "ResumeSkill.findById", query = "SELECT r FROM ResumeSkill r WHERE r.id = :id"),
        @NamedQuery(name = "ResumeSkill.findByVersionId", query = "SELECT r FROM ResumeSkill r WHERE r.versionId = :versionId"),
        @NamedQuery(name = "ResumeSkill.findBySkill", query = "SELECT r FROM ResumeSkill r WHERE r.skill = :skill"),
        @NamedQuery(name = "ResumeSkill.findByResumeId", query = "SELECT r FROM ResumeSkill r WHERE r.resumeId = :resumeId"),
        @NamedQuery(name = "ResumeSkill.findByCreatedUser", query = "SELECT r FROM ResumeSkill r WHERE r.createdUser = :createdUser"),
        @NamedQuery(name = "ResumeSkill.findByCreationDate", query = "SELECT r FROM ResumeSkill r WHERE r.creationDate = :creationDate"),
        @NamedQuery(name = "ResumeSkill.findByLastModifiedDate", query = "SELECT r FROM ResumeSkill r WHERE r.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "ResumeSkill.findByLastModifiedUser", query = "SELECT r FROM ResumeSkill r WHERE r.lastModifiedUser = :lastModifiedUser")
    })
public class ResumeSkill implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "skill", nullable = false)
    private String skill;

    @Column(name = "resumeId", nullable = false)
    private int resumeId;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "lastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;
    
    /** Creates a new instance of ResumeSkill */
    public ResumeSkill() {
    }

    /**
     * Creates a new instance of ResumeSkill with the specified values.
     * @param id the id of the ResumeSkill
     */
    public ResumeSkill(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of ResumeSkill with the specified values.
     * @param id the id of the ResumeSkill
     * @param versionId the versionId of the ResumeSkill
     * @param skill the skill of the ResumeSkill
     * @param resumeId the resumeId of the ResumeSkill
     * @param createdUser the createdUser of the ResumeSkill
     * @param lastModifiedUser the lastModifiedUser of the ResumeSkill
     */
    public ResumeSkill(Integer id, int versionId, String skill, int resumeId, String createdUser, String lastModifiedUser) {
        this.id = id;
        this.versionId = versionId;
        this.skill = skill;
        this.resumeId = resumeId;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the id of this ResumeSkill.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this ResumeSkill to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this ResumeSkill.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this ResumeSkill to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the skill of this ResumeSkill.
     * @return the skill
     */
    public String getSkill() {
        return this.skill;
    }

    /**
     * Sets the skill of this ResumeSkill to the specified value.
     * @param skill the new skill
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * Gets the resumeId of this ResumeSkill.
     * @return the resumeId
     */
    public int getResumeId() {
        return this.resumeId;
    }

    /**
     * Sets the resumeId of this ResumeSkill to the specified value.
     * @param resumeId the new resumeId
     */
    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    /**
     * Gets the createdUser of this ResumeSkill.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this ResumeSkill to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the creationDate of this ResumeSkill.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this ResumeSkill to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the lastModifiedDate of this ResumeSkill.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this ResumeSkill to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this ResumeSkill.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this ResumeSkill to the specified value.
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
     * Determines whether another object is equal to this ResumeSkill.  The result is 
     * <code>true</code> if and only if the argument is not null and is a ResumeSkill object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumeSkill)) {
            return false;
        }
        ResumeSkill other = (ResumeSkill)object;
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
        return "com.abbt.crm.base.entity.ResumeSkill[id=" + id + "]";
    }
    
}
