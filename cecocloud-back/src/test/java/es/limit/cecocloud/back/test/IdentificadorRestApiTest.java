/**
 * 
 */
package es.limit.cecocloud.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Test pels objectes de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorRestApiTest extends AbstractRestApiTest<Identificador, Long> {

	@Override
	protected CrudTester<Identificador> getCrudTester() {
		return new IdentificadorCrudTester();
	}

	@WithMockUser(value = "baseadmin")
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
