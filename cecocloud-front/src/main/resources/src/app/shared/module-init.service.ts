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
				{ icon: 'room', label: 'Zones', route: '/fact/zones' },
				{ icon: 'room', label: 'Codis postals', route: '/fact/codisPostal' },
				{ icon: 'room', label: 'Divises', route: '/fact/divises' },
				{ icon: 'room', label: 'Documents de pagament / cobrament', route: '/fact/documentsPagamentCobrament' },
				{ icon: 'room', label: 'Families de proveidors', route: '/fact/familiesProveidor' },
				{ icon: 'room', label: 'Iva', route: '/fact/ives' },
				{ icon: 'room', label: 'Naturaleses de pagament / cobrament', route: '/fact/naturalesesPagamentCobrament' },
				{ icon: 'room', label: 'Països', route: '/fact/paisos' },
				{ icon: 'room', label: 'Proveidors', route: '/fact/proveidors' },
				{ icon: 'room', label: 'Províncies', route: '/fact/provincies' },
				{ icon: 'room', label: 'Règims d\'iva', route: '/fact/regimsIva' },
				{ icon: 'room', label: 'Tipus de venciment', route: '/fact/tipusVenciments' },
				{ icon: 'room', label: 'Transportistes', route: '/fact/transportistes' },				
				{ icon: 'room', label: 'Unitats tipus', route: '/fact/unitatsTipus' },
				{ icon: 'room', label: 'Vehicles', route: '/fact/vehicles' }
				
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
