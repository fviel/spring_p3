/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.inheritancetest.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

//import br.com.responderquestoes.utils.Configuracoes;

public abstract class GenericDAO<ID, U> {
	// problema, praticamente tenho um singleton do emf, mas preciso abrir e
	// fechar ele, quando eu faria ele
	// somente vou matar ele quando for fechar a aplicação
	//private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("RQ_PG_pu");
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MYSQL_pu");
	//private static EntityManagerFactory emf;
	
	
	//AO RODAR NO TOMCAT, NÃO ESTÁ ENCONTRANDO O PROPERTIES
	/*static {
		//seleciona o persistence unit com base na configuração de properties
		Configuracoes config = new Configuracoes(null);
		String bd = config.getConfig("bd");
		System.out.println(bd);
		if(bd.equals("postgre")) {
			emf = Persistence.createEntityManagerFactory("RQ_PG_pu");
		}
		if(bd.equals("mysql")) {
			emf = Persistence.createEntityManagerFactory("RQ_MYSQL_pu");
		}
	}*/
	
	private EntityManager em;
	private Class<U> entityClass;

	public GenericDAO(Class<U> entityClass) {
		this.entityClass = entityClass;
	}

	public void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		//System.out.println("iniciada a transação");
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void rollback() {
		em.getTransaction().rollback();
	}

	public void rollbackAndCloseTransaction() {
		try {
			this.em.getTransaction().rollback();
		} finally {
			this.closeTransaction();
		}
	}
	
	//verifica se a transação ainda está ativa
	public boolean isTransactionActive(){
		return this.em.getTransaction().isActive();
	}

	private void closeTransaction() {
		this.em.close();
	}

	public void commitAndCloseTransaction() {
		try {
			//System.out.println("commit de transação");
			this.commit();
		} finally {
			//System.out.println("close de transação");
			this.closeTransaction();
		}
	}

	public void flush() {
		em.flush();
	}

	public void save(U entity) {
		em.persist(entity);
	}

	public void delete(U entity) {
		//System.out.println("1");
		em.refresh(entity);
		//System.out.println("2");
		em.remove(entity);
		//System.out.println("3");
	}

	public U update(U entity) {
		return em.merge(entity);
	}

	public U find(ID entityID) {
		return em.find(entityClass, entityID);
	}

	public U findReferenceOnly(ID entityID) {
		try {
			return em.getReference(entityClass, entityID);
		} catch (EntityNotFoundException e) {
			// Tenta retornar null na exception, pois o JPA por padrão retorna
			// exception quando não encontra o item no banco de dados.
			// JPA parte do princípio que ele TEM que encontrar algo no banco
			return null;
		}catch(Exception e) {
			return null;
		}
	}

	// sempre antes de fechar a aplicacao, devo manualmente chamar este metodo
	public static void fecharEntityManagerFactory() {
		emf.close();
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public U merge(U entity) {
		return em.merge(entity);
	}

}
