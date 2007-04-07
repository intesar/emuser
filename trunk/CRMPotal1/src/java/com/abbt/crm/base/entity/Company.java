/*
 * Company.java
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
 * Entity class Company
 * 
 * @author Mohammed Hamed
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
        @NamedQuery(name = "Company.findByLastModifiedUser", query = "SELECT c FROM Company c WHERE c.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Company.findByHomePhone", query = "SELECT c FROM Company c WHERE c.homePhone = :homePhone"),
        @NamedQuery(name = "Company.findByOfficePhone1", query = "SELECT c FROM Company c WHERE c.officePhone1 = :officePhone1"),
        @NamedQuery(name = "Company.findByOfficePhone2", query = "SELECT c FROM Company c WHERE c.officePhone2 = :officePhone2"),
        @NamedQuery(name = "Company.findByOfficePhone3", query = "SELECT c FROM Company c WHERE c.officePhone3 = :officePhone3"),
        @NamedQuery(name = "Company.findByOfficePhone4", query = "SELECT c FROM Company c WHERE c.officePhone4 = :officePhone4"),
        @NamedQuery(name = "Company.findByFax", query = "SELECT c FROM Company c WHERE c.fax = :fax")
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

    @Column(name = "expirationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Column(name = "maxLicenceUser", nullable = false)
    private int maxLicenceUser;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser", nullable = false)
    private String createdUser;

    @Column(name = "lastModifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser", nullable = false)
    private String lastModifiedUser;

    @Column(name = "homePhone")
    private String homePhone;

    @Column(name = "officePhone1")
    private String officePhone1;

    @Column(name = "officePhone2")
    private String officePhone2;

    @Column(name = "officePhone3")
    private String officePhone3;

    @Column(name = "officePhone4")
    private String officePhone4;

    @Column(name = "fax")
    private String fax;
    
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
     * @param maxLicenceUser the maxLicenceUser of the Company
     * @param createdUser the createdUser of the Company
     * @param lastModifiedUser the lastModifiedUser of the Company
     */
    public Company(Integer id, int versionId, int companyId, String name, boolean isEnabled, String licenceType, int maxLicenceUser, String createdUser, String lastModifiedUser) {
        this.id = id;
        this.versionId = versionId;
        this.companyId = companyId;
        this.name = name;
        this.isEnabled = isEnabled;
        this.licenceType = licenceType;
        this.maxLicenceUser = maxLicenceUser;
        this.createdUser = createdUser;
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
     * Gets the homePhone of this Company.
     * @return the homePhone
     */
    public String getHomePhone() {
        return this.homePhone;
    }

    /**
     * Sets the homePhone of this Company to the specified value.
     * @param homePhone the new homePhone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Gets the officePhone1 of this Company.
     * @return the officePhone1
     */
    public String getOfficePhone1() {
        return this.officePhone1;
    }

    /**
     * Sets the officePhone1 of this Company to the specified value.
     * @param officePhone1 the new officePhone1
     */
    public void setOfficePhone1(String officePhone1) {
        this.officePhone1 = officePhone1;
    }

    /**
     * Gets the officePhone2 of this Company.
     * @return the officePhone2
     */
    public String getOfficePhone2() {
        return this.officePhone2;
    }

    /**
     * Sets the officePhone2 of this Company to the specified value.
     * @param officePhone2 the new officePhone2
     */
    public void setOfficePhone2(String officePhone2) {
        this.officePhone2 = officePhone2;
    }

    /**
     * Gets the officePhone3 of this Company.
     * @return the officePhone3
     */
    public String getOfficePhone3() {
        return this.officePhone3;
    }

    /**
     * Sets the officePhone3 of this Company to the specified value.
     * @param officePhone3 the new officePhone3
     */
    public void setOfficePhone3(String officePhone3) {
        this.officePhone3 = officePhone3;
    }

    /**
     * Gets the officePhone4 of this Company.
     * @return the officePhone4
     */
    public String getOfficePhone4() {
        return this.officePhone4;
    }

    /**
     * Sets the officePhone4 of this Company to the specified value.
     * @param officePhone4 the new officePhone4
     */
    public void setOfficePhone4(String officePhone4) {
        this.officePhone4 = officePhone4;
    }

    /**
     * Gets the fax of this Company.
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets the fax of this Company to the specified value.
     * @param fax the new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
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
        return "com.abbt.crm.base.entity.Company[id=" + id + "]";
    }
    
}
