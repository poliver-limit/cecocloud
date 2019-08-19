import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from '../../shared/material.module';
import { LoginComponent } from './login.component';

@NgModule( {
    imports: [
        CommonModule,
        MaterialModule,
        TranslateModule,
        RouterModule.forChild( [
            { path: '', component: LoginComponent }
        ] )
    ],
    declarations: [
        LoginComponent
    ]
} )
export class LoginModule {}