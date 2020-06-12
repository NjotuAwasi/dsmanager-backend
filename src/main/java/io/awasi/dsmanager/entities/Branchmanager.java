/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.awasi.dsmanager.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "branchmanager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branchmanager.findAll", query = "SELECT b FROM Branchmanager b")
    , @NamedQuery(name = "Branchmanager.findByUsers", query = "SELECT b FROM Branchmanager b WHERE b.branchmanagerPK.users = :users")
    , @NamedQuery(name = "Branchmanager.findById", query = "SELECT b FROM Branchmanager b WHERE b.branchmanagerPK.id = :id")})
public class Branchmanager implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BranchmanagerPK branchmanagerPK;
    @JoinColumn(name = "branch", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Branch branch;
    @JoinColumn(name = "users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;

    public Branchmanager() {
    }

    public Branchmanager(BranchmanagerPK branchmanagerPK) {
        this.branchmanagerPK = branchmanagerPK;
    }

    public Branchmanager(int users, int id) {
        this.branchmanagerPK = new BranchmanagerPK(users, id);
    }

    public BranchmanagerPK getBranchmanagerPK() {
        return branchmanagerPK;
    }

    public void setBranchmanagerPK(BranchmanagerPK branchmanagerPK) {
        this.branchmanagerPK = branchmanagerPK;
    }


    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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
        hash += (branchmanagerPK != null ? branchmanagerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branchmanager)) {
            return false;
        }
        Branchmanager other = (Branchmanager) object;
        if ((this.branchmanagerPK == null && other.branchmanagerPK != null) || (this.branchmanagerPK != null && !this.branchmanagerPK.equals(other.branchmanagerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Branchmanager[ branchmanagerPK=" + branchmanagerPK + " ]";
    }
    
}
