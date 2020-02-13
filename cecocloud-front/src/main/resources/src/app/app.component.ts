import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BngAuthService, BngAuthTokenPayload, BngMenuService, BngMenu } from 'base-angular';

import { AppService } from './shared/app.service';
import { FuncionalitatsPermisosService } from './shared/funcionalitats-permisos/funcionalitats-permisos.service';

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
		console.log("Menu:", menu);
		this.funcionalitatsPermisosService.getAllowedFuncionalitatsByModul(module).subscribe((funcionalitats: string[]) => {
			console.log("Funcionalitats: ", funcionalitats);
			let menuItems = menu.items.filter(item => (item.resource == null || funcionalitats.includes(item.resource)));
			menu.items = menuItems;
			this.menuService.setActiveMenu(menu);
		});
		this.router.navigate(['/' + module]);
	}

	onAdminButtonClick() {
		this.menuService.setActiveGlobalMenu('admin');
		this.router.navigate(['/admin-app']);
	}

	onIdentificadorEmpresaSelected(identificadorEmpresa: any) {
		//console.log('>>> onIdentificadorEmpresaSelected', identificadorEmpresa)
		//this.currentEmpresa = identificadorEmpresa.empresa;
		this.router.navigate(['/']);
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
		private menuService: BngMenuService,
		private funcionalitatsPermisosService: FuncionalitatsPermisosService) {
		// Manten actualitzada la informació de l'usuari autenticat
		this.tokenPayload = authService.getAuthTokenPayload();
		authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			this.tokenPayload = tokenPayload;
			let menu: BngMenu = this.appService.getCurrentRouteMenu();
			console.log("current menu:", menu);
			// if (this.appService.isModuleCurrentMenu) {
			// 	console.log("App Constructor");
			// 	let routerUrl = this.router.url.substring(1);
			// 	let modul = (routerUrl.indexOf("/") != -1) ? routerUrl.substring(0, routerUrl.indexOf("/")) : routerUrl;
			// 	console.log("Modul: ", modul);
			// 	this.funcionalitatsPermisosService.getAllowedFuncionalitatsByModul(modul).subscribe((funcionalitats: string[]) => {
			// 		let menuItems = menu.items.filter(item => (item.resource == null || funcionalitats.includes(item.resource)));
			// 		menu.items = menuItems;
			// 		this.menuService.setActiveMenu(menu);
			// 	});
			// } else {
			this.menuService.setActiveMenu(menu);
			// }
		});
	}

}
