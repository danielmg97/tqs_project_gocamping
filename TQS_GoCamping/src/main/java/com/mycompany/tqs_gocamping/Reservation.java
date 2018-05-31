/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "Reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id")
    , @NamedQuery(name = "Reservation.findByStart", query = "SELECT r FROM Reservation r WHERE r.start = :start")
    , @NamedQuery(name = "Reservation.findByFinish", query = "SELECT r FROM Reservation r WHERE r.finish = :finish")
    , @NamedQuery(name = "Reservation.findByPeople", query = "SELECT r FROM Reservation r WHERE r.people = :people")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finish;
    @Basic(optional = false)
    @NotNull
    @Column(name = "people")
    private int people;
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Place placeId;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User uid;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Reservation(Integer id, Date start, Date finish, int people) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.people = people;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Place getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Place placeId) {
        this.placeId = placeId;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<reservation>"
                + "<id>"+id+"</id>"
                + "<start>"+start+"</start>"
                + "<finish>"+finish+"</finish>"
                + "<people>"+people+"</people>"
                + "<placeId>"+placeId+"</placeId>"
                + "</reservation>";
    }
    
}
