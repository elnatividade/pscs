package br.com.pscs.cadastroCliente.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import br.com.pscs.cadastroCliente.dao.ClienteDAO;
import br.com.pscs.cadastroCliente.model.Cliente;

public class ClienteService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteDAO clienteDao;
	
	
	/*-----------------  CONSTRUTORES   -----------------*/
	public ClienteService(){
		super();
	}
	
	
	/*-----------------     SERVIÇOS     -----------------*/
	public Cliente cadastrar(Cliente cliente) {
		return clienteDao.salvar(cliente);
	}
	
	public List<Cliente> listarTodos(){
		return clienteDao.listarTodos();
		
	}

	public void excluir(Cliente cliente) {
		clienteDao.excluir(cliente);
		
	}


	public Cliente atualizar(Cliente cliente) {
		return clienteDao.atualizar(cliente);
	}
	
}
