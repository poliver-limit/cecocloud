/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.PaisCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Pais;

/**
 * Test pels objectes de tipus pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PaisRestApiTest extends AbstractRestApiTest<Pais, String> {

	@Override
	protected CrudTester<Pais> getCrudTester() {
		return new PaisCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
