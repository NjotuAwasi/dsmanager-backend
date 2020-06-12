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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Users.findByDatecreated", query = "SELECT u FROM Users u WHERE u.datecreated = :datecreated")
    , @NamedQuery(name = "Users.findByDatemodified", query = "SELECT u FROM Users u WHERE u.datemodified = :datemodified")
    , @NamedQuery(name = "Users.findByPicture", query = "SELECT u FROM Users u WHERE u.picture = :picture")
    , @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone")
    , @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender")
    , @NamedQuery(name = "Users.findByBirthdate", query = "SELECT u FROM Users u WHERE u.birthdate = :birthdate")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "datecreated")
    @Temporal(TemporalType.DATE)
    private Date datecreated;
    @Column(name = "datemodified")
    @Temporal(TemporalType.DATE)
    private Date datemodified;
    @Size(max = 254)
    @Column(name = "picture")
    private String picture;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "phone")
    private String phone;
    @Size(max = 30)
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "login")
    private String login;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Student> studentList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Schooladministrator> schooladministratorList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Administrator> administratorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Userrole> userroleList;
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Message> messageList;
    @JoinColumn(name = "branch", referencedColumnName = "id")
    @ManyToOne
    private Branch branch;
    @JoinColumn(name = "school", referencedColumnName = "id")
    @ManyToOne
    private School school;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Instructor> instructorList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Usernotification> usernotificationList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Branchmanager> branchmanagerList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private List<Course> courseList;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlTransient
    public List<Schooladministrator> getSchooladministratorList() {
        return schooladministratorList;
    }

    public void setSchooladministratorList(List<Schooladministrator> schooladministratorList) {
        this.schooladministratorList = schooladministratorList;
    }

    @XmlTransient
    public List<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<Administrator> administratorList) {
        this.administratorList = administratorList;
    }

    @XmlTransient
    public List<Userrole> getUserroleList() {
        return userroleList;
    }

    public void setUserroleList(List<Userrole> userroleList) {
        this.userroleList = userroleList;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

 
    public School getSchool() {
        return school;
    }


    public void setSchool(School school) {
        this.school = school;
    }

    @XmlTransient
    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    @XmlTransient
    public List<Usernotification> getUsernotificationList() {
        return usernotificationList;
    }

    public void setUsernotificationList(List<Usernotification> usernotificationList) {
        this.usernotificationList = usernotificationList;
    }

    @XmlTransient
    public List<Branchmanager> getBranchmanagerList() {
        return branchmanagerList;
    }

    public void setBranchmanagerList(List<Branchmanager> branchmanagerList) {
        this.branchmanagerList = branchmanagerList;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Users[ id=" + id + " ]";
    }

}
