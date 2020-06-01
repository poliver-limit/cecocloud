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
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus seccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class SeccioCrudTester extends AbstractCrudTester<Seccio> {

	@Override
	public Seccio createDto() {
		Seccio dto = new Seccio();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		dto.setEmpresa(getGenericReferenceWithCompositePk(Empresa.class));
		dto.setSeccioGrup(getGenericReferenceWithCompositePk(SeccioGrup.class));
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Seccio dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Seccio update(Seccio dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
		dto.setObservaciones(TestUtils.OBS_TEST);
		dto.setCompteSous("compteSous");
		dto.setControlHoresExtras(true);
		dto.setControlPartes(true);
		dto.setDepcmp("dcmp");
		dto.setDiscos("dc");
		dto.setDtehor(TestUtils.BDECIMAL_TEST);
		dto.setHoresLaboralesDia(TestUtils.BDECIMAL_TEST);
		dto.setRolVistas("rolVistas");
		return dto;
	}

	@Override
	public void compareDto(Seccio expected, Seccio actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getCompteSous(), actual.getCompteSous());
		assertEquals(expected.isControlHoresExtras(), actual.isControlHoresExtras());
		assertEquals(expected.isControlPartes(), actual.isControlPartes());
		assertEquals(expected.getDepcmp(), actual.getDepcmp());
		assertEquals(expected.getDiscos(), actual.getDiscos());
		assertEquals(expected.getDtehor().compareTo(actual.getDtehor()), 0);
		assertEquals(expected.getHoresLaboralesDia().compareTo(actual.getHoresLaboralesDia()), 0);
		assertEquals(expected.getRolVistas(), actual.getRolVistas());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(),
				new EmpresaCrudTester(),
				new SeccioGrupCrudTester()};
	}

}
