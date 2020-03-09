/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.RegistreComercialCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels objectes de tipus registreComercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RegistreComercialRestApiTest extends ModuleResourceRestApiTest<RegistreComercial> {

	@Override
	protected CrudTester<RegistreComercial> getCrudTester() {
		return new RegistreComercialCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.fact.name()).get();
		return moduleInfo.getFuncionalitats().get("FAC_REGCOM");
	}

}
