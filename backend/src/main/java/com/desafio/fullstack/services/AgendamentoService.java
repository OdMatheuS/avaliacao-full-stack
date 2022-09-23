package com.desafio.fullstack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.fullstack.entities.Agendamento;
import com.desafio.fullstack.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;

	public List<Agendamento> findAgendamento() {
		return repository.findAll();

	}

	public void insertAgendamento(Agendamento agendamento) {
		repository.save(agendamento);
	}

}
