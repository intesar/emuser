/*
 * Address.java
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class Address
 * 
 * @author shannan
 */
@Entity
@Table(name = "address")
@NamedQueries( {
        @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"),
        @NamedQuery(name = "Address.findByAddressType", query = "SELECT a FROM Address a WHERE a.addressType = :addressType"),
        @NamedQuery(name = "Address.findByStreetLine1", query = "SELECT a FROM Address a WHERE a.streetLine1 = :streetLine1"),
        @NamedQuery(name = "Address.findByStreetLine2", query = "SELECT a FROM Address a WHERE a.streetLine2 = :streetLine2"),
        @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
        @NamedQuery(name = "Address.findByState", query = "SELECT a FROM Address a WHERE a.state = :state"),
        @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = :zipcode"),
        @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"),
        @NamedQuery(name = "Address.findByVerified", query = "SELECT a FROM Address a WHERE a.verified = :verified"),
        @NamedQuery(name = "Address.findByCreatedBy", query = "SELECT a FROM Address a WHERE a.createdBy = :createdBy"),
        @NamedQuery(name = "Address.findByCreatedDate", query = "SELECT a FROM Address a WHERE a.createdDate = :createdDate"),
        @NamedQuery(name = "Address.findByLastUpdatedBy", query = "SELECT a FROM Address a WHERE a.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "Address.findByLastUpdatedDate", query = "SELECT a FROM Address a WHERE a.lastUpdatedDate = :lastUpdatedDate")
    })
public class Address implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "addressType", nullable = false)
    private String addressType;

    @Column(name = "streetLine1", nullable = false)
    private String streetLine1;

    @Column(name = "streetLine2")
    private String streetLine2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "country")
    private String country;

    @Column(name = "verified")
    private Short verified;

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

    @OneToMany(mappedBy = "billingAddress")
    private Collection<Company> companyCollection;

    @OneToMany(mappedBy = "otherAddress")
    private Collection<Company> companyCollection1;

    @OneToMany(mappedBy = "primaryAddress")
    private Collection<User> userCollection;
    
    /** Creates a new instance of Address */
    public Address() {
    }

    /**
     * Creates a new instance of Address with the specified values.
     * @param id the id of the Address
     */
    public Address(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Address with the specified values.
     * @param id the id of the Address
     * @param addressType the addressType of the Address
     * @param streetLine1 the streetLine1 of the Address
     * @param city the city of the Address
     * @param zipcode the zipcode of the Address
     */
    public Address(Integer id, String addressType, String streetLine1, String city, String zipcode) {
        this.id = id;
        this.addressType = addressType;
        this.streetLine1 = streetLine1;
        this.city = city;
        this.zipcode = zipcode;
    }

    /**
     * Gets the id of this Address.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Address to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the addressType of this Address.
     * @return the addressType
     */
    public String getAddressType() {
        return this.addressType;
    }

    /**
     * Sets the addressType of this Address to the specified value.
     * @param addressType the new addressType
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * Gets the streetLine1 of this Address.
     * @return the streetLine1
     */
    public String getStreetLine1() {
        return this.streetLine1;
    }

    /**
     * Sets the streetLine1 of this Address to the specified value.
     * @param streetLine1 the new streetLine1
     */
    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    /**
     * Gets the streetLine2 of this Address.
     * @return the streetLine2
     */
    public String getStreetLine2() {
        return this.streetLine2;
    }

    /**
     * Sets the streetLine2 of this Address to the specified value.
     * @param streetLine2 the new streetLine2
     */
    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    /**
     * Gets the city of this Address.
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of this Address to the specified value.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of this Address.
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of this Address to the specified value.
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zipcode of this Address.
     * @return the zipcode
     */
    public String getZipcode() {
        return this.zipcode;
    }

    /**
     * Sets the zipcode of this Address to the specified value.
     * @param zipcode the new zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Gets the country of this Address.
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the country of this Address to the specified value.
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the verified of this Address.
     * @return the verified
     */
    public Short getVerified() {
        return this.verified;
    }

    /**
     * Sets the verified of this Address to the specified value.
     * @param verified the new verified
     */
    public void setVerified(Short verified) {
        this.verified = verified;
    }

    /**
     * Gets the createdBy of this Address.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this Address to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this Address.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this Address to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this Address.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this Address to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdatedDate of this Address.
     * @return the lastUpdatedDate
     */
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    /**
     * Sets the lastUpdatedDate of this Address to the specified value.
     * @param lastUpdatedDate the new lastUpdatedDate
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    /**
     * Gets the companyCollection of this Address.
     * @return the companyCollection
     */
    public Collection<Company> getCompanyCollection() {
        return this.companyCollection;
    }

    /**
     * Sets the companyCollection of this Address to the specified value.
     * @param companyCollection the new companyCollection
     */
    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
    }

    /**
     * Gets the companyCollection1 of this Address.
     * @return the companyCollection1
     */
    public Collection<Company> getCompanyCollection1() {
        return this.companyCollection1;
    }

    /**
     * Sets the companyCollection1 of this Address to the specified value.
     * @param companyCollection1 the new companyCollection1
     */
    public void setCompanyCollection1(Collection<Company> companyCollection1) {
        this.companyCollection1 = companyCollection1;
    }

    /**
     * Gets the userCollection of this Address.
     * @return the userCollection
     */
    public Collection<User> getUserCollection() {
        return this.userCollection;
    }

    /**
     * Sets the userCollection of this Address to the specified value.
     * @param userCollection the new userCollection
     */
    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
     * Determines whether another object is equal to this Address.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Address object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address)object;
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
        return "com.abbt.timesheet.entities.Address[id=" + id + "]";
    }
    
}
