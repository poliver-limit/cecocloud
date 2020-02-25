import { Component, OnInit } from "@angular/core";
import { BngFormConfig } from "base-angular";

import { LicitacionsService } from "./licitacions.service";
import { DocumentsService} from "./documents.service";
import { ActivatedRoute } from "@angular/router";
import { formatDate } from "@angular/common";
import { HalParam } from '@lagoshny/ngx-hal-client';

@Component({
  templateUrl: "licitacio.html"
})
export class LicitacionsFormComponent implements OnInit {
  private id: number;
  licitacio: any;
  tLic: any[] = [];
  tDocs: any[] = [];
  documentos: any[]=[];
  displayedColumns: string[] = ["label", "descripcio"];
  displayedColumnsDoc: string[] = ["nom","tipus", "uri"];

  formConfig: BngFormConfig = {
    readOnlyStateEnabled: true
  };

  ngOnInit(): void {
    this.licitacionsService.whenReady().subscribe(() => {
      this.licitacionsService.get(this.id).subscribe(licitacio => {
        this.licitacio = licitacio;

        console.log("LICITACIÓN: " , this.licitacio);

         if((this.licitacio.url).includes('https://') ){
           this.licitacio.url = this.licitacio.uri;
         }else{
           this.licitacio.url = "https://" + this.licitacio.url;
         }
        this.tLic.push({
          label: "Expediente",
          descripcio: this.licitacio.expedientId
        });
        this.tLic.push({
          label: "Órgano contratación",
          descripcio: this.licitacio.unitatNom
        });
        this.tLic.push({
          label: "Estado",
          descripcio: this.licitacio.expedientEstat
        });
        this.tLic.push({
          label: "Título",
          descripcio: this.licitacio.projecteTitol
        });
        this.tLic.push({
          label: "Importe sin tasas",
          descripcio: this.licitacio.projecteImportSenseTaxes
        });
        this.tLic.push({
          label: "Importe total",
          descripcio: this.licitacio.projecteImportTotal
        });
        this.tLic.push({
          label: "Tipo de contrato",
          descripcio: this.licitacio.projecteTipusDescripcio
        });
        this.tLic.push({
          label: "Lugar de ejecución",
          descripcio:
            this.licitacio.projectePaisDescripcio +
            "/" +
            this.licitacio.projecteProvinciaDescripcio
        });
        this.tLic.push({
          label: "Procedimiento",
          descripcio: this.licitacio.procedimentTipus
        });
        this.tLic.push({
          label: "Fecha actualización",
          descripcio: formatDate(
            this.licitacio.dataActualitzacio,
            "dd/MM/yyyy",
            "en-US"
          )
        });
        this.tLic.push({
          label: "Fecha límite",
          descripcio: formatDate(
            this.licitacio.dataLimit,
            "dd/MM/yyyy",
            "en-US"
          )
        });
        this.tLic.push({
          label: "licitacio.camp.url",          
          descripcio: this.licitacio.url
        });

        this.documentsService.whenReady().subscribe(() => {
          const requestDocParams: HalParam[] = [];
          requestDocParams.push({
			    	key: "query",
				    value: 'licitacio.id=="' + this.licitacio.id + '"'
			    });
          this.documentsService.getAll({ params: requestDocParams }).subscribe((docs) => {
            this.tDocs = docs;
            for(var i=0;i<this.tDocs.length;i++){           
              this.documentos.push(this.tDocs[i].nom, this.tDocs[i].tipus, this.tDocs[i].uri);
            }
          });
        });
      });
    });
  }

  constructor(
    public licitacionsService: LicitacionsService,
    public documentsService: DocumentsService,
    public activatedRoute: ActivatedRoute
  ) {
    activatedRoute.params.subscribe(params => {
      if (params.id) {
        this.id = params.id;
      }
    });
  }
}
