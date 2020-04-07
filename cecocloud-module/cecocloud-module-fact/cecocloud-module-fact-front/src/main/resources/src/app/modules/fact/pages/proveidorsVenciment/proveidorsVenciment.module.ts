import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ProveidorsVencimentGridComponent } from './proveidorsVenciment-grid.component';
import { ProveidorsVencimentFormComponent } from './proveidorsVenciment-form.component';
import { ProveidorsVencimentService } from './proveidorsVenciment.service';

import { ProveidorsFormModule } from '../proveidors/proveidors-form.module'
import { TipusVencimentsFormModule } from '../tipusVenciments/tipusVenciments-form.module'

import { ProveidorsVencimentFormModule } from './proveidorsVenciment-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ProveidorsVencimentFormModule,
		ProveidorsFormModule,                   
		TipusVencimentsFormModule,    
        RouterModule.forChild( [
            { path: '', component: ProveidorsVencimentGridComponent },
            { path: 'create', component: ProveidorsVencimentFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProveidorsVencimentFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProveidorsVencimentGridComponent        
    ],
    providers: [
        ProveidorsVencimentService
    ]
} )
export class ProveidorsVencimentModule {}