/**
 * 
 */
package es.limit.cecocloud.cita.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.back.test.tester.CitaCrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels recursos de tipus cita.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CitaRestApiTest extends ModuleResourceRestApiTest<Cita> {

	@Override
	protected CrudTester<Cita> getCrudTester() {
		return new CitaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		//genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.fact.name()).get();
		return moduleInfo.getFuncionalitats().get("FAC_CLIENT");
	}

}
