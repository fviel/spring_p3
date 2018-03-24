/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest.repositories;


import com.fernando.inheritancetest.entities.CommercialVehicle;
import com.fernando.inheritancetest.entities.Vehicle;


/**
 *
 * @author Fernando
 * Classe responsável por interagir com o banco de dados em uma camada abaixo.
 */
public class CommercialVehicleDAO extends GenericDAO<Integer, CommercialVehicle> {

    //Construtor obrigatório exigido pela minha Generic
    public CommercialVehicleDAO() {
        super(CommercialVehicle.class);
    }
}
