/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.MagatzemCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;

/**
 * Test pels objectes de tipus Magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MagatzemRestApiTest extends AbstractRestApiTest<Magatzem, String> {

	@Override
	protected CrudTester<Magatzem> getCrudTester() {
		return new MagatzemCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
