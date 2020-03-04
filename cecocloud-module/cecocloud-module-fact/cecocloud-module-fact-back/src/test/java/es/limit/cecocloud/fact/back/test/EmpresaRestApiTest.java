/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.EmpresaCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;

/**
 * Test pels objectes de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaRestApiTest extends AbstractRestApiTest<Empresa, String> {

	@Override
	protected CrudTester<Empresa> getCrudTester() {
		return new EmpresaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
