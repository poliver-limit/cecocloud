/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.DivisaCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;

/**
 * Test pels objectes de tipus pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DivisaRestApiTest extends AbstractRestApiTest<Divisa, String> {

	@Override
	protected CrudTester<Divisa> getCrudTester() {
		return new DivisaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
