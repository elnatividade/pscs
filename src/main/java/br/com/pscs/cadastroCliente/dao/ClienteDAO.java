package br.com.pscs.cadastroCliente.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import br.com.pscs.cadastroCliente.model.Cliente;

public class ClienteDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	/*-----------------    CONSTRUTORES     -----------------*/
	public ClienteDAO(){
		super();
	}
	
	
	/*-----------------     PERSISTENCIA     -----------------*/
	public Cliente salvar(Cliente cliente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroClientePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction emt = em.getTransaction();
		emt.begin();
		em.persist(cliente);
		emt.commit();
				
		return cliente;
		
	}
	
	public void excluir(Cliente cliente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroClientePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction emt = em.getTransaction();
		cliente = em.find(Cliente.class, cliente.getCodigo());
		emt.begin();
		em.remove(cliente);
		emt.commit();
	}
	
	public Cliente atualizar(Cliente cliente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroClientePU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction emt = em.getTransaction();
		emt.begin();
		Cliente clienteAtualizado = em.merge(cliente);
		emt.commit();
		
		return clienteAtualizado;
		
	}
	
	public List<Cliente> listarTodos(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastroClientePU");
		EntityManager em = emf.createEntityManager();
		List<Cliente> resultado =  em.createQuery("FROM Cliente", Cliente.class).getResultList();
				
		return resultado;

	}

	

}
