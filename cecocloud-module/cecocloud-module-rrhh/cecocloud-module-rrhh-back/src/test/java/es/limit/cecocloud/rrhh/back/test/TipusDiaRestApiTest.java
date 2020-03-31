/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.back.test.tester.TipusDiaCrudTester;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels objectes de tipus tipusDia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TipusDiaRestApiTest extends ModuleResourceRestApiTest<TipusDia> {

	@Override
	protected CrudTester<TipusDia> getCrudTester() {
		return new TipusDiaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.rrhh.name()).get();
		return moduleInfo.getFuncionalitats().get("REH_TIPDIA");
	}

}
