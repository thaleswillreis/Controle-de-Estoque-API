package com.will.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Saida implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_saida")
	private Integer codSaida;
	private Double valorTotal;
	private Double frete;
	private Double imposto;
	private Date dataSaida;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cod_transportadora")
	private Transportadora transportadora;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cod_loja")
	private Loja loja;

	public Saida() {
	}

	public Saida(Integer codSaida, Double valorTotal, Double frete, Double imposto, Date dataSaida) {
		super();
		this.codSaida = codSaida;
		this.valorTotal = valorTotal;
		this.frete = frete;
		this.imposto = imposto;
		this.dataSaida = dataSaida;
	}

	public Integer getCodSaida() {
		return codSaida;
	}

	public void setCodSaida(Integer codSaida) {
		this.codSaida = codSaida;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codSaida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saida other = (Saida) obj;
		return Objects.equals(codSaida, other.codSaida);
	}
}
