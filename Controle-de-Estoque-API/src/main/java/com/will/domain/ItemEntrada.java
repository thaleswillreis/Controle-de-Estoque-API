package com.will.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemEntrada implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_item_entrada")
	private Integer codItemEntrada;
	private String lote;
	private Integer qtde;
	private Double valor;
	@ManyToOne
	@JoinColumn(name = "cod_produto")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "cod_entrada")
	private Entrada entrada;
	
	public ItemEntrada() {
	}

	public ItemEntrada(Integer codItemEntrada, String lote, Integer qtde, Double valor, Produto produto,
			Entrada entrada) {
		super();
		this.codItemEntrada = codItemEntrada;
		this.lote = lote;
		this.qtde = qtde;
		this.valor = valor;
		this.produto = produto;
		this.entrada = entrada;
	}

	public Integer getCodItemEntrada() {
		return codItemEntrada;
	}

	public void setCodItemEntrada(Integer codItemEntrada) {
		this.codItemEntrada = codItemEntrada;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codItemEntrada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEntrada other = (ItemEntrada) obj;
		return Objects.equals(codItemEntrada, other.codItemEntrada);
	}
}
