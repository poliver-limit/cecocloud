import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { AvariesGridComponent } from './avaries-grid.component';
import { AvariesFormComponent } from './avaries-form.component';
import { AvariesService } from './avaries.service';

import { AvariesFormModule } from './avaries-form.module';
import { MagatzemsFormModule } from '../magatzems/magatzems-form.module';
import { ProjectesFormModule } from '../projectes/projectes-form.module';
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module';
import { PressupostosFormModule } from '../pressupostos/pressupostos-form.module';
import { CodisPostalFormModule } from '../codisPostal/codisPostal-form.module';
import { SubClientsFormModule } from '../subClients/subClients-form.module';
import { ClientsFormModule } from '../clients/clients-form.module';
import { TallersFormModule } from '../tallers/tallers-form.module';
import { ClientsAdresaFormModule } from '../clientsAdresa/clientsAdresa-form.module';
import { DocumentsPagamentCobramentFormModule } from '../documentsPagamentCobrament/documentsPagamentCobrament-form.module';
import { MantenimentsDeTipusFormModule } from '../mantenimentsDeTipus/mantenimentsDeTipus-form.module';
import { SeriesVendaFormModule } from '../seriesVenda/seriesVenda-form.module';
import { TipusVencimentsFormModule } from '../tipusVenciments/tipusVenciments-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        AvariesFormModule,
        EmpresesFactFormModule,
        PressupostosFormModule,
        CodisPostalFormModule,
        SubClientsFormModule,   
        ClientsFormModule,   
        TallersFormModule,
        ProjectesFormModule,
        MantenimentsDeTipusFormModule,
        TipusVencimentsFormModule,
        ClientsAdresaFormModule,
        DocumentsPagamentCobramentFormModule,
        SeriesVendaFormModule,       
        RouterModule.forChild( [
            { path: '', component: AvariesGridComponent },
            { path: 'create', component: AvariesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: AvariesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        AvariesGridComponent        
    ],
    providers: [
        AvariesService
    ]
} )
export class AvariesModule {}