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
@Table(name = "schooladministrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schooladministrator.findAll", query = "SELECT s FROM Schooladministrator s")
    , @NamedQuery(name = "Schooladministrator.findByUsers", query = "SELECT s FROM Schooladministrator s WHERE s.schooladministratorPK.users = :users")
    , @NamedQuery(name = "Schooladministrator.findBySchool", query = "SELECT s FROM Schooladministrator s WHERE s.schooladministratorPK.school = :school")
    , @NamedQuery(name = "Schooladministrator.findById", query = "SELECT s FROM Schooladministrator s WHERE s.schooladministratorPK.id = :id")})
public class Schooladministrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchooladministratorPK schooladministratorPK;
    @JoinColumn(name = "users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;

    public Schooladministrator() {
    }

    public Schooladministrator(SchooladministratorPK schooladministratorPK) {
        this.schooladministratorPK = schooladministratorPK;
    }

    public Schooladministrator(int users, int school, int id) {
        this.schooladministratorPK = new SchooladministratorPK(users, school, id);
    }

    public SchooladministratorPK getSchooladministratorPK() {
        return schooladministratorPK;
    }

    public void setSchooladministratorPK(SchooladministratorPK schooladministratorPK) {
        this.schooladministratorPK = schooladministratorPK;
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
        hash += (schooladministratorPK != null ? schooladministratorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schooladministrator)) {
            return false;
        }
        Schooladministrator other = (Schooladministrator) object;
        if ((this.schooladministratorPK == null && other.schooladministratorPK != null) || (this.schooladministratorPK != null && !this.schooladministratorPK.equals(other.schooladministratorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Schooladministrator[ schooladministratorPK=" + schooladministratorPK + " ]";
    }
    
}
