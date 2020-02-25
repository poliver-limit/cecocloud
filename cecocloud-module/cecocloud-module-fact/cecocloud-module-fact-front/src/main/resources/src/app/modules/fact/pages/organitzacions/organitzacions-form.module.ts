import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { OrganitzacionsFormComponent } from './organitzacions-form.component';
import { OrganitzacionsService } from './organitzacions.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        OrganitzacionsFormComponent
    ],
	entryComponents: [
		OrganitzacionsFormComponent
	],
	exports: [
		OrganitzacionsFormComponent
	],
    providers: [
        OrganitzacionsService
    ]
} )
export class OrganitzacionsFormModule {}