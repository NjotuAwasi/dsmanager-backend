/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.awasi.dsmanager.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByUsers", query = "SELECT s FROM Student s WHERE s.studentPK.users = :users")
    , @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.studentPK.id = :id")
    , @NamedQuery(name = "Student.findByIdnumber", query = "SELECT s FROM Student s WHERE s.idnumber = :idnumber")
    , @NamedQuery(name = "Student.findByStatus", query = "SELECT s FROM Student s WHERE s.status = :status")
    , @NamedQuery(name = "Student.findByResults", query = "SELECT s FROM Student s WHERE s.results = :results")
    , @NamedQuery(name = "Student.findByFeepaid", query = "SELECT s FROM Student s WHERE s.feepaid = :feepaid")
    , @NamedQuery(name = "Student.findByFee", query = "SELECT s FROM Student s WHERE s.fee = :fee")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentPK studentPK;
    @Column(name = "idnumber")
    private BigInteger idnumber;
    @Size(max = 30)
    @Column(name = "status")
    private String status;
    @Size(max = 30)
    @Column(name = "results")
    private String results;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "feepaid")
    private Double feepaid;
    @Column(name = "fee")
    private Double fee;
    @JoinColumn(name = "review", referencedColumnName = "id")
    @ManyToOne
    private Review review;
    @JoinColumn(name = "users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student1")
    private List<Studentschedule> studentscheduleList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student1")
    private List<Studentsession> studentsessionList;

    public Student() {
    }

    public Student(StudentPK studentPK) {
        this.studentPK = studentPK;
    }

    public Student(int users, int id) {
        this.studentPK = new StudentPK(users, id);
    }

    public StudentPK getStudentPK() {
        return studentPK;
    }

    public void setStudentPK(StudentPK studentPK) {
        this.studentPK = studentPK;
    }

    public BigInteger getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(BigInteger idnumber) {
        this.idnumber = idnumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Double getFeepaid() {
        return feepaid;
    }

    public void setFeepaid(Double feepaid) {
        this.feepaid = feepaid;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Users getUsers1() {
        return users1;
    }

    public void setUsers1(Users users1) {
        this.users1 = users1;
    }

    @XmlTransient
    public List<Studentschedule> getStudentscheduleList() {
        return studentscheduleList;
    }

    public void setStudentscheduleList(List<Studentschedule> studentscheduleList) {
        this.studentscheduleList = studentscheduleList;
    }

    @XmlTransient
    public List<Studentsession> getStudentsessionList() {
        return studentsessionList;
    }

    public void setStudentsessionList(List<Studentsession> studentsessionList) {
        this.studentsessionList = studentsessionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentPK != null ? studentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentPK == null && other.studentPK != null) || (this.studentPK != null && !this.studentPK.equals(other.studentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Student[ studentPK=" + studentPK + " ]";
    }
    
}
