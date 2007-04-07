/*
 * Notes.java
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
 * Entity class Notes
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "notes")
@NamedQueries( {
        @NamedQuery(name = "Notes.findById", query = "SELECT n FROM Notes n WHERE n.id = :id"),
        @NamedQuery(name = "Notes.findByVersionId", query = "SELECT n FROM Notes n WHERE n.versionId = :versionId"),
        @NamedQuery(name = "Notes.findByDescription", query = "SELECT n FROM Notes n WHERE n.description = :description"),
        @NamedQuery(name = "Notes.findByCreationDate", query = "SELECT n FROM Notes n WHERE n.creationDate = :creationDate"),
        @NamedQuery(name = "Notes.findByCreatedUser", query = "SELECT n FROM Notes n WHERE n.createdUser = :createdUser"),
        @NamedQuery(name = "Notes.findByLastModifiedUser", query = "SELECT n FROM Notes n WHERE n.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Notes.findByLastModifiedDate", query = "SELECT n FROM Notes n WHERE n.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Notes.findByContactid", query = "SELECT n FROM Notes n WHERE n.contactid = :contactid")
    })
public class Notes implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "description", nullable = false)
    private String description;

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

    @Column(name = "contactid", nullable = false)
    private String contactid;
    
    /** Creates a new instance of Notes */
    public Notes() {
    }

    /**
     * Creates a new instance of Notes with the specified values.
     * @param id the id of the Notes
     */
    public Notes(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Notes with the specified values.
     * @param id the id of the Notes
     * @param versionId the versionId of the Notes
     * @param description the description of the Notes
     * @param createdUser the createdUser of the Notes
     * @param lastModifiedUser the lastModifiedUser of the Notes
     * @param contactid the contactid of the Notes
     */
    public Notes(Integer id, int versionId, String description, String createdUser, String lastModifiedUser, String contactid) {
        this.id = id;
        this.versionId = versionId;
        this.description = description;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.contactid = contactid;
    }

    /**
     * Gets the id of this Notes.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Notes to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Notes.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Notes to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the description of this Notes.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Notes to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the creationDate of this Notes.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Notes to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Notes.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Notes to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this Notes.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Notes to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Notes.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Notes to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the contactid of this Notes.
     * @return the contactid
     */
    public String getContactid() {
        return this.contactid;
    }

    /**
     * Sets the contactid of this Notes to the specified value.
     * @param contactid the new contactid
     */
    public void setContactid(String contactid) {
        this.contactid = contactid;
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
     * Determines whether another object is equal to this Notes.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Notes object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes)object;
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
        return "com.abbt.crm.base.entity.Notes[id=" + id + "]";
    }
    
}
