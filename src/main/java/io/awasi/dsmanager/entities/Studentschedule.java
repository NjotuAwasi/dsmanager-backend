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
@Table(name = "studentschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentschedule.findAll", query = "SELECT s FROM Studentschedule s")
    , @NamedQuery(name = "Studentschedule.findByUsers", query = "SELECT s FROM Studentschedule s WHERE s.studentschedulePK.users = :users")
    , @NamedQuery(name = "Studentschedule.findByStudent", query = "SELECT s FROM Studentschedule s WHERE s.studentschedulePK.student = :student")
    , @NamedQuery(name = "Studentschedule.findBySchedule", query = "SELECT s FROM Studentschedule s WHERE s.studentschedulePK.schedule = :schedule")
    , @NamedQuery(name = "Studentschedule.findById", query = "SELECT s FROM Studentschedule s WHERE s.studentschedulePK.id = :id")})
public class Studentschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentschedulePK studentschedulePK;
    @JoinColumn(name = "schedule", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Schedule schedule1;
    @JoinColumns({
        @JoinColumn(name = "users", referencedColumnName = "users", insertable = false, updatable = false)
        , @JoinColumn(name = "student", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Student student1;

    public Studentschedule() {
    }

    public Studentschedule(StudentschedulePK studentschedulePK) {
        this.studentschedulePK = studentschedulePK;
    }

    public Studentschedule(int users, int student, int schedule, int id) {
        this.studentschedulePK = new StudentschedulePK(users, student, schedule, id);
    }

    public StudentschedulePK getStudentschedulePK() {
        return studentschedulePK;
    }

    public void setStudentschedulePK(StudentschedulePK studentschedulePK) {
        this.studentschedulePK = studentschedulePK;
    }

    public Schedule getSchedule1() {
        return schedule1;
    }

    public void setSchedule1(Schedule schedule1) {
        this.schedule1 = schedule1;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentschedulePK != null ? studentschedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentschedule)) {
            return false;
        }
        Studentschedule other = (Studentschedule) object;
        if ((this.studentschedulePK == null && other.studentschedulePK != null) || (this.studentschedulePK != null && !this.studentschedulePK.equals(other.studentschedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Studentschedule[ studentschedulePK=" + studentschedulePK + " ]";
    }
    
}
