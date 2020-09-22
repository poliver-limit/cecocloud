import { Injectable } from '@angular/core';

import { BngMenuService, BngMenu } from 'base-angular';

@Injectable({
	providedIn: 'root'
})
export class AppService {

	private mainMenu: BngMenu = {
		items: [{
			icon: 'room',
			label: 'Albarans',
			labelKey: 'app.menu.fact.albarans',
			route: '/fact/albarans'
		}, {
			icon: 'room',
			label: 'Àrea negocis',
			labelKey: 'app.menu.fact.areaNegocis',
			route: '/fact/areaNegocis'
		}, {
			icon: 'room',
			label: 'Articles',
			labelKey: 'app.menu.fact.articles',
			route: '/fact/articles'
		}, {
			icon: 'room',
			label: 'Articles família',
			labelKey: 'app.menu.fact.articlesFamilia',
			route: '/fact/articlesFamilia'
		}, {
			icon: 'room',
			label: 'Articles família empresa',
			labelKey: 'app.menu.fact.articlesFamiliaEmpresa',
			route: '/fact/articlesFamiliaEmpresa'
		}, {
			icon: 'room',
			label: 'Articles gamma',
			labelKey: 'app.menu.fact.articlesGamma',
			route: '/fact/articlesGamma'
		}, {
			icon: 'room',
			label: 'Articles marca',
			labelKey: 'app.menu.fact.articlesMarca',
			route: '/fact/articlesMarca'
		}, {
			icon: 'room',
			label: 'Articles model',
			labelKey: 'app.menu.fact.articlesModel',
			route: '/fact/articlesModel'
		}, {
			icon: 'room',
			label: 'Business groups',
			labelKey: 'app.menu.fact.businessGroups',
			route: '/fact/businessGroups'
		}, {
			icon: 'room',
			label: 'Codis postals',
			labelKey: 'app.menu.fact.codisPostal',
			route: '/fact/codisPostal'
		}, {
			icon: 'room',
			label: 'Departaments',
			labelKey: 'app.menu.fact.departaments',
			route: '/fact/departaments'
		}, {
			icon: 'room',
			label: 'Divises',
			labelKey: 'app.menu.fact.divises',
			route: '/fact/divises'
		}, {
			icon: 'room',
			label: 'Documents de pagament/cobrament',
			labelKey: 'app.menu.fact.documentsPagamentCobrament',
			route: '/fact/documentsPagamentCobrament'
		}, {
			icon: 'room',
			label: 'Empreses (Facturació)',
			labelKey: 'app.menu.fact.empreses',
			route: '/fact/empreses'
		}, {
			icon: 'room',
			label: 'Famílies cost',
			labelKey: 'app.menu.fact.familiesCost',
			route: '/fact/familiesCost'
		}, {
			icon: 'room',
			label: 'Famílies proveidor',
			labelKey: 'app.menu.fact.familiesProveidor',
			route: '/fact/familiesProveidor'
		}, {
			icon: 'room',
			label: 'Final factures',
			labelKey: 'app.menu.fact.finalFactures',
			route: '/fact/finalFactures'
		}, {
			icon: 'room',
			label: 'Groups',
			labelKey: 'app.menu.fact.groups',
			route: '/fact/groups'
		}, {
			icon: 'room',
			label: 'Idiomes',
			labelKey: 'app.menu.fact.idiomes',
			route: '/fact/idiomes'
		}, {
			icon: 'room',
			label: 'Iva',
			labelKey: 'app.menu.fact.ives',
			route: '/fact/ives'
		}, {
			icon: 'room',
			label: 'Magatzems',
			labelKey: 'app.menu.fact.magatzems',
			route: '/fact/magatzems'
		}, {
			icon: 'room',
			label: 'Magatzems període',
			labelKey: 'app.menu.fact.magatzemsPeriode',
			route: '/fact/magatzemsPeriode'
		}, {
			icon: 'room',
			label: 'Naturaleses de pagament/cobrament',
			labelKey: 'app.menu.fact.naturalesesPagamentCobrament',
			route: '/fact/naturalesesPagamentCobrament'
		}, {
			icon: 'room',
			label: 'Països',
			labelKey: 'app.menu.fact.paisos',
			route: '/fact/paisos'
		}, {
			icon: 'room',
			label: 'Parameters',
			labelKey: 'app.menu.fact.parameters',
			route: '/fact/parameters'
		}, {
			icon: 'room',
			label: 'Peus de document',
			labelKey: 'app.menu.fact.peusDocument',
			route: '/fact/peusDocument'
		}, {
			icon: 'room',
			label: 'Projectes',
			labelKey: 'app.menu.fact.projectes',
			route: '/fact/projectes'
		}, {
			icon: 'room',
			label: 'Projectes Tipus',
			labelKey: 'app.menu.fact.projectesTipus',
			route: '/fact/projectesTipus'
		}, {
			icon: 'room',
			label: 'Proveidors',
			labelKey: 'app.menu.fact.proveidors',
			route: '/fact/proveidors'
		}, {
			icon: 'room',
			label: 'Províncies',
			labelKey: 'app.menu.fact.provincies',
			route: '/fact/provincies'
		}, {
			icon: 'room',
			label: 'Règims d\'iva',
			labelKey: 'app.menu.fact.regimsIva',
			route: '/fact/regimsIva'
		}, {
			icon: 'room',
			label: 'Seccions empresa',
			labelKey: 'app.menu.fact.seccionsEmpresa',
			route: '/fact/seccionsEmpresa'
		}, {
			icon: 'room',
			label: 'Sèries de compra',
			labelKey: 'app.menu.fact.seriesCompra',
			route: '/fact/seriesCompra'
		}, {
			icon: 'room',
			label: 'Sèries intracomunitàries',
			labelKey: 'app.menu.fact.seriesIntracomunitaria',
			route: '/fact/seriesIntracomunitaria'
		}, {
			icon: 'room',
			label: 'Sèries de venda',
			labelKey: 'app.menu.fact.seriesVenda',
			route: '/fact/seriesVenda'
		}, {
			icon: 'room',
			label: 'Situacions comercials',
			labelKey: 'app.menu.fact.situacionsComercial',
			route: '/fact/situacionsComercial'
		}, {
			icon: 'room',
			label: 'Situacions inicials',
			labelKey: 'app.menu.fact.situacionsInicial',
			route: '/fact/situacionsInicial'
		}, {
			icon: 'room',
			label: 'Subvencions',
			labelKey: 'app.menu.fact.subvencions',
			route: '/fact/subvencions'
		}, {
			icon: 'room',
			label: 'Tarifes',
			labelKey: 'app.menu.fact.tarifes',
			route: '/fact/tarifes'
		}, {
			icon: 'room',
			label: 'Tarifes descompte',
			labelKey: 'app.menu.fact.tarifesDescompte',
			route: '/fact/tarifesDescompte'
		}, {
			icon: 'room',
			label: 'Tipus de comissió',
			labelKey: 'app.menu.fact.tipusComissions',
			route: '/fact/tipusComissions'
		}, {
			icon: 'room',
			label: 'Tipus de facturació',
			labelKey: 'app.menu.fact.tipusFacturacions',
			route: '/fact/tipusFacturacions'
		}, {
			icon: 'room',
			label: 'Tipus d\'incidencia factura',
			labelKey: 'app.menu.fact.tipusIncidenciesFactura',
			route: '/fact/tipusIncidenciesFactura'
		}, {
			icon: 'room',
			label: 'Tipus de proveïdor/client',
			labelKey: 'app.menu.fact.tipusProveidorsClient',
			route: '/fact/tipusProveidorsClient'
		}, {
			icon: 'room',
			label: 'Tipus de riscos',
			labelKey: 'app.menu.fact.tipusRiscos',
			route: '/fact/tipusRiscos'
		}, {
			icon: 'room',
			label: 'Tipus de venciments',
			labelKey: 'app.menu.fact.tipusVenciments',
			route: '/fact/tipusVenciments'
		}, {
			icon: 'room',
			label: 'Transportistes',
			labelKey: 'app.menu.fact.transportistes',
			route: '/fact/transportistes'
		}, {
			icon: 'room',
			label: 'Ubicacions',
			labelKey: 'app.menu.fact.ubicacions',
			route: '/fact/ubicacions'
		}, {
			icon: 'room',
			label: 'Ubicacions articles',
			labelKey: 'app.menu.fact.ubicacionsArticle',
			route: '/fact/ubicacionsArticle'
		}, {
			icon: 'room',
			label: 'Unitats tipus',
			labelKey: 'app.menu.fact.',
			route: '/fact/unitatsTipus'
		}, {
			icon: 'room',
			label: 'Vehicles',
			labelKey: 'app.menu.fact.vehicles',
			route: '/fact/vehicles'
		}, {
			icon: 'room',
			label: 'Zones',
			labelKey: 'app.menu.fact.zones',
			route: '/fact/zones'
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
