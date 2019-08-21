import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from '../../shared/material.module';
import { RegistreRoutingModule } from './registre.routing';
import { CreateComponent } from './create.component';
import { RecoverComponent } from './recover.component';
import { ValidateComponent } from './validate.component';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MaterialModule,
        RegistreRoutingModule
    ],
    declarations: [
        CreateComponent,
        RecoverComponent,
        ValidateComponent
    ]
} )
export class RegistreModule {}