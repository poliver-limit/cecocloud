import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { CategoriesTraduccioService } from './categoriesTraduccio.service';

import { FormGroup } from '@angular/forms';

@Component( {
	templateUrl: 'categoriesTraduccio-form.html'
} )
export class CategoriesTraduccioFormComponent extends BngFormBaseComponent {

	public activarFamilia: boolean = true;
	public activarMarca: boolean = true;
	public activarModel: boolean = true;
	public activarGamma: boolean = true;
	public actius: number = 0;	
	public pepe: "flex";
	activarTot() {		
		this.activarFamilia = true;
		this.activarMarca = true;
		this.activarModel = true;
		this.activarGamma = true;
	}
	
	desactivarTot() {		
		this.activarFamilia = false;
		this.activarMarca = false;
		this.activarModel = false;
		this.activarGamma = false;
	}
	
	onFormGroupChange(formGroup: FormGroup) {

		formGroup.get('familia').valueChanges.subscribe(val => {			
			if (val != null) {
				this.desactivarTot();
				this.activarFamilia = true;
			}
			else {
				if (this.activarFamilia) {
					this.activarTot();
				}
			}		
		});
		
		formGroup.get('marca').valueChanges.subscribe(val => {
			if (val != null) {
				this.desactivarTot();
				this.activarMarca = true;
			}
			else {
				if (this.activarMarca) {
					this.activarTot();
				}
			}		
		});
		
		formGroup.get('model').valueChanges.subscribe(val => {
			if (val != null) {
				this.desactivarTot();
				this.activarModel = true;
			}
			else {
				if (this.activarModel) {
					this.activarTot();
				}
			}		
		});
		
		formGroup.get('gamma').valueChanges.subscribe(val => {
			if (val != null) {
				this.desactivarTot();
				this.activarGamma = true;
			}
			else {
				if (this.activarGamma) {
					this.activarTot();
				}
			}		
		});	
		
	}	
		
	onResourceLoad(categoriaTraduccio: any) {	
		if (categoriaTraduccio.familia!=null) {
			this.desactivarTot();		
			this.activarFamilia = true;
		}
		if (categoriaTraduccio.marca!=null) {
			this.desactivarTot();		
			this.activarMarca = true;
		}
		if (categoriaTraduccio.model!=null) {
			this.desactivarTot();		
			this.activarModel = true;
		}
		if (categoriaTraduccio.gamma!=null) {
			this.desactivarTot();		
			this.activarGamma = true;
		}
	}
			
	formConfig: BngFormConfig = {
	}
	
	constructor(
		activatedRoute: ActivatedRoute,
		public categoriesTraduccioService: CategoriesTraduccioService
	) {
		super(activatedRoute);			
	}

}