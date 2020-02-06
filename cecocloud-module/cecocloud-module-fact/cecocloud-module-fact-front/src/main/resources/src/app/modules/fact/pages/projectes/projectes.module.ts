import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';
import { MatCardModule } from '@angular/material/card';
import { MaterialModule } from '../../../../shared/material.module';
import { MatTabsModule } from '@angular/material/tabs';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';
import { ProjectesGridComponent } from './projectes-grid.component';
import { ProjectesFormComponent } from './projectes-form.component';
import { ProjectesService } from './projectes.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        MatTabsModule,
        MatDividerModule,
        MatCardModule,
        MatExpansionModule,
        RouterModule.forChild( [
            { path: '', component: ProjectesGridComponent },
            { path: 'create', component: ProjectesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProjectesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProjectesGridComponent,
        ProjectesFormComponent
    ],
    providers: [
        ProjectesService
    ]
} )
export class ProjectesModule {}