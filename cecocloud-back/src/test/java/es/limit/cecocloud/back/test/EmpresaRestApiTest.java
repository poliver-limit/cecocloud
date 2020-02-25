/**
 * 
 */
package es.limit.cecocloud.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecoloud.test.tester.EmpresaCrudTester;

/**
 * Test pels objectes de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaRestApiTest extends AbstractRestApiTest<Empresa, Long> {

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
