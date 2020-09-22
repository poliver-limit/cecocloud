import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { BusinessGroupsFormComponent } from './businessGroups-form.component';
import { BusinessGroupsService } from './businessGroups.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        BusinessGroupsFormComponent
    ],
	entryComponents: [
		BusinessGroupsFormComponent
	],
	exports: [
		BusinessGroupsFormComponent
	],
    providers: [
        BusinessGroupsService
    ]
} )
export class BusinessGroupsFormModule {}