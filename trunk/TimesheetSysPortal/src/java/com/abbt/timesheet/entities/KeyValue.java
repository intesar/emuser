/*
 * KeyValue.java
 *
 * Created on May 7, 2007, 11:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.timesheet.entities;

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
 * Entity class KeyValue
 * 
 * @author shannan
 */
@Entity
@Table(name = "key_value")
@NamedQueries( {
        @NamedQuery(name = "KeyValue.findById", query = "SELECT k FROM KeyValue k WHERE k.id = :id"),
        @NamedQuery(name = "KeyValue.findByKey", query = "SELECT k FROM KeyValue k WHERE k.key = :key"),
        @NamedQuery(name = "KeyValue.findByValue", query = "SELECT k FROM KeyValue k WHERE k.value = :value"),
        @NamedQuery(name = "KeyValue.findByDescription", query = "SELECT k FROM KeyValue k WHERE k.description = :description"),
        @NamedQuery(name = "KeyValue.findBySortNumber", query = "SELECT k FROM KeyValue k WHERE k.sortNumber = :sortNumber"),
        @NamedQuery(name = "KeyValue.findByCreatedBy", query = "SELECT k FROM KeyValue k WHERE k.createdBy = :createdBy"),
        @NamedQuery(name = "KeyValue.findByCreatedDate", query = "SELECT k FROM KeyValue k WHERE k.createdDate = :createdDate"),
        @NamedQuery(name = "KeyValue.findByLastUpdatedBy", query = "SELECT k FROM KeyValue k WHERE k.lastUpdatedBy = :lastUpdatedBy"),
        @NamedQuery(name = "KeyValue.findByLastUpdateDate", query = "SELECT k FROM KeyValue k WHERE k.lastUpdateDate = :lastUpdateDate")
    })
public class KeyValue implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "key", nullable = false)
    private String key;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "sortNumber")
    private Integer sortNumber;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastUpdatedBy")
    private String lastUpdatedBy;

    @Column(name = "lastUpdateDate")
    @Temporal(TemporalType.DATE)
    private Date lastUpdateDate;
    
    /** Creates a new instance of KeyValue */
    public KeyValue() {
    }

    /**
     * Creates a new instance of KeyValue with the specified values.
     * @param id the id of the KeyValue
     */
    public KeyValue(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of KeyValue with the specified values.
     * @param id the id of the KeyValue
     * @param key the key of the KeyValue
     * @param value the value of the KeyValue
     */
    public KeyValue(Integer id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the id of this KeyValue.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this KeyValue to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the key of this KeyValue.
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Sets the key of this KeyValue to the specified value.
     * @param key the new key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the value of this KeyValue.
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Sets the value of this KeyValue to the specified value.
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the description of this KeyValue.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this KeyValue to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the sortNumber of this KeyValue.
     * @return the sortNumber
     */
    public Integer getSortNumber() {
        return this.sortNumber;
    }

    /**
     * Sets the sortNumber of this KeyValue to the specified value.
     * @param sortNumber the new sortNumber
     */
    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    /**
     * Gets the createdBy of this KeyValue.
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets the createdBy of this KeyValue to the specified value.
     * @param createdBy the new createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the createdDate of this KeyValue.
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets the createdDate of this KeyValue to the specified value.
     * @param createdDate the new createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the lastUpdatedBy of this KeyValue.
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * Sets the lastUpdatedBy of this KeyValue to the specified value.
     * @param lastUpdatedBy the new lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Gets the lastUpdateDate of this KeyValue.
     * @return the lastUpdateDate
     */
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    /**
     * Sets the lastUpdateDate of this KeyValue to the specified value.
     * @param lastUpdateDate the new lastUpdateDate
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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
     * Determines whether another object is equal to this KeyValue.  The result is 
     * <code>true</code> if and only if the argument is not null and is a KeyValue object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KeyValue)) {
            return false;
        }
        KeyValue other = (KeyValue)object;
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
        return "com.abbt.timesheet.entities.KeyValue[id=" + id + "]";
    }
    
}
