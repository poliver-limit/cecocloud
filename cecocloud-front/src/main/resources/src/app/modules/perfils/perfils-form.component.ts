// (MGG) -> Els comentaris(//) son simplement resultat de proves
// per inici formació en Angular. Es futuriblement per esborrar
import { Component } from '@angular/core';
//import { ViewChild, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig } from 'base-angular';
import { FormBuilder, FormGroup } from '@angular/forms';
//import { Validators } from '@angular/forms';
import { HalParam } from 'angular4-hal';
//import { MatSelect } from '@angular/material/select';

import { PerfilsService } from './perfils.service';
import { RolsService } from './rols.service';
import { PerfilRolService } from './perfilRol.service';

@Component( {
    template: `
		<bng-form
		    bng-form-mant
		    [config]="formConfig"
		    [restapiService]="perfilsService">
			<form [formGroup]="formGroup" *ngIf="id">
				<mat-form-field style="width:100%;">
					<mat-label>Rols</mat-label>	
					<mat-select #rolsSelect multiple formControlName="rols">    
						<mat-option *ngFor="let role of roleList" [value]="role.id">{{role.descripcio}}</mat-option>
					</mat-select>
				</mat-form-field>
			</form>
		</bng-form>
	`
} )

export class PerfilsFormComponent
//implements OnInit
{

//	@ViewChild('rolsSelect', { static: false }) rolsSelect: MatSelect;	
//	ngOnInit() {		
//	}

	id: any;
	roleList: any;

    formConfig: BngFormConfig = {
    }

	formGroup: FormGroup = this.formBuilder.group({
		rols: ['']
	});	

    constructor(
		private formBuilder: FormBuilder,
		activatedRoute: ActivatedRoute,
        public perfilsService: PerfilsService,
        public rolsService: RolsService,
		public perfilRolService: PerfilRolService
	)
	{
		// this.formGroup.get('rols') (retorna formControl) reactive forms
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;
				rolsService.whenReady().subscribe(() => {
					rolsService.getAll().subscribe((resposta: any) => {		
						this.roleList = resposta					
						
						perfilRolService.whenReady().subscribe(() => {
							let requestParams: HalParam[] = [];
							requestParams.push({
								key: 'query',
								value: 'perfil.id==' + this.id
							});
							
							perfilRolService.getAll({params: requestParams}).subscribe((resposta: any) => {
//								console.log('>>> perfilRols', resposta)
								let selectedIds = [];
								resposta.forEach((perfilRol: any) => {
									selectedIds.push(perfilRol.rol.id);
								});
								this.formGroup.get('rols').setValue(selectedIds);
								
//								for (var i=0;i<resposta.length;i++) {
//									console.log(resposta[i].rol.id)
//									this.rolsSelected.push(resposta[i].rol.id)
//								}
//								console.log(">>> rolsSelected: ", this.rolsSelected)
//								console.log('>>> rolsSelect', this.rolsSelect);								
							});
						});						
					});
				});
				
							
			}
		});		
	}	

}