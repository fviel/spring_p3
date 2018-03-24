/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest.repositories;


import com.fernando.inheritancetest.entities.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Fernando
 * Classe responsável por interagir com o banco de dados em uma camada abaixo.
 */
public class VehicleDAO extends GenericDAO<Integer, Vehicle> {

    //Construtor obrigatório exigido pela minha Generic
    public VehicleDAO(Class<Vehicle> entityClass) {
        super(entityClass);
    }
   

}
