import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgGridModule } from 'ag-grid-angular';
import { TranslateModule } from '@ngx-translate/core';

import { MaterialModule } from './material.module';
import { DatagridComponent } from './datagrid/datagrid.component';
import { DatagridHeaderComponent } from './datagrid/datagrid-header.component';
import { DatagridMantenimentDirective } from './datagrid/datagrid-manteniment.directive';
import { DatagridLinkCellRenderer } from './datagrid/datagrid-link-cell-renderer.component';
import { RestapiFormComponent } from './restapi-form/restapi-form.component';
import { RestapiFormHeaderComponent } from './restapi-form/restapi-form-header.component';
import { RestapiFormMantenimentDirective } from './restapi-form/restapi-form-manteniment.directive';
import { RestapiFormErrorsDialogComponent } from './restapi-form/restapi-form-errors-dialog.component';
import { RestapiDefaultFieldComponent } from './restapi-form/restapi-default-field.component';
import { RestapiCustomFieldComponent } from './restapi-form/restapi-custom-field.component';
import { RestapiLovComponent } from './restapi-lov/restapi-lov.component';
import { RestapiLovDialogComponent } from './restapi-lov/restapi-lov-dialog.component';

@NgModule( {
    imports: [
        CommonModule,
        RouterModule,
        FormsModule,
        ReactiveFormsModule,
        MaterialModule,
        AgGridModule.withComponents( [
            DatagridHeaderComponent,
            DatagridLinkCellRenderer
        ] ),
        TranslateModule.forChild()
    ],
    declarations: [
        DatagridComponent,
        DatagridHeaderComponent,
        DatagridMantenimentDirective,
        DatagridLinkCellRenderer,
        RestapiFormComponent,
        RestapiFormHeaderComponent,
        RestapiFormMantenimentDirective,
        RestapiFormErrorsDialogComponent,
        RestapiDefaultFieldComponent,
        RestapiCustomFieldComponent,
        RestapiLovComponent,
        RestapiLovDialogComponent
    ],
    exports: [
        DatagridComponent,
        DatagridMantenimentDirective,
        RestapiFormComponent,
        RestapiCustomFieldComponent,
        RestapiFormMantenimentDirective,
    ],
    entryComponents: [
        RestapiDefaultFieldComponent,
        RestapiFormErrorsDialogComponent,
        RestapiLovDialogComponent
    ]
} )
export class MantenimentModule {}