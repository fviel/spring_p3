/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest;

import com.fernando.inheritancetest.entities.CommercialVehicle;
import com.fernando.inheritancetest.entities.Vehicle;

/**
 *
 * @author Fernando
 */
public class Run {

    public static void main(String... args) {
        Vehicle v1 = new Vehicle(0, "abc1234");
        Vehicle v2 = new Vehicle(1, "bbc1234");
        Vehicle v3 = new Vehicle(2, "cbc1234");
        Vehicle v4 = new Vehicle(3, "dbc1234");
        
        CommercialVehicle cv1 = new CommercialVehicle(v1, "fernando");
        CommercialVehicle cv2 = new CommercialVehicle("fernando");
        
        System.out.println("Vehicle: " + v1);
        System.out.println("CommercialVehicle: " + cv2);
        
        cv2 = (CommercialVehicle) v1;
        System.out.println("CommercialVehicle: " + cv2);
        
        
        
        
        
    }

}
