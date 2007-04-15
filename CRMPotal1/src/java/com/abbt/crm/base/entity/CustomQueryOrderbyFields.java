/*
 * CustomQueryOrderbyFields.java
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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class CustomQueryOrderbyFields
 * 
 * @author shannan
 */
@Entity
@Table(name = "custom_query_orderby_fields")
@NamedQueries( {
        @NamedQuery(name = "CustomQueryOrderbyFields.findById", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.id = :id"),
        @NamedQuery(name = "CustomQueryOrderbyFields.findByQueryName", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.customQueryOrderbyFieldsPK.queryName = :queryName"),
        @NamedQuery(name = "CustomQueryOrderbyFields.findByFieldName", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.customQueryOrderbyFieldsPK.fieldName = :fieldName"),
        @NamedQuery(name = "CustomQueryOrderbyFields.findByIsDefault", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.isDefault = :isDefault"),
        @NamedQuery(name = "CustomQueryOrderbyFields.findByEnabled", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.enabled = :enabled"),
        @NamedQuery(name = "CustomQueryOrderbyFields.findByCreationDate", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.creationDate = :creationDate"),
        @NamedQuery(name = "CustomQueryOrderbyFields.findByCreatedUser", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.createdUser = :createdUser"),
        @NamedQuery(name = "CustomQueryOrderbyFields.findBySortBy", query = "SELECT c FROM CustomQueryOrderbyFields c WHERE c.sortBy = :sortBy")
    })
public class CustomQueryOrderbyFields implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected CustomQueryOrderbyFieldsPK customQueryOrderbyFieldsPK;

    @Column(name = "id")
    private Integer id;

    @Column(name = "isDefault")
    private Short isDefault;

    @Column(name = "enabled")
    private Short enabled;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "createdUser")
    private String createdUser;

    @Column(name = "sortBy", nullable = false)
    private int sortBy;

    /** Creates a new instance of CustomQueryOrderbyFields */
    public CustomQueryOrderbyFields() {
    }

    /**
     * Creates a new instance of CustomQueryOrderbyFields with the specified values.
     * @param customQueryOrderbyFieldsPK the customQueryOrderbyFieldsPK of the CustomQueryOrderbyFields
     */
    public CustomQueryOrderbyFields(CustomQueryOrderbyFieldsPK customQueryOrderbyFieldsPK) {
        this.customQueryOrderbyFieldsPK = customQueryOrderbyFieldsPK;
    }

    /**
     * Creates a new instance of CustomQueryOrderbyFields with the specified values.
     * @param customQueryOrderbyFieldsPK the customQueryOrderbyFieldsPK of the CustomQueryOrderbyFields
     * @param creationDate the creationDate of the CustomQueryOrderbyFields
     * @param sortBy the sortBy of the CustomQueryOrderbyFields
     */
    public CustomQueryOrderbyFields(CustomQueryOrderbyFieldsPK customQueryOrderbyFieldsPK, Date creationDate, int sortBy) {
        this.customQueryOrderbyFieldsPK = customQueryOrderbyFieldsPK;
        this.creationDate = creationDate;
        this.sortBy = sortBy;
    }

    /**
     * Creates a new instance of CustomQueryOrderbyFieldsPK with the specified values.
     * @param fieldName the fieldName of the CustomQueryOrderbyFieldsPK
     * @param queryName the queryName of the CustomQueryOrderbyFieldsPK
     */
    public CustomQueryOrderbyFields(String fieldName, String queryName) {
        this.customQueryOrderbyFieldsPK = new CustomQueryOrderbyFieldsPK(fieldName, queryName);
    }

    /**
     * Gets the customQueryOrderbyFieldsPK of this CustomQueryOrderbyFields.
     * @return the customQueryOrderbyFieldsPK
     */
    public CustomQueryOrderbyFieldsPK getCustomQueryOrderbyFieldsPK() {
        return this.customQueryOrderbyFieldsPK;
    }

    /**
     * Sets the customQueryOrderbyFieldsPK of this CustomQueryOrderbyFields to the specified value.
     * @param customQueryOrderbyFieldsPK the new customQueryOrderbyFieldsPK
     */
    public void setCustomQueryOrderbyFieldsPK(CustomQueryOrderbyFieldsPK customQueryOrderbyFieldsPK) {
        this.customQueryOrderbyFieldsPK = customQueryOrderbyFieldsPK;
    }

    /**
     * Gets the id of this CustomQueryOrderbyFields.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this CustomQueryOrderbyFields to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the isDefault of this CustomQueryOrderbyFields.
     * @return the isDefault
     */
    public Short getIsDefault() {
        return this.isDefault;
    }

    /**
     * Sets the isDefault of this CustomQueryOrderbyFields to the specified value.
     * @param isDefault the new isDefault
     */
    public void setIsDefault(Short isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * Gets the enabled of this CustomQueryOrderbyFields.
     * @return the enabled
     */
    public Short getEnabled() {
        return this.enabled;
    }

    /**
     * Sets the enabled of this CustomQueryOrderbyFields to the specified value.
     * @param enabled the new enabled
     */
    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the creationDate of this CustomQueryOrderbyFields.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this CustomQueryOrderbyFields to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the createdUser of this CustomQueryOrderbyFields.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this CustomQueryOrderbyFields to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the sortBy of this CustomQueryOrderbyFields.
     * @return the sortBy
     */
    public int getSortBy() {
        return this.sortBy;
    }

    /**
     * Sets the sortBy of this CustomQueryOrderbyFields to the specified value.
     * @param sortBy the new sortBy
     */
    public void setSortBy(int sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.customQueryOrderbyFieldsPK != null ? this.customQueryOrderbyFieldsPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this CustomQueryOrderbyFields.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CustomQueryOrderbyFields object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomQueryOrderbyFields)) {
            return false;
        }
        CustomQueryOrderbyFields other = (CustomQueryOrderbyFields)object;
        if (this.customQueryOrderbyFieldsPK != other.customQueryOrderbyFieldsPK && (this.customQueryOrderbyFieldsPK == null || !this.customQueryOrderbyFieldsPK.equals(other.customQueryOrderbyFieldsPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.crm.base.entity.CustomQueryOrderbyFields[customQueryOrderbyFieldsPK=" + customQueryOrderbyFieldsPK + "]";
    }

}
