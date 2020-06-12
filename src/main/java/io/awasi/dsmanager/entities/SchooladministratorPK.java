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
public class SchooladministratorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users")
    private int users;
    @Basic(optional = false)
    @NotNull
    @Column(name = "school")
    private int school;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public SchooladministratorPK() {
    }

    public SchooladministratorPK(int users, int school, int id) {
        this.users = users;
        this.school = school;
        this.id = id;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
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
        hash += (int) school;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchooladministratorPK)) {
            return false;
        }
        SchooladministratorPK other = (SchooladministratorPK) object;
        if (this.users != other.users) {
            return false;
        }
        if (this.school != other.school) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.SchooladministratorPK[ users=" + users + ", school=" + school + ", id=" + id + " ]";
    }
    
}
