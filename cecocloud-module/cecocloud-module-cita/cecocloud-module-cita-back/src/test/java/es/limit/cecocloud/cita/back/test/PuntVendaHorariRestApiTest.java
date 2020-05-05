/**
 * 
 */
package es.limit.cecocloud.cita.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.back.test.tester.PuntVendaHorariCrudTester;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels recursos que relacionen un punt de venda amb un horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PuntVendaHorariRestApiTest extends ModuleResourceRestApiTest<PuntVendaHorari> {

	@Override
	protected CrudTester<PuntVendaHorari> getCrudTester() {
		return new PuntVendaHorariCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.cita.name()).get();
		return moduleInfo.getFuncionalitats().get("CIT_PUNVEN");
	}

}
