import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../../shared/material.module';
import { LoginComponent } from './login.component';

@NgModule( {
    imports: [
        CommonModule,
        RouterModule.forChild( [
            { path: '', component: LoginComponent }
        ] ),
        MaterialModule],
    declarations: [
        LoginComponent]
} )
export class LoginModule {}