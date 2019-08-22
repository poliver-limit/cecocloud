import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MdcWebMaterialModule } from '../../shared/mdc-web-material.module';
import { LoginComponent } from './login.component';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MdcWebMaterialModule,
        RouterModule.forChild( [
            { path: '', component: LoginComponent }
        ] )
    ],
    declarations: [
        LoginComponent
    ]
} )
export class LoginModule {}