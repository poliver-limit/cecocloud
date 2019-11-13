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

@Component( {
    template: `
		<bng-form
		    bng-form-mant
		    [config]="formConfig"
		    [restapiService]="perfilsService">
			<form [formGroup]="formGroup" *ngIf="id">
				<mat-form-field style="width:100%;">
					<mat-label>Rols</mat-label>	
					<mat-select #rolsSelect multiple formControlName="rols" (selectionChange)="onSelectionChange($event.value)">    
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
		public perfilRolService: PerfilRolService
	)
	{
		// this.formGroup.get('rols') (retorna formControl) reactive forms
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
								console.log('>>> perfilRols', resposta)
								let selectedIds = [];
								this.profileRoleList.forEach((perfilRol: any) => {
									selectedIds.push(perfilRol.rol.id);
								});
								this.formGroup.get('rols').setValue(selectedIds);
								
								console.log("This.id "+ this.id)
								perfilsService.get(this.id).subscribe((resposta: any) => {
									this.perfil = resposta;							
								})
								
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
	
	onSelectionChange(selection: any) {
//		console.log ("Selection: ",selection)
//		this.profileRoleList.forEach((perfilRol: any) => {
//			this.perfilRolService.delete(perfilRol)
//		});
//		this.perfilRolService.delete(this.profileRoleList)
	}
	
	onOptionClick(rol: any) {
		console.log ("Rol: ",rol)
		
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
			console.log ("Esborrem el perfil de la estructura");
			console.log ("Esborrem el perfil de bbdd");			
		} else {
			
			console.log ("Creem el perfil a bbdd");
			let perfilRol: any = {
				rol: {id: rol.id},
				perfil: {id: this.perfil.id}
			}		
			this.perfilRolService.create(<PerfilRol>perfilRol).subscribe((resposta: any) => {
				console.log ("PerfilRol creat: " , resposta);
			});			
			
			
			
			console.log ("Creem el perfil a la estructura");
			
						
		}
			
		
		
		let requestParams: HalParam[] = [];
		requestParams.push({
			key: 'query',
			value: 'perfil.id==' + this.id + ';rol.id==' + rol.id
		});		
		
		this.perfilRolService.getAll({params: requestParams}).subscribe((resposta: any) => {
			console.log(resposta);
			if (resposta.length>0) {
				console.log ("Esborrem el perfilRol")
				this.perfilRolService.delete(resposta[0]);
			} else {
				console.log ("Creem el perfilRol")
			}
		})
	}

}