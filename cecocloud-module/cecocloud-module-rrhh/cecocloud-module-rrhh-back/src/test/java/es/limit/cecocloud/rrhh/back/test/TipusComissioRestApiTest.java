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
import es.limit.cecocloud.rrhh.back.test.tester.TornCrudTester;
import es.limit.cecocloud.rrhh.logic.api.dto.Torn;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels objectes de tipus torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TipusComissioRestApiTest extends ModuleResourceRestApiTest<Torn> {

	@Override
	protected CrudTester<Torn> getCrudTester() {
		return new TornCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.rrhh.name()).get();
		return moduleInfo.getFuncionalitats().get("REH_TIPCOM");
	}

}
