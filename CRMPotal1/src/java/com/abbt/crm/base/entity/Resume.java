/*
 * Resume.java
 *
 * Created on April 2, 2007, 10:11 PM
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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class Resume
 * 
 * @author shannan
 */
@Entity
@Table(name = "resume")
@NamedQueries( {
        @NamedQuery(name = "Resume.findById", query = "SELECT r FROM Resume r WHERE r.id = :id"),
        @NamedQuery(name = "Resume.findByVersionId", query = "SELECT r FROM Resume r WHERE r.versionId = :versionId"),
        @NamedQuery(name = "Resume.findByName", query = "SELECT r FROM Resume r WHERE r.name = :name"),
        @NamedQuery(name = "Resume.findByDescription", query = "SELECT r FROM Resume r WHERE r.description = :description"),
        @NamedQuery(name = "Resume.findByVisibility", query = "SELECT r FROM Resume r WHERE r.visibility = :visibility"),
        @NamedQuery(name = "Resume.findByCreationDate", query = "SELECT r FROM Resume r WHERE r.creationDate = :creationDate"),
        @NamedQuery(name = "Resume.findByCreatedUser", query = "SELECT r FROM Resume r WHERE r.createdUser = :createdUser"),
        @NamedQuery(name = "Resume.findByLastModifiedUser", query = "SELECT r FROM Resume r WHERE r.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Resume.findByLastModifiedDate", query = "SELECT r FROM Resume r WHERE r.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Resume.findByEmployeeId", query = "SELECT r FROM Resume r WHERE r.employeeId = :employeeId"),
        @NamedQuery(name = "Resume.findByResumeId", query = "SELECT r FROM Resume r WHERE r.resumeId = :resumeId"),
        @NamedQuery(name = "Resume.findByContents", query = "SELECT r FROM Resume r WHERE r.contents = :contents")
    })
public class Resume implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Lob
    @Column(name = "file", nullable = false)
    private byte [] file;

    @Column(name = "visibility", nullable = false)
    private boolean visibility;

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

    @Column(name = "employeeId", nullable = false)
    private int employeeId;

    @Column(name = "resumeId", nullable = false)
    private int resumeId;

    @Column(name = "contents", nullable = false)
    private String contents;

    /** Creates a new instance of Resume */
    public Resume() {
    }

    /**
     * Creates a new instance of Resume with the specified values.
     * @param id the id of the Resume
     */
    public Resume(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Resume with the specified values.
     * @param id the id of the Resume
     * @param versionId the versionId of the Resume
     * @param name the name of the Resume
     * @param description the description of the Resume
     * @param file the file of the Resume
     * @param visibility the visibility of the Resume
     * @param creationDate the creationDate of the Resume
     * @param createdUser the createdUser of the Resume
     * @param lastModifiedUser the lastModifiedUser of the Resume
     * @param lastModifiedDate the lastModifiedDate of the Resume
     * @param employeeId the employeeId of the Resume
     * @param resumeId the resumeId of the Resume
     * @param contents the contents of the Resume
     */
    public Resume(Integer id, int versionId, String name, String description, byte [] file, boolean visibility, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate, int employeeId, int resumeId, String contents) {
        this.id = id;
        this.versionId = versionId;
        this.name = name;
        this.description = description;
        this.file = file;
        this.visibility = visibility;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.employeeId = employeeId;
        this.resumeId = resumeId;
        this.contents = contents;
    }

    /**
     * Gets the id of this Resume.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Resume to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Resume.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Resume to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the name of this Resume.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this Resume to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this Resume.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Resume to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the file of this Resume.
     * @return the file
     */
    public byte [] getFile() {
        return this.file;
    }

    /**
     * Sets the file of this Resume to the specified value.
     * @param file the new file
     */
    public void setFile(byte [] file) {
        this.file = file;
    }

    /**
     * Gets the visibility of this Resume.
     * @return the visibility
     */
    public boolean getVisibility() {
        return this.visibility;
    }

    /**
     * Sets the visibility of this Resume to the specified value.
     * @param visibility the new visibility
     */
    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the creationDate of this Resume.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Resume to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Resume.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Resume to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this Resume.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Resume to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Resume.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Resume to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the employeeId of this Resume.
     * @return the employeeId
     */
    public int getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets the employeeId of this Resume to the specified value.
     * @param employeeId the new employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the resumeId of this Resume.
     * @return the resumeId
     */
    public int getResumeId() {
        return this.resumeId;
    }

    /**
     * Sets the resumeId of this Resume to the specified value.
     * @param resumeId the new resumeId
     */
    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    /**
     * Gets the contents of this Resume.
     * @return the contents
     */
    public String getContents() {
        return this.contents;
    }

    /**
     * Sets the contents of this Resume to the specified value.
     * @param contents the new contents
     */
    public void setContents(String contents) {
        this.contents = contents;
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
     * Determines whether another object is equal to this Resume.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Resume object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resume)) {
            return false;
        }
        Resume other = (Resume)object;
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
        return "com.abbt.crm.base.entity.Resume[id=" + id + "]";
    }

}
