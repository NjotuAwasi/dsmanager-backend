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
public class UsernotificationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "users")
    private int users;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notification")
    private int notification;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public UsernotificationPK() {
    }

    public UsernotificationPK(int users, int notification, int id) {
        this.users = users;
        this.notification = notification;
        this.id = id;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getNotification() {
        return notification;
    }

    public void setNotification(int notification) {
        this.notification = notification;
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
        hash += (int) notification;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsernotificationPK)) {
            return false;
        }
        UsernotificationPK other = (UsernotificationPK) object;
        if (this.users != other.users) {
            return false;
        }
        if (this.notification != other.notification) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.UsernotificationPK[ users=" + users + ", notification=" + notification + ", id=" + id + " ]";
    }
    
}
