import { Component } from '@angular/core';
import {
    Router,
    Event,
    NavigationEnd
} from '@angular/router';

import { AuthService } from './shared/auth/auth.service';
import { AuthTokenPayload } from './shared/auth/auth-token-payload';

@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
} )
export class AppComponent {

    private topbarVisible: boolean = false;
    private usuariNom: String;

    onMenuSortirClick() {
        this.authService.logout();
        this.router.navigate( ['/login'] );
    }

    constructor(
        private authService: AuthService,
        private router: Router ) {
        // Manten actualitzat el nom d'usuari
        let payload = authService.getAuthTokenPayload();
        if (payload) {
            this.usuariNom = payload.name;
        }
        authService.authTokenChangeEvent.subscribe(( payload: AuthTokenPayload ) => {
            this.usuariNom = payload.name;
        } );
        // Oculta la barra superior en la pàgina de login
        router.events.subscribe(( event: Event ) => {
            if ( event instanceof NavigationEnd ) {
                this.topbarVisible = ( event.url !== '/login' );
            }
        } );
    }

}
