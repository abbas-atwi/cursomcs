package com.nelioalves.cursomcs.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//essa classe vai controlar 
@RestController
// endpoints 
@RequestMapping(value="/categorias")
public class CategoriaResource {
//	buscar 
	@RequestMapping(method= RequestMethod.GET)
	public String listar() {
		return "REST ESTA FUNCIONANDO !";
	}
}
