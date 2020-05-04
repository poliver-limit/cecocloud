/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.DocumentPagamentCobramentCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test per a recursos de tipus document de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DocumentPagamentCobramentRestApiTest extends ModuleResourceRestApiTest<DocumentPagamentCobrament> {

	@Override
	protected CrudTester<DocumentPagamentCobrament> getCrudTester() {
		return new DocumentPagamentCobramentCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.fact.name()).get();
		return moduleInfo.getFuncionalitats().get("FAC_DOCP-C");
	}

}
