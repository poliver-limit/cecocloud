import { Component } from "@angular/core";
import { BngFormConfig } from "base-angular";

import { ProjectesService } from "./projectes.service";

@Component({
  template: `
    <bng-form
      bng-form-mant
      [config]="formConfig"
      [restapiService]="projectesService"
    >
      <div style="display: flex; margin-bottom:20px;">
        <div style="width: 50%; padding-right: 1em">
          <bng-custom-field name="codi"></bng-custom-field>
        </div>
        <div style="width: 50%; padding-right: 1em">
          <bng-custom-field name="nom"></bng-custom-field>
        </div>
      </div>

      <!-- -------------------------------------------------------------------------- -->

      <mat-tab-group>
        <mat-tab label="Datos del proyecto">
          <ng-container *ngTemplateOutlet="fieldsTab1"></ng-container>
        </mat-tab>
        <mat-tab label="Datos técnicos">
          <ng-container *ngTemplateOutlet="fieldsTab2"></ng-container>
        </mat-tab>
        <mat-tab label="Más">
          <ng-container *ngTemplateOutlet="fieldsTab3"></ng-container>
        </mat-tab>
      </mat-tab-group>

      <!-- -------------------------------------------------------------------------- -->

      <ng-template #fieldsTab1>
        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="numero"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="empresa"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="serie"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="referencia"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="codiAlternatiu"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 100%; padding-right: 1em">
            <bng-custom-field name="descripcio"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="responsable"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="divisa"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="divisaValorEuros"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="valorEstimat"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="finalFactura"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="projecteTipus"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="magatzem"></bng-custom-field>
          </div>
        </div>        

        <div style="display: flex">
        <div style="width: 50%; padding-right: 1em">
          <bng-custom-field name="client"></bng-custom-field>
        </div>
        <div style="width: 50%; padding-right: 1em">
          <bng-custom-field name="subClient"></bng-custom-field>
        </div>
      </div>

      <div style="display: flex">
        <div style="width: 50%; padding-right: 1em">
          <bng-custom-field name="clientAdresa"></bng-custom-field>
        </div>
      </div>

      <div style="display: flex">
        <div style="width: 100%; padding-right: 1em">
          <bng-custom-field name="observacions"></bng-custom-field>
        </div>
      </div>
      </ng-template>

      <!-- -------------------------------------------------------------------------- -->      

      <ng-template #fieldsTab2>
        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="direccioTecnica"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="importFianca"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="dipositFianca"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="estat"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="dataInici"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="dataFi"></bng-custom-field>
          </div>
        </div>
        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="dataFiPrevist"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="dataAdjudicacio"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="operariResponsable"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="operariCapGrup"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="operariEncarregat"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="operariAdministratiu"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="contactePersona"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="contacteTelefon"></bng-custom-field>
          </div>
        </div>

        <div style="display: flex">
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="codiPostal"></bng-custom-field>
          </div>
          <div style="width: 50%; padding-right: 1em">
            <bng-custom-field name="adreca"></bng-custom-field>
          </div>
        </div>

       
      </ng-template>

      <!-- -------------------------------------------------------------------------- -->

      <ng-template #fieldsTab3>

      <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="dietes"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="plusPerillositat"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="controlarCostos"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="horesCami"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="dataExecucio"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="dataRecepcioProvisional"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="dataRecepcioFinal"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="dataIniciGarantia"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="dataDevolucioAval"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="horesEquiv"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="horesEquivConstruccio"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="horesEquivGarantia"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="percentExecucioLliure"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field
          name="percentExecucioConstruccio"
        ></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="percentExecucioGarantia"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="zona"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="albaransClientCrear"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="albaransClientPreu"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field
          name="albaransClientProjecteTipus"
        ></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="estudiDespesesGenerals"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="estudiBaixaPercent"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="estudiTasaPercent"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field
          name="estudiSumarValoracioEnExces"
        ></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="mesosGarantia"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="tipusInversio"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="retencioClasse"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="retencioPercent"></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="retencioTipus"></bng-custom-field>
      </div>
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field
          name="comptabilitatCodiProjecte"
        ></bng-custom-field>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 50%; padding-right: 1em">
        <bng-custom-field name="areaNegoci"></bng-custom-field>
      </div>
    </div>
       
      </ng-template>

      
    </bng-form>
  `
})
export class ProjectesFormComponent {
  formConfig: BngFormConfig = {};

  // projecteId: number;

  // onResourceChange(projecte: any) {
  // 	this.projecteId = projecte.codi;
  // }
  constructor(public projectesService: ProjectesService) {}
}
