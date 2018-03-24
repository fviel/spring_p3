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
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Fernando
 * Classe responsável por interagir com o banco de dados em uma camada abaixo.
 */
public class VehicleDAO extends GenericDAO<Integer, Vehicle> {
 

    //Construtor obrigatório exigido pela minha Generic
    public VehicleDAO() {
        super(Vehicle.class);
    }

    public List<Vehicle> listVehicles() {
		// o nome da named query precisa ser o mesmo nome do método
		Query query = super.getEntityManager().createNamedQuery("Vehicle.listVehicles");
		try {
			@SuppressWarnings("unchecked")
			List<Vehicle> retorno = query.getResultList();
			return retorno;
		} catch (NoResultException ne) {
			return null;
		}
	}

	public List<Vehicle> findByScore(Integer score) {
		Query query = super.getEntityManager().createNamedQuery("Vehicle.findByScore");
		query.setParameter("score", score);
		try {
			@SuppressWarnings("unchecked")
			List<Vehicle> retorno = query.getResultList();
			return retorno;		
		} catch (NoResultException ne) {
			return null;
		}
	}
   

}
