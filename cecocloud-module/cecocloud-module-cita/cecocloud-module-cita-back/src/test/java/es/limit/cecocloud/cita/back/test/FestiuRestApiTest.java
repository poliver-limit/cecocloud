/**
 * 
 */
package es.limit.cecocloud.cita.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.back.test.tester.FestiuCrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Festiu;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels recursos de tipus festiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class FestiuRestApiTest extends ModuleResourceRestApiTest<Festiu> {

	@Override
	protected CrudTester<Festiu> getCrudTester() {
		return new FestiuCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.cita.name()).get();
		return moduleInfo.getFuncionalitats().get("CIT_GRPFES");
	}

}
