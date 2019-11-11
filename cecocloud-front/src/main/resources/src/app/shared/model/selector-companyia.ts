import { SelectorEmpresa } from './selector-empresa';

export class SelectorCompanyia {
	
	id: number;
	codi: string;
	nom: string;
	administracio: boolean;
	empreses: SelectorEmpresa[];
	
		
	constructor(
		id: number,
		codi: string,
		nom: string,
		administracio: boolean,
		empreses: SelectorEmpresa[]) {
			this.id = id;
			this.codi = codi;
			this.nom = nom;
			this.administracio = administracio;
			this.empreses = empreses;
		}
}