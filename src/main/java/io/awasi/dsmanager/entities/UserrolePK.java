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
public class UserrolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users")
    private int users;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    private int role;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public UserrolePK() {
    }

    public UserrolePK(int users, int role, int id) {
        this.users = users;
        this.role = role;
        this.id = id;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
        hash += (int) role;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserrolePK)) {
            return false;
        }
        UserrolePK other = (UserrolePK) object;
        if (this.users != other.users) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.UserrolePK[ users=" + users + ", role=" + role + ", id=" + id + " ]";
    }
    
}
