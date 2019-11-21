import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Vehicle extends Resource {}

@Injectable()
export class VehiclesService extends BngRestapiService<Vehicle> {

    constructor( injector: Injector ) {
        super( Vehicle, 'vehicle', injector, 'fact' );
    }

}