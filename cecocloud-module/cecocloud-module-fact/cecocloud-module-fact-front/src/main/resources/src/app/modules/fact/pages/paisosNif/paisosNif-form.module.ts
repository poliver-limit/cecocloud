import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { PaisosNifFormComponent } from './paisosNif-form.component';
import { PaisosNifService } from './paisosNif.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        PaisosNifFormComponent
    ],
	entryComponents: [
		PaisosNifFormComponent
	],
	exports: [
		PaisosNifFormComponent
	],
    providers: [
        PaisosNifService
    ]
} )
export class PaisosNifFormModule {}