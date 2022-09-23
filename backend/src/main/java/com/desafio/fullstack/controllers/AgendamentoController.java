package com.desafio.fullstack.controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.fullstack.entities.Agendamento;
import com.desafio.fullstack.exception.CustomException;
import com.desafio.fullstack.services.AgendamentoService;
import com.desafio.fullstack.services.CalcTxAgendaTransfService;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoService service;

	@Autowired
	private CalcTxAgendaTransfService calcService;

	@GetMapping
	public List<Agendamento> findAgendamento() {
		return service.findAgendamento();
	}

	@PostMapping
	public ResponseEntity<String> insertAgendamento(@RequestBody Agendamento agendamento) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		agendamento.setDataAgendamento(today);

		try {
			if (Objects.isNull(calcService.calcTxD(agendamento))) {
				throw new CustomException(
						"Não foi possível realizar a operação, ocorreu um erro na aplicação da taxa.");
			}
			agendamento.setTaxa(calcService.calcTxD(agendamento));
			service.insertAgendamento(agendamento);
			return ResponseEntity.ok("Sucesso! agendamento de transferência concluido!");
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}

	}

}
