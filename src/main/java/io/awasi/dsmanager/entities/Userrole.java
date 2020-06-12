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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "userrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userrole.findAll", query = "SELECT u FROM Userrole u")
    , @NamedQuery(name = "Userrole.findByUsers", query = "SELECT u FROM Userrole u WHERE u.userrolePK.users = :users")
    , @NamedQuery(name = "Userrole.findByRole", query = "SELECT u FROM Userrole u WHERE u.userrolePK.role = :role")
    , @NamedQuery(name = "Userrole.findById", query = "SELECT u FROM Userrole u WHERE u.userrolePK.id = :id")})
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserrolePK userrolePK;
    @JoinColumn(name = "role", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role1;
    @JoinColumn(name = "users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Users users1;

    public Userrole() {
    }

    public Userrole(UserrolePK userrolePK) {
        this.userrolePK = userrolePK;
    }

    public Userrole(int users, int role, int id) {
        this.userrolePK = new UserrolePK(users, role, id);
    }

    public UserrolePK getUserrolePK() {
        return userrolePK;
    }

    public void setUserrolePK(UserrolePK userrolePK) {
        this.userrolePK = userrolePK;
    }

    public Role getRole1() {
        return role1;
    }

    public void setRole1(Role role1) {
        this.role1 = role1;
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
        hash += (userrolePK != null ? userrolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userrole)) {
            return false;
        }
        Userrole other = (Userrole) object;
        if ((this.userrolePK == null && other.userrolePK != null) || (this.userrolePK != null && !this.userrolePK.equals(other.userrolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Userrole[ userrolePK=" + userrolePK + " ]";
    }
    
}
