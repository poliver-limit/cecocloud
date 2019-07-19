import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../../shared/material.module';
import { UsuariNouComponent } from './usuariNou.component';

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild([
            { path: '', component: UsuariNouComponent }
        ]),
        MaterialModule],
    declarations: [
        UsuariNouComponent]
})
export class UsuariNouModule { }