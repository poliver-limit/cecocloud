/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.ProducteCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Producte;

/**
 * Test pels objectes de tipus Producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProducteRestApiTest extends AbstractRestApiTest<Producte, String> {

	@Override
	protected CrudTester<Producte> getCrudTester() {
		return new ProducteCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
