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
import javax.persistence.JoinColumns;
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
@Table(name = "studentsession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentsession.findAll", query = "SELECT s FROM Studentsession s")
    , @NamedQuery(name = "Studentsession.findByUsers", query = "SELECT s FROM Studentsession s WHERE s.studentsessionPK.users = :users")
    , @NamedQuery(name = "Studentsession.findByStudent", query = "SELECT s FROM Studentsession s WHERE s.studentsessionPK.student = :student")
    , @NamedQuery(name = "Studentsession.findBySession", query = "SELECT s FROM Studentsession s WHERE s.studentsessionPK.session = :session")
    , @NamedQuery(name = "Studentsession.findById", query = "SELECT s FROM Studentsession s WHERE s.studentsessionPK.id = :id")})
public class Studentsession implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentsessionPK studentsessionPK;
    @JoinColumn(name = "session", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Session session1;
    @JoinColumns({
        @JoinColumn(name = "users", referencedColumnName = "users", insertable = false, updatable = false)
        , @JoinColumn(name = "student", referencedColumnName = "id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Student student1;

    public Studentsession() {
    }

    public Studentsession(StudentsessionPK studentsessionPK) {
        this.studentsessionPK = studentsessionPK;
    }

    public Studentsession(int users, int student, int session, int id) {
        this.studentsessionPK = new StudentsessionPK(users, student, session, id);
    }

    public StudentsessionPK getStudentsessionPK() {
        return studentsessionPK;
    }

    public void setStudentsessionPK(StudentsessionPK studentsessionPK) {
        this.studentsessionPK = studentsessionPK;
    }

    public Session getSession1() {
        return session1;
    }

    public void setSession1(Session session1) {
        this.session1 = session1;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentsessionPK != null ? studentsessionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentsession)) {
            return false;
        }
        Studentsession other = (Studentsession) object;
        if ((this.studentsessionPK == null && other.studentsessionPK != null) || (this.studentsessionPK != null && !this.studentsessionPK.equals(other.studentsessionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.awasi.dsmanager.entities.Studentsession[ studentsessionPK=" + studentsessionPK + " ]";
    }
    
}
