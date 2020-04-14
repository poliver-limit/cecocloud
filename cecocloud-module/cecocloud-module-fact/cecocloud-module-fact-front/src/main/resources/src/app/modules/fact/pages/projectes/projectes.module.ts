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

// Manteniments de tipus 1
import { ProjectesPressupostService } from '../projectesPressupost/projectesPressupost.service';
import { ProjectesTarifaProveidorService } from '../projectesTarifaProveidor/projectesTarifaProveidor.service';
import { ProjectesAplicacioService } from '../projectesAplicacio/projectesAplicacio.service';
import { InversionsSubjectePassiuService } from '../inversionsSubjectePassiu/inversionsSubjectePassiu.service';
import { ProveidorsVencimentService } from '../proveidorsVenciment/proveidorsVenciment.service';
import { HistoricsResponsablesService } from '../historicsResponsables/historicsResponsables.service';

// Creació embeguda sobre LOV fields
import { SeriesVendaFormModule } from '../seriesVenda/seriesVenda-form.module'
import { DivisesFormModule } from '../divises/divises-form.module'
import { FinalFacturesFormModule } from '../finalFactures/finalFactures-form.module'
import { ProjectesTipusFormModule } from '../projectesTipus/projectesTipus-form.module'
import { MagatzemsFormModule } from '../magatzems/magatzems-form.module'
import { ClientsFormModule } from '../clients/clients-form.module'
import { ClassesRetencionsFormModule } from '../classesRetencions/classesRetencions-form.module'
import { AreaNegocisFormModule } from '../areaNegocis/areaNegocis-form.module'
import { SubClientsFormModule } from '../subClients/subClients-form.module'
import { ClientsAdresaFormModule } from '../clientsAdresa/clientsAdresa-form.module'
import { CodisPostalFormModule } from '../codisPostal/codisPostal-form.module'
import { ZonesFormModule } from '../zones/zones-form.module'

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

		SeriesVendaFormModule,
		DivisesFormModule,
		FinalFacturesFormModule,
		ProjectesTipusFormModule,
		MagatzemsFormModule,
		ClientsFormModule,
		ClassesRetencionsFormModule,
		AreaNegocisFormModule,
		SubClientsFormModule,
		ClientsAdresaFormModule,
		CodisPostalFormModule,
		ZonesFormModule,

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
        ProjectesService,

		ProjectesPressupostService,
		ProjectesTarifaProveidorService,
		ProjectesAplicacioService,
		InversionsSubjectePassiuService,
		ProveidorsVencimentService,
		HistoricsResponsablesService
    ]
} )
export class ProjectesModule {}