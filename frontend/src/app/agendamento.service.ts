import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agendamento } from './interfaces/agendamento';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AgendamentoService {

  constructor(private http:HttpClient) { }

  public getAgendamento(){
    return this.http.get<Agendamento>(`${environment.baseURL}/agendamento`)
  }

  public postAgendarTransferencia(value:Agendamento){
    return this.http.post(`${environment.baseURL}/agendamento`,value,{responseType:'text'})
  }

}
