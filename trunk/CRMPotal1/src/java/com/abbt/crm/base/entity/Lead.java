/*
 * Lead.java
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
 * Entity class Lead
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "lead")
@NamedQueries( {
        @NamedQuery(name = "Lead.findById", query = "SELECT l FROM Lead l WHERE l.id = :id"),
        @NamedQuery(name = "Lead.findByVersionId", query = "SELECT l FROM Lead l WHERE l.versionId = :versionId"),
        @NamedQuery(name = "Lead.findByFirstName", query = "SELECT l FROM Lead l WHERE l.firstName = :firstName"),
        @NamedQuery(name = "Lead.findByLastName", query = "SELECT l FROM Lead l WHERE l.lastName = :lastName"),
        @NamedQuery(name = "Lead.findByEmail", query = "SELECT l FROM Lead l WHERE l.email = :email"),
        @NamedQuery(name = "Lead.findByCompany", query = "SELECT l FROM Lead l WHERE l.company = :company"),
        @NamedQuery(name = "Lead.findByWebsite", query = "SELECT l FROM Lead l WHERE l.website = :website"),
        @NamedQuery(name = "Lead.findByDescription", query = "SELECT l FROM Lead l WHERE l.description = :description"),
        @NamedQuery(name = "Lead.findByTitle", query = "SELECT l FROM Lead l WHERE l.title = :title"),
        @NamedQuery(name = "Lead.findByCreationDate", query = "SELECT l FROM Lead l WHERE l.creationDate = :creationDate"),
        @NamedQuery(name = "Lead.findByCreatedUser", query = "SELECT l FROM Lead l WHERE l.createdUser = :createdUser"),
        @NamedQuery(name = "Lead.findByLastModifiedUser", query = "SELECT l FROM Lead l WHERE l.lastModifiedUser = :lastModifiedUser"),
        @NamedQuery(name = "Lead.findByLastModifiedDate", query = "SELECT l FROM Lead l WHERE l.lastModifiedDate = :lastModifiedDate"),
        @NamedQuery(name = "Lead.findByHomePhone", query = "SELECT l FROM Lead l WHERE l.homePhone = :homePhone"),
        @NamedQuery(name = "Lead.findByOfficePhone1", query = "SELECT l FROM Lead l WHERE l.officePhone1 = :officePhone1"),
        @NamedQuery(name = "Lead.findByOfficePhone2", query = "SELECT l FROM Lead l WHERE l.officePhone2 = :officePhone2"),
        @NamedQuery(name = "Lead.findByFax", query = "SELECT l FROM Lead l WHERE l.fax = :fax"),
        @NamedQuery(name = "Lead.findByOtherPhone", query = "SELECT l FROM Lead l WHERE l.otherPhone = :otherPhone"),
        @NamedQuery(name = "Lead.findByMobile", query = "SELECT l FROM Lead l WHERE l.mobile = :mobile"),
        @NamedQuery(name = "Lead.findByOfficeAddressLine1", query = "SELECT l FROM Lead l WHERE l.officeAddressLine1 = :officeAddressLine1"),
        @NamedQuery(name = "Lead.findByOfficeAddressLine2", query = "SELECT l FROM Lead l WHERE l.officeAddressLine2 = :officeAddressLine2"),
        @NamedQuery(name = "Lead.findByHomeAddressLine1", query = "SELECT l FROM Lead l WHERE l.homeAddressLine1 = :homeAddressLine1"),
        @NamedQuery(name = "Lead.findByHomeAddressLine2", query = "SELECT l FROM Lead l WHERE l.homeAddressLine2 = :homeAddressLine2")
    })
public class Lead implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "versionId", nullable = false)
    private int versionId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "title", nullable = false)
    private String title;

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

    @Column(name = "homePhone")
    private String homePhone;

    @Column(name = "officePhone1")
    private String officePhone1;

    @Column(name = "officePhone2")
    private String officePhone2;

    @Column(name = "fax")
    private String fax;

    @Column(name = "otherPhone")
    private String otherPhone;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "officeAddressLine1")
    private String officeAddressLine1;

    @Column(name = "officeAddressLine2")
    private String officeAddressLine2;

    @Column(name = "homeAddressLine1")
    private String homeAddressLine1;

    @Column(name = "homeAddressLine2")
    private String homeAddressLine2;
    
    /** Creates a new instance of Lead */
    public Lead() {
    }

    /**
     * Creates a new instance of Lead with the specified values.
     * @param id the id of the Lead
     */
    public Lead(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Lead with the specified values.
     * @param id the id of the Lead
     * @param versionId the versionId of the Lead
     * @param firstName the firstName of the Lead
     * @param lastName the lastName of the Lead
     * @param email the email of the Lead
     * @param company the company of the Lead
     * @param website the website of the Lead
     * @param description the description of the Lead
     * @param title the title of the Lead
     * @param createdUser the createdUser of the Lead
     * @param lastModifiedUser the lastModifiedUser of the Lead
     */
    public Lead(Integer id, int versionId, String firstName, String lastName, String email, String company, String website, String description, String title, String createdUser, String lastModifiedUser) {
        this.id = id;
        this.versionId = versionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.website = website;
        this.description = description;
        this.title = title;
        this.createdUser = createdUser;
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the id of this Lead.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Lead to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the versionId of this Lead.
     * @return the versionId
     */
    public int getVersionId() {
        return this.versionId;
    }

    /**
     * Sets the versionId of this Lead to the specified value.
     * @param versionId the new versionId
     */
    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Gets the firstName of this Lead.
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the firstName of this Lead to the specified value.
     * @param firstName the new firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the lastName of this Lead.
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the lastName of this Lead to the specified value.
     * @param lastName the new lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email of this Lead.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this Lead to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the company of this Lead.
     * @return the company
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * Sets the company of this Lead to the specified value.
     * @param company the new company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the website of this Lead.
     * @return the website
     */
    public String getWebsite() {
        return this.website;
    }

    /**
     * Sets the website of this Lead to the specified value.
     * @param website the new website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets the description of this Lead.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Lead to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the title of this Lead.
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of this Lead to the specified value.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the creationDate of this Lead.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Lead to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this Lead.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this Lead to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the lastModifiedUser of this Lead.
     * @return the lastModifiedUser
     */
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    /**
     * Sets the lastModifiedUser of this Lead to the specified value.
     * @param lastModifiedUser the new lastModifiedUser
     */
    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    /**
     * Gets the lastModifiedDate of this Lead.
     * @return the lastModifiedDate
     */
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Sets the lastModifiedDate of this Lead to the specified value.
     * @param lastModifiedDate the new lastModifiedDate
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the homePhone of this Lead.
     * @return the homePhone
     */
    public String getHomePhone() {
        return this.homePhone;
    }

    /**
     * Sets the homePhone of this Lead to the specified value.
     * @param homePhone the new homePhone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Gets the officePhone1 of this Lead.
     * @return the officePhone1
     */
    public String getOfficePhone1() {
        return this.officePhone1;
    }

    /**
     * Sets the officePhone1 of this Lead to the specified value.
     * @param officePhone1 the new officePhone1
     */
    public void setOfficePhone1(String officePhone1) {
        this.officePhone1 = officePhone1;
    }

    /**
     * Gets the officePhone2 of this Lead.
     * @return the officePhone2
     */
    public String getOfficePhone2() {
        return this.officePhone2;
    }

    /**
     * Sets the officePhone2 of this Lead to the specified value.
     * @param officePhone2 the new officePhone2
     */
    public void setOfficePhone2(String officePhone2) {
        this.officePhone2 = officePhone2;
    }

    /**
     * Gets the fax of this Lead.
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets the fax of this Lead to the specified value.
     * @param fax the new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the otherPhone of this Lead.
     * @return the otherPhone
     */
    public String getOtherPhone() {
        return this.otherPhone;
    }

    /**
     * Sets the otherPhone of this Lead to the specified value.
     * @param otherPhone the new otherPhone
     */
    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    /**
     * Gets the mobile of this Lead.
     * @return the mobile
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile of this Lead to the specified value.
     * @param mobile the new mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the officeAddressLine1 of this Lead.
     * @return the officeAddressLine1
     */
    public String getOfficeAddressLine1() {
        return this.officeAddressLine1;
    }

    /**
     * Sets the officeAddressLine1 of this Lead to the specified value.
     * @param officeAddressLine1 the new officeAddressLine1
     */
    public void setOfficeAddressLine1(String officeAddressLine1) {
        this.officeAddressLine1 = officeAddressLine1;
    }

    /**
     * Gets the officeAddressLine2 of this Lead.
     * @return the officeAddressLine2
     */
    public String getOfficeAddressLine2() {
        return this.officeAddressLine2;
    }

    /**
     * Sets the officeAddressLine2 of this Lead to the specified value.
     * @param officeAddressLine2 the new officeAddressLine2
     */
    public void setOfficeAddressLine2(String officeAddressLine2) {
        this.officeAddressLine2 = officeAddressLine2;
    }

    /**
     * Gets the homeAddressLine1 of this Lead.
     * @return the homeAddressLine1
     */
    public String getHomeAddressLine1() {
        return this.homeAddressLine1;
    }

    /**
     * Sets the homeAddressLine1 of this Lead to the specified value.
     * @param homeAddressLine1 the new homeAddressLine1
     */
    public void setHomeAddressLine1(String homeAddressLine1) {
        this.homeAddressLine1 = homeAddressLine1;
    }

    /**
     * Gets the homeAddressLine2 of this Lead.
     * @return the homeAddressLine2
     */
    public String getHomeAddressLine2() {
        return this.homeAddressLine2;
    }

    /**
     * Sets the homeAddressLine2 of this Lead to the specified value.
     * @param homeAddressLine2 the new homeAddressLine2
     */
    public void setHomeAddressLine2(String homeAddressLine2) {
        this.homeAddressLine2 = homeAddressLine2;
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
     * Determines whether another object is equal to this Lead.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Lead object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lead)) {
            return false;
        }
        Lead other = (Lead)object;
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
        return "com.abbt.crm.base.entity.Lead[id=" + id + "]";
    }
    
}
