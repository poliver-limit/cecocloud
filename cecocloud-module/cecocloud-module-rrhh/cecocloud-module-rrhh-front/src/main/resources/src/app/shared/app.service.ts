import { Injectable } from '@angular/core';

import { BngMenuService, BngMenu } from 'base-angular';

@Injectable({
	providedIn: 'root'
})
export class AppService {

	private mainMenu: BngMenu = {
		items: [{
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
	};

	private configureMainMenu() {
		this.menuService.setActiveMenu(this.mainMenu);
	}

	constructor(
		private menuService: BngMenuService) {
		this.configureMainMenu();
	}

}
