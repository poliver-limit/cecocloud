import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../../shared/material.module';
import { HomeComponent } from './home.component';

@NgModule( {
    imports: [
        CommonModule,
        MaterialModule,
        RouterModule.forChild( [
            { path: '', component: HomeComponent }
        ] )],
    declarations: [
        HomeComponent]
} )
export class HomeModule {}