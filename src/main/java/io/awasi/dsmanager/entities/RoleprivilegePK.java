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
public class RoleprivilegePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    private int role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "privilege")
    private int privilege;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public RoleprivilegePK() {
    }

    public RoleprivilegePK(int role, int privilege, int id) {
        this.role = role;
        this.privilege = privilege;
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
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
        hash += (int) role;
        hash += (int) privilege;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleprivilegePK)) {
            return false;
        }
        RoleprivilegePK other = (RoleprivilegePK) object;
        if (this.role != other.role) {
            return false;
        }
        if (this.privilege != other.privilege) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.RoleprivilegePK[ role=" + role + ", privilege=" + privilege + ", id=" + id + " ]";
    }
    
}
