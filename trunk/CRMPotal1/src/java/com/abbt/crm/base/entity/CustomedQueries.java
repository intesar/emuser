/*
 * CustomedQueries.java
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
 * Entity class CustomedQueries
 * 
 * @author shannan
 */
@Entity
@Table(name = "customed_queries")
@NamedQueries( {
        @NamedQuery(name = "CustomedQueries.findById", query = "SELECT c FROM CustomedQueries c WHERE c.id = :id"),
        @NamedQuery(name = "CustomedQueries.findByName", query = "SELECT c FROM CustomedQueries c WHERE c.name = :name"),
        @NamedQuery(name = "CustomedQueries.findByQuery", query = "SELECT c FROM CustomedQueries c WHERE c.query = :query"),
        @NamedQuery(name = "CustomedQueries.findByAscOrDesc", query = "SELECT c FROM CustomedQueries c WHERE c.ascOrDesc = :ascOrDesc"),
        @NamedQuery(name = "CustomedQueries.findByType", query = "SELECT c FROM CustomedQueries c WHERE c.type = :type"),
        @NamedQuery(name = "CustomedQueries.findByEnabled", query = "SELECT c FROM CustomedQueries c WHERE c.enabled = :enabled"),
        @NamedQuery(name = "CustomedQueries.findByDefault1", query = "SELECT c FROM CustomedQueries c WHERE c.default1 = :default1"),
        @NamedQuery(name = "CustomedQueries.findByParameterCount", query = "SELECT c FROM CustomedQueries c WHERE c.parameterCount = :parameterCount"),
        @NamedQuery(name = "CustomedQueries.findByCreatedUser", query = "SELECT c FROM CustomedQueries c WHERE c.createdUser = :createdUser"),
        @NamedQuery(name = "CustomedQueries.findByCreationDate", query = "SELECT c FROM CustomedQueries c WHERE c.creationDate = :creationDate"),
        @NamedQuery(name = "CustomedQueries.findByUsername", query = "SELECT c FROM CustomedQueries c WHERE c.username = :username"),
        @NamedQuery(name = "CustomedQueries.findByDisplayOrder", query = "SELECT c FROM CustomedQueries c WHERE c.displayOrder = :displayOrder")
    })
public class CustomedQueries implements Serializable {

    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "query", nullable = false)
    private String query;

    @Column(name = "ascOrDesc")
    private String ascOrDesc;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "enabled")
    private Short enabled;

    @Column(name = "default")
    private Short default1;

    @Column(name = "parameterCount")
    private Integer parameterCount;

    @Column(name = "createdUser")
    private String createdUser;

    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "username")
    private String username;

    @Column(name = "displayOrder", nullable = false)
    private int displayOrder;

    /** Creates a new instance of CustomedQueries */
    public CustomedQueries() {
    }

    /**
     * Creates a new instance of CustomedQueries with the specified values.
     * @param name the name of the CustomedQueries
     */
    public CustomedQueries(String name) {
        this.name = name;
    }

    /**
     * Creates a new instance of CustomedQueries with the specified values.
     * @param name the name of the CustomedQueries
     * @param query the query of the CustomedQueries
     * @param type the type of the CustomedQueries
     * @param creationDate the creationDate of the CustomedQueries
     * @param displayOrder the displayOrder of the CustomedQueries
     */
    public CustomedQueries(String name, String query, String type, Date creationDate, int displayOrder) {
        this.name = name;
        this.query = query;
        this.type = type;
        this.creationDate = creationDate;
        this.displayOrder = displayOrder;
    }

    /**
     * Gets the id of this CustomedQueries.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this CustomedQueries to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of this CustomedQueries.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this CustomedQueries to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the query of this CustomedQueries.
     * @return the query
     */
    public String getQuery() {
        return this.query;
    }

    /**
     * Sets the query of this CustomedQueries to the specified value.
     * @param query the new query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * Gets the ascOrDesc of this CustomedQueries.
     * @return the ascOrDesc
     */
    public String getAscOrDesc() {
        return this.ascOrDesc;
    }

    /**
     * Sets the ascOrDesc of this CustomedQueries to the specified value.
     * @param ascOrDesc the new ascOrDesc
     */
    public void setAscOrDesc(String ascOrDesc) {
        this.ascOrDesc = ascOrDesc;
    }

    /**
     * Gets the type of this CustomedQueries.
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of this CustomedQueries to the specified value.
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the enabled of this CustomedQueries.
     * @return the enabled
     */
    public Short getEnabled() {
        return this.enabled;
    }

    /**
     * Sets the enabled of this CustomedQueries to the specified value.
     * @param enabled the new enabled
     */
    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the default1 of this CustomedQueries.
     * @return the default1
     */
    public Short getDefault1() {
        return this.default1;
    }

    /**
     * Sets the default1 of this CustomedQueries to the specified value.
     * @param default1 the new default1
     */
    public void setDefault1(Short default1) {
        this.default1 = default1;
    }

    /**
     * Gets the parameterCount of this CustomedQueries.
     * @return the parameterCount
     */
    public Integer getParameterCount() {
        return this.parameterCount;
    }

    /**
     * Sets the parameterCount of this CustomedQueries to the specified value.
     * @param parameterCount the new parameterCount
     */
    public void setParameterCount(Integer parameterCount) {
        this.parameterCount = parameterCount;
    }

    /**
     * Gets the createdUser of this CustomedQueries.
     * @return the createdUser
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * Sets the createdUser of this CustomedQueries to the specified value.
     * @param createdUser the new createdUser
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Gets the creationDate of this CustomedQueries.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this CustomedQueries to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the username of this CustomedQueries.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this CustomedQueries to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the displayOrder of this CustomedQueries.
     * @return the displayOrder
     */
    public int getDisplayOrder() {
        return this.displayOrder;
    }

    /**
     * Sets the displayOrder of this CustomedQueries to the specified value.
     * @param displayOrder the new displayOrder
     */
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
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
     * Determines whether another object is equal to this CustomedQueries.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CustomedQueries object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomedQueries)) {
            return false;
        }
        CustomedQueries other = (CustomedQueries)object;
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
        return "com.abbt.crm.base.entity.CustomedQueries[name=" + name + "]";
    }

}
