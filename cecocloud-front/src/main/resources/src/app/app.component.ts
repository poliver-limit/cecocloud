import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BngAuthService, BngAuthTokenPayload, BngMenuService, BngMenu } from 'base-angular';

import { AppService } from './shared/app.service';

@Component({
	selector: 'app-root',
	template: `
<bng-base-app
	appTitle="Cecocloud"
	appIcon="cloud_queue"
	(moduleSelected)="onModuleSelected($event)">
	<button mat-icon-button *ngIf="tokenPayload?.rol.includes('ADMIN')" (click)="onAdminButtonClick()" style="margin-right:.5em">
		<mat-icon>build</mat-icon>
	</button>
	<selector-identificador-empresa
		(identificadorEmpresaSelected)="onIdentificadorEmpresaSelected($event)"
		(identificadorAdminSelected)="onIdentificadorAdminSelected($event)">
	</selector-identificador-empresa>
</bng-base-app>`
})
export class AppComponent {

	tokenPayload: BngAuthTokenPayload;

	onModuleSelected(module: string) {
		let menu: BngMenu = this.appService.getModuleMenu(module);
		this.menuService.setActiveMenu(menu);
		this.router.navigate(['/' + module]);
	}

	onAdminButtonClick() {
		let menu: BngMenu = this.appService.getAdminMenu();
		this.menuService.setActiveMenu(menu);
		this.router.navigate(['/admin-app']);
	}

	onIdentificadorEmpresaSelected(identificadorEmpresa: any) {
		console.log('>>> onIdentificadorEmpresaSelected', identificadorEmpresa)
		//this.currentEmpresa = identificadorEmpresa.empresa;
	}

	onIdentificadorAdminSelected(identificador: any) {
		let menu: BngMenu = this.appService.getAdminIdentificadorMenu();
		menu.label = identificador.descripcio;
		this.menuService.setActiveMenu(menu);
		this.router.navigate(['/admin-identificador']);
	}

	constructor(
		authService: BngAuthService,
		private router: Router,
		private appService: AppService,
		private menuService: BngMenuService) {
		// Manten actualitzada la informació de l'usuari autenticat
		this.tokenPayload = authService.getAuthTokenPayload();
		authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			this.tokenPayload = tokenPayload;
			let menu: BngMenu = this.appService.getCurrentRouteMenu();
			this.menuService.setActiveMenu(menu);
		});
	}

}
