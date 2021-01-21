package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Product;

@Repository
public class ProductDAO {
	
	/*
	 * @PersistenceContext. Essa annotation vem da pr�pria especifica��o JPA.
	 * Geralmente, ela � usada dentro dos servidores JavaEE, mas nada impede de
	 * outro framework qualquer fazer uso damesma. Perceba que o nome
	 * PersistenceContext tem todo um valor sem�ntico: ele realmente indica que a
	 * classe quer receber ali um EntityManager.
	 */
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Product product) {
		manager.persist(product);
	}
}
