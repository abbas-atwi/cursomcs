package com.nelioalves.cursomcs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
//	Fazer mapeamento
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
//	Fazer mapeamento
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double preco;
	
//	Temos que associar e fazer mapeamento
//	Um produto tem varias categorias, associando entre eles
//	Json ja forma buscados agora nao busco mais
	@JsonBackReference
	@ManyToMany
//	Definir quem vai ser a tabela q vai ser mt pra mt Tabela do meio
	@JoinTable(name = "PRODUTO_CATEGORIA", 
//	Nome do campo da tabela correspondete ao codigo do produto chave estrangeira
	joinColumns = @JoinColumn(name = "produto_id"),
//	Nome da outra chave estrangeira
	inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	
	public Produto() {
		
	}

// Categoria nao entra pois ja foi iniciada
	public Produto(Integer id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
