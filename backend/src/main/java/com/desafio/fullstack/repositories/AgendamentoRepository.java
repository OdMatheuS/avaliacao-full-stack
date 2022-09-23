package com.desafio.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.fullstack.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
