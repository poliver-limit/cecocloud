/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaCrudTester extends AbstractCrudTester<Empresa> {

	@Override
	public Empresa createDto() {
		Empresa dto = new Empresa();
		dto.setCodi(es.limit.cecoloud.test.tester.EmpresaCrudTester.EMPRESA_CODI_TEST);
		dto = this.update(dto);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Empresa dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Empresa update(Empresa dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setAsientoProrrateoPagaExtra(true);
		dto.setCodiPostal("CP");
		dto.setCompte("compte");
		dto.setCompteEmbargo("Embargo");
		dto.setCompteOrganismesSSEmpresa("OrgSSEmp");
		dto.setComptePagoNomina("PagoNomina");
		dto.setCompteRetencioIrpf("RetenIrpf");
		dto.setCompteSS("compteSS");
		dto.setCompteSSEmpresa("compteSSEm");
		dto.setCompteTerminacio(true);
		dto.setCompteTerminacioEmbargo(true);
		dto.setCompteTerminacioOrganismesSSEmpresa(true);
		dto.setCompteTerminacioRetencio(true);
		dto.setCompteTerminacioSS(true);
		dto.setCompteTerminacioSSEmpresa(true);
		dto.setDomiciliPostal("domPostal");
		dto.setDri001("01");
		dto.setDri002("02");
		dto.setEmail("email");
		dto.setEmpresaComptabilitatCodi("Codi");
		dto.setExerciciComptabilitatTraspas("Tras");
		dto.setGenerarAsientos(true);
		dto.setLogoImprimir(true);
		dto.setPaginaWeb("paginaWeb");
		dto.setPoble("poble");
		dto.setTelefon("telefon");
		dto.setTraspasCrearComptesComptablesExistir(true);
		dto.setVacancesDiesNaturals(true);
		return dto;
	}

	@Override
	public void compareDto(Empresa expected, Empresa actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getCodiPostal(), actual.getCodiPostal());
		assertEquals(expected.getCompte(), actual.getCompte());
		assertEquals(expected.getCompteEmbargo(), actual.getCompteEmbargo());
		assertEquals(expected.getCompteOrganismesSSEmpresa(), actual.getCompteOrganismesSSEmpresa());
		assertEquals(expected.getComptePagoNomina(), actual.getComptePagoNomina());
		assertEquals(expected.getCompteRetencioIrpf(), actual.getCompteRetencioIrpf());
		assertEquals(expected.getCompteRetencioIrpf(), actual.getCompteRetencioIrpf());
		assertEquals(expected.getCompteSS(), actual.getCompteSS());
		assertEquals(expected.getCompteSSEmpresa(), actual.getCompteSSEmpresa());
		assertEquals(expected.isCompteTerminacio(), actual.isCompteTerminacio());
		assertEquals(expected.isCompteTerminacioEmbargo(), actual.isCompteTerminacioEmbargo());
		assertEquals(expected.isCompteTerminacioOrganismesSSEmpresa(), actual.isCompteTerminacioOrganismesSSEmpresa());
		assertEquals(expected.isCompteTerminacioRetencio(), actual.isCompteTerminacioRetencio());
		assertEquals(expected.isCompteTerminacioSS(), actual.isCompteTerminacioSS());
		assertEquals(expected.isCompteTerminacioSSEmpresa(), actual.isCompteTerminacioSSEmpresa());
		assertEquals(expected.getDomiciliPostal(), actual.getDomiciliPostal());
		assertEquals(expected.getDri001(), actual.getDri001());
		assertEquals(expected.getDri002(), actual.getDri002());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getEmpresaComptabilitatCodi(), actual.getEmpresaComptabilitatCodi());
		assertEquals(expected.getExerciciComptabilitatTraspas(), actual.getExerciciComptabilitatTraspas());
		assertEquals(expected.isGenerarAsientos(), actual.isGenerarAsientos());
		assertEquals(expected.isLogoImprimir(), actual.isLogoImprimir());
		assertEquals(expected.getPaginaWeb(), actual.getPaginaWeb());
		assertEquals(expected.getPoble(), actual.getPoble());
		assertEquals(expected.getTelefon(), actual.getTelefon());
		assertEquals(expected.isTraspasCrearComptesComptablesExistir(), actual.isTraspasCrearComptesComptablesExistir());
		assertEquals(expected.isVacancesDiesNaturals(), actual.isVacancesDiesNaturals());
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
