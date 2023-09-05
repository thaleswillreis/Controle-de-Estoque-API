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
import jakarta.persistence.OneToMany;

@Entity
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String loja;
	private String emailLoja;
	private String cpfOuCnpj;
	private Integer tipo;
	private String nomeContatoLoja;
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Endereco> enderecos = new ArrayList<>();
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	public Loja() {
	}

	public Loja(Integer id, String loja, String emailLoja, String cpfOuCnpj, TipoPessoa tipo, String nomeContatoLoja) {
		super();
		this.id = id;
		this.loja = loja;
		this.emailLoja = emailLoja;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.nomeContatoLoja = nomeContatoLoja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public String getEmailLoja() {
		return emailLoja;
	}

	public void setEmailLoja(String emailLoja) {
		this.emailLoja = emailLoja;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getNomeContatoLoja() {
		return nomeContatoLoja;
	}

	public void setNomeContatoLoja(String nomeContatoLoja) {
		this.nomeContatoLoja = nomeContatoLoja;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(id, other.id);
	}
}
