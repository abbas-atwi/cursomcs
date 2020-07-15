package com.nelioalves.cursomcs.services;

//Regra de negocio
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomcs.domain.Cliente;
import com.nelioalves.cursomcs.repositories.ClienteRepository;
import com.nelioalves.cursomcs.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
//	para instanciar @autowired
	@Autowired
	private ClienteRepository repo;
	
//	Buscar uma categoria por codigo ele tem que pegar do repository
	public Cliente buscar(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado Id:" + id + ", Tipo: " + Cliente.class.getName()));
		 }
		
		} 

