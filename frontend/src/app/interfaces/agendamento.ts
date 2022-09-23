export interface Agendamento {
    id: number;
    contaDestino: string;
    contaOrigem: string;
    taxa: number;
    valorTransferencia: number;
    dataTransferencia: string;
    dataAgendamento: string;
  }