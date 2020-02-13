import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { BngAuthService, BngAuthTokenPayload, BngMenuService, BngMenu, BngModuleService, BngAppModule } from 'base-angular';

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
	initialMenuSelected: boolean;
	changeRouteWhenAllowedModulesChanged: boolean;

	onModuleSelected(module: string) {
		let menu: BngMenu = this.appService.getModuleMenu(module);
		this.menuService.setActiveMenu(menu);
		this.router.navigate(['/' + module]);
	}

	onAdminButtonClick() {
		this.menuService.setActiveGlobalMenu('admin');
		this.router.navigate(['/admin-app']);
	}

	onIdentificadorEmpresaSelected(identificadorEmpresa: any) {
		this.changeRouteWhenAllowedModulesChanged = true;
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
		private moduleService: BngModuleService) {
		// Manten actualitzada la informació de l'usuari autenticat
		this.tokenPayload = authService.getAuthTokenPayload();
		authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			this.tokenPayload = tokenPayload;
		});
		// Canvia la ruta quan canviam la selecció identificador/empresa i s'han acabat de refrescar els mòduls
		this.moduleService.getAllowedModuleItemsChangeSubject().subscribe((modules: BngAppModule[]) => {
			if (this.changeRouteWhenAllowedModulesChanged) {
				if (modules && modules.length === 1) {
					this.moduleService.selectionSet(modules[0].code);
					this.onModuleSelected(modules[0].code);
				} else {
					this.moduleService.selectionClear();
					this.menuService.setActiveMenu(undefined);
					this.router.navigate(['/']);
				}
			}
		});
		// Configura el menu inicial al carregar l'aplicació
		this.router.events.subscribe((event) => {
			if (!this.initialMenuSelected && event instanceof NavigationEnd) {
				let menu: BngMenu = this.appService.getCurrentRouteMenu();
				this.menuService.setActiveMenu(menu);
				this.initialMenuSelected = true;
			}
		});
	}

}
