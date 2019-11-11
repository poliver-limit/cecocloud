export class MenuCompanyiaEmpresa {
	
	companyiaId: number;
	empresaId: number;
	nom: string;
	administracio: boolean;
	
		
	constructor(
		companyiaId: number,
		empresaId: number,
		nom: string,
		administracio: boolean) {
			this.companyiaId = companyiaId;
			this.empresaId = empresaId;
			this.nom = nom;
			this.administracio = administracio;
		}
}