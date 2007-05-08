/*
 * Company.java
 *
 * Created on May 7, 2007, 11:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
        @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
        @NamedQuery(name = "Company.findByCreatedBy", query = "SELECT c FROM Company c WHERE c.createdBy = :createdBy"),
        @NamedQuery(name = "Company.findByCreatedDate", query = "SELECT c FROM Company c WHERE c.createdDate = :createdDate"),
        @NamedQuery(name = "Company.findByLastUpdatedBy", query = "SELECT c FROM Company c WHERE c.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Company.findByLastUpdatedDate", query = "SELECT c FROM Company c WHERE c.lastUpdatedDate = :lastUpdatedDate"),
        @NamedQuery(name = "Company.findByDescription", query = "SELECT c FROM Company c WHERE c.description = :description"),
        @NamedQuery(name = "Company.findByIsEnabled", query = "SELECT c FROM Company c WHERE c.isEnabled = :isEnabled"),
        @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id")
    })
public class Company implements Serializable {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastUpdatedBy")
    private String lastUpdatedBy;

    @Column(name = "lastUpdatedDate")
    @Temporal(TemporalType.DATE)
    private Date lastUpdatedDate;

    @Column(name = "description")
    private String description;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @Column(name = "id")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyName")
    private Collection<UserCompany> userCompanyCollection;

    @JoinColumn(name = "phone3", referencedColumnName = "id")
    @ManyToOne
    private Phone phone3;

    @JoinColumn(name = "billingAddress", referencedColumnName = "id")
    @ManyToOne
    private Address billingAddress;

    @JoinColumn(name = "otherAddress", referencedColumnName = "id")
    @ManyToOne
    private Address otherAddress;

    @JoinColumn(name = "phone1", referencedColumnName = "id")
    @ManyToOne
    private Phone phone1;

    @JoinColumn(name = "phone2", referencedColumnName = "id")
    @ManyToOne
    private Phone phone2;
    
    /** Creates a new instance of Company */
    public Company() {
    }

    /**
     * Creates a new instance of Company with the specified values.
     * @param name the name of the Company
     */
    public Company(String name) {
        this.name = name;
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
     * Gets the createdBy of this Company.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this Company to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this Company.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this Company to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this Company.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this Company to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdatedDate of this Company.
     * @return the lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Sets the lastUpdatedDate of this Company to the specified value.
     * @param lastUpdatedDate the new lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Gets the description of this Company.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Company to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets the userCompanyCollection of this Company.
     * @return the userCompanyCollection
     */
    public Collection<UserCompany> getUserCompanyCollection() {
        return this.userCompanyCollection;
    }

    /**
     * Sets the userCompanyCollection of this Company to the specified value.
     * @param userCompanyCollection the new userCompanyCollection
     */
    public void setUserCompanyCollection(Collection<UserCompany> userCompanyCollection) {
        this.userCompanyCollection = userCompanyCollection;
    }

    /**
     * Gets the phone3 of this Company.
     * @return the phone3
     */
    public Phone getPhone3() {
        return this.phone3;
    }

    /**
     * Sets the phone3 of this Company to the specified value.
     * @param phone3 the new phone3
     */
    public void setPhone3(Phone phone3) {
        this.phone3 = phone3;
    }

    /**
     * Gets the billingAddress of this Company.
     * @return the billingAddress
     */
    public Address getBillingAddress() {
        return this.billingAddress;
    }

    /**
     * Sets the billingAddress of this Company to the specified value.
     * @param billingAddress the new billingAddress
     */
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Gets the otherAddress of this Company.
     * @return the otherAddress
     */
    public Address getOtherAddress() {
        return this.otherAddress;
    }

    /**
     * Sets the otherAddress of this Company to the specified value.
     * @param otherAddress the new otherAddress
     */
    public void setOtherAddress(Address otherAddress) {
        this.otherAddress = otherAddress;
    }

    /**
     * Gets the phone1 of this Company.
     * @return the phone1
     */
    public Phone getPhone1() {
        return this.phone1;
    }

    /**
     * Sets the phone1 of this Company to the specified value.
     * @param phone1 the new phone1
     */
    public void setPhone1(Phone phone1) {
        this.phone1 = phone1;
    }

    /**
     * Gets the phone2 of this Company.
     * @return the phone2
     */
    public Phone getPhone2() {
        return this.phone2;
    }

    /**
     * Sets the phone2 of this Company to the specified value.
     * @param phone2 the new phone2
     */
    public void setPhone2(Phone phone2) {
        this.phone2 = phone2;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.name != null ? this.name.hashCode() : 0);
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
        if (this.name != other.name && (this.name == null || !this.name.equals(other.name))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.timesheet.entities.Company[name=" + name + "]";
    }
    
}
