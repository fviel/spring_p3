/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest.entities;

import javax.persistence.Entity;

/**
 *
 * @author Fernando
 */
@Entity
public class CommercialVehicle extends Vehicle{
    
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return super.toString() + " CommercialVehicle{" + "owner=" + owner + '}';
    }

    public CommercialVehicle() {
    }

    public CommercialVehicle(String owner, int id, String licensePlate) {
        super(id, licensePlate);
        this.owner = owner;
    }
    
    
    public CommercialVehicle(Vehicle v, String owner) {
        super(v);
        this.owner = owner;
    }

    public CommercialVehicle(String owner) {
        this.owner = owner;
    }
}
