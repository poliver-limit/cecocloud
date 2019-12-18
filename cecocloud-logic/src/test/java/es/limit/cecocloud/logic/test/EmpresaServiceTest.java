/**
 * 
 */
package es.limit.cecocloud.logic.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecoloud.test.tester.EmpresaCrudTester;

/**
 * Test pels objectes de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaServiceTest extends AbstractServiceTest<Empresa, Long> {

	@Override
	protected CrudTester<Empresa> getCrudTester() {
		return new EmpresaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_ADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
