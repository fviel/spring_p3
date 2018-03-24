/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest.facades;

import com.fernando.inheritancetest.entities.CommercialVehicle;
import com.fernando.inheritancetest.repositories.CommercialVehicleDAO;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class CommercialVehicleFacade {
	private CommercialVehicleDAO dao = new CommercialVehicleDAO();

	public void save(CommercialVehicle objeto) throws Exception {
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

	public void merge(CommercialVehicle objeto) throws Exception {
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

	public CommercialVehicle find(Integer id) throws Exception {
		try {
			dao.beginTransaction();
			CommercialVehicle objeto = dao.find(id);
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
			CommercialVehicle objeto = dao.findReferenceOnly(id);
			dao.delete(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
	
	//delete de objeto detachado
	public void delete(CommercialVehicle u) throws Exception {
		try {
			dao.beginTransaction();
			CommercialVehicle objeto = dao.find(u.getId());
			dao.delete(objeto);
			dao.commitAndCloseTransaction();
		} catch (Exception e) {
			if (dao.isTransactionActive())
				dao.rollbackAndCloseTransaction();
			throw e;
		}
	}
		
	/*public List<CommercialVehicle> list() throws Exception {
		try {
			dao.beginTransaction();
			List<CommercialVehicle> qList = dao.listCommercialVehicles();
			dao.commitAndCloseTransaction();
			return qList;
			
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			if (dao.isTransactionActive()) {
				dao.rollbackAndCloseTransaction();
			}
			throw e;
		}
	}*/
}