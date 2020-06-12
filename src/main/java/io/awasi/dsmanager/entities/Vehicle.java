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
import javax.persistence.JoinColumns;
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
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id")
    , @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model")
    , @NamedQuery(name = "Vehicle.findByType", query = "SELECT v FROM Vehicle v WHERE v.type = :type")
    , @NamedQuery(name = "Vehicle.findByBrand", query = "SELECT v FROM Vehicle v WHERE v.brand = :brand")
    , @NamedQuery(name = "Vehicle.findByDatecreated", query = "SELECT v FROM Vehicle v WHERE v.datecreated = :datecreated")
    , @NamedQuery(name = "Vehicle.findByDatemodified", query = "SELECT v FROM Vehicle v WHERE v.datemodified = :datemodified")
    , @NamedQuery(name = "Vehicle.findByPicture", query = "SELECT v FROM Vehicle v WHERE v.picture = :picture")
    , @NamedQuery(name = "Vehicle.findByPlate", query = "SELECT v FROM Vehicle v WHERE v.plate = :plate")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "model")
    private String model;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Size(max = 50)
    @Column(name = "brand")
    private String brand;
    @Column(name = "datecreated")
    @Temporal(TemporalType.DATE)
    private Date datecreated;
    @Column(name = "datemodified")
    @Temporal(TemporalType.DATE)
    private Date datemodified;
    @Size(max = 254)
    @Column(name = "picture")
    private String picture;
    @Size(max = 50)
    @Column(name = "plate")
    private String plate;
    @JoinColumns({
        @JoinColumn(name = "users", referencedColumnName = "users")
        , @JoinColumn(name = "instructor", referencedColumnName = "id")})
    @ManyToOne
    private Instructor instructor;
    @JoinColumn(name = "school", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private School school;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Vehicle[ id=" + id + " ]";
    }
    
}
