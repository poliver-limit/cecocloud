import { Component } from '@angular/core';
import {
    Router,
    Event,
    NavigationEnd
} from '@angular/router';
import { TranslateService } from '@ngx-translate/core';

import { AuthService } from './shared/auth/auth.service';
import { AuthTokenPayload } from './shared/auth/auth-token-payload';

@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
} )
export class AppComponent {

    private topbarVisible: boolean = false;
    private tokenPayload: AuthTokenPayload;

    onMenuSortirClick() {
        if ( confirm( this.translate.instant( 'app.action.logout.confirm' ) ) ) {
            this.authService.logout();
            localStorage.clear();
            this.router.navigate( ['/login'] );
        }
    }

    constructor(
        private authService: AuthService,
        private translate: TranslateService,
        private router: Router ) {
        // Manten actualitzada la informació de l'usuari autenticat
        this.tokenPayload = authService.getAuthTokenPayload();
        authService.authTokenChangeEvent.subscribe(( tokenPayload: AuthTokenPayload ) => {
            this.tokenPayload = tokenPayload;
        } );
        // Configura l'idioma per defecte
        var userLang = navigator.language;
        translate.setDefaultLang( 'ca' );
        translate.use( 'ca' );
        // Oculta la barra superior en la pàgina de login
        router.events.subscribe(( event: Event ) => {
            if ( event instanceof NavigationEnd ) {
                this.topbarVisible = ( event.url !== '/login' ) && ( !event.url.startsWith( '/registre' ) );
            }
        } );
    }

}
