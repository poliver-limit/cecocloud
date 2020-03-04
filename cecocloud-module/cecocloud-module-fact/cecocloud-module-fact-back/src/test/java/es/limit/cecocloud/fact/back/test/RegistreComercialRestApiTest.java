/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.RegistreComercialCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial;

/**
 * Test pels objectes de tipus RegistreComercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RegistreComercialRestApiTest extends AbstractRestApiTest<RegistreComercial, String> {

	@Override
	protected CrudTester<RegistreComercial> getCrudTester() {
		return new RegistreComercialCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
