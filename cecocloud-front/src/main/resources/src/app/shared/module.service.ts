import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { BngAuthService, BngRestapiConfigService } from 'base-angular';

export class ModuleMenuItem {
    icon?: string;
    label: string;
    labelKey: string;
    route?: string;
    onlyForRoles?: string[];
}

export class ModuleItem {
	code: string;
    icon?: string;
    label: string;
	menuItems?: ModuleMenuItem[];
}

@Injectable( {
    providedIn: 'root'
} )
export class ModuleService {

	private selected: ModuleItem;
	private availableModuleItems: ModuleItem[] = [];
    private allowedModuleItems: ModuleItem[] = [];
    private allowedModuleItemsChangeSubject: Subject<ModuleItem[]> = new Subject<ModuleItem[]>();

	public register(moduleItem: ModuleItem) {
		this.availableModuleItems.push(moduleItem);
	}

    public getAllowedModuleItems() {
        return this.allowedModuleItems;
    }

    public getAllowedModuleItemsChangeSubject(): Subject<ModuleItem[]> {
        return this.allowedModuleItemsChangeSubject;
    }

	public getModuleItem(module: string): ModuleItem {
		let foundModuleItem: ModuleItem;
		this.availableModuleItems.forEach((moduleItem: ModuleItem) => {
			if (moduleItem.code === module) {
				foundModuleItem = moduleItem;
			}
		});
		return foundModuleItem
	}

	public setSelected(module?: string) {
		if (module) {
			this.selected = this.getModuleItem(module);
		} else {
			this.selected = undefined;
		}
	}

	public removeSelected() {
		this.setSelected()
	}

	public getSelected(): ModuleItem {
		return this.selected;
	}

    public refreshAllowedModuleItems() {
		this.allowedModuleItems.splice(0, this.allowedModuleItems.length);
		if (this.authService.getAuthTokenPayload()) {
			this.http.get(this.restapiConfigService.getContextRelativeUrl('/modules')).subscribe((response: string[]) => {
				response.forEach((module: string) => {
					this.availableModuleItems.forEach((moduleItem: ModuleItem) => {
						if (moduleItem.code === module) {
							this.allowedModuleItems.push(moduleItem);
						}
					});
				});
				this.allowedModuleItemsChangeSubject.next( this.allowedModuleItems );
			});
		}
    }

    constructor(
		private http: HttpClient,
		private restapiConfigService: BngRestapiConfigService,
        private authService: BngAuthService ) {
        authService.getAuthTokenChangeEvent().subscribe(() => {
        	this.refreshAllowedModuleItems();
        } );
    }

}
