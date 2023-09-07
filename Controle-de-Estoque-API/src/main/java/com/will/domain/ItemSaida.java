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
public class ItemSaida implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_item_saida")
	private Integer codItemSaida;
	private String lote;
	private Integer qtde;
	private Double valor;
	@ManyToOne
	@JoinColumn(name = "cod_produto")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "cod_saida")
	private Saida saida;
	
	public ItemSaida() {
	}

	public ItemSaida(Integer codItemSaida, String lote, Integer qtde, Double valor, Produto produto,
			Saida saida) {
		super();
		this.codItemSaida = codItemSaida;
		this.lote = lote;
		this.qtde = qtde;
		this.valor = valor;
		this.produto = produto;
		this.saida = saida;
	}

	public Integer getCodItemSaida() {
		return codItemSaida;
	}

	public void setCodItemSaida(Integer codItemSaida) {
		this.codItemSaida = codItemSaida;
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

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codItemSaida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemSaida other = (ItemSaida) obj;
		return Objects.equals(codItemSaida, other.codItemSaida);
	}
}
