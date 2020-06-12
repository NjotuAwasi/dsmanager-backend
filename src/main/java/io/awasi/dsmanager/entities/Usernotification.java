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
@Table(name = "usernotification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usernotification.findAll", query = "SELECT u FROM Usernotification u")
    , @NamedQuery(name = "Usernotification.findByUsers", query = "SELECT u FROM Usernotification u WHERE u.usernotificationPK.users = :users")
    , @NamedQuery(name = "Usernotification.findByNotification", query = "SELECT u FROM Usernotification u WHERE u.usernotificationPK.notification = :notification")
    , @NamedQuery(name = "Usernotification.findById", query = "SELECT u FROM Usernotification u WHERE u.usernotificationPK.id = :id")})
public class Usernotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsernotificationPK usernotificationPK;
    @JoinColumn(name = "notification", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Notification notification1;
    @JoinColumn(name = "users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;

    public Usernotification() {
    }

    public Usernotification(UsernotificationPK usernotificationPK) {
        this.usernotificationPK = usernotificationPK;
    }

    public Usernotification(int users, int notification, int id) {
        this.usernotificationPK = new UsernotificationPK(users, notification, id);
    }

    public UsernotificationPK getUsernotificationPK() {
        return usernotificationPK;
    }

    public void setUsernotificationPK(UsernotificationPK usernotificationPK) {
        this.usernotificationPK = usernotificationPK;
    }

    public Notification getNotification1() {
        return notification1;
    }

    public void setNotification1(Notification notification1) {
        this.notification1 = notification1;
    }

    public Users getUsers1() {
        return users1;
    }

    public void setUsers1(Users users1) {
        this.users1 = users1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usernotificationPK != null ? usernotificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usernotification)) {
            return false;
        }
        Usernotification other = (Usernotification) object;
        if ((this.usernotificationPK == null && other.usernotificationPK != null) || (this.usernotificationPK != null && !this.usernotificationPK.equals(other.usernotificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Usernotification[ usernotificationPK=" + usernotificationPK + " ]";
    }
    
}
