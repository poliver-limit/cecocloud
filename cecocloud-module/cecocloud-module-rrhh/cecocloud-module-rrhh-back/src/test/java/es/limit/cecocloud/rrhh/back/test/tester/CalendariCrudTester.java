/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus calendari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CalendariCrudTester extends AbstractCrudTester<Calendari> {

	@Override
	public Calendari createDto() {
		Calendari dto = new Calendari();
		dto.setData(new Date());
		dto.setDescripcio(TestUtils.DES_TEST);
		dto.setObservacio(TestUtils.OBS_TEST);
		dto.setTipusDia(getGenericReferenceWithCompositePkFromParentCrudTester(TipusDia.class));
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Calendari dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio(TestUtils.DES_TEST + "1");
		dto.setObservacio(TestUtils.OBS_TEST + "1");
	}

	@Override
	public void compareDto(Calendari expected, Calendari actual) {
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getObservacio(), actual.getObservacio());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(),  new TipusDiaCrudTester() };
	}

}
