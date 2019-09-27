import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

import { MdcWebModule } from '../../shared/mdc-web.module';
import { LoginComponent } from './login.component';

@NgModule( {
    imports: [
        CommonModule,
        TranslateModule,
        MdcWebModule,
        RouterModule.forChild( [
            { path: '', component: LoginComponent }
        ] )
    ],
    declarations: [
        LoginComponent
    ]
} )
export class LoginModule {}