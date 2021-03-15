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
 *TESTING
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
	
	public void updateCustomer(TCustomer toEdit) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	
	public void deleteCustomer(TCustomer toDelete) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();		
		TypedQuery<TCustomer> typedQuery = em.createQuery("select c from TCustomer c where c.name = :selectedName and c.address = :selectedAddress", TCustomer.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAddress", toDelete.getAddress());
		
		typedQuery.setMaxResults(1);
		
		TCustomer result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<TCustomer> searchForName(String name) {//search through list of customers for the entity name that matches desired name
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<TCustomer> typedQuery = em.createQuery("select c from TCustomer c where c.name = :selectedCustomer", TCustomer.class);//need search logic**** :selectedCustomer
		typedQuery.setParameter("selectedCustomer", name);
		
		List<TCustomer> foundCustomers = typedQuery.getResultList();
		em.close();
		
		return foundCustomers;
	}
	
	public TCustomer searchForId(int id){
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		TCustomer found = em.find(TCustomer.class, id);
		em.close();
		return found;
	}
	
	public List<TCustomer> showAllCustomers(){
		EntityManager em = emManager.createEntityManager();
		List<TCustomer> allCities = em.createQuery("SELECT i FROM TCustomer i").getResultList();
		return allCities;
	}
}