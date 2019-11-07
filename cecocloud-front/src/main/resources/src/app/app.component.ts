import { Component, OnInit, ViewChild, HostListener } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { filter } from 'rxjs/operators';
import { MatSidenav } from '@angular/material';
import { BngAuthService, BngAuthTokenPayload, BngScreenSizeService, BngScreenSizeChangeEvent, BngModuleService, BngModuleItem } from 'base-angular';

import { MenuService, AppMenu } from './shared/menu.service';
import { ModuleInitService } from './shared/module-init.service';
import { CompanyiesService } from './shared/companyies.service';

@Component({
	selector: 'app-root',
	template: `
<header *ngIf="topbarVisible && !mobileScreen">
	<ng-container *ngTemplateOutlet="toolbar_template"></ng-container>
</header>
<mat-sidenav-container>
	<mat-sidenav #sidenav *ngIf="topbarVisible" [mode]="(!mobileScreen) ? 'side' : 'over'" [opened]="!mobileScreen" [ngStyle]="{ 'margin-top' : (topbarVisible && !mobileScreen) ? '64px' : '0', 'width' : '256px'}">
		<ng-container *ngIf="currentMenu">
			<mat-toolbar>
				<mat-icon *ngIf="currentMenu.icon" style="margin-right:.5em">{{currentMenu.icon}}</mat-icon>
				<span>{{currentMenu.label}}</span>
			</mat-toolbar>
			<mat-divider></mat-divider>
			<nav>
				<mat-nav-list>
					<a mat-list-item *ngFor="let item of currentMenu.menuItems; let i = index" [routerLink]="item.route">
						<mat-icon style="margin-right:1em">{{item.icon}}</mat-icon>
						<span>{{item.label}}</span>
					</a>
				</mat-nav-list>
			</nav>
		</ng-container>
	</mat-sidenav>
	<mat-sidenav-content [ngStyle]="{ 'margin-top' : (topbarVisible) ? (mobileScreen ? '56px' : '64px') : '0'}">
		<header *ngIf="topbarVisible && mobileScreen">
			<ng-container *ngTemplateOutlet="toolbar_template"></ng-container>
		</header>
		<main id="content">
			<router-outlet></router-outlet>
		</main>
	</mat-sidenav-content>
</mat-sidenav-container>
<ng-template #toolbar_template>
	<mat-toolbar id="toolbar" color="primary">
		<button mat-icon-button *ngIf="mobileScreen" (click)="onMenuItemClick()" style="margin-right: .5em">
			<mat-icon>menu</mat-icon>
		</button>
		<span>Cecocloud</span>
		<span class="toolbar-fill"></span>
		<span>
			<!--button mat-icon-button>
				<mat-icon>contact_support</mat-icon>
			</button-->
			<button mat-icon-button (click)="onAdminButtonClick()" style="margin-right:.5em">
				<mat-icon>build</mat-icon>
			</button>
			<button mat-button *ngIf="companyies.length" [matMenuTriggerFor]="companyiaMenu">{{companyies[companyiaSelectedIndex].nom}} <mat-icon>arrow_drop_down</mat-icon></button>
			<mat-menu #companyiaChild="matMenu">
				<ng-template matMenuContent let-index="index">
					<button mat-menu-item (click)="onCompanyiaAdministrarButtonClick(index)"><mat-icon>build</mat-icon> Administrar</button>
				</ng-template>
			</mat-menu>
			<mat-menu #companyiaMenu="matMenu" xPosition="before">
				<button mat-menu-item *ngFor="let companyia of companyies; let i = index" (click)="onCompanyiaButtonClick(i)" [matMenuTriggerFor]="companyiaChild" [matMenuTriggerData]="{index: i}">{{companyia.nom}}</button>
			</mat-menu>
			<!--button mat-button [matMenuTriggerFor]="empresaMenu">Empresa 1 <mat-icon>arrow_drop_down</mat-icon></button>
			<mat-menu #empresaMenu="matMenu" xPosition="before">
				<button mat-menu-item>Empresa 1</button>
				<button mat-menu-item>Empresa 2</button>
				<button mat-menu-item>Empresa 3</button>
				<mat-divider></mat-divider>
				<button mat-menu-item><mat-icon>build</mat-icon> Configurar</button>
			</mat-menu-->
			<button mat-icon-button [matMenuTriggerFor]="modulesMenu" style="margin-right:.5em">
				<mat-icon>apps</mat-icon>
			</button>
			<mat-menu #modulesMenu="matMenu" xPosition="before">
				<button mat-menu-item *ngFor="let item of moduleItems" (click)="onModuleButtonClick(item.code)">
					<mat-icon>{{item.icon}}</mat-icon>
    				<span>{{item.label}}</span>
				</button>
			</mat-menu>
			<button mat-icon-button [matMenuTriggerFor]="userMenu">
				<mat-icon>account_circle</mat-icon>
			</button>
			<mat-menu #userMenu="matMenu">
				<mat-list style="padding-top:0">
					<mat-list-item>
						<ng-container mat-list-icon>
							<button mat-mini-fab>{{tokenPayload?.name.charAt(0).toUpperCase()}}</button>
						</ng-container>
						<h4 mat-line>{{tokenPayload?.name}}</h4>
						<p mat-line>{{tokenPayload?.email}}</p>
					</mat-list-item>
					<mat-divider></mat-divider>
  					<mat-list-item role="listitem">
						<div class="toolbar-fill" style="flex: 1 1 auto; text-align: center">
							<button mat-stroked-button (click)="onActionSortirClick()">{{'app.action.logout'|translate}}</button>
						</div>
					</mat-list-item>
				</mat-list>
			</mat-menu>
		</span>
	</mat-toolbar>
</ng-template>
`,
	styles: [`
#toolbar {
	position: fixed;
	top: 0;
	z-index: 2;
}
#content {
    min-height: calc(100vh - 64px);
}
.toolbar-fill {
	flex: 1 1 auto;
}
`], providers: [
		CompanyiesService
	]
})
export class AppComponent implements OnInit {

