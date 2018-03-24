/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */

   @Entity
   @Table(name = "tb_vehicle", schema = "vehicle")
   @Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 8739631506221299741L;
       
    @Id
    private int id;
    private String licensePlate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Vehicle(int id, String licensePlate) {
        this.id = id;
        this.licensePlate = licensePlate;
    }

    public Vehicle() {
    }
    
    public Vehicle(Vehicle v) {
        this.id = v.getId();
        this.licensePlate = v.getLicensePlate();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", licensePlate=" + licensePlate + '}';
    }
}
