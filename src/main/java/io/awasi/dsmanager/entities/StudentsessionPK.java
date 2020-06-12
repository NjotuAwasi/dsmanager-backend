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
public class StudentsessionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users")
    private int users;
    @Basic(optional = false)
    @NotNull
    @Column(name = "student")
    private int student;
    @Basic(optional = false)
    @NotNull
    @Column(name = "session")
    private int session;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public StudentsessionPK() {
    }

    public StudentsessionPK(int users, int student, int session, int id) {
        this.users = users;
        this.student = student;
        this.session = session;
        this.id = id;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
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
        hash += (int) student;
        hash += (int) session;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentsessionPK)) {
            return false;
        }
        StudentsessionPK other = (StudentsessionPK) object;
        if (this.users != other.users) {
            return false;
        }
        if (this.student != other.student) {
            return false;
        }
        if (this.session != other.session) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.StudentsessionPK[ users=" + users + ", student=" + student + ", session=" + session + ", id=" + id + " ]";
    }
    
}
