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
@Table(name = "Park")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Park.findAll", query = "SELECT p FROM Park p")
    , @NamedQuery(name = "Park.findById", query = "SELECT p FROM Park p WHERE p.id = :id")
    , @NamedQuery(name = "Park.findByName", query = "SELECT p FROM Park p WHERE p.name = :name")
    , @NamedQuery(name = "Park.findByAddress", query = "SELECT p FROM Park p WHERE p.address = :address")
    , @NamedQuery(name = "Park.findByPic", query = "SELECT p FROM Park p WHERE p.pic = :pic")})
public class Park implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Size(max = 900)
    @Column(name = "pic")
    private String pic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parkId")
    private Collection<Place> placeCollection;

    public Park() {
    }

    public Park(Integer id) {
        this.id = id;
    }

    public Park(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @XmlTransient
    public Collection<Place> getPlaceCollection() {
        return placeCollection;
    }

    public void setPlaceCollection(Collection<Place> placeCollection) {
        this.placeCollection = placeCollection;
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
        if (!(object instanceof Park)) {
            return false;
        }
        Park other = (Park) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tqs_gocamping.Park[ id=" + id + " ]";
    }
    
}
