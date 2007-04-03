/*
 * SelectType.java
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class SelectType
 * 
 * @author shannan
 */
@Entity
@Table(name = "select_type")
@NamedQueries( {
        @NamedQuery(name = "SelectType.findById", query = "SELECT s FROM SelectType s WHERE s.id = :id"),
        @NamedQuery(name = "SelectType.findByVersionId", query = "SELECT s FROM SelectType s WHERE s.versionId = :versionId"),
        @NamedQuery(name = "SelectType.findByName", query = "SELECT s FROM SelectType s WHERE s.name = :name"),
        @NamedQuery(name = "SelectType.findByDescription", query = "SELECT s FROM SelectType s WHERE s.description = :description"),
        @NamedQuery(name = "SelectType.findByType", query = "SELECT s FROM SelectType s WHERE s.type = :type"),
        @NamedQuery(name = "SelectType.findBySortNumber", query = "SELECT s FROM SelectType s WHERE s.sortNumber = :sortNumber"),
        @NamedQuery(name = "SelectType.findByCreationDate", query = "SELECT s FROM SelectType s WHERE s.creationDate = :creationDate"),
        @NamedQuery(name = "SelectType.findByCreatedUser", query = "SELECT s FROM SelectType s WHERE s.createdUser = :createdUser"),
        @NamedQuery(name = "SelectType.findByLastModifiedUser", query = "SELECT s FROM SelectType s WHERE s.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "SelectType.findByLastModifiedDate", query = "SELECT s FROM SelectType s WHERE s.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "SelectType.findByIsGlobal", query = "SELECT s FROM SelectType s WHERE s.isGlobal = :isGlobal"),
        @NamedQuery(name = "SelectType.findByOwnedCompany", query = "SELECT s FROM SelectType s WHERE s.ownedCompany = :ownedCompany")
    })
public class SelectType implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "sortNumber", nullable = false)
    private String sortNumber;

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

    @Column(name = "isGlobal", nullable = false)
    private boolean isGlobal;

    @Column(name = "ownedCompany", nullable = false)
    private boolean ownedCompany;

    /** Creates a new instance of SelectType */
    public SelectType() {
    }

    /**
     * Creates a new instance of SelectType with the specified values.
     * @param id the id of the SelectType
     */
    public SelectType(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of SelectType with the specified values.
     * @param id the id of the SelectType
     * @param versionId the versionId of the SelectType
     * @param name the name of the SelectType
     * @param description the description of the SelectType
     * @param type the type of the SelectType
     * @param sortNumber the sortNumber of the SelectType
     * @param creationDate the creationDate of the SelectType
     * @param createdUser the createdUser of the SelectType
     * @param lastModifiedUser the lastModifiedUser of the SelectType
     * @param lastModifiedDate the lastModifiedDate of the SelectType
     * @param isGlobal the isGlobal of the SelectType
     * @param ownedCompany the ownedCompany of the SelectType
     */
    public SelectType(Integer id, int versionId, String name, String description, String type, String sortNumber, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate, boolean isGlobal, boolean ownedCompany) {
        this.id = id;
        this.versionId = versionId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.sortNumber = sortNumber;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
        this.isGlobal = isGlobal;
        this.ownedCompany = ownedCompany;
    }

    /**
     * Gets the id of this SelectType.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this SelectType to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this SelectType.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this SelectType to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the name of this SelectType.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this SelectType to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this SelectType.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this SelectType to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the type of this SelectType.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this SelectType to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the sortNumber of this SelectType.
     * @return the sortNumber
     */
    public String getSortNumber() {
        return this.sortNumber;
    }

    /**
     * Sets the sortNumber of this SelectType to the specified value.
     * @param sortNumber the new sortNumber
     */
    public void setSortNumber(String sortNumber) {
        this.sortNumber = sortNumber;
    }

    /**
     * Gets the creationDate of this SelectType.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this SelectType to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this SelectType.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this SelectType to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this SelectType.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this SelectType to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this SelectType.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this SelectType to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the isGlobal of this SelectType.
     * @return the isGlobal
     */
    public boolean getIsGlobal() {
        return this.isGlobal;
    }

    /**
     * Sets the isGlobal of this SelectType to the specified value.
     * @param isGlobal the new isGlobal
     */
    public void setIsGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    /**
     * Gets the ownedCompany of this SelectType.
     * @return the ownedCompany
     */
    public boolean getOwnedCompany() {
        return this.ownedCompany;
    }

    /**
     * Sets the ownedCompany of this SelectType to the specified value.
     * @param ownedCompany the new ownedCompany
     */
    public void setOwnedCompany(boolean ownedCompany) {
        this.ownedCompany = ownedCompany;
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
     * Determines whether another object is equal to this SelectType.  The result is 
     * <code>true</code> if and only if the argument is not null and is a SelectType object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SelectType)) {
            return false;
        }
        SelectType other = (SelectType)object;
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
        return "com.abbt.crm.base.entity.SelectType[id=" + id + "]";
    }

}
