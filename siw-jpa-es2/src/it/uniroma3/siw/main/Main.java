package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import it.uniroma3.siw.model.Product;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce-unit");
		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();
	}
}