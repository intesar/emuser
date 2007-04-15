/*
 * Company.java
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
        @NamedQuery(name = "Company.findByLastModifiedUser", query = "SELECT c FROM Company c WHERE c.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Company.findByPhone1", query = "SELECT c FROM Company c WHERE c.phone1 = :phone1"),
        @NamedQuery(name = "Company.findByPhone2", query = "SELECT c FROM Company c WHERE c.phone2 = :phone2"),
        @NamedQuery(name = "Company.findByPhone3", query = "SELECT c FROM Company c WHERE c.phone3 = :phone3"),
        @NamedQuery(name = "Company.findByPhone4", query = "SELECT c FROM Company c WHERE c.phone4 = :phone4"),
        @NamedQuery(name = "Company.findByFax", query = "SELECT c FROM Company c WHERE c.fax = :fax"),
        @NamedQuery(name = "Company.findByBillingStreet", query = "SELECT c FROM Company c WHERE c.billingStreet = :billingStreet"),
        @NamedQuery(name = "Company.findByBillingCity", query = "SELECT c FROM Company c WHERE c.billingCity = :billingCity"),
        @NamedQuery(name = "Company.findByBillingState", query = "SELECT c FROM Company c WHERE c.billingState = :billingState"),
        @NamedQuery(name = "Company.findByBillingZipcode", query = "SELECT c FROM Company c WHERE c.billingZipcode = :billingZipcode"),
        @NamedQuery(name = "Company.findByBillingCountry", query = "SELECT c FROM Company c WHERE c.billingCountry = :billingCountry"),
        @NamedQuery(name = "Company.findByShippingStreet", query = "SELECT c FROM Company c WHERE c.shippingStreet = :shippingStreet"),
        @NamedQuery(name = "Company.findByShippingCity", query = "SELECT c FROM Company c WHERE c.shippingCity = :shippingCity"),
        @NamedQuery(name = "Company.findByShippingState", query = "SELECT c FROM Company c WHERE c.shippingState = :shippingState"),
        @NamedQuery(name = "Company.findByShippingZipcode", query = "SELECT c FROM Company c WHERE c.shippingZipcode = :shippingZipcode"),
        @NamedQuery(name = "Company.findByShippingCountry", query = "SELECT c FROM Company c WHERE c.shippingCountry = :shippingCountry"),
        @NamedQuery(name = "Company.findByIsShippingSameAsBillingAddress", query = "SELECT c FROM Company c WHERE c.isShippingSameAsBillingAddress = :isShippingSameAsBillingAddress")
    })
public class Company implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId")
    private Integer versionId;

    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @Column(name = "licenceType")
    private String licenceType;

    @Column(name = "expirationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Column(name = "maxLicenceUser")
    private Integer maxLicenceUser;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser")
    private String createdUser;

    @Column(name = "lastModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "lastModifiedUser")
    private String lastModifiedUser;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "phone3")
    private String phone3;

    @Column(name = "phone4")
    private String phone4;

    @Column(name = "fax")
    private String fax;

    @Column(name = "billingStreet")
    private String billingStreet;

    @Column(name = "billingCity")
    private String billingCity;

    @Column(name = "billingState")
    private String billingState;

    @Column(name = "billingZipcode")
    private String billingZipcode;

    @Column(name = "billingCountry")
    private String billingCountry;

    @Column(name = "shippingStreet")
    private String shippingStreet;

    @Column(name = "shippingCity")
    private String shippingCity;

    @Column(name = "shippingState")
    private String shippingState;

    @Column(name = "shippingZipcode")
    private String shippingZipcode;

    @Column(name = "shippingCountry")
    private String shippingCountry;

    @Column(name = "isShippingSameAsBillingAddress")
    private Boolean isShippingSameAsBillingAddress;

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
     * @param name the name of the Company
     * @param expirationDate the expirationDate of the Company
     * @param creationDate the creationDate of the Company
     * @param lastModifiedDate the lastModifiedDate of the Company
     */
    public Company(Integer id, String name, Date expirationDate, Date creationDate, Date lastModifiedDate) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
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
    public Integer getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Company to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the companyId of this Company.
     * @return the companyId
     */
    public Integer getCompanyId() {
        return this.companyId;
    }

    /**
     * Sets the companyId of this Company to the specified value.
     * @param companyId the new companyId
     */
    public void setCompanyId(Integer companyId) {
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
    public Boolean getIsEnabled() {
        return this.isEnabled;
    }

    /**
     * Sets the isEnabled of this Company to the specified value.
     * @param isEnabled the new isEnabled
     */
    public void setIsEnabled(Boolean isEnabled) {
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
    public Integer getMaxLicenceUser() {
        return this.maxLicenceUser;
    }

    /**
     * Sets the maxLicenceUser of this Company to the specified value.
     * @param maxLicenceUser the new maxLicenceUser
     */
    public void setMaxLicenceUser(Integer maxLicenceUser) {
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
     * Gets the phone1 of this Company.
     * @return the phone1
     */
    public String getPhone1() {
        return this.phone1;
    }

    /**
     * Sets the phone1 of this Company to the specified value.
     * @param phone1 the new phone1
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     * Gets the phone2 of this Company.
     * @return the phone2
     */
    public String getPhone2() {
        return this.phone2;
    }

    /**
     * Sets the phone2 of this Company to the specified value.
     * @param phone2 the new phone2
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * Gets the phone3 of this Company.
     * @return the phone3
     */
    public String getPhone3() {
        return this.phone3;
    }

    /**
     * Sets the phone3 of this Company to the specified value.
     * @param phone3 the new phone3
     */
    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    /**
     * Gets the phone4 of this Company.
     * @return the phone4
     */
    public String getPhone4() {
        return this.phone4;
    }

    /**
     * Sets the phone4 of this Company to the specified value.
     * @param phone4 the new phone4
     */
    public void setPhone4(String phone4) {
        this.phone4 = phone4;
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
     * Gets the billingStreet of this Company.
     * @return the billingStreet
     */
    public String getBillingStreet() {
        return this.billingStreet;
    }

    /**
     * Sets the billingStreet of this Company to the specified value.
     * @param billingStreet the new billingStreet
     */
    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    /**
     * Gets the billingCity of this Company.
     * @return the billingCity
     */
    public String getBillingCity() {
        return this.billingCity;
    }

    /**
     * Sets the billingCity of this Company to the specified value.
     * @param billingCity the new billingCity
     */
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     * Gets the billingState of this Company.
     * @return the billingState
     */
    public String getBillingState() {
        return this.billingState;
    }

    /**
     * Sets the billingState of this Company to the specified value.
     * @param billingState the new billingState
     */
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    /**
     * Gets the billingZipcode of this Company.
     * @return the billingZipcode
     */
    public String getBillingZipcode() {
        return this.billingZipcode;
    }

    /**
     * Sets the billingZipcode of this Company to the specified value.
     * @param billingZipcode the new billingZipcode
     */
    public void setBillingZipcode(String billingZipcode) {
        this.billingZipcode = billingZipcode;
    }

    /**
     * Gets the billingCountry of this Company.
     * @return the billingCountry
     */
    public String getBillingCountry() {
        return this.billingCountry;
    }

    /**
     * Sets the billingCountry of this Company to the specified value.
     * @param billingCountry the new billingCountry
     */
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    /**
     * Gets the shippingStreet of this Company.
     * @return the shippingStreet
     */
    public String getShippingStreet() {
        return this.shippingStreet;
    }

    /**
     * Sets the shippingStreet of this Company to the specified value.
     * @param shippingStreet the new shippingStreet
     */
    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    /**
     * Gets the shippingCity of this Company.
     * @return the shippingCity
     */
    public String getShippingCity() {
        return this.shippingCity;
    }

    /**
     * Sets the shippingCity of this Company to the specified value.
     * @param shippingCity the new shippingCity
     */
    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    /**
     * Gets the shippingState of this Company.
     * @return the shippingState
     */
    public String getShippingState() {
        return this.shippingState;
    }

    /**
     * Sets the shippingState of this Company to the specified value.
     * @param shippingState the new shippingState
     */
    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    /**
     * Gets the shippingZipcode of this Company.
     * @return the shippingZipcode
     */
    public String getShippingZipcode() {
        return this.shippingZipcode;
    }

    /**
     * Sets the shippingZipcode of this Company to the specified value.
     * @param shippingZipcode the new shippingZipcode
     */
    public void setShippingZipcode(String shippingZipcode) {
        this.shippingZipcode = shippingZipcode;
    }

    /**
     * Gets the shippingCountry of this Company.
     * @return the shippingCountry
     */
    public String getShippingCountry() {
        return this.shippingCountry;
    }

    /**
     * Sets the shippingCountry of this Company to the specified value.
     * @param shippingCountry the new shippingCountry
     */
    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    /**
     * Gets the isShippingSameAsBillingAddress of this Company.
     * @return the isShippingSameAsBillingAddress
     */
    public Boolean getIsShippingSameAsBillingAddress() {
        return this.isShippingSameAsBillingAddress;
    }

    /**
     * Sets the isShippingSameAsBillingAddress of this Company to the specified value.
     * @param isShippingSameAsBillingAddress the new isShippingSameAsBillingAddress
     */
    public void setIsShippingSameAsBillingAddress(Boolean isShippingSameAsBillingAddress) {
        this.isShippingSameAsBillingAddress = isShippingSameAsBillingAddress;
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
