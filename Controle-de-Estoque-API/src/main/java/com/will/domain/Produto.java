package com.will.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;
	private String codigoDeBarras;
	private String produto;
	private String descricao;
	private Double pesoProduto;
	private Boolean produtoControlado;
	private Double preco;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", 
		joinColumns = @JoinColumn(name = "produto_id"), 
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	@ManyToMany
	@JoinTable(name = "PRODUTO_FORNECEDOR", 
			joinColumns = @JoinColumn(name = "produto_id"), 
			inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
	)
	private List<Fornecedor> fornecedores = new ArrayList<>();

	public Produto() {
	}

	public Produto(Integer codProduto, String codigoDeBarras, String produto, String descricao, Double pesoProduto, Boolean produtoControlado, Double preco) {
		super();
		this.codProduto = codProduto;
		this.codigoDeBarras = codigoDeBarras;
		this.produto = produto;
		this.descricao = descricao;
		this.pesoProduto = pesoProduto;
		this.produtoControlado = produtoControlado;
		this.preco = preco;
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPesoProduto() {
		return pesoProduto;
	}

	public void setPesoProduto(Double pesoProduto) {
		this.pesoProduto = pesoProduto;
	}

	public Boolean getProdutoControlado() {
		return produtoControlado;
	}

	public void setProdutoControlado(Boolean produtoControlado) {
		this.produtoControlado = produtoControlado;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codProduto, other.codProduto);
	}
}
