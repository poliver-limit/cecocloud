/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.ClientCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Client;

/**
 * Test pels objectes de tipus Client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ClientRestApiTest extends AbstractRestApiTest<Client, String> {

	@Override
	protected CrudTester<Client> getCrudTester() {
		return new ClientCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
