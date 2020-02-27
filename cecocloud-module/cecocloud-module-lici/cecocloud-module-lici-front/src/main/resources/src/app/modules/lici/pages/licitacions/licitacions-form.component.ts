import { Component, OnInit } from "@angular/core";

import { LicitacionsService } from "./licitacions.service";
import { DocumentsService } from "./documents.service";
import { ActivatedRoute, Router } from "@angular/router";
import { formatDate } from "@angular/common";
import { HalParam } from "@lagoshny/ngx-hal-client";
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Component({
  templateUrl: "licitacio.html"
})
export class LicitacionsFormComponent implements OnInit {
  private id: number;
  licitacio: any;
  tLic: any[] = [];
  tDocs: any[] = [];
  documentos: any[] = [];
  displayedColumns: string[] = ["label", "descripcio"];
  displayedColumnsDoc: string[] = ["nom", "tipus", "uri"];
  private url = window.location.pathname.split("/");
  public licitacioInfo = <any>{};

  ngOnInit(): void {
    this.licitacionsService.whenReady().subscribe(() => {
      this.licitacionsService.get(this.id).subscribe(licitacio => {
        this.licitacio = licitacio;

        if (this.licitacio.url.includes("https://")) {
          this.licitacio.url = this.licitacio.uri;
        } else {
          this.licitacio.url = "https://" + this.licitacio.url;
        }
        this.tLic.push({
          label: "resource.licitacio.field.unitatNom",
          descripcio: this.licitacio.unitatNom
        });
        this.tLic.push({
          label: "resource.licitacio.field.expedientEstat",
          descripcio: this.licitacio.expedientEstat
        });
        this.tLic.push({
          label: "resource.licitacio.field.projecteTitol",
          descripcio: this.licitacio.projecteTitol
        });
        this.tLic.push({
          label: "resource.licitacio.field.projecteImportSenseTaxes",
          descripcio: this.licitacio.projecteImportSenseTaxes
        });
        this.tLic.push({
          label: "resource.licitacio.field.projecteImportTotal",
          descripcio: this.licitacio.projecteImportTotal
        });
        this.tLic.push({
          label: "resource.licitacio.field.projecteTipusDescripcio",
          descripcio: this.licitacio.projecteTipusDescripcio
        });
        this.tLic.push({
          label: "licitacio.camp.llocExecucio",
          descripcio:
            this.licitacio.projectePaisDescripcio +
            "/" +
            this.licitacio.projecteProvinciaDescripcio
        });
        this.tLic.push({
          label: "resource.licitacio.field.procedimentTipus",
          descripcio: this.licitacio.procedimentTipus
        });
        this.tLic.push({
          label: "resource.licitacio.field.dataActualitzacio",
          descripcio: formatDate(
            this.licitacio.dataActualitzacio,
            "dd/MM/yyyy",
            "en-US"
          )
        });
        this.tLic.push({
          label: "resource.licitacio.field.dataLimit",
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
          this.documentsService
            .getAll({ params: requestDocParams })
            .subscribe(docs => {
              this.tDocs = docs;
              for (var i = 0; i < this.tDocs.length; i++) {
                this.documentos.push(
                  this.tDocs[i].nom,
                  this.tDocs[i].tipus,
                  this.tDocs[i].uri
                );
              }
            });
        });
      });
    });
  }

  onButtonBackClick() {
    this.router.navigate(["/lici/licitacio"]);
  }

  changeDestacat(destacada: boolean) {
    const request = this.http
      .patch("/api/lici/licitacions/" + this.url[this.url.length - 1], [
        { op: "replace", path: "/destacada", value: !destacada }
      ])
      .subscribe(
        val => {
          console.log("PATCH call successful, destacat: ", val["destacada"]);
        },
        error => console.log(error),
        () => this.getLicitacio()
      );
  }

  private getLicitacio() {
    const request = this.http
      .get("/api/lici/licitacions/" + this.url[this.url.length - 1])
      .subscribe(res => {
        this.licitacioInfo = res;
      });

    return request;
  }

  constructor(
    public licitacionsService: LicitacionsService,
    public documentsService: DocumentsService,
    public activatedRoute: ActivatedRoute,
    public router: Router,
    private http: HttpClient
  ) {
    activatedRoute.params.subscribe(params => {
      if (params.id) {
        this.id = params.id;
      }
    });

    this.getLicitacio();
  }
}
const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};
