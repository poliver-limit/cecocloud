import { Component } from '@angular/core';
import {
    Router,
    Event,
    NavigationEnd
} from '@angular/router';

import { AuthService } from './shared/auth/auth.service';

@Component( {
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
} )
export class AppComponent {

    private topbarVisible: boolean = false;

    onMenuSortirClick() {
        this.authService.logout();
        this.router.navigate( ['/login'] );
    }

    constructor(
            private authService: AuthService,
            private router: Router ) {
        // Oculta la barra superior en la pàgina de login
        router.events.subscribe(( event: Event ) => {
            if ( event instanceof NavigationEnd ) {
                this.topbarVisible = (event.url !== '/login');
            }
        } );
    }

}
