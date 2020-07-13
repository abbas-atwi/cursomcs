package com.nelioalves.cursomcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomcs.Endereco;

// pra acessar os dados / objetos do tipo categoria e o tipo e o id Integer , esta mapeado
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
}
