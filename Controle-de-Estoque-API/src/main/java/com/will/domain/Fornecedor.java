package com.will.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.will.domain.enums.TipoPessoa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codFornecedor;
	@Column(unique=true)
	private String fornecedor;
	private String emailFornecedor;
	private String cpfOuCnpj;
	private Integer tipo;
	private String nomeContatoFornecedor;
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Endereco> enderecos = new ArrayList<>();
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@ManyToMany(mappedBy="fornecedores")
	private List<Produto> produtos = new ArrayList<>();

	public Fornecedor() {
	}

	public Fornecedor(Integer codFornecedor, String fornecedor, String emailFornecedor, String cpfOuCnpj, TipoPessoa tipo, String nomeContatoFornecedor) {
		super();
		this.codFornecedor = codFornecedor;
		this.fornecedor = fornecedor;
		this.emailFornecedor = emailFornecedor;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.nomeContatoFornecedor = nomeContatoFornecedor;
	}

	public Integer getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(Integer codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getEmailFornecedor() {
		return emailFornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TipoPessoa getTipo() {
		return TipoPessoa.toEnum(tipo);
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo.getCod();
	}

	public String getNomeContatoFornecedor() {
		return nomeContatoFornecedor;
	}

	public void setNomeContatoFornecedor(String nomeContatoFornecedor) {
		this.nomeContatoFornecedor = nomeContatoFornecedor;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codFornecedor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(codFornecedor, other.codFornecedor);
	}
}