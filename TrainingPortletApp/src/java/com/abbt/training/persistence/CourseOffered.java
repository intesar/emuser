/*
 * CourseOffered.java
 *
 * Created on April 16, 2007, 6:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class CourseOffered
 * 
 * @author shannan
 */
@Entity
@Table(name = "course_offered")
@NamedQueries( {
        @NamedQuery(name = "CourseOffered.findById", query = "SELECT c FROM CourseOffered c WHERE c.id = :id"),
        @NamedQuery(name = "CourseOffered.findByLocation", query = "SELECT c FROM CourseOffered c WHERE c.location = :location"),
        @NamedQuery(name = "CourseOffered.findByStartDate", query = "SELECT c FROM CourseOffered c WHERE c.startDate = :startDate"),
        @NamedQuery(name = "CourseOffered.findByDuration", query = "SELECT c FROM CourseOffered c WHERE c.duration = :duration"),
        @NamedQuery(name = "CourseOffered.findBySummary", query = "SELECT c FROM CourseOffered c WHERE c.summary = :summary"),
        @NamedQuery(name = "CourseOffered.findAll", query = "SELECT c FROM CourseOffered c ORDER BY c.startDate")
    })
public class CourseOffered implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "location")
    private String location;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "duration")
    private String duration;

    @Column(name = "summary")
    private String summary;

    @JoinColumn(name = "courseName", referencedColumnName = "name")
    @ManyToOne
    private Course courseName;

    @JoinColumn(name = "instructorEmail", referencedColumnName = "email")
    @ManyToOne
    private Instructor instructorEmail;

    /** Creates a new instance of CourseOffered */
    public CourseOffered() {
    }

    /**
     * Creates a new instance of CourseOffered with the specified values.
     * @param id the id of the CourseOffered
     */
    public CourseOffered(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id of this CourseOffered.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this CourseOffered to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the location of this CourseOffered.
     * @return the location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location of this CourseOffered to the specified value.
     * @param location the new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the startDate of this CourseOffered.
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the startDate of this CourseOffered to the specified value.
     * @param startDate the new startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the duration of this CourseOffered.
     * @return the duration
     */
    public String getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of this CourseOffered to the specified value.
     * @param duration the new duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets the summary of this CourseOffered.
     * @return the summary
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * Sets the summary of this CourseOffered to the specified value.
     * @param summary the new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the courseName of this CourseOffered.
     * @return the courseName
     */
    public Course getCourseName() {
        return this.courseName;
    }

    /**
     * Sets the courseName of this CourseOffered to the specified value.
     * @param courseName the new courseName
     */
    public void setCourseName(Course courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the instructorEmail of this CourseOffered.
     * @return the instructorEmail
     */
    public Instructor getInstructorEmail() {
        return this.instructorEmail;
    }

    /**
     * Sets the instructorEmail of this CourseOffered to the specified value.
     * @param instructorEmail the new instructorEmail
     */
    public void setInstructorEmail(Instructor instructorEmail) {
        this.instructorEmail = instructorEmail;
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
     * Determines whether another object is equal to this CourseOffered.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CourseOffered object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseOffered)) {
            return false;
        }
        CourseOffered other = (CourseOffered)object;
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
        return "com.abbt.training.persistence.CourseOffered[id=" + id + "]";
    }

}
