import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { GroupsFormComponent } from './groups-form.component';
import { GroupsService } from './groups.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        GroupsFormComponent
    ],
	entryComponents: [
		GroupsFormComponent
	],
	exports: [
		GroupsFormComponent
	],
    providers: [
        GroupsService
    ]
} )
export class GroupsFormModule {}