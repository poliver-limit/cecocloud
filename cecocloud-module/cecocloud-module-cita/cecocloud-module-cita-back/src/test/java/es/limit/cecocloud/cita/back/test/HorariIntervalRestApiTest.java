/**
 * 
 */
package es.limit.cecocloud.cita.back.test;

import java.time.temporal.ChronoUnit;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.back.test.tester.HorariIntervalCrudTester;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels recursos de tipus interval horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class HorariIntervalRestApiTest extends ModuleResourceRestApiTest<HorariInterval> {

	@Override
	protected CrudTester<HorariInterval> getCrudTester() {
		return new HorariIntervalCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.cita.name()).get();
		return moduleInfo.getFuncionalitats().get("CIT_HORARI");
	}

	@Override
	protected void testWithCrudVerifiedResource(HorariInterval resource) {
		System.out.println(">>> interval: " + resource);
		System.out.println(">>>    horaInici: " + resource.getHoraInici() + ", " + resource.getHoraInici().truncatedTo(ChronoUnit.SECONDS));
		System.out.println(">>>    horaFi: " + resource.getHoraFi() + ", " + resource.getHoraFi().truncatedTo(ChronoUnit.SECONDS));
	}

}
