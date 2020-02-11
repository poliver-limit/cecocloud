import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { IdentificadorsService } from './../identificadors/identificadors.service';
import { IdentificadorsPermissionService } from '../identificadors/identificadors-permission.service';
import { IdentificadorComponent } from './identificador.component';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
		TranslateModule,
        BngModule,
        MaterialModule,
        RouterModule.forChild([
            { path: '', component: IdentificadorComponent, canDeactivate: [BngFormExitGuard] }
        ])
    ],
    declarations: [
        IdentificadorComponent
    ],
    providers: [
        IdentificadorsService,
        IdentificadorsPermissionService
    ]
})
export class IdentificadorModule { }