import { Component, OnInit, ViewChild, HostListener, ElementRef } from '@angular/core';
import { MdcDrawer, MdcList, MdcIconButton } from '@angular-mdc/web';
import { Router, Event, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { filter } from 'rxjs/operators';

import { AuthService } from './shared/auth/auth.service';
import { AuthTokenPayload } from './shared/auth/auth-token-payload';
import { ScreenSizeService, ScreenSizeChangeEvent } from './shared/screen-size.service';
import { MenuService, MenuItem } from './shared/menu.service';

@Component( {
    selector: 'app-root',
    template: `
<header>
    <mdc-top-app-bar *ngIf="topbarVisible" fixed [fixedAdjustElement]="content">
        <mdc-top-app-bar-row>
            <mdc-top-app-bar-section align="start">
                <button #menuButton mdcTopAppBarNavIcon (click)="drawer.open = !drawer.open" *ngIf="mobileScreen">
                    <mdc-icon>menu</mdc-icon>
                </button>
                <a routerLink="/" mdcTopAppBarTitle style="color: white;">Cecocloud</a>
            </mdc-top-app-bar-section>
            <mdc-top-app-bar-section align="end">
                <a *ngIf="false" href="/cecocloud/swagger-ui.html" target="_blank" style="text-decoration:none"><mdc-icon mdcTopAppBarActionItem>contact_support</mdc-icon></a>
                <div mdcMenuSurfaceAnchor #userAnchor>
                    <mdc-icon #userIcon mdcTopAppBarActionItem title="{{tokenPayload?.name}}" (click)="userMenu.open = !userMenu.open">account_circle</mdc-icon>
                    <mdc-menu anchorCorner="bottomStart" quickOpen #userMenu [anchorElement]="userAnchor">
                        <mdc-list-group>
                            <mdc-list twoLine interactive="false">
                                <mdc-list-item>
                                    <a mdc-fab mini style="margin-right: 1em">{{tokenPayload?.name.charAt(0).toUpperCase()}}</a>
                                    <mdc-list-item-text secondaryText="{{tokenPayload?.email}}">{{tokenPayload?.name}}</mdc-list-item-text>
                                </mdc-list-item>
                            </mdc-list>
                            <mdc-list-divider></mdc-list-divider>
                            <div style="text-align: center; margin-bottom: 6px">
                                <button mdc-button outlined (click)="onActionSortirClick()" class="logout-button-ink-color">{{'app.action.logout'|translate}}</button>
                            </div>
                        </mdc-list-group>
                    </mdc-menu>
                </div>
            </mdc-top-app-bar-section>
        </mdc-top-app-bar-row>
    </mdc-top-app-bar>
</header>
<nav *ngIf="topbarVisible && mobileScreen">
    <mdc-drawer #drawer drawer="modal" (closed)="onDrawerClosed()">
        <mdc-drawer-content>
            <mdc-list #menuList>
                <a mdc-list-item [routerLink]="item.route" *ngFor="let item of allowedMenuItems; let i = index">
                    <mdc-icon mdcListItemGraphic *ngIf="item.icon">{{item.icon}}</mdc-icon>{{item.label}}
                </a>
            </mdc-list>
        </mdc-drawer-content>
    </mdc-drawer>
</nav>
<div #content id="content">
    <nav>
        <mdc-drawer *ngIf="topbarVisible && !mobileScreen" drawer="fixed" [fixedAdjustElement]="content" (closed)="onDrawerClosed()">
            <mdc-drawer-content>
                <mdc-list #menuList>
                    <a mdc-list-item [routerLink]="item.route" *ngFor="let item of allowedMenuItems; let i = index">
                        <mdc-icon mdcListItemGraphic *ngIf="item.icon">{{item.icon}}</mdc-icon>{{item.label}}
                    </a>
                </mdc-list>
            </mdc-drawer-content>
        </mdc-drawer>
    </nav>
    <main [ngClass]="{'staticDrawerContent': !mobileScreen}">
        <router-outlet></router-outlet>
    </main>
</div>
`,
    styles: [`
#content {
    min-height: calc(100vh - 64px);
}
#content mdc-drawer {
    min-height: calc(100vh - 64px);
    height: calc(100% - 64px);
    position: fixed;
    z-index: 2;
}
main.staticDrawerContent {
    margin-left: 256px;
}
`]
} )
export class AppComponent implements OnInit {

    @ViewChild( 'drawer', { static: false } ) drawer: MdcDrawer;
    @ViewChild( 'menuButton', { static: false } ) menuButton: ElementRef;
    @ViewChild( 'menuList', { static: false } ) menulist: MdcList;
    @ViewChild( 'content', { static: false } ) content: ElementRef;

    topbarVisible: boolean = false;
    mobileScreen: boolean;
    smallToolbar: boolean = false;
    tokenPayload: AuthTokenPayload;
    allowedMenuItems: MenuItem[];

    ngOnInit() {
        this.allowedMenuItems = this.menuService.getAllowedMenuItems();
        this.refreshSmallToolbar( window.innerWidth );
        this.screenSizeService.onWindowResize( window.innerWidth );
    }

    onActionSortirClick() {
        if ( confirm( this.translate.instant( 'app.action.logout.confirm' ) ) ) {
            this.tokenPayload = undefined;
            this.allowedMenuItems = [];
            this.authService.logout();
        }
    }

    onDrawerClosed() {
        this.menuButton.nativeElement.blur();
    }

    @HostListener( 'window:resize', ['$event'] )
    onWindowResize( event ) {
        this.refreshSmallToolbar( event.target.innerWidth );
        this.screenSizeService.onWindowResize( event.target.innerWidth );
    }

    refreshSmallToolbar( windowWidth: number ) {
        this.smallToolbar = windowWidth < 600;
    }

    constructor(
        private authService: AuthService,
        private translate: TranslateService,
        private router: Router,
        private screenSizeService: ScreenSizeService,
        private menuService: MenuService ) {
        // Manten actualitzada la informació de l'usuari autenticat
        this.tokenPayload = authService.getAuthTokenPayload();
        authService.getAuthTokenChangeEvent().subscribe(( tokenPayload: AuthTokenPayload ) => {
            this.tokenPayload = tokenPayload;
        } );
        // Manten actualitzada la llista d'elements de menu permesos
        menuService.getAllowedMenuItemsChangeSubject().subscribe(( allowedMenuItems: MenuItem[] ) => {
            this.allowedMenuItems = allowedMenuItems;
        } );
        // Configura l'idioma per defecte
        var userLang = navigator.language;
        translate.setDefaultLang( 'ca' );
        translate.use( 'ca' );
        // Oculta la barra superior en la pàgina de login i selecciona l'opcio de menu actual
        router.events.pipe( filter( event => event instanceof NavigationEnd ) ).subscribe(( event: NavigationEnd ) => {
            this.topbarVisible = ( event.url !== '/login' ) && ( !event.url.startsWith( '/registre' ) );
            // Oculta la barra superior en dispositius mòbils si no estam a la pàgina principal
            if ( this.mobileScreen && event.url !== '/' ) {
                this.topbarVisible = false;
                this.content.nativeElement.classList.remove( 'mdc-top-app-bar--fixed-adjust' );
            }
            // Ho posat a dins un setTimeout per a evitar l'error "Expression has changed after it was checked"
            setTimeout(() => {
                let menuSelectedIndex = undefined;
                if ( this.allowedMenuItems ) {
                    for ( let i = 0; i < this.allowedMenuItems.length; i++ ) {
                        if ( event.url.startsWith( this.allowedMenuItems[i].route ) ) {
                            menuSelectedIndex = i;
                            break;
                        }
                    }
                    if ( menuSelectedIndex && this.menulist ) {
                        this.menulist.setSelectedIndex( menuSelectedIndex );
                    }
                }
                if ( this.drawer ) {
                    this.drawer.open = false;
                }
            } );
        } );
        // Es subscriu al subject de canvi de tamany de la pantalla
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}
