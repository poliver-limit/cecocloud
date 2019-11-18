import { Injectable } from '@angular/core';

import { BngModuleService } from 'base-angular';

@Injectable( {
    providedIn: 'root'
} )
export class ModuleInitService {

    constructor(moduleService: BngModuleService) {
		moduleService.register({
			code: 'fact',
			icon: 'assignment',
			label: 'Facturació',
			menuItems: [
				{ icon: 'room', label: 'Zones', route: '/fact/zones' }
			]
		});
		moduleService.register({
			code: 'comp',
			icon: 'assessment',
			label: 'Comptabilitat'
		});
		moduleService.register({
			code: 'rrhh',
			icon: 'people_alt',
			label: 'Recursos humans'
		});
		moduleService.register({
			code: 'rrmm',
			icon: 'commute',
			label: 'Recursos de maquinària'
		});
		moduleService.register({
			code: 'banc',
			icon: 'account_balance',
			label: 'Gestió bancària'
		});
		moduleService.register({
			code: 'lici',
			icon: 'work',
			label: 'Licitacions'
		});
		moduleService.register({
			code: 'marc',
			icon: 'touch_app',
			label: 'Marcatges',
			menuItems: [
				{ icon: 'people_alt', label: 'Operaris', route: '/marc/operaris' },
		    	{ icon: 'timer', label: 'Marcatges', route: '/marc/marcatges' }
			]
		});
		moduleService.refreshAllowedModuleItems();
    }

}
