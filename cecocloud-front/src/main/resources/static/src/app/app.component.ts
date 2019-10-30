import { Component, OnInit, ViewChild, HostListener } from '@angular/core';
import { MatSidenav } from '@angular/material';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { filter } from 'rxjs/operators';
import { BngAuthService, BngAuthTokenPayload, BngScreenSizeService, BngScreenSizeChangeEvent } from 'base-angular';

import { MenuService, MenuItem } from './shared/menu.service';

@Component({
	selector: 'app-root',
	template: `
<header *ngIf="topbarVisible && !mobileScreen">
	<ng-container *ngTemplateOutlet="toolbar_template"></ng-container>
</header>
<mat-sidenav-container>
	<mat-sidenav #sidenav *ngIf="topbarVisible" [mode]="(!mobileScreen) ? 'side' : 'over'" [opened]="!mobileScreen" [ngStyle]="{ 'margin-top' : (topbarVisible && !mobileScreen) ? '64px' : '0', 'width' : '256px'}">
		<nav>
			<mat-nav-list>
				<a mat-list-item *ngFor="let item of allowedMenuItems; let i = index" [routerLink]="item.route">
					<mat-icon style="margin-right:1em">{{item.icon}}</mat-icon>
					<span>{{item.label}}</span>
				</a>
			</mat-nav-list>
		</nav>
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
			<button mat-icon-button>
				<mat-icon>build</mat-icon>
			</button>
			<button mat-button>
				LIM / PRO
				<mat-icon>arrow_drop_down</mat-icon>
			</button>
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
`]
})
export class AppComponent implements OnInit {

	@ViewChild('sidenav', { static: false }) sidenav: MatSidenav;

	topbarVisible: boolean = false;
	mobileScreen: boolean;
	smallToolbar: boolean = false;
	tokenPayload: BngAuthTokenPayload;
	allowedMenuItems: MenuItem[];

	ngOnInit() {
		this.allowedMenuItems = this.menuService.getAllowedMenuItems();
		this.refreshSmallToolbar(window.innerWidth);
		this.screenSizeService.onWindowResize(window.innerWidth);
	}

	onMenuItemClick() {
		this.sidenav.toggle();
	}

	onActionSortirClick() {
		if (confirm(this.translate.instant('app.action.logout.confirm'))) {
			this.tokenPayload = undefined;
			this.allowedMenuItems = [];
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

	constructor(
		private authService: BngAuthService,
		private translate: TranslateService,
		router: Router,
		private screenSizeService: BngScreenSizeService,
		private menuService: MenuService) {
		// Manten actualitzada la informació de l'usuari autenticat
		this.tokenPayload = authService.getAuthTokenPayload();
		authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			this.tokenPayload = tokenPayload;
		});
		// Manten actualitzada la llista d'elements de menu permesos
		menuService.getAllowedMenuItemsChangeSubject().subscribe((allowedMenuItems: MenuItem[]) => {
			this.allowedMenuItems = allowedMenuItems;
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
