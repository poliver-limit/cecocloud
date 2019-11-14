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

import { Perfil, PerfilsService } from './perfils.service';
import { Rol, RolsService } from './rols.service';
import { PerfilRol, PerfilRolService } from './perfilRol.service';
import { HttpClient } from '@angular/common/http';

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
						<mat-option *ngFor="let role of roleList" [value]="role.id" (click)="onOptionClick(role)">
							{{role.descripcio}}
						</mat-option>
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
	perfil: any; 
	roleList: any;
	profileRoleList: any;

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
		public perfilRolService: PerfilRolService,
		private http: HttpClient
	)
	{		
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;				
				rolsService.whenReady().subscribe(() => {
					rolsService.getAll().subscribe((resposta: any) => {		
						this.roleList = resposta;			
						
						perfilRolService.whenReady().subscribe(() => {
							let requestParams: HalParam[] = [];
							requestParams.push({
								key: 'query',
								value: 'perfil.id==' + this.id
							});
							
							perfilRolService.getAll({params: requestParams}).subscribe((resposta: any) => {
								this.profileRoleList = resposta;								
								
								let selectedIds = [];
								this.profileRoleList.forEach((perfilRol: any) => {
									selectedIds.push(perfilRol.rol.id);
								});
								this.formGroup.get('rols').setValue(selectedIds);								
								
								perfilsService.get(this.id).subscribe((resposta: any) => {
									this.perfil = resposta;							
								})							
						
							});
						});						
					});
				});
				
							
			}
		});		
	}
	
	onOptionClick(rol: any) {		
		
		let i = 0;
		let found = false;
		while (!found && i<this.profileRoleList.length) {
			if (this.profileRoleList[i].rol.id==rol.id) {
				found = true;
			} else {
				i++;
			}
		}
		
		if (found) {			
					
			// Eliminar perfilRol de la BBDD			
//			this.http.delete (this.profileRoleList[i]._links.self.href).subscribe((resposta: any) => {
			this.perfilRolService.deleteById(this.profileRoleList[i].id).subscribe((resposta: any) => {		
				
				// Eliminar perfilRol de l'estructura			
				this.profileRoleList.splice(i,1);				
				
			});		
			
		} else {
			
			// Creació perfilRol a la BBDD
			let perfilRol: any = { rol: {id: rol.id}, perfil: {id: this.perfil.id} }			
			this.perfilRolService.create(<PerfilRol>perfilRol).subscribe((resposta: any) => {							
							
				// Creació del perfilRol a la estructura								
				let perfilRolObj = new PerfilRol;		
				perfilRolObj["id"] = resposta.id;		
				perfilRolObj["rol"] = {id:resposta.rol.id};
				perfilRolObj["perfil"] = {id:resposta.perfil.id};
//				perfilRolObj["_links"] = resposta._links			
						
				this.profileRoleList.push(perfilRolObj);				
						
			});			
			
			
						
		}	

	}

}