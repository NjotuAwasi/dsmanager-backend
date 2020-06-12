/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.awasi.dsmanager.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "instructorschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructorschedule.findAll", query = "SELECT i FROM Instructorschedule i")
    , @NamedQuery(name = "Instructorschedule.findByUsers", query = "SELECT i FROM Instructorschedule i WHERE i.instructorschedulePK.users = :users")
    , @NamedQuery(name = "Instructorschedule.findByInstructor", query = "SELECT i FROM Instructorschedule i WHERE i.instructorschedulePK.instructor = :instructor")
    , @NamedQuery(name = "Instructorschedule.findBySchedule", query = "SELECT i FROM Instructorschedule i WHERE i.instructorschedulePK.schedule = :schedule")
    , @NamedQuery(name = "Instructorschedule.findById", query = "SELECT i FROM Instructorschedule i WHERE i.instructorschedulePK.id = :id")})
public class Instructorschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstructorschedulePK instructorschedulePK;
    @JoinColumns({
        @JoinColumn(name = "users", referencedColumnName = "users", insertable = false, updatable = false)
        , @JoinColumn(name = "instructor", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Instructor instructor1;
    @JoinColumn(name = "schedule", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Schedule schedule1;

    public Instructorschedule() {
    }

    public Instructorschedule(InstructorschedulePK instructorschedulePK) {
        this.instructorschedulePK = instructorschedulePK;
    }

    public Instructorschedule(int users, int instructor, int schedule, int id) {
        this.instructorschedulePK = new InstructorschedulePK(users, instructor, schedule, id);
    }

    public InstructorschedulePK getInstructorschedulePK() {
        return instructorschedulePK;
    }

    public void setInstructorschedulePK(InstructorschedulePK instructorschedulePK) {
        this.instructorschedulePK = instructorschedulePK;
    }

    public Instructor getInstructor1() {
        return instructor1;
    }

    public void setInstructor1(Instructor instructor1) {
        this.instructor1 = instructor1;
    }

    public Schedule getSchedule1() {
        return schedule1;
    }

    public void setSchedule1(Schedule schedule1) {
        this.schedule1 = schedule1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorschedulePK != null ? instructorschedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructorschedule)) {
            return false;
        }
        Instructorschedule other = (Instructorschedule) object;
        if ((this.instructorschedulePK == null && other.instructorschedulePK != null) || (this.instructorschedulePK != null && !this.instructorschedulePK.equals(other.instructorschedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Instructorschedule[ instructorschedulePK=" + instructorschedulePK + " ]";
    }
    
}
