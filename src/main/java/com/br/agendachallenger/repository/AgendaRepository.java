package com.br.agendachallenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.agendachallenger.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, String>{

}
