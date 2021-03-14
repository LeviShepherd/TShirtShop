/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Mar 9, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.TCustomer;

/**
 * @author wuebk
 *testing
 */
public class TCustomerHelper {
	static EntityManagerFactory emManager = Persistence.createEntityManagerFactory("TShirtShop");
	
	public void insertCustomer(TCustomer s) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public void editCustomer(TCustomer toEdit) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TCustomer> typedQuery = em.createQuery("select C from customers where C.name = :selectedname", TCustomer.class);
		typedQuery.setParameter("selectedname", toEdit.getName());
		
		typedQuery.setMaxResults(1);
		
		TCustomer result = typedQuery.getSingleResult();
		
		
		
	}

	
	public void deleteCustomer(TCustomer toDelete) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();		
		TypedQuery<TCustomer> typedQuery = em.createQuery("select C from customers C where C.name = :selectedname", TCustomer.class);
		typedQuery.setParameter("selectedname", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		TCustomer result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public TCustomer searchForName(String name) {//search through list of customers for the entity name that matches desired name
		TCustomer foundCustomer = new TCustomer();
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<TCustomer> typedQuery = em.createQuery("  ");//need search logic**** selectedCustomer
		typedQuery.setParameter("selectedCustomer", name);
		
		foundCustomer = typedQuery.getResultList();
		em.close();
		
		return foundCustomer;
	}
	
	public List<TCustomer> showAllCustomers(){
		EntityManager em = emManager.createEntityManager();
		List<TCustomer> allCities = em.createQuery("SELECT i FROM TCustomer i").getResultList();
		return allCities;
	}
}