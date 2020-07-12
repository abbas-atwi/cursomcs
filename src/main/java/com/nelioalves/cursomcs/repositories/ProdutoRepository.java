package com.nelioalves.cursomcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomcs.domain.Produto;

// pra acessar os dados / objetos do tipo categoria e o tipo e o id Integer , esta mapeado
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
}
