package com.desafio.fullstack.services;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.desafio.fullstack.entities.Agendamento;
import com.desafio.fullstack.services.interfaces.CalcTxInterface;

@Service
public class CalcTxAgendaTransfService implements CalcTxInterface {

	private long diffDays(Agendamento agendamento) {
		long diffDays = agendamento.getDataAgendamento().until(agendamento.getDataTransferencia(), ChronoUnit.DAYS);

		return diffDays;
	}

	@Override
	public Double calcTxA(Agendamento agendamento) {

		if (this.diffDays(agendamento) == 0) {
			return (agendamento.getValorTransferencia() * 0.03) + 3.0;
		}
		return null;
	}

	@Override
	public Double calcTxB(Agendamento agendamento) {

		if (this.diffDays(agendamento) <= 10) {
			return 12.0;
		}

		return null;
	}

	@Override
	public Double calcTxC(Agendamento agendamento) {
		if (this.diffDays(agendamento) > 10 && this.diffDays(agendamento) <= 20) {
			return (agendamento.getValorTransferencia() * 0.082);
		}

		else if (this.diffDays(agendamento) > 20 && this.diffDays(agendamento) <= 30) {
			return (agendamento.getValorTransferencia() * 0.069);
		}

		else if (this.diffDays(agendamento) > 30 && this.diffDays(agendamento) <= 40) {
			return (agendamento.getValorTransferencia() * 0.047);
		}

		else if (this.diffDays(agendamento) > 40) {
			return (agendamento.getValorTransferencia() * 0.017);
		}

		return null;
	}

	@Override
	public Double calcTxD(Agendamento agendamento) {
		if (agendamento.getValorTransferencia() <= 1000) {
			return this.calcTxA(agendamento);
		}

		else if (agendamento.getValorTransferencia() >= 1001 && agendamento.getValorTransferencia() <= 2000) {
			return this.calcTxB(agendamento);
		}

		else if (agendamento.getValorTransferencia() > 2000) {
			return calcTxC(agendamento);
		}

		return null;
	}

}
