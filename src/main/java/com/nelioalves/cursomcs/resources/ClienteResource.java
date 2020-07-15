package com.nelioalves.cursomcs.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomcs.domain.Cliente;
import com.nelioalves.cursomcs.services.ClienteService;

//essa classe vai controlar 
@RestController
// endpoints 
@RequestMapping(value="/clientes")
public class ClienteResource {
// acessando o servico
	
	@Autowired
	private ClienteService service;
	
	//	buscar 
//	Quem vai receber esta exception e a camada resource rest
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ResponseEntity<?>find(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
