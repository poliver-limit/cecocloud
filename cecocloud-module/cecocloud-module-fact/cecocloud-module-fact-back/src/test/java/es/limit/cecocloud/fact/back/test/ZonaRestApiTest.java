/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.ZonaCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Zona;

/**
 * Test pels objectes de tipus zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ZonaRestApiTest extends AbstractRestApiTest<Zona, String> {

	@Override
	protected CrudTester<Zona> getCrudTester() {
		return new ZonaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
