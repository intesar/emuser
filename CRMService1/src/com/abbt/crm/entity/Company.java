/*
 * Company.java
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
 * Entity class Company
 * 
 * @author shannan
 */
@Entity
@Table(name = "company")
@NamedQueries( {
        @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id"),
        @NamedQuery(name = "Company.findByVersionId", query = "SELECT c FROM Company c WHERE c.versionId = :versionId"),
        @NamedQuery(name = "Company.findByCompanyId", query = "SELECT c FROM Company c WHERE c.companyId = :companyId"),
        @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
        @NamedQuery(name = "Company.findByIsEnabled", query = "SELECT c FROM Company c WHERE c.isEnabled = :isEnabled"),
        @NamedQuery(name = "Company.findByLicenceType", query = "SELECT c FROM Company c WHERE c.licenceType = :licenceType"),
        @NamedQuery(name = "Company.findByExpirationDate", query = "SELECT c FROM Company c WHERE c.expirationDate = :expirationDate"),
        @NamedQuery(name = "Company.findByMaxLicenceUser", query = "SELECT c FROM Company c WHERE c.maxLicenceUser = :maxLicenceUser"),
        @NamedQuery(name = "Company.findByCreationDate", query = "SELECT c FROM Company c WHERE c.creationDate = :creationDate"),
        @NamedQuery(name = "Company.findByCreatedUser", query = "SELECT c FROM Company c WHERE c.createdUser = :createdUser"),
        @NamedQuery(name = "Company.findByLastModifiedDate", query = "SELECT c FROM Company c WHERE c.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Company.findByLastModifiedUser", query = "SELECT c FROM Company c WHERE c.lastModifiedUser = :lastModifiedUser")
    })
public class Company implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "companyId", nullable = false)
    private int companyId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;

    @Column(name = "licenceType", nullable = false)
    private String licenceType;

    @Column(name = "expirationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Column(name = "maxLicenceUser", nullable = false)
    private int maxLicenceUser;

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

    /** Creates a new instance of Company */
    public Company() {
    }

    /**
     * Creates a new instance of Company with the specified values.
     * @param id the id of the Company
     */
    public Company(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Company with the specified values.
     * @param id the id of the Company
     * @param versionId the versionId of the Company
     * @param companyId the companyId of the Company
     * @param name the name of the Company
     * @param isEnabled the isEnabled of the Company
     * @param licenceType the licenceType of the Company
     * @param expirationDate the expirationDate of the Company
     * @param maxLicenceUser the maxLicenceUser of the Company
     * @param creationDate the creationDate of the Company
     * @param createdUser the createdUser of the Company
     * @param lastModifiedDate the lastModifiedDate of the Company
     * @param lastModifiedUser the lastModifiedUser of the Company
     */
    public Company(Integer id, int versionId, int companyId, String name, boolean isEnabled, String licenceType, Date expirationDate, int maxLicenceUser, Date creationDate, String createdUser, Date lastModifiedDate, String lastModifiedUser) {
        this.id = id;
        this.versionId = versionId;
        this.companyId = companyId;
        this.name = name;
        this.isEnabled = isEnabled;
        this.licenceType = licenceType;
        this.expirationDate = expirationDate;
        this.maxLicenceUser = maxLicenceUser;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the id of this Company.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Company to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Company.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Company to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the companyId of this Company.
     * @return the companyId
     */
    public int getCompanyId() {
        return this.companyId;
    }

    /**
     * Sets the companyId of this Company to the specified value.
     * @param companyId the new companyId
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets the name of this Company.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this Company to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the isEnabled of this Company.
     * @return the isEnabled
     */
    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this Company to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Gets the licenceType of this Company.
     * @return the licenceType
     */
    public String getLicenceType() {
        return this.licenceType;
    }

    /**
     * Sets the licenceType of this Company to the specified value.
     * @param licenceType the new licenceType
     */
    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    /**
     * Gets the expirationDate of this Company.
     * @return the expirationDate
     */
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * Sets the expirationDate of this Company to the specified value.
     * @param expirationDate the new expirationDate
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the maxLicenceUser of this Company.
     * @return the maxLicenceUser
     */
    public int getMaxLicenceUser() {
        return this.maxLicenceUser;
    }

    /**
     * Sets the maxLicenceUser of this Company to the specified value.
     * @param maxLicenceUser the new maxLicenceUser
     */
    public void setMaxLicenceUser(int maxLicenceUser) {
        this.maxLicenceUser = maxLicenceUser;
    }

    /**
     * Gets the creationDate of this Company.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Company to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Company.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Company to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedDate of this Company.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Company to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the lastModifiedUser of this Company.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Company to the specified value.
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
     * Determines whether another object is equal to this Company.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Company object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company)object;
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
        return "com.abbt.crm.entity.Company[id=" + id + "]";
    }

}
