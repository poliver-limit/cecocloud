import { Component, OnInit, ViewChild, HostListener, ElementRef } from '@angular/core';
import { MdcDrawer, MdcList, MdcIconButton } from '@angular-mdc/web';
import {
    Router,
    Event,
    NavigationEnd
} from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { filter, startWith, tap, delay } from 'rxjs/operators';

import { ScreenSizeService, ScreenSizeChangeEvent } from './shared/screen-size.service';
import { AuthService } from './shared/auth/auth.service';
import { AuthTokenPayload } from './shared/auth/auth-token-payload';

@Component( {
    selector: 'app-root',
    template: `
<mdc-top-app-bar #topbar fixed *ngIf="topbarVisible">
    <mdc-top-app-bar-row>
        <mdc-top-app-bar-section align="start">
            <button #menuButton mdcTopAppBarNavIcon (click)="drawer.open = !drawer.open" *ngIf="smallScreen">
                <mdc-icon>menu</mdc-icon>
            </button>
            <a routerLink="/" mdcTopAppBarTitle style="color: white;">Cecocloud</a>
        </mdc-top-app-bar-section>
        <mdc-top-app-bar-section align="end">
            <a href="/cecocloud/swagger-ui.html" target="_blank" style="text-decoration:none"><mdc-icon mdcTopAppBarActionItem>contact_support</mdc-icon></a>
            <div mdcMenuSurfaceAnchor #userAnchor>
                <mdc-icon #userIcon mdcTopAppBarActionItem title="{{tokenPayload.name}}" (click)="userMenu.open = !userMenu.open">account_circle</mdc-icon>
                <mdc-menu anchorCorner="bottomStart" quickOpen #userMenu [anchorElement]="userAnchor">
                    <mdc-list-group>
                        <mdc-list twoLine interactive="false">
                            <mdc-list-item>
                                <a mdc-fab mini style="margin-right: 1em">{{tokenPayload.name?.charAt(0).toUpperCase()}}</a>
                                <mdc-list-item-text secondaryText="{{tokenPayload.email}}">{{tokenPayload.name}}</mdc-list-item-text>
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
<div #container id="container" [ngClass]="{'topbarMargin': topbarVisible && !smallScreen, 'topbarSmallScreenMargin': topbarVisible && smallScreen}">
    <mdc-drawer #drawer [drawer]="smallScreen ? 'modal' : 'fixed'" fixedAdjustElement="drawerContent" *ngIf="topbarVisible" (closed)="onDrawerClosed()">
        <mdc-drawer-content>
            <mdc-list #menuList>
                <a mdc-list-item [routerLink]="item.route" *ngFor="let item of menuItems; let i = index">
                    <mdc-icon mdcListItemGraphic *ngIf="item.icon">{{item.icon}}</mdc-icon>{{item.label}}
                </a>
            </mdc-list>
        </mdc-drawer-content>
    </mdc-drawer>
    <div id="drawerContent" #drawerContent [ngClass]="{'contentWithStaticDrawer': !smallScreen}">
        <router-outlet></router-outlet>
    </div>
</div>`
} )
export class AppComponent implements OnInit {

    @ViewChild( 'drawer', { static: false } ) drawer: MdcDrawer;
    @ViewChild( 'menuButton', { static: false } ) menuButton: ElementRef;
    @ViewChild( 'menuList', { static: false } ) menulist: MdcList;

    private topbarVisible: boolean = false;
    private smallScreen: boolean = false;
    private tokenPayload: AuthTokenPayload;
    private menuItems = [
        { icon: 'people', label: 'Usuaris', route: '/usuaris' },
        { icon: 'domain', label: 'Companyies', route: '/companyies' },
        { icon: 'business_center', label: 'Empreses', route: '/empreses' },
        { icon: 'people', label: 'Operaris', route: '/operaris' },
        { icon: 'timer', label: 'Marcatges', route: '/marcatges' }
    ];
    private menuSelectedIndex: number;

    ngOnInit() {
        this.screenSizeService.onWindowResize( window.innerWidth );
    }

    onActionSortirClick() {
        if ( confirm( this.translate.instant( 'app.action.logout.confirm' ) ) ) {
            this.authService.logout();
            this.router.navigate( ['/login'] );
        }
    }

    onDrawerClosed() {
        this.menuButton.nativeElement.blur();
    }

    @HostListener( 'window:resize', ['$event'] )
    onWindowResize( event ) {
        this.screenSizeService.onWindowResize( event.target.innerWidth );
    }

    constructor(
        private authService: AuthService,
        private translate: TranslateService,
        private router: Router,
        private screenSizeService: ScreenSizeService ) {
        // Manten actualitzada la informació de l'usuari autenticat
        this.tokenPayload = authService.getAuthTokenPayload();
        authService.authTokenChangeEvent.subscribe(( tokenPayload: AuthTokenPayload ) => {
            this.tokenPayload = tokenPayload;
        } );
        // Configura l'idioma per defecte
        var userLang = navigator.language;
        translate.setDefaultLang( 'ca' );
        translate.use( 'ca' );
        // Oculta la barra superior en la pàgina de login i selecciona l'opcio de menu actual
        router.events.pipe( filter( event => event instanceof NavigationEnd ) ).subscribe(( event: NavigationEnd ) => {
            this.topbarVisible = ( event.url !== '/login' ) && ( !event.url.startsWith( '/registre' ) );
            // Ho posat a dins un setTimeout per a evitar l'error "Expression has changed after it was checked"
            setTimeout(() => {
                this.menuSelectedIndex = undefined;
                for ( let i = 0; i < this.menuItems.length; i++ ) {
                    if ( event.url.startsWith( this.menuItems[i].route ) ) {
                        this.menuSelectedIndex = i;
                        break;
                    }
                }
                if ( this.menuSelectedIndex && this.menulist ) {
                    this.menulist.setSelectedIndex( this.menuSelectedIndex );
                }
            } );
        } );
        // Es subscriu al subject de canvi de tamany de la pantalla
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.smallScreen = event.small
        } );
    }

}
