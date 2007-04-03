/*
 * CompanyPhone.java
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
 * Entity class CompanyPhone
 * 
 * @author shannan
 */
@Entity
@Table(name = "company_phone")
@NamedQueries( {
        @NamedQuery(name = "CompanyPhone.findById", query = "SELECT c FROM CompanyPhone c WHERE c.id = :id"),
        @NamedQuery(name = "CompanyPhone.findByVersionId", query = "SELECT c FROM CompanyPhone c WHERE c.versionId = :versionId"),
        @NamedQuery(name = "CompanyPhone.findByFaxNo", query = "SELECT c FROM CompanyPhone c WHERE c.faxNo = :faxNo"),
        @NamedQuery(name = "CompanyPhone.findByPhoneNo", query = "SELECT c FROM CompanyPhone c WHERE c.phoneNo = :phoneNo"),
        @NamedQuery(name = "CompanyPhone.findByCompanyId", query = "SELECT c FROM CompanyPhone c WHERE c.companyId = :companyId"),
        @NamedQuery(name = "CompanyPhone.findByCreationDate", query = "SELECT c FROM CompanyPhone c WHERE c.creationDate = :creationDate"),
        @NamedQuery(name = "CompanyPhone.findByCreatedUser", query = "SELECT c FROM CompanyPhone c WHERE c.createdUser = :createdUser"),
        @NamedQuery(name = "CompanyPhone.findByLastModifiedUser", query = "SELECT c FROM CompanyPhone c WHERE c.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "CompanyPhone.findByLastModifiedDate", query = "SELECT c FROM CompanyPhone c WHERE c.lastModifiedDate = :lastModifiedDate")
    })
public class CompanyPhone implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "faxNo", nullable = false)
    private String faxNo;

    @Column(name = "phoneNo", nullable = false)
    private String phoneNo;

    @Column(name = "companyId", nullable = false)
    private int companyId;

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

    /** Creates a new instance of CompanyPhone */
    public CompanyPhone() {
    }

    /**
     * Creates a new instance of CompanyPhone with the specified values.
     * @param id the id of the CompanyPhone
     */
    public CompanyPhone(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of CompanyPhone with the specified values.
     * @param id the id of the CompanyPhone
     * @param versionId the versionId of the CompanyPhone
     * @param faxNo the faxNo of the CompanyPhone
     * @param phoneNo the phoneNo of the CompanyPhone
     * @param companyId the companyId of the CompanyPhone
     * @param creationDate the creationDate of the CompanyPhone
     * @param createdUser the createdUser of the CompanyPhone
     * @param lastModifiedUser the lastModifiedUser of the CompanyPhone
     * @param lastModifiedDate the lastModifiedDate of the CompanyPhone
     */
    public CompanyPhone(Integer id, int versionId, String faxNo, String phoneNo, int companyId, Date creationDate, String createdUser, String lastModifiedUser, Date lastModifiedDate) {
        this.id = id;
        this.versionId = versionId;
        this.faxNo = faxNo;
        this.phoneNo = phoneNo;
        this.companyId = companyId;
        this.creationDate = creationDate;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the id of this CompanyPhone.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this CompanyPhone to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this CompanyPhone.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this CompanyPhone to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the faxNo of this CompanyPhone.
     * @return the faxNo
     */
    public String getFaxNo() {
        return this.faxNo;
    }

    /**
     * Sets the faxNo of this CompanyPhone to the specified value.
     * @param faxNo the new faxNo
     */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * Gets the phoneNo of this CompanyPhone.
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return this.phoneNo;
    }

    /**
     * Sets the phoneNo of this CompanyPhone to the specified value.
     * @param phoneNo the new phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the companyId of this CompanyPhone.
     * @return the companyId
     */
    public int getCompanyId() {
        return this.companyId;
    }

    /**
     * Sets the companyId of this CompanyPhone to the specified value.
     * @param companyId the new companyId
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets the creationDate of this CompanyPhone.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this CompanyPhone to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this CompanyPhone.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this CompanyPhone to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this CompanyPhone.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this CompanyPhone to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this CompanyPhone.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this CompanyPhone to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
     * Determines whether another object is equal to this CompanyPhone.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CompanyPhone object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyPhone)) {
            return false;
        }
        CompanyPhone other = (CompanyPhone)object;
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
        return "com.abbt.crm.entity.CompanyPhone[id=" + id + "]";
    }

}
