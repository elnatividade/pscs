package br.com.pscs.cadastroCliente.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.pscs.cadastroCliente.model.Cliente;
import br.com.pscs.cadastroCliente.service.ClienteService;
import br.com.pscs.cadastroCliente.util.FacesUtil;

@Named
@ViewScoped
public class ClienteBean implements Serializable{
	
	/*----------------- ENUMERACOES -----------------*/
	private enum ModoCadastro{
		ADICAO,
		EDICAO;
	}
	/*-----------------------------------------------*/
	
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	private Cliente clienteEditar;
	
	private Cliente clienteExcluir;
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@Inject 
	private ClienteService clienteService;
	
	private ModoCadastro modoCadastro;
	
		
	/*----------------- CONSTRUTORES -----------------*/
	public ClienteBean() {
		super();
	}
	
	
	/*-----------------    GETTERS    -----------------*/
	public Cliente getCliente() {
		return cliente;
	}
	
	public Cliente getClienteEditar() {
		return clienteEditar;
	}
	
	public Cliente getClienteExcluir() {
		return clienteExcluir;
	}
	
	public List<Cliente> getClientes(){
		return clientes;
	}
	
	public ModoCadastro getModoCadastro() {
		return modoCadastro;
	}
	
	
	/*-----------------    SETTERS    -----------------*/
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setClienteEditar(Cliente clienteEditar) {
		this.clienteEditar = clienteEditar;
	}
	
	public void setClienteExcluir(Cliente clienteExcluir) {
		this.clienteExcluir = clienteExcluir;
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void setModoCadastro(ModoCadastro modoCadastro) {
		this.modoCadastro = modoCadastro;
	}
	
	
	/*-----------------     AÇOES     -----------------*/
	@PostConstruct
	public void init() {
		this.limpar();
		this.carregaClientes();
		this.modoCadastro = ModoCadastro.ADICAO;
	}
	
	public void limpar() {
		this.cliente = new Cliente();
		this.clientes = new ArrayList<Cliente>();
	}
	
	public void carregaClientes() {
		this.clientes.addAll(clienteService.listarTodos());
	}
	
	public String cadastrar() {
		if (existeCPF(cliente)) {
			FacesUtil.addErrorMessage("O CPF de " + cliente.getNome() + " já está cadastrado");
			return "";
		}
		
		Cliente ClienteCadastrado = clienteService.cadastrar(cliente);
		FacesUtil.addSuccessMessage("O cliente " + ClienteCadastrado.getNome() + " foi salvo com sucesso!");
		init();
		
		return "";
	}
	
	public void editar() {
		cliente = clienteEditar;
		modoCadastro = ModoCadastro.EDICAO;
	}
	
	public String atualizar() {
		if (existeCPF(clienteEditar)) {
			FacesUtil.addErrorMessage("O CPF de " + clienteEditar.getNome() + " já está cadastrado");
			return "";
		}
		
		clienteService.atualizar(clienteEditar);
		FacesUtil.addSuccessMessage("O cliente " + clienteEditar.getNome() + " foi atualizado com sucesso!");
		init();
		
		return "";
	}
	
	public String excluir() {
		clienteService.excluir(clienteExcluir);
		FacesUtil.addSuccessMessage("O cliente " + clienteExcluir.getNome() + " foi excluido com sucesso!");
		init();
		
		return "";
	}
	
	public boolean exibeBotaoAtualizar() {
		return modoCadastro.equals(ModoCadastro.EDICAO);
	}
	
	public boolean exibeBotaoCadastrar() {
		return modoCadastro.equals(ModoCadastro.ADICAO);
	}
	
	public boolean existeCPF(Cliente cliente) {
		return clienteService.verificaCPF(cliente);
	}
	
	
	
}
