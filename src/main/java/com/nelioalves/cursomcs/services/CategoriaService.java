package com.nelioalves.cursomcs.services;

//Regra de negocio
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomcs.domain.Categoria;
import com.nelioalves.cursomcs.repositories.CategoriaRepository;
import com.nelioalves.cursomcs.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
//	para instanciar @autowired
	@Autowired
	private CategoriaRepository repo;
	
//	Buscar uma categoria por codigo ele tem que pegar do repository
	public Categoria buscar(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado Id:" + id + ", Tipo: " + Categoria.class.getName()));
		 }
		
		} 

