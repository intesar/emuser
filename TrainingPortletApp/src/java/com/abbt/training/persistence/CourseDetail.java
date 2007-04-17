/*
 * CourseDetail.java
 *
 * Created on April 16, 2007, 6:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class CourseDetail
 * 
 * @author shannan
 */
@Entity
@Table(name = "course_detail")
@NamedQueries( {
        @NamedQuery(name = "CourseDetail.findById", query = "SELECT c FROM CourseDetail c WHERE c.id = :id"),
        @NamedQuery(name = "CourseDetail.findByDetail", query = "SELECT c FROM CourseDetail c WHERE c.detail = :detail"),
        @NamedQuery(name = "CourseDetail.findByDuration", query = "SELECT c FROM CourseDetail c WHERE c.duration = :duration"),
        @NamedQuery(name = "CourseDetail.findBySummary", query = "SELECT c FROM CourseDetail c WHERE c.summary = :summary"),
        @NamedQuery(name = "CourseDetail.findByCourseName", query = "SELECT c FROM CourseDetail c WHERE c.courseName.name = :courseName")
    })
public class CourseDetail implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "summary")
    private String summary;

    @JoinColumn(name = "courseName", referencedColumnName = "name")
    @ManyToOne
    private Course courseName;

    /** Creates a new instance of CourseDetail */
    public CourseDetail() {
    }

    /**
     * Creates a new instance of CourseDetail with the specified values.
     * @param id the id of the CourseDetail
     */
    public CourseDetail(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of CourseDetail with the specified values.
     * @param id the id of the CourseDetail
     * @param detail the detail of the CourseDetail
     * @param duration the duration of the CourseDetail
     */
    public CourseDetail(Integer id, String detail, String duration) {
        this.id = id;
        this.detail = detail;
        this.duration = duration;
    }

    /**
     * Gets the id of this CourseDetail.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this CourseDetail to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the detail of this CourseDetail.
     * @return the detail
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * Sets the detail of this CourseDetail to the specified value.
     * @param detail the new detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * Gets the duration of this CourseDetail.
     * @return the duration
     */
    public String getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of this CourseDetail to the specified value.
     * @param duration the new duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets the summary of this CourseDetail.
     * @return the summary
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * Sets the summary of this CourseDetail to the specified value.
     * @param summary the new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the courseName of this CourseDetail.
     * @return the courseName
     */
    public Course getCourseName() {
        return this.courseName;
    }

    /**
     * Sets the courseName of this CourseDetail to the specified value.
     * @param courseName the new courseName
     */
    public void setCourseName(Course courseName) {
        this.courseName = courseName;
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
     * Determines whether another object is equal to this CourseDetail.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CourseDetail object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseDetail)) {
            return false;
        }
        CourseDetail other = (CourseDetail)object;
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
        return "com.abbt.training.persistence.CourseDetail[id=" + id + "]";
    }

}
