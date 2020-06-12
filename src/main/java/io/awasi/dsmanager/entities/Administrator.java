/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.awasi.dsmanager.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a")
    , @NamedQuery(name = "Administrator.findByUsers", query = "SELECT a FROM Administrator a WHERE a.administratorPK.users = :users")
    , @NamedQuery(name = "Administrator.findById", query = "SELECT a FROM Administrator a WHERE a.administratorPK.id = :id")})
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministratorPK administratorPK;
    @OneToMany(mappedBy = "administrator")
    private List<Log> logList;
    @JsonIgnore
    @JoinColumn(name = "users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administrator")
    private List<Event> eventList;

    public Administrator() {
    }

    public Administrator(AdministratorPK administratorPK) {
        this.administratorPK = administratorPK;
    }

    public Administrator(int users, int id) {
        this.administratorPK = new AdministratorPK(users, id);
    }

    public AdministratorPK getAdministratorPK() {
        return administratorPK;
    }

    public void setAdministratorPK(AdministratorPK administratorPK) {
        this.administratorPK = administratorPK;
    }

    @XmlTransient
    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public Users getUsers1() {
        return users1;
    }

    public void setUsers1(Users users1) {
        this.users1 = users1;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administratorPK != null ? administratorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.administratorPK == null && other.administratorPK != null) || (this.administratorPK != null && !this.administratorPK.equals(other.administratorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Administrator[ administratorPK=" + administratorPK + " ]";
    }
    
}
