package br.com.pscs.cadastroCliente.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name="cliente")

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String Endereco;
	private String telefone;
	private String nomeMae;
	private String nomePai;
	
	
	/*----------------- CONSTRUTORES -----------------*/
	public Cliente() {
		super();
	}

	
	/*-----------------    GETTERS    -----------------*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getCodigo() {
		return codigo;
	}
	
	@Column(name="nome", length=100)
	@NotBlank(message="O campo Nome deve ser preenchido")
	public String getNome() {
		return nome;
	}
	
	@Column(name="cpf", length=14)
	@NotBlank(message="O campo CPF deve ser preenchido")
	public String getCpf() {
		return cpf;
	}
	
	@Column(name="data_nascimento", length=10)
	@NotNull(message="O campo Data de Nasciment deve ser preenchido")
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@Column(name="endereco", length=100)
	@NotBlank(message="O campo Endereço deve ser preenchido")
	public String getEndereco() {
		return Endereco;
	}

	@Column(name="telefone", length=13)
	public String getTelefone() {
		return telefone;
	}

	@Column(name="nome_mae", length=100)
	public String getNomeMae() {
		return nomeMae;
	}

	@Column(name="nome_pai", length=100)
	public String getNomePai() {
		return nomePai;
	}


	/*-----------------    SETTERS    -----------------*/
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
			
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}


	/*-----------------  SOBRECARGAS  -----------------*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Endereco == null) ? 0 : Endereco.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePai == null) ? 0 : nomePai.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (Endereco == null) {
			if (other.Endereco != null)
				return false;
		} else if (!Endereco.equals(other.Endereco))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePai == null) {
			if (other.nomePai != null)
				return false;
		} else if (!nomePai.equals(other.nomePai))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [nome=").append(nome).append(", dataNascimento=").append(dataNascimento)
				.append(", cpf=").append(cpf).append(", Endereco=").append(Endereco).append(", telefone=")
				.append(telefone).append(", nomeMae=").append(nomeMae).append(", nomePai=").append(nomePai).append("]");
		return builder.toString();
	}
	
		
}
