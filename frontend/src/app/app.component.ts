import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AgendamentoService } from './agendamento.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  public agendamento$ = this.agendamentoService.getAgendamento();
  public msgBtnAgendarTransferencia = 'Para habilitar o botão, precisa preencher os campos de forma valida.';
  public formAgendamento: FormGroup;
  public date = new Date().toLocaleDateString();

  private configSnack = {
    duration: 3500,
    verticalPosition: 'top',
    horizontalPosition: 'right',
  };

  constructor(
    private agendamentoService: AgendamentoService,
    private fb: FormBuilder,
    private _snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.formAgendamento = this.fb.group({
      contaOrigem: ['', Validators.minLength(6)],
      contaDestino: ['', Validators.minLength(6)],
      dataTransferencia: ['', Validators.required],
      valorTransferencia: [1, Validators.pattern(/^-?(0|[1-9]\d*)?$/)],
    });
  }

  public agendarTransferencia() {
    this.agendamentoService
      .postAgendarTransferencia(this.formAgendamento.value)
      .subscribe(
        (value: string) => {
          this.openSnackBar(value, 'X', this.configSnack);
          this.agendamento$ = this.agendamentoService.getAgendamento();
        },
        (err: HttpErrorResponse) => {
          this.openSnackBar(err.error, 'X', this.configSnack);
        }
      );
  }

  private openSnackBar(message: string, action: string, config?: unknown) {
    this._snackBar.open(message, action, config);
  }
}
