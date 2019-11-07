import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { BngAuthService, BngAuthTokenPayload, BngRestapiConfigService } from 'base-angular';

import { AppMenuItem } from './menu.service';

export class ModuleItem {
	code: string;
    icon?: string;
    label: string;
	menuItems?: AppMenuItem[];
}

@Injectable( {
    providedIn: 'root'
} )
export abstract class ModuleService {

    private moduleItems: ModuleItem[] = [{
		code: 'fact',
		icon: 'assignment',
		label: 'Facturació'
	}, {
		code: 'comp',
		icon: 'assessment',
		label: 'Comptabilitat'
	}, {
		code: 'rrhh',
		icon: 'people_alt',
		label: 'Recursos humans'
	}, {
		code: 'rrmm',
		icon: 'commute',
		label: 'Recursos de maquinària'
	}, {
		code: 'banc',
		icon: 'account_balance',
		label: 'Gestió bancària'
	}, {
		code: 'lici',
		icon: 'work',
		label: 'Licitacions'
	}, { 
		code: 'marc',
		icon: 'touch_app',
		label: 'Marcatges',
		menuItems: [
			{ icon: 'people_alt', label: 'Operaris', labelKey: 'app.menu.operaris', route: '/operaris' },
        	{ icon: 'timer', label: 'Marcatges', labelKey: 'app.menu.marcatges', route: '/marcatges' }
		]
	}];
    private allowedModuleItems: ModuleItem[] = [];
    private allowedModuleItemsChangeSubject: Subject<ModuleItem[]> = new Subject<ModuleItem[]>();

    public getAllowedModuleItems() {
        return this.allowedModuleItems;
    }

    public getAllowedModuleItemsChangeSubject(): Subject<ModuleItem[]> {
        return this.allowedModuleItemsChangeSubject;
    }

	public getModuleItem(module: string): ModuleItem {
		let foundModuleItem: ModuleItem;
		this.moduleItems.forEach((moduleItem: ModuleItem) => {
			if (moduleItem.code === module) {
				foundModuleItem = moduleItem;
			}
		});
		return foundModuleItem
	}

    private refreshAllowedModuleItems() {
		this.http.get(this.restapiConfigService.getContextRelativeUrl('/modules')).subscribe((response: string[]) => {
			response.forEach((module: string) => {
				this.moduleItems.forEach((moduleItem: ModuleItem) => {
					if (true || moduleItem.code === module) {
						this.allowedModuleItems.push(moduleItem);
					}
				});
			});
			this.allowedModuleItemsChangeSubject.next( this.allowedModuleItems );
		});
    }

    constructor(
		private http: HttpClient,
		private restapiConfigService: BngRestapiConfigService,
        authService: BngAuthService ) {
        this.refreshAllowedModuleItems();
        authService.getAuthTokenChangeEvent().subscribe(() => {
            this.refreshAllowedModuleItems();
        } );
    }

}
