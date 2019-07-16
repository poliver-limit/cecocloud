import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../../shared/material.module';
import { HomeComponent } from './home.component';

@NgModule( {
    imports: [
        CommonModule,
        RouterModule.forChild( [
            { path: '', component: HomeComponent }
        ] ),
        MaterialModule],
    declarations: [
        HomeComponent]
} )
export class HomeModule {}