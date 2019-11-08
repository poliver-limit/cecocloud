export class MenuEmpresa {
	
	id: number;
	codi: string;
	nom: string;
	
	constructor(
		id: number,
		codi: string,
		nom: string) {
			this.id = id;
			this.codi = codi;
			this.nom = nom;
		}
}