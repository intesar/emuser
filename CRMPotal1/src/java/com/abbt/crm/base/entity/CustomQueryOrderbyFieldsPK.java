/*
 * CustomQueryOrderbyFieldsPK.java
 *
 * Created on April 14, 2007, 7:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.crm.base.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class CustomQueryOrderbyFieldsPK for entity class CustomQueryOrderbyFields
 * 
 * @author shannan
 */
@Embeddable
public class CustomQueryOrderbyFieldsPK implements Serializable {

    @Column(name = "queryName", nullable = false)
    private String queryName;

    @Column(name = "fieldName", nullable = false)
    private String fieldName;

    /** Creates a new instance of CustomQueryOrderbyFieldsPK */
    public CustomQueryOrderbyFieldsPK() {
    }

    /**
     * Creates a new instance of CustomQueryOrderbyFieldsPK with the specified values.
     * @param fieldName the fieldName of the CustomQueryOrderbyFieldsPK
     * @param queryName the queryName of the CustomQueryOrderbyFieldsPK
     */
    public CustomQueryOrderbyFieldsPK(String fieldName, String queryName) {
        this.fieldName = fieldName;
        this.queryName = queryName;
    }

    /**
     * Gets the queryName of this CustomQueryOrderbyFieldsPK.
     * @return the queryName
     */
    public String getQueryName() {
        return this.queryName;
    }

    /**
     * Sets the queryName of this CustomQueryOrderbyFieldsPK to the specified value.
     * @param queryName the new queryName
     */
    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    /**
     * Gets the fieldName of this CustomQueryOrderbyFieldsPK.
     * @return the fieldName
     */
    public String getFieldName() {
        return this.fieldName;
    }

    /**
     * Sets the fieldName of this CustomQueryOrderbyFieldsPK to the specified value.
     * @param fieldName the new fieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.fieldName != null ? this.fieldName.hashCode() : 0);
        hash += (this.queryName != null ? this.queryName.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this CustomQueryOrderbyFieldsPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CustomQueryOrderbyFieldsPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomQueryOrderbyFieldsPK)) {
            return false;
        }
        CustomQueryOrderbyFieldsPK other = (CustomQueryOrderbyFieldsPK)object;
        if (this.fieldName != other.fieldName && (this.fieldName == null || !this.fieldName.equals(other.fieldName))) return false;
        if (this.queryName != other.queryName && (this.queryName == null || !this.queryName.equals(other.queryName))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.crm.base.entity.CustomQueryOrderbyFieldsPK[fieldName=" + fieldName + ", queryName=" + queryName + "]";
    }

}
