/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.awasi.dsmanager.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "schoollog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schoollog.findAll", query = "SELECT s FROM Schoollog s")
    , @NamedQuery(name = "Schoollog.findById", query = "SELECT s FROM Schoollog s WHERE s.id = :id")
    , @NamedQuery(name = "Schoollog.findByDatecreated", query = "SELECT s FROM Schoollog s WHERE s.datecreated = :datecreated")
    , @NamedQuery(name = "Schoollog.findByMessage", query = "SELECT s FROM Schoollog s WHERE s.message = :message")})
public class Schoollog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datecreated")
    @Temporal(TemporalType.DATE)
    private Date datecreated;
    @Size(max = 254)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "school", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private School school;

    public Schoollog() {
    }

    public Schoollog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
        if (!(object instanceof Schoollog)) {
            return false;
        }
        Schoollog other = (Schoollog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Schoollog[ id=" + id + " ]";
    }
    
}
