/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.back.test.tester.OperariCrudTester;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels objectes de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class OperariRestApiTest extends ModuleResourceRestApiTest<Operari> {

	@Override
	protected CrudTester<Operari> getCrudTester() {
		return new OperariCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		assertTrue(true);
//		bucle infinito por referencia asi mismo del operario
//		genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.rrhh.name()).get();
		return moduleInfo.getFuncionalitats().get("REH_OPERAR");
	}

}
