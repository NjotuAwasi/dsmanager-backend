/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.awasi.dsmanager.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
    , @NamedQuery(name = "Notification.findById", query = "SELECT n FROM Notification n WHERE n.id = :id")
    , @NamedQuery(name = "Notification.findByMessage", query = "SELECT n FROM Notification n WHERE n.message = :message")
    , @NamedQuery(name = "Notification.findByDatecreated", query = "SELECT n FROM Notification n WHERE n.datecreated = :datecreated")
    , @NamedQuery(name = "Notification.findByRead", query = "SELECT n FROM Notification n WHERE n.read = :read")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "message")
    private String message;
    @Column(name = "datecreated")
    @Temporal(TemporalType.DATE)
    private Date datecreated;
    @Column(name = "read")
    private Boolean read;
    @JoinColumn(name = "school", referencedColumnName = "id")
    @ManyToOne
    private School school;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notification1")
    private List<Usernotification> usernotificationList;

    public Notification() {
    }

    public Notification(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @XmlTransient
    public List<Usernotification> getUsernotificationList() {
        return usernotificationList;
    }

    public void setUsernotificationList(List<Usernotification> usernotificationList) {
        this.usernotificationList = usernotificationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Notification[ id=" + id + " ]";
    }
    
}
