import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MdcSnackbar } from '@angular-mdc/web';
import { TranslateService } from '@ngx-translate/core';
import { MarcatgeService } from '../marcatge/marcatge.service';
import { Locale } from 'ngx-bootstrap/chronos/locale/locale.class';

@Component({
    template: `  
    <div class="col-md-6 offset-md-3">
    <form (submit)="onSubmit($event)">
        <div class="row col-8">
            <label style="font-size:1em;">Seleccione una empresa</label>
            <select outlined *ngIf="empresas !== undefined" class="col-12" [(ngModel)]="empresaSeleccionada"
                name="empresaSelect" (change)="onEmpresaChange()">
                <option *ngFor="let empresa of empresas" [ngValue]="empresa">
                    {{empresa.nom}}
                </option>
            </select>
            <br />
            <br />
            <label>Seleccione una fecha</label>
            <div class="row col-12">
                <input type="text" class="col-12" #dp="bsDatepicker" bsDatepicker name="fecha" [bsValue]="fecha_actual"
                    [(ngModel)]="fechaSelect">
                <label>Seleccione una hora</label>
                <ngx-material-timepicker #picker></ngx-material-timepicker>
                <input class="col-12" [ngxTimepicker]="picker" [format]="24" [(ngModel)]="horaSelect" name="hora">
            </div>
            <div>
                <button mdc-button primary (click)="marcar($event)">Registrar marcaje</button>
            </div>
            <div class="row">
                <div class="col">
                    <table class="table">
                        <thead>
                            <tr>
                                <th *ngFor="let head of headElements" scope="col">{{head}} </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr *ngFor="let lm of listaMarcajes">
                                <th scope="row" class="text-truncate">{{empresaSeleccionada?.nom}}</th>
                                <td>{{lm.data | date:'yyy-MM-dd'}}</td>
                                <td>{{lm.data | date:'HH:mm'}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </form>
</div>

`,
    styles: [`
        .contenedor{
          
        }
      `]
})

export class CreateMarcatgeComponent implements OnInit {

    private empresas = []; //almacenará la respuesta de la api
    private listaMarcajes = []; //almacenará la respuesta de la api
    empresaSeleccionada: any; //almacena el campo de la empresa seleccionada    
    fechaSelect: Date; //almacena el campo de la fecha 
    horaSelect: any; //almacena el campo de la hora 
    private options = {
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit'
    };
    private hora_actual = new Date().toLocaleTimeString('es-ES', this.options); //, this.options); //hora actual que se muestra en el campo
    private fecha_actual = new Date(); //fecha actual que se muestra en el campo
    private valid: boolean = true; //control de errores
    headElements = ['Empresa', 'Fecha', 'Hora'];


    //----------------------------------------------------------

    //método que se ejecuta al inciar la app
    ngOnInit() {

        this.consultarEmpresas();

        this.horaSelect = this.hora_actual;
        this.fechaSelect = this.fecha_actual;

        console.log("Hora: " + this.hora_actual);


    }

    //----------------------------------------------------------    

    //método que realiza la consulta de las empresas relaccionadas con el usuario
    consultarEmpresas() {
        this.valid = true;

        this.marcatgeService.consultarEmpresas().subscribe(
            (response) => {
                this.empresaSeleccionada = response[0];
                this.empresas = response;
                console.log(">>>>>CONSULTA EMPRESAS", response);

                this.consultarMarcajes();
            },
            err => {
                this.valid = false;
            });

    }

    //----------------------------------------------------------

    onEmpresaChange() {

        console.log(this.empresaSeleccionada);
        this.consultarMarcajes();
    }

    //----------------------------------------------------------

    consultarMarcajes() {
        this.valid = true;

        var dataMarcatge = this.formatDia();


        this.marcatgeService.consultarMarcatges(this.empresaSeleccionada.id, dataMarcatge).
            subscribe((response: any[]) => {
                this.listaMarcajes = response;
                console.log(">>>>>>CONSULTA MARCAJES", response);
            },
                err => {
                    this.valid = false;
                })

    }

    //----------------------------------------------------------

    //método que da el formato específico que requiere la api
    formatDia() {
        let date = this.fechaSelect.toLocaleDateString().split('/');
        date[0] = (date[0].length == 1) ? '0' + date[0] : date[0];
        date[1] = (date[1].length == 1) ? '0' + date[1] : date[1];
        return date.reverse().join('-');
    }

    //----------------------------------------------------------

    //método que envía el marcaje a la api
    marcar() {
        this.valid = true;
        var dataMarcatge = `${this.formatDia()}T${this.horaSelect}+0000`;//  + this.fechaSelect + "T" + this.horaSelect; // + "+0000";

        console.log(this.empresaSeleccionada);
        this.marcatgeService.createMarcatge(dataMarcatge, this.empresaSeleccionada.id).subscribe(
            (response) => {
                console.log(">>>>NUEVO MARCAJE", response);
            },
            err => {
                this.valid = false;
            });

    }

    //----------------------------------------------------------

    onSubmit(event) {
        event.preventDefault();
    }

    //---------------------------------------------------------- 

    constructor(
        private marcatgeService: MarcatgeService,
        private router: Router,
        private snackbar: MdcSnackbar,
        private translate: TranslateService) {

    }

}