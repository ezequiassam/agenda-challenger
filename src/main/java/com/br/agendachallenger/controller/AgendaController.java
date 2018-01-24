package com.br.agendachallenger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.agendachallenger.model.Agenda;
import com.br.agendachallenger.repository.AgendaRepository;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

	@Autowired
	private AgendaRepository provider;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Agenda> findAll() {
		Iterable<Agenda> listaAgendas = provider.findAll();
		return listaAgendas;
	}

	@PostMapping
	public Agenda create(@Valid Agenda agenda) {
		return provider.save(agenda);

	}
	
	@DeleteMapping
	public Agenda remove(Agenda agenda) {
		provider.delete(agenda);
		return agenda;
	}
	
	
}
