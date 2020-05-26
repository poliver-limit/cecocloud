import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Apikey extends RestapiResource {}

@Injectable()
export class ApikeysService extends BngRestapiService<Apikey> {

	key: string;

	public store(key: string): void {
		this.key = key;
	}

	public retrieve(): string {
		let key = this.key;
		delete this.key;
		return key;
	}

    constructor( injector: Injector ) {
        super( Apikey, 'apiKey', injector );
    }

}