import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgGridModule } from 'ag-grid-angular';
import { TranslateModule } from '@ngx-translate/core';

import { MdcWebModule } from './mdc-web.module';
import { AngularMaterialModule } from './angular-material.module';
import { DatagridComponent } from './datagrid/datagrid.component';
import { DatagridHeaderComponent } from './datagrid/datagrid-header.component';
import { DatagridMantenimentDirective } from './datagrid/datagrid-manteniment.directive';
import { DatagridLinkCellRenderer } from './datagrid/datagrid-link-cell-renderer.component';
import { DatagridRestapiEditorComponent } from './datagrid/datagrid-restapi-editor.component';
import { DatagridRestapiFilterComponent } from './datagrid/datagrid-restapi-filter.component';
import { DatagridRestapiFloatingFilterComponent } from './datagrid/datagrid-restapi-floating-filter.component';
import { RestapiFormComponent } from './restapi-form/restapi-form.component';
import { RestapiFormHeaderComponent } from './restapi-form/restapi-form-header.component';
import { RestapiFormMantenimentDirective } from './restapi-form/restapi-form-manteniment.directive';
import { RestapiFieldMdcwebComponent } from './restapi-form/restapi-field-mdcweb.component';
import { RestapiFieldMaterialComponent } from './restapi-form/restapi-field-material.component';
import { RestapiCustomFieldComponent } from './restapi-form/restapi-custom-field.component';
import { RestapiLovMdcwebComponent } from './restapi-lov/restapi-lov-mdcweb.component';
import { RestapiLovMaterialComponent } from './restapi-lov/restapi-lov-material.component';
import { RestapiLovDialogComponent } from './restapi-lov/restapi-lov-dialog.component';

@NgModule( {
    imports: [
        CommonModule,
        RouterModule,
        FormsModule,
        ReactiveFormsModule,
        MdcWebModule,
        AngularMaterialModule,
        AgGridModule.withComponents( [
            DatagridHeaderComponent,
            DatagridLinkCellRenderer,
            DatagridRestapiEditorComponent,
            DatagridRestapiFilterComponent,
            DatagridRestapiFloatingFilterComponent
        ] ),
        TranslateModule.forChild()
    ],
    declarations: [
        DatagridComponent,
        DatagridHeaderComponent,
        DatagridMantenimentDirective,
        DatagridLinkCellRenderer,
        DatagridRestapiEditorComponent,
        DatagridRestapiFilterComponent,
        DatagridRestapiFloatingFilterComponent,
        RestapiFormComponent,
        RestapiFormHeaderComponent,
        RestapiFormMantenimentDirective,
        RestapiFieldMdcwebComponent,
        RestapiFieldMaterialComponent,
        RestapiCustomFieldComponent,
        RestapiLovMdcwebComponent,
        RestapiLovMaterialComponent,
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
        RestapiFieldMdcwebComponent,
        RestapiFieldMaterialComponent,
        RestapiLovDialogComponent
    ]
} )
export class MantenimentModule {}