import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Vehicle extends RestapiResource {}

@Injectable()
export class VehiclesService extends BngRestapiService<Vehicle> {

    constructor( injector: Injector ) {
        super( Vehicle, 'vehicle', injector, 'ecom' );
    }

}