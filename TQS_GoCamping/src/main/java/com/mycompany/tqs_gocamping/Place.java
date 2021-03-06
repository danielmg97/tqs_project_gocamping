/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_gocamping;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "Place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p")
    , @NamedQuery(name = "Place.findById", query = "SELECT p FROM Place p WHERE p.id = :id")
    , @NamedQuery(name = "Place.findByName", query = "SELECT p FROM Place p WHERE p.name = :type")
    , @NamedQuery(name = "Place.findByCapacity", query = "SELECT p FROM Place p WHERE p.capacity = :capacity")
    , @NamedQuery(name = "Place.findByPrice", query = "SELECT p FROM Place p WHERE p.price = :price")
    , @NamedQuery(name = "Place.findByPic", query = "SELECT p FROM Place p WHERE p.pic = :pic")
    , @NamedQuery(name = "Place.findByDescription", query = "SELECT p FROM Place p WHERE p.description = :description")
    , @NamedQuery(name = "Place.findByRate", query = "SELECT p FROM Place p WHERE p.rate = :rate")

    ,@NamedQuery(name = "Place.findByJoinAddress", query = "SELECT p FROM Place p,Park pk WHERE pk.id = p.parkId.id AND pk.address LIKE :address")
    ,@NamedQuery(name = "Place.findByJoinTypeAddress", query = "SELECT p FROM Place p,Park pk WHERE pk.id = p.parkId.id AND pk.address LIKE :address AND p.name=:type")
    ,@NamedQuery(name = "Place.findByJoinTypePeople", query = "SELECT p FROM Place p,Park pk WHERE pk.id = p.parkId.id AND p.capacity=:capacity AND p.name=:type")
    ,@NamedQuery(name = "Place.findByJoinTypeAddressPeople", query = "SELECT p FROM Place p,Park pk WHERE pk.id = p.parkId.id AND pk.address LIKE :address AND p.capacity=:capacity AND p.name=:type")
    ,@NamedQuery(name = "Place.findByJoinAddressPeople", query = "SELECT p FROM Place p,Park pk WHERE pk.id = p.parkId.id AND pk.address LIKE :address AND p.capacity=:capacity")})
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Size(max = 900)
    @Column(name = "pic")
    private String pic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private int rate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeId")
    private Collection<Reservation> reservationCollection;
    @JoinColumn(name = "park_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Park parkId;

    public Place() {
    }

    public Place(Integer id) {
        this.id = id;
    }

    public Place(Integer id, String name, int capacity, float price, String description, int rate) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.description = description;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    public Park getParkId() {
        return parkId;
    }

    public void setParkId(Park parkId) {
        this.parkId = parkId;
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
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<place>"
                + "<id>"+id+"</id>"
                + "<name>"+name+"</name>"
                + "<capacity>"+capacity+"</capacity>"
                + "<pic>"+pic+"</pic>"
                + "<parkId>"+parkId+"</parkId>"
                + "<description>"+description+"</description>"
                + "<price>"+price+"</price>"
                + "<rate>"+rate+"</rate>"
                + "</place>";
    }
    
}
