import { MenuEmpresa } from './menu-empresa';

export class MenuCompanyia {
	
	id: number;
	codi: string;
	nom: string;
	administracio: boolean;
	empreses: MenuEmpresa[];
	
		
	constructor(
		id: number,
		codi: string,
		nom: string,
		administracio: boolean,
		empreses: MenuEmpresa[]) {
			this.id = id;
			this.codi = codi;
			this.nom = nom;
			this.administracio = administracio;
			this.empreses = empreses;
		}
}