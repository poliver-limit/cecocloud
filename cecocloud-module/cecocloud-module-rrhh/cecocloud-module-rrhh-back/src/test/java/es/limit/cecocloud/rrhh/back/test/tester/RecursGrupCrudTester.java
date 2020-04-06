/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RecursGrupCrudTester extends AbstractCrudTester<RecursGrup> {

	@Override
	public RecursGrup createDto() {
		RecursGrup dto = new RecursGrup();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(RecursGrup dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public RecursGrup update(RecursGrup dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
		dto.setDescripcio(TestUtils.OBS_TEST);
		dto.setNumHor(TestUtils.BDECIMAL_TEST);
		return dto;
	}

	@Override
	public void compareDto(RecursGrup expected, RecursGrup actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertTrue(expected.getNumHor().compareTo(actual.getNumHor()) == 0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
