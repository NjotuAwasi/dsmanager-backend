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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s")
    , @NamedQuery(name = "School.findById", query = "SELECT s FROM School s WHERE s.id = :id")
    , @NamedQuery(name = "School.findByEmail", query = "SELECT s FROM School s WHERE s.email = :email")
    , @NamedQuery(name = "School.findByDescription", query = "SELECT s FROM School s WHERE s.description = :description")
    , @NamedQuery(name = "School.findByPicture", query = "SELECT s FROM School s WHERE s.picture = :picture")
    , @NamedQuery(name = "School.findByDatecreated", query = "SELECT s FROM School s WHERE s.datecreated = :datecreated")
    , @NamedQuery(name = "School.findByDatemodified", query = "SELECT s FROM School s WHERE s.datemodified = :datemodified")
    , @NamedQuery(name = "School.findByCity", query = "SELECT s FROM School s WHERE s.city = :city")
    , @NamedQuery(name = "School.findByLocation", query = "SELECT s FROM School s WHERE s.location = :location")
    , @NamedQuery(name = "School.findByStatus", query = "SELECT s FROM School s WHERE s.status = :status")
    , @NamedQuery(name = "School.findByName", query = "SELECT s FROM School s WHERE s.name = :name")
    , @NamedQuery(name = "School.findByPhone", query = "SELECT s FROM School s WHERE s.phone = :phone")})
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Size(max = 254)
    @Column(name = "picture")
    private String picture;
    @Column(name = "datecreated")
    @Temporal(TemporalType.DATE)
    private Date datecreated;
    @Column(name = "datemodified")
    @Temporal(TemporalType.DATE)
    private Date datemodified;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "location")
    private String location;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "phone")
    private String phone;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Schoollog> schoollogList;
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Branch> branchList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Vehicle> vehicleList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Session> sessionList;
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Notification> notificationList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Review> reviewList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Course> courseList;
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Message> messageList;
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Users> usersList;
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Schedule> scheduleList;

    public School() {
    }

    public School(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public List<Schoollog> getSchoollogList() {
        return schoollogList;
    }

    public void setSchoollogList(List<Schoollog> schoollogList) {
        this.schoollogList = schoollogList;
    }

    @XmlTransient
    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    @XmlTransient
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @XmlTransient
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
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
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.School[ id=" + id + " ]";
    }
    
}
