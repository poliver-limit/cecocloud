/**
 * 
 */
package es.limit.cecocloud.logic.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Test pels objectes de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorServiceTest extends AbstractServiceTest<Identificador, String> {

	@Override
	protected CrudTester<Identificador> getCrudTester() {
		return new CrudTester<Identificador>() {
			@Override
			public Identificador createDto() {
				Identificador dto = new Identificador();
				dto.setNom("Test");
				dto.setActiu(true);
				return dto;
			}
			@Override
			public void updateDto(Identificador dto) {
				dto.setNom("Test2");
				dto.setActiu(false);
			}
			@Override
			public void compareDto(Identificador expected, Identificador actual) {
				assertEquals(expected.getCodi(), actual.getCodi());
				assertEquals(expected.getNom(), actual.getNom());
				assertEquals(expected.isActiu(), actual.isActiu());
			}
			@Override
			public List<Class<? extends Identificable<?>>> toCreateBeforeTest() {
				return null;
			}
		};
	}

}
