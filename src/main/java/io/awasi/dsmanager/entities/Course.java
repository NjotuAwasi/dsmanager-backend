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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
    , @NamedQuery(name = "Course.findByType", query = "SELECT c FROM Course c WHERE c.type = :type")
    , @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")
    , @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description")
    , @NamedQuery(name = "Course.findByDatecreated", query = "SELECT c FROM Course c WHERE c.datecreated = :datecreated")
    , @NamedQuery(name = "Course.findByDatemodified", query = "SELECT c FROM Course c WHERE c.datemodified = :datemodified")
    , @NamedQuery(name = "Course.findByPicture", query = "SELECT c FROM Course c WHERE c.picture = :picture")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "type")
    private String type;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Column(name = "datecreated")
    @Temporal(TemporalType.DATE)
    private Date datecreated;
    @Column(name = "datemodified")
    @Temporal(TemporalType.DATE)
    private Date datemodified;
    @Size(max = 254)
    @Column(name = "picture")
    private String picture;
    @JoinColumn(name = "school", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private School school;
    @JoinColumn(name = "users", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users users1;

   

	public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(Date datemodified) {
        this.datemodified = datemodified;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Course[ id=" + id + " ]";
    }
    
}
