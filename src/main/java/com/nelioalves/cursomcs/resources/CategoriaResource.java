package com.nelioalves.cursomcs.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomcs.domain.Categoria;


//essa classe vai controlar 
@RestController
// endpoints 
@RequestMapping(value="/categorias")
public class CategoriaResource {
//	buscar 
	@RequestMapping(method= RequestMethod.GET)
	public List<Categoria>listar() {
		
		Categoria cat1 = new Categoria(1, "informatica");
		Categoria cat2 = new Categoria(2, "escritorio");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
}
