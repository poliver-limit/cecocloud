/**
 * 
 */
package es.limit.cecocloud.logic.test;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Test pels objectes de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorTest extends AbstractServiceTest<Identificador, String> {

	@Override
	protected Identificador createDto() {
		Identificador dto = new Identificador();
		dto.setNom("Test");
		dto.setActiu(true);
		return dto;
	}

	@Override
	protected void updateDto(Identificador dto) {
		dto.setNom("Test2");
		dto.setActiu(false);
	}

	@Override
	protected void compareDto(Identificador expected, Identificador actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.isActiu(), actual.isActiu());
	}

}