	@ViewChild('sidenav', { static: false }) sidenav: MatSidenav;

	companyies: any[] = [];
	companyiaSelectedIndex: number;

	topbarVisible: boolean = false;
	mobileScreen: boolean;
	smallToolbar: boolean = false;
	tokenPayload: BngAuthTokenPayload;
	currentMenu: AppMenu;
	moduleItems: BngModuleItem[];

	ngOnInit() {
		this.currentMenu = this.menuService.getAdminMenu();
		this.refreshSmallToolbar(window.innerWidth);
		this.screenSizeService.onWindowResize(window.innerWidth);
	}

	onMenuItemClick() {
		this.sidenav.toggle();
	}

	onAdminButtonClick() {
		this.moduleService.setSelected();
		this.currentMenu = this.menuService.getAdminMenu();
	}

	onCompanyiaButtonClick(index: number) {
		this.companyiaSelectedIndex = index;
		this.authService.sessionSave({
			companyia: this.companyies[index].id
		});
	}

	onCompanyiaAdministrarButtonClick(index: number) {
		console.log('>>> onCompanyiaAdministrarButtonClick', index);
	}

	onModuleButtonClick(module: string) {
		this.moduleService.setSelected(module);
		this.currentMenu = this.menuService.getModuleMenu(module);
	}

	onActionSortirClick() {
		if (confirm(this.translate.instant('app.action.logout.confirm'))) {
			this.tokenPayload = undefined;
			this.currentMenu = undefined;
			this.authService.logout();
		}
	}

	onSessionIconClick() {
		this.authService.sessionSave({
			companyia: 10,
			empresa: 11
		});
	}

	onDrawerClosed() {
		//this.menuButton.nativeElement.blur();
	}

	@HostListener('window:resize', ['$event'])
	onWindowResize(event: Event) {
		let innerWidth = event.target['innerWidth'];
		this.refreshSmallToolbar(innerWidth);
		this.screenSizeService.onWindowResize(innerWidth);
	}

	refreshSmallToolbar(windowWidth: number) {
		this.smallToolbar = windowWidth < 600;
	}

	updateCompanyies() {
		if (this.tokenPayload) {
			this.companyiesService.whenReady().subscribe(() => {
				this.companyiesService.getAll().subscribe((resposta: any[]) => {
					this.companyies = resposta;
					if (resposta.length) {
						let session: any = this.authService.getSession();
						if (!session || !session.companyia) {
							this.companyiaSelectedIndex = 0;
							this.authService.sessionSave({
								companyia: resposta[0].id
							});
						} else {
							for (let i = 0; i < resposta.length; i++) {
								if (resposta[i].id == session.companyia) {
									this.companyiaSelectedIndex = i;
									break;
								}
							}
						}
					}
				});
			});
		}
	}

	constructor(
		private authService: BngAuthService,
		private translate: TranslateService,
		router: Router,
		private screenSizeService: BngScreenSizeService,
		private menuService: MenuService,
		private moduleService: BngModuleService,
		moduleInitService: ModuleInitService,
		private companyiesService: CompanyiesService) {
		// Manten actualitzada la informació de l'usuari autenticat
		this.tokenPayload = authService.getAuthTokenPayload();
		this.updateCompanyies();
		authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			this.tokenPayload = tokenPayload;
			this.updateCompanyies();
		});
		// Manten actualitzada la llista d'elements de menu
		/*menuService.getAllowedMenuItemsChangeSubject().subscribe((menuItems: MenuItem[]) => {
			this.menuItems = menuItems;
		});*/
		// Manten actualitzada la llista de mòduls disponibles
		moduleService.getAllowedModuleItemsChangeSubject().subscribe((moduleItems: BngModuleItem[]) => {
			this.moduleItems = moduleItems;
		});
		// Configura l'idioma de l'aplicació
		let userLang = navigator.language.substring(0, 2); // 'ca';
		translate.setDefaultLang(userLang);
		translate.use(userLang);
		// Oculta la barra superior en la pàgina de login i selecciona l'opcio de menu actual
		router.events.pipe(filter(event => event instanceof NavigationEnd)).subscribe((event: NavigationEnd) => {
			this.topbarVisible = (event.url !== '/login') && (!event.url.startsWith('/registre'));
			if (this.mobileScreen && this.sidenav) {
				this.sidenav.close();
			}
			// Ho posam a dins un setTimeout per a evitar l'error "Expression has changed after it was checked"
			/*setTimeout(() => {
				let menuSelectedIndex = undefined;
				if (this.allowedMenuItems) {
					for (let i = 0; i < this.allowedMenuItems.length; i++) {
						if (event.url.startsWith(this.allowedMenuItems[i].route)) {
							menuSelectedIndex = i;
							break;
						}
					}
					if (menuSelectedIndex && this.menulist) {
						this.menulist.setSelectedIndex(menuSelectedIndex);
					}
				}
				if (this.drawer) {
					this.drawer.open = false;
				}
			});*/
		});
		// Es subscriu al subject de canvi de tamany de la pantalla
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile
		});
	}

}
