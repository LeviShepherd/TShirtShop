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
 *
 */
public class TCustomerHelper {
	static EntityManagerFactory emManager = Persistence.createEntityManagerFactory("TShirtShop");
	
	public void insertTCustomer(TCustomer s) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<TCustomer> showAllCustomers(){
		EntityManager em = emManager.createEntityManager();
		List<TCustomer> allCities = em.createQuery("SELECT i FROM TCustomer i").getResultList();
		return allCities;
	}
	
	public void deleteZip(TCustomer toDelete) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();		
		TypedQuery<TCustomer> typedQuery = em.createQuery("select C from towns where C.name = :selectedname", TCustomer.class);
		typedQuery.setParameter("selectedzipCode", toDelete.getName());
		
		typedQuery.setMaxResults(1);
		
		TCustomer result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<TCustomer> lookForZip(String Zip){
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TCustomer> tQ = em.createQuery("select C from customers where C.name = :selectedname", TCustomer.class);
		tQ.setParameter("selectedzipCode", Zip);
		List<TCustomer> foundZip = tQ.getResultList();
		em.close();
		return foundZip;
	}
}
