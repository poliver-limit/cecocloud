/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.ProvinciaCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Provincia;

/**
 * Test pels objectes de tipus Provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProvinciaRestApiTest extends AbstractRestApiTest<Provincia, String> {

	@Override
	protected CrudTester<Provincia> getCrudTester() {
		return new ProvinciaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
