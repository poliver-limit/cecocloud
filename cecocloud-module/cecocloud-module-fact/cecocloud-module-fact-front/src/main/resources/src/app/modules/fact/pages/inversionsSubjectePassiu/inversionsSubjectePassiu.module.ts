import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { InversionsSubjectePassiuGridComponent } from './inversionsSubjectePassiu-grid.component';
import { InversionsSubjectePassiuFormComponent } from './inversionsSubjectePassiu-form.component';
import { InversionsSubjectePassiuService } from './inversionsSubjectePassiu.service';

import { ProveidorsFormModule } from '../proveidors/proveidors-form.module';

import { InversionsSubjectePassiuFormModule } from './inversionsSubjectePassiu-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		InversionsSubjectePassiuFormModule,
		ProveidorsFormModule,	  
        RouterModule.forChild( [
            { path: '', component: InversionsSubjectePassiuGridComponent },
            { path: 'create', component: InversionsSubjectePassiuFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: InversionsSubjectePassiuFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        InversionsSubjectePassiuGridComponent        
    ],
    providers: [
        InversionsSubjectePassiuService
    ]
} )
export class InversionsSubjectePassiuModule {}