/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.CodiPostalCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;

/**
 * Test pels objectes de tipus CodiPostal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CodiPostalRestApiTest extends AbstractRestApiTest<CodiPostal, String> {

	@Override
	protected CrudTester<CodiPostal> getCrudTester() {
		return new CodiPostalCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
