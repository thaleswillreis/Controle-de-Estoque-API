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
public class Transportadora implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codTransportadora;
	@Column(unique=true)
	private String transportadora;
	private String emailTransportadora;
	private String cpfOuCnpj;
	private Integer tipo;
	private String nomeContatoTransportadora;
	@OneToMany(mappedBy = "transportadora", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Endereco> enderecos = new ArrayList<>();
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	public Transportadora() {
	}

	public Transportadora(Integer codTransportadora, String transportadora, String emailTransportadora, String cpfOuCnpj, TipoPessoa tipo, String nomeContatoTransportadora) {
		super();
		this.codTransportadora = codTransportadora;
		this.transportadora = transportadora;
		this.emailTransportadora = emailTransportadora;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.nomeContatoTransportadora = nomeContatoTransportadora;
	}

	public Integer getCodTransportadora() {
		return codTransportadora;
	}

	public void setCodTransportadora(Integer codTransportadora) {
		this.codTransportadora = codTransportadora;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public String getEmailTransportadora() {
		return emailTransportadora;
	}

	public void setEmailTransportadora(String emailTransportadora) {
		this.emailTransportadora = emailTransportadora;
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

	public String getNomeContatoTransportadora() {
		return nomeContatoTransportadora;
	}

	public void setNomeContatoTransportadora(String nomeContatoTransportadora) {
		this.nomeContatoTransportadora = nomeContatoTransportadora;
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
		return Objects.hash(codTransportadora);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transportadora other = (Transportadora) obj;
		return Objects.equals(codTransportadora, other.codTransportadora);
	}
}