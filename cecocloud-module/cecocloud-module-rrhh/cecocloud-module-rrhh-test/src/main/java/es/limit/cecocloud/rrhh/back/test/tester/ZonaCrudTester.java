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
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Zonaz.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ZonaCrudTester extends AbstractCrudTester<Zona> {

	@Override
	public Zona createDto() {
		Zona dto = new Zona();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Zona dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Zona update(Zona dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
		dto.setObservacio(TestUtils.OBS_TEST);
		dto.setZonaTreball(true);
		return dto;
	}

	@Override
	public void compareDto(Zona expected, Zona actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getObservacio(), actual.getObservacio());
		assertEquals(expected.getZonaTreball(), actual.getZonaTreball());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
