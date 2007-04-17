/*
 * Course.java
 *
 * Created on April 16, 2007, 6:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbt.training.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class Course
 * 
 * @author shannan
 */
@Entity
@Table(name = "course")
@NamedQueries( {
        @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
        @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
        @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description")
    })
public class Course implements Serializable {

    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseName")
    private Collection<CourseOffered> courseOfferedCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseName")
    private Collection<CourseDetail> courseDetailCollection;

    /** Creates a new instance of Course */
    public Course() {
    }

    /**
     * Creates a new instance of Course with the specified values.
     * @param name the name of the Course
     */
    public Course(String name) {
        this.name = name;
    }

    /**
     * Gets the id of this Course.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Course to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of this Course.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this Course to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this Course.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Course to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the courseOfferedCollection of this Course.
     * @return the courseOfferedCollection
     */
    public Collection<CourseOffered> getCourseOfferedCollection() {
        return this.courseOfferedCollection;
    }

    /**
     * Sets the courseOfferedCollection of this Course to the specified value.
     * @param courseOfferedCollection the new courseOfferedCollection
     */
    public void setCourseOfferedCollection(Collection<CourseOffered> courseOfferedCollection) {
        this.courseOfferedCollection = courseOfferedCollection;
    }

    /**
     * Gets the courseDetailCollection of this Course.
     * @return the courseDetailCollection
     */
    public Collection<CourseDetail> getCourseDetailCollection() {
        return this.courseDetailCollection;
    }

    /**
     * Sets the courseDetailCollection of this Course to the specified value.
     * @param courseDetailCollection the new courseDetailCollection
     */
    public void setCourseDetailCollection(Collection<CourseDetail> courseDetailCollection) {
        this.courseDetailCollection = courseDetailCollection;
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
     * Determines whether another object is equal to this Course.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Course object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course)object;
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
        return "com.abbt.training.persistence.Course[name=" + name + "]";
    }

}
