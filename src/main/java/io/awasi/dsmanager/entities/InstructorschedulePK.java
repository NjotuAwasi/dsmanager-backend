/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.awasi.dsmanager.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Embeddable
public class InstructorschedulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users")
    private int users;
    @Basic(optional = false)
    @NotNull
    @Column(name = "instructor")
    private int instructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "schedule")
    private int schedule;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public InstructorschedulePK() {
    }

    public InstructorschedulePK(int users, int instructor, int schedule, int id) {
        this.users = users;
        this.instructor = instructor;
        this.schedule = schedule;
        this.id = id;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) users;
        hash += (int) instructor;
        hash += (int) schedule;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstructorschedulePK)) {
            return false;
        }
        InstructorschedulePK other = (InstructorschedulePK) object;
        if (this.users != other.users) {
            return false;
        }
        if (this.instructor != other.instructor) {
            return false;
        }
        if (this.schedule != other.schedule) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.InstructorschedulePK[ users=" + users + ", instructor=" + instructor + ", schedule=" + schedule + ", id=" + id + " ]";
    }
    
}
