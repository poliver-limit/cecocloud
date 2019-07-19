import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../../shared/material.module';
import { RecuperarContrasenyaComponent } from './recuperarContrasenya.component';

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild([
            { path: '', component: RecuperarContrasenyaComponent }
        ]),
        MaterialModule],
    declarations: [
        RecuperarContrasenyaComponent]
})
export class RecuperarContrasenyaModule { }