import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../../shared/material.module';
import { ValidarUsuariComponent } from './validarUsuari.component';

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild([
            { path: '', component: ValidarUsuariComponent }
        ]),
        MaterialModule],
    declarations: [
        ValidarUsuariComponent]
})
export class ValidarUsuariModule { }