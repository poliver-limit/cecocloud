import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { AlbaransFormComponent } from '../albarans/albarans-form.component';
import { ClientsFormComponent } from '../clients/clients-form.component';
import { ClientsAdresaFormComponent } from '../clientsAdresa/clientsAdresa-form.component';
import { CodisPostalFormComponent } from '../codisPostal/codisPostal-form.component';
import { DocumentsPagamentCobramentFormComponent } from '../documentsPagamentCobrament/documentsPagamentCobrament-form.component';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';
import { MantenimentsDeTipusFormComponent } from '../mantenimentsDeTipus/mantenimentsDeTipus-form.component';
import { PressupostosFormComponent } from '../pressupostos/pressupostos-form.component';
import { ProjectesFormComponent } from '../projectes/projectes-form.component';
import { SeriesVendaFormComponent } from '../seriesVenda/seriesVenda-form.component';
import { SubClientsFormComponent } from '../subClients/subClients-form.component';
import { TallersFormComponent } from '../tallers/tallers-form.component';
import { TipusVencimentsFormComponent } from '../tipusVenciments/tipusVenciments-form.component';

import { AvariesService } from './avaries.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="avariesService"></bng-form>
`
} )
export class AvariesFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        activatedRoute: ActivatedRoute,
        public avariesService: AvariesService) {
        super(activatedRoute);
        this.setConfigExternalFormComponents([
            { resourceName: 'empresa', component: EmpresesFactFormComponent },
            { resourceName: 'pressupost', component: PressupostosFormComponent },
            { resourceName: 'codiPostal', component: CodisPostalFormComponent },
            { resourceName: 'subClient', component: SubClientsFormComponent },
            { resourceName: 'client', component: ClientsFormComponent },
            { resourceName: 'taller', component: TallersFormComponent },
            { resourceName: 'projecte', component: ProjectesFormComponent },
            { resourceName: 'albara', component: AlbaransFormComponent },
            { resourceName: 'mantenimentDeTipus', component: MantenimentsDeTipusFormComponent },
            { resourceName: 'tipusVenciment', component: TipusVencimentsFormComponent },
            { resourceName: 'clientAdresa', component: ClientsAdresaFormComponent },
            { resourceName: 'documentPagamentCobrament', component: DocumentsPagamentCobramentFormComponent },
            { resourceName: 'serieVenda', component: SeriesVendaFormComponent }
        ]);
    }
}