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
import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus regim.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RegimCrudTester extends AbstractCrudTester<Regim> {

	@Override
	public Regim createDto() {
		Regim dto = new Regim();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Regim dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Regim update(Regim dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
		dto.setContarHores(true);
		dto.setMantenirProximaEntrada(true);
		dto.setMostrarLlistatPlanificacio(true);
		dto.setNumHoresLaborals(TestUtils.BDECIMAL_TEST);
		dto.setNumMinHoresLaborals(TestUtils.BDECIMAL_TEST);
		dto.setPresencia(true);
		return dto;
	}

	@Override
	public void compareDto(Regim expected, Regim actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getContarHores(), actual.getContarHores());
		assertEquals(expected.getMantenirProximaEntrada(), actual.getMantenirProximaEntrada());
		assertEquals(expected.getMostrarLlistatPlanificacio(), actual.getMostrarLlistatPlanificacio());
		assertEquals(expected.getNumHoresLaborals(), actual.getNumHoresLaborals());
		assertEquals(expected.getNumMinHoresLaborals(), actual.getNumMinHoresLaborals());
		assertEquals(expected.getPresencia(), actual.getPresencia());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
