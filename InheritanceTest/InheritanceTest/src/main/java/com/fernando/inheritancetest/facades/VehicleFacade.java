/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest.facades;

import com.fernando.inheritancetest.entities.Vehicle;
import com.fernando.inheritancetest.repositories.VehicleDAO;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class VehicleFacade {
	private VehicleDAO dao = new VehicleDAO();

	public void save(Vehicle objeto) throws Exception {
		try {
			dao.beginTransaction();
			dao.save(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive()) {
				dao.rollbackAndCloseTransaction();
			}
			throw e;
		}
	}

	public void merge(Vehicle objeto) throws Exception {
		try {
			dao.beginTransaction();
			dao.merge(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive()) {
				dao.rollbackAndCloseTransaction();
			}
			throw new Exception(e);
		}
	}

	public Vehicle find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Vehicle objeto = dao.find(id);
			dao.commitAndCloseTransaction();
			return objeto;
		} catch (Exception e) {
			if (dao.isTransactionActive()) {
				dao.rollbackAndCloseTransaction();
			}
			throw e;
		}
	}

	public void delete(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			Vehicle objeto = dao.findReferenceOnly(id);
			dao.delete(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	//delete de objeto detachado
	public void delete(Vehicle u) throws Exception {
		try {
			dao.beginTransaction();
			Vehicle objeto = dao.find(u.getId());
			dao.delete(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
		
	public List<Vehicle> list() throws Exception {
		try {
			dao.beginTransaction();
			List<Vehicle> qList = dao.listVehicles();
			dao.commitAndCloseTransaction();
			return qList;
			
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			if (dao.isTransactionActive()) {
				dao.rollbackAndCloseTransaction();
			}
			throw e;
		}
	}
}