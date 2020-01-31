import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BngAuthService, BngMenuService, BngModuleService, BngMenu, BngAppModule } from 'base-angular';

import { IdentificadorsService } from '../pages/identificadors/identificadors.service';

@Injectable({
	providedIn: 'root'
})
export class AppService {

	adminMenu: BngMenu = {
		icon: 'build',
		label: 'Administració',
		labelKey: 'app.menu.admin',
		items: [{
			icon: 'people',
			label: 'Usuaris',
			labelKey: 'app.menu.usuaris',
			resource: 'usuari',
			route: '/usuaris'
		}, {
			icon: 'domain',
			label: 'Grups d\'empreses',
			labelKey: 'app.menu.identificadors',
			resource: 'identificador',
			route: '/identificadors'
		}]
	}

	adminIdentificadorMenu: BngMenu = {
		icon: 'build',
		label: '...',
		items: [{
			icon: 'domain',
			label: 'Grups d\'empreses',
			labelKey: 'app.menu.identificador',
			route: '/identificador'
		}, {
			icon: 'people',
			label: 'Usuaris',
			labelKey: 'app.menu.usuaris',
			route: '/usuari-identificadors'
		}, {
			icon: 'business_center',
			label: 'Empreses',
			labelKey: 'app.menu.empreses',
			resource: 'empresa',
			route: '/empreses'
		}, {
			icon: 'portrait',
			label: 'Perfils',
			labelKey: 'app.menu.perfils',
			route: '/perfils'
		}]
	}

	public getAdminMenu(): BngMenu {
		return this.adminMenu;
	}

	public getAdminIdentificadorMenu(): BngMenu {
		return this.adminIdentificadorMenu;
	}

