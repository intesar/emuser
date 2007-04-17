/*
 * Instructor.java
 *
 * Created on April 16, 2007, 6:44 PM
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
 * Entity class Instructor
 * 
 * @author shannan
 */
@Entity
@Table(name = "instructor")
@NamedQueries( {
        @NamedQuery(name = "Instructor.findById", query = "SELECT i FROM Instructor i WHERE i.id = :id"),
        @NamedQuery(name = "Instructor.findByFirstname", query = "SELECT i FROM Instructor i WHERE i.firstname = :firstname"),
        @NamedQuery(name = "Instructor.findByLastname", query = "SELECT i FROM Instructor i WHERE i.lastname = :lastname"),
        @NamedQuery(name = "Instructor.findByEmail", query = "SELECT i FROM Instructor i WHERE i.email = :email"),
        @NamedQuery(name = "Instructor.findByPhone", query = "SELECT i FROM Instructor i WHERE i.phone = :phone"),
        @NamedQuery(name = "Instructor.findByMobile", query = "SELECT i FROM Instructor i WHERE i.mobile = :mobile"),
        @NamedQuery(name = "Instructor.findByQualification", query = "SELECT i FROM Instructor i WHERE i.qualification = :qualification"),
        @NamedQuery(name = "Instructor.findBySummary", query = "SELECT i FROM Instructor i WHERE i.summary = :summary")
    })
public class Instructor implements Serializable {

    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "qualification", nullable = false)
    private String qualification;

    @Column(name = "summary")
    private String summary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorEmail")
    private Collection<CourseOffered> courseOfferedCollection;

    /** Creates a new instance of Instructor */
    public Instructor() {
    }

    /**
     * Creates a new instance of Instructor with the specified values.
     * @param email the email of the Instructor
     */
    public Instructor(String email) {
        this.email = email;
    }

    /**
     * Creates a new instance of Instructor with the specified values.
     * @param email the email of the Instructor
     * @param firstname the firstname of the Instructor
     * @param lastname the lastname of the Instructor
     * @param qualification the qualification of the Instructor
     */
    public Instructor(String email, String firstname, String lastname, String qualification) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.qualification = qualification;
    }

    /**
     * Gets the id of this Instructor.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this Instructor to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the firstname of this Instructor.
     * @return the firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Sets the firstname of this Instructor to the specified value.
     * @param firstname the new firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the lastname of this Instructor.
     * @return the lastname
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Sets the lastname of this Instructor to the specified value.
     * @param lastname the new lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the email of this Instructor.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this Instructor to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone of this Instructor.
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets the phone of this Instructor to the specified value.
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the mobile of this Instructor.
     * @return the mobile
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile of this Instructor to the specified value.
     * @param mobile the new mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the qualification of this Instructor.
     * @return the qualification
     */
    public String getQualification() {
        return this.qualification;
    }

    /**
     * Sets the qualification of this Instructor to the specified value.
     * @param qualification the new qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Gets the summary of this Instructor.
     * @return the summary
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * Sets the summary of this Instructor to the specified value.
     * @param summary the new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the courseOfferedCollection of this Instructor.
     * @return the courseOfferedCollection
     */
    public Collection<CourseOffered> getCourseOfferedCollection() {
        return this.courseOfferedCollection;
    }

    /**
     * Sets the courseOfferedCollection of this Instructor to the specified value.
     * @param courseOfferedCollection the new courseOfferedCollection
     */
    public void setCourseOfferedCollection(Collection<CourseOffered> courseOfferedCollection) {
        this.courseOfferedCollection = courseOfferedCollection;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Instructor.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Instructor object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor)object;
        if (this.email != other.email && (this.email == null || !this.email.equals(other.email))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abbt.training.persistence.Instructor[email=" + email + "]";
    }

}
