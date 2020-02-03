import { Component } from '@angular/core';
import { BngAuthService, BngAuthTokenPayload } from 'base-angular';

@Component({
	selector: 'app-root',
	template: `
<bng-base-app
	appTitle="Marcatges"
	appIcon="touch_app">
</bng-base-app>`
})
export class AppComponent {

	tokenPayload: BngAuthTokenPayload;

	constructor(
		authService: BngAuthService) {
		// Manten actualitzada la informació de l'usuari autenticat
		this.tokenPayload = authService.getAuthTokenPayload();
		authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			this.tokenPayload = tokenPayload;
		});
	}

}
