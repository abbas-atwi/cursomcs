package com.nelioalves.cursomcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomcs.domain.Pedido;

// pra acessar os dados / objetos do tipo categoria e o tipo e o id Integer , esta mapeado
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
}
