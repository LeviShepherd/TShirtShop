/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Mar 14, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TOrders;

/**
 * @author wuebk
 *
 */
public class TOrdersHelper {
	
	static EntityManagerFactory emManager = Persistence.createEntityManagerFactory("TShirtShop");
	
	public void insertOrders(TOrders s) {
		EntityManager em = emManager.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<TOrders> showAllOrders(){
		EntityManager em = emManager.createEntityManager();
		List<TOrders> allOrders = em.createQuery("SELECT i FROM TOrders i").getResultList();//<<NEED TO CHECK LOGIC ON QUERY
		return allOrders;
	}
	
}
