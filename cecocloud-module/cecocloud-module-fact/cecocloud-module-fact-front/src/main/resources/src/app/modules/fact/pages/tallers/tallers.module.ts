import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TallersGridComponent } from './tallers-grid.component';
import { TallersFormComponent } from './tallers-form.component';
import { TallersService } from './tallers.service';

import { TallersFormModule } from './tallers-form.module';
import { MagatzemsFormModule } from '../magatzems/magatzems-form.module';
import { ProjectesFormModule } from '../projectes/projectes-form.module';
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        TallersFormModule,
        EmpresesFactFormModule,
        MagatzemsFormModule,
        ProjectesFormModule,
        RouterModule.forChild( [
            { path: '', component: TallersGridComponent },
            { path: 'create', component: TallersFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TallersFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TallersGridComponent        
    ],
    providers: [
        TallersService
    ]
} )
export class TallersModule {}