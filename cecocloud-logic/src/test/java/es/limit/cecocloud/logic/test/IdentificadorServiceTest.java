/**
 * 
 */
package es.limit.cecocloud.logic.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Test pels objectes de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorServiceTest extends AbstractServiceTest<Identificador, Long> {

	@Override
	protected CrudTester<Identificador> getCrudTester() {
		return new IdentificadorCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_ADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
