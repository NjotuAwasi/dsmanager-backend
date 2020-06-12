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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id")
    , @NamedQuery(name = "Schedule.findByStartdate", query = "SELECT s FROM Schedule s WHERE s.startdate = :startdate")
    , @NamedQuery(name = "Schedule.findByEnddate", query = "SELECT s FROM Schedule s WHERE s.enddate = :enddate")
    , @NamedQuery(name = "Schedule.findByStatus", query = "SELECT s FROM Schedule s WHERE s.status = :status")
    , @NamedQuery(name = "Schedule.findByClass1", query = "SELECT s FROM Schedule s WHERE s.class1 = :class1")
    , @NamedQuery(name = "Schedule.findByLocation", query = "SELECT s FROM Schedule s WHERE s.location = :location")
    , @NamedQuery(name = "Schedule.findByIsallday", query = "SELECT s FROM Schedule s WHERE s.isallday = :isallday")
    , @NamedQuery(name = "Schedule.findBySubject", query = "SELECT s FROM Schedule s WHERE s.subject = :subject")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Size(max = 30)
    @Column(name = "status")
    private String status;
    @Size(max = 30)
    @Column(name = "class")
    private String class1;
    @Size(max = 100)
    @Column(name = "location")
    private String location;
    @Column(name = "isallday")
    private Boolean isallday;
    @Size(max = 50)
    @Column(name = "subject")
    private String subject;
    @Column(name = "recurrencerule")
    private String recurrencerule;
    @Column(name = "description")
    private String description;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule1")
    private List<Instructorschedule> instructorscheduleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule1")
    private List<Studentschedule> studentscheduleList;
    @JoinColumn(name = "school", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne
    private School school;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsallday() {
        return isallday;
    }

    public void setIsallday(Boolean isallday) {
        this.isallday = isallday;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @XmlTransient
    public List<Instructorschedule> getInstructorscheduleList() {
        return instructorscheduleList;
    }

    public void setInstructorscheduleList(List<Instructorschedule> instructorscheduleList) {
        this.instructorscheduleList = instructorscheduleList;
    }

    @XmlTransient
    public List<Studentschedule> getStudentscheduleList() {
        return studentscheduleList;
    }

    public void setStudentscheduleList(List<Studentschedule> studentscheduleList) {
        this.studentscheduleList = studentscheduleList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRecurrencerule() {
		return recurrencerule;
	}

	public void setRecurrencerule(String recurrencerule) {
		this.recurrencerule = recurrencerule;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Schedule[ id=" + id + " ]";
    }
    
}
