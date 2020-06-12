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
@Table(name = "roleprivilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roleprivilege.findAll", query = "SELECT r FROM Roleprivilege r")
    , @NamedQuery(name = "Roleprivilege.findByRole", query = "SELECT r FROM Roleprivilege r WHERE r.roleprivilegePK.role = :role")
    , @NamedQuery(name = "Roleprivilege.findByPrivilege", query = "SELECT r FROM Roleprivilege r WHERE r.roleprivilegePK.privilege = :privilege")
    , @NamedQuery(name = "Roleprivilege.findById", query = "SELECT r FROM Roleprivilege r WHERE r.roleprivilegePK.id = :id")})
public class Roleprivilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleprivilegePK roleprivilegePK;
    @JoinColumn(name = "privilege", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Privilege privilege1;
    @JoinColumn(name = "role", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role1;

    public Roleprivilege() {
    }

    public Roleprivilege(RoleprivilegePK roleprivilegePK) {
        this.roleprivilegePK = roleprivilegePK;
    }

    public Roleprivilege(int role, int privilege, int id) {
        this.roleprivilegePK = new RoleprivilegePK(role, privilege, id);
    }

    public RoleprivilegePK getRoleprivilegePK() {
        return roleprivilegePK;
    }

    public void setRoleprivilegePK(RoleprivilegePK roleprivilegePK) {
        this.roleprivilegePK = roleprivilegePK;
    }

    public Privilege getPrivilege1() {
        return privilege1;
    }

    public void setPrivilege1(Privilege privilege1) {
        this.privilege1 = privilege1;
    }

    public Role getRole1() {
        return role1;
    }

    public void setRole1(Role role1) {
        this.role1 = role1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleprivilegePK != null ? roleprivilegePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roleprivilege)) {
            return false;
        }
        Roleprivilege other = (Roleprivilege) object;
        if ((this.roleprivilegePK == null && other.roleprivilegePK != null) || (this.roleprivilegePK != null && !this.roleprivilegePK.equals(other.roleprivilegePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Roleprivilege[ roleprivilegePK=" + roleprivilegePK + " ]";
    }
    
}