	public getCurrentRouteMenu(): BngMenu {
		let found: boolean = false;
		if (this.router.url.startsWith('/admin-app')) {
			found = true;
		} else {
			this.adminMenu.items.forEach((menuItem: BngMenu) => {
				if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
					found = true;
				}
			});
		}
		if (found) {
			return this.adminMenu;
		} else {
			found = false;
			if (this.router.url.startsWith('/admin-identificador')) {
				found = true;
			} else {
				this.adminIdentificadorMenu.items.forEach((menuItem: BngMenu) => {
					if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
						found = true;
					}
				});
			}
		}
		if (found) {
			let session: any = this.authService.getSession();
			if (session) {
				this.identificadorsService.whenReady().subscribe(() => {
					this.identificadorsService.get(session.i).subscribe((resposta: any) => {
						this.adminIdentificadorMenu.label = resposta.descripcio;
					});
				});
			}
			return this.adminIdentificadorMenu;
		} else {
			let routerUrl = this.router.url.substring(1);
			let modul = (routerUrl.indexOf("/") != -1) ? routerUrl.substring(0, routerUrl.indexOf("/")) : routerUrl;
			return this.getModuleMenu(modul);
		}
	}

	public getModuleMenu(module: string): BngMenu {
		let moduleItem: BngAppModule = this.moduleService.getModuleItem(module);
		if (moduleItem) {
			return <BngMenu>{
				icon: moduleItem.icon,
				label: moduleItem.label,
				labelKey: 'app.module.' + module,
				items: moduleItem.menuItems
			};
		}
	}

	private registerGlobalMenus() {
		this.menuService.registerGlobal('admin', this.adminMenu);
		this.menuService.registerGlobal('admin-idf', this.adminIdentificadorMenu);
	}

	private registerAvailableModules() {
		this.moduleService.register({
			code: 'fact',
			icon: 'assignment',
			label: 'Facturació',
			menuItems: [
				{ icon: 'room', label: 'Albarans', route: '/fact/albarans' },
				{ icon: 'room', label: 'Articles', route: '/fact/articles' },
				{ icon: 'room', label: 'Articles família', route: '/fact/articlesFamilia' },
				{ icon: 'room', label: 'Articles família empresa', route: '/fact/articlesFamiliaEmpresa' },
				{ icon: 'room', label: 'Articles gamma', route: '/fact/articlesGamma' },
				{ icon: 'room', label: 'Articles marca', route: '/fact/articlesMarca' },
				{ icon: 'room', label: 'Articles model', route: '/fact/articlesModel' },
				{ icon: 'room', label: 'Codis postals', route: '/fact/codisPostal' },
				{ icon: 'room', label: 'Departaments', route: '/fact/departaments' },
				{ icon: 'room', label: 'Divises', route: '/fact/divises' },
				{ icon: 'room', label: 'Documents de pagament/cobrament', route: '/fact/documentsPagamentCobrament' },
				{ icon: 'room', label: 'Empreses (Facturació)', route: '/fact/empreses' },
				{ icon: 'room', label: 'Famílies cost', route: '/fact/familiesCost' },
				{ icon: 'room', label: 'Famílies proveidor', route: '/fact/familiesProveidor' },
				{ icon: 'room', label: 'Idiomes', route: '/fact/idiomes' },
				{ icon: 'room', label: 'Iva', route: '/fact/ives' },
				{ icon: 'room', label: 'Magatzems', route: '/fact/magatzems' },
				{ icon: 'room', label: 'Magatzems període', route: '/fact/magatzemsPeriode' },
				{ icon: 'room', label: 'Naturaleses de pagament/cobrament', route: '/fact/naturalesesPagamentCobrament' },
				{ icon: 'room', label: 'Països', route: '/fact/paisos' },
				{ icon: 'room', label: 'Peus de document', route: '/fact/peusDocument' },
				{ icon: 'room', label: 'Projectes', route: '/fact/projectes' },
				{ icon: 'room', label: 'Proveidors', route: '/fact/proveidors' },
				{ icon: 'room', label: 'Províncies', route: '/fact/provincies' },
				{ icon: 'room', label: 'Règims d\'iva', route: '/fact/regimsIva' },
				{ icon: 'room', label: 'Seccions empresa', route: '/fact/seccionsEmpresa' },
				{ icon: 'room', label: 'Sèries de compra', route: '/fact/seriesCompra' },
				{ icon: 'room', label: 'Sèries intracomunitàries', route: '/fact/seriesIntracomunitaria' },
				{ icon: 'room', label: 'Sèries de venda', route: '/fact/seriesVenda' },
				{ icon: 'room', label: 'Situacions comercials', route: '/fact/situacionsComercial' },
				{ icon: 'room', label: 'Situacions inicials', route: '/fact/situacionsInicial' },
				{ icon: 'room', label: 'Subvencions', route: '/fact/subvencions' },
				{ icon: 'room', label: 'Tarifes', route: '/fact/tarifes' },
				{ icon: 'room', label: 'Tarifes descompte', route: '/fact/tarifesDescompte' },
				{ icon: 'room', label: 'Tipus de comissió', route: '/fact/tipusComissions' },
				{ icon: 'room', label: 'Tipus de facturació', route: '/fact/tipusFacturacions' },
				{ icon: 'room', label: 'Tipus d\'incidencia factura', route: '/fact/tipusIncidenciesFactura' },
				{ icon: 'room', label: 'Tipus de proveïdor/client', route: '/fact/tipusProveidorsClient' },
				{ icon: 'room', label: 'Tipus de riscos', route: '/fact/tipusRiscos' },
				{ icon: 'room', label: 'Tipus de venciments', route: '/fact/tipusVenciments' },
				{ icon: 'room', label: 'Transportistes', route: '/fact/transportistes' },
				{ icon: 'room', label: 'Ubicacions', route: '/fact/ubicacions' },
				{ icon: 'room', label: 'Ubicacions articles', route: '/fact/ubicacionsArticle' },
				{ icon: 'room', label: 'Unitats tipus', route: '/fact/unitatsTipus' },
				{ icon: 'room', label: 'Vehicles', route: '/fact/vehicles' },
				{ icon: 'room', label: 'Zones (Facturació)', route: '/fact/zones' }

			]
		});
		this.moduleService.register({
			code: 'comp',
			icon: 'assessment',
			label: 'Comptabilitat'
		});
		this.moduleService.register({
			code: 'rrhh',
			icon: 'people_alt',
			label: 'Recursos humans',
			menuItems: [{
				icon: 'room',
				label: 'Calendaris',
				labelKey: 'app.menu.rrhh.calendaris',
				route: '/rrhh/calendaris'
			}, {
				icon: 'room',
				label: 'Categories',
				labelKey: 'app.menu.rrhh.categories',
				route: '/rrhh/categories'
			}, {
				icon: 'room',
				label: 'Grups festius',
				labelKey: 'app.menu.rrhh.grupsFestius',
				route: '/rrhh/grupsFestiu'
			}, {
				icon: 'room',
				label: 'Horaris',
				labelKey: 'app.menu.rrhh.horaris',
				route: '/rrhh/horaris'
			}, {
				icon: 'room',
				label: 'Intervals',
				labelKey: 'app.menu.rrhh.intervals',
				route: '/rrhh/intervals'
			}, {
				icon: 'room',
				label: 'Nodes',
				labelKey: 'app.menu.rrhh.nodes',
				route: '/rrhh/nodes'
			}, {
				icon: 'room',
				label: 'Operaris',
				labelKey: 'app.menu.rrhh.operaris',
				route: '/rrhh/operarisRrhh'
			}, {
				icon: 'room',
				label: 'Parametres',
				labelKey: 'app.menu.rrhh.parametres',
				route: '/rrhh/parametres'
			}, {
				icon: 'room',
				label: 'Recursos Grup',
				labelKey: 'app.menu.rrhh.recursosGrups',
				route: '/rrhh/recursosGrup'
			}, {
				icon: 'room',
				label: 'Regims',
				labelKey: 'app.menu.rrhh.regims',
				route: '/rrhh/regims'
			}, {
				icon: 'room',
				label: 'Registres Diaris',
				labelKey: 'app.menu.rrhh.registresDiaris',
				route: '/rrhh/registresDiari'
			}, {
				icon: 'room',
				label: 'Seccions',
				labelKey: 'app.menu.rrhh.seccions',
				route: '/rrhh/seccions'
			}, {
				icon: 'room',
				label: 'Seccions Grup',
				labelKey: 'app.menu.rrhh.seccionsGrups',
				route: '/rrhh/seccionsGrup'
			}, {
				icon: 'room',
				label: 'Servidors',
				labelKey: 'app.menu.rrhh.servidors',
				route: '/rrhh/servidors'
			}, {
				icon: 'room',
				label: 'Subcategories',
				labelKey: 'app.menu.rrhh.subcategories',
				route: '/rrhh/subcategories'
			}, {
				icon: 'room',
				label: 'Tipus Dia',
				labelKey: 'app.menu.rrhh.tipusDies',
				route: '/rrhh/tipusDies'
			}, {
				icon: 'room',
				label: 'Tipus Transaccio',
				labelKey: 'app.menu.rrhh.tipusTransaccions',
				route: '/rrhh/tipusTransaccions'
			}, {
				icon: 'room',
				label: 'Transaccions',
				labelKey: 'app.menu.rrhh.transaccions',
				route: '/rrhh/transaccions'
			}, {
				icon: 'room',
				label: 'Zones',
				labelKey: 'app.menu.rrhh.zones',
				route: '/rrhh/zonesRrhh'
			}]
		});
		this.moduleService.register({
			code: 'rrmm',
			icon: 'commute',
			label: 'Recursos de maquinària'
		});
		this.moduleService.register({
			code: 'banc',
			icon: 'account_balance',
			label: 'Gestió bancària'
		});
		this.moduleService.register({
			code: 'lici',
			icon: 'work',
			label: 'Licitacions'
		});
		this.moduleService.register({
			code: 'marc',
			icon: 'touch_app',
			label: 'Marcatges',
			menuItems: [{
				icon: 'people_alt',
				label: 'Operaris',
				labelKey: 'app.menu.marc.operaris',
				route: '/marc/operaris'
			},{
				icon: 'timer',
				label: 'Marcatges',
				labelKey: 'app.menu.marc.marcatges',
				route: '/marc/marcatges'
			}]
		});
		this.moduleService.register({
			code: 'comd',
			icon: 'touch_app',
			label: 'Comandes'
		});
		this.moduleService.refreshAllowedModuleItems();
	}

	constructor(
		private router: Router,
		private authService: BngAuthService,
		private menuService: BngMenuService,
		private moduleService: BngModuleService,
		private identificadorsService: IdentificadorsService) {
		this.registerGlobalMenus();
		this.registerAvailableModules();
		this.menuService.setActiveGlobalMenu('admin');
	}

}
