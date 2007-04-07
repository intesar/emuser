/*
 * Message.java
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
 * Entity class Message
 * 
 * @author Mohammed Hamed
 */
@Entity
@Table(name = "message")
@NamedQueries( {
        @NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id"),
        @NamedQuery(name = "Message.findByTo", query = "SELECT m FROM Message m WHERE m.to = :to"),
        @NamedQuery(name = "Message.findByFrom", query = "SELECT m FROM Message m WHERE m.from = :from"),
        @NamedQuery(name = "Message.findByMessage", query = "SELECT m FROM Message m WHERE m.message = :message"),
        @NamedQuery(name = "Message.findByCreationDate", query = "SELECT m FROM Message m WHERE m.creationDate = :creationDate")
    })
public class Message implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "to", nullable = false)
    private String to;

    @Column(name = "from", nullable = false)
    private String from;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    /** Creates a new instance of Message */
    public Message() {
    }

    /**
     * Creates a new instance of Message with the specified values.
     * @param id the id of the Message
     */
    public Message(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Message with the specified values.
     * @param id the id of the Message
     * @param to the to of the Message
     * @param from the from of the Message
     * @param message the message of the Message
     */
    public Message(Integer id, String to, String from, String message) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.message = message;
    }

    /**
     * Gets the id of this Message.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Message to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the to of this Message.
     * @return the to
     */
    public String getTo() {
        return this.to;
    }

    /**
     * Sets the to of this Message to the specified value.
     * @param to the new to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the from of this Message.
     * @return the from
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * Sets the from of this Message to the specified value.
     * @param from the new from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets the message of this Message.
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message of this Message to the specified value.
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the creationDate of this Message.
     * @return the creationDate
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the creationDate of this Message to the specified value.
     * @param creationDate the new creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
     * Determines whether another object is equal to this Message.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Message object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message)object;
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
        return "com.abbt.crm.base.entity.Message[id=" + id + "]";
    }
    
}
