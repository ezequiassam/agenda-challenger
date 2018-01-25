package com.br.agendachallenger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Agenda> findAll() {
		Iterable<Agenda> listaAgendas = provider.findAll();
		return listaAgendas;
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Agenda> findById(@PathVariable("id") long id) {
		Agenda agenda = provider.findOne(id);
		if (agenda == null) {
			return new ResponseEntity<Agenda>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Agenda>(agenda, HttpStatus.OK);
	}

	@PostMapping()
	public Agenda create(@RequestBody @Valid Agenda agenda) {
		return provider.save(agenda);

	}

	@PutMapping(value = "/{id}", produces="application/json")
	public Agenda update(@PathVariable("id") long id, @RequestBody @Valid Agenda agenda) {
		Agenda a  = provider.findOne(id);
		if (a == null) {
			return null;
		}
		
		a.setNome(agenda.getNome());
		a.setTelefone(agenda.getTelefone());
		a.setData(agenda.getData());
		a.setLocal(agenda.getLocal());
		return provider.save(a);
	}

	@DeleteMapping(value = "/{id}")
	public Agenda remove(@PathVariable("id") long id) {
		Agenda agenda = provider.findOne(id);
		provider.delete(agenda);
		return agenda;
	}

}
