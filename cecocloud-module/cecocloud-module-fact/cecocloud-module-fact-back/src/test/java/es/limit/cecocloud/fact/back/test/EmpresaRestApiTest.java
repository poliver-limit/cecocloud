/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.EmpresaCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.test.ModuleResourceRestApiTest;

/**
 * Test pels objectes de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaRestApiTest extends ModuleResourceRestApiTest<Empresa> {

	@Override
	protected CrudTester<Empresa> getCrudTester() {
		return new EmpresaCrudTester();
	}

	//@WithMockUser(value = USUARI_TEST_NOADMIN)
	//@Test
	//
	// Aquest test està desactivat perquè Cecocloud crea les empreses de forma automàtica
	// quan es donen d'alta al grup d'empreses.
	//
	public void crudTest() {
		//genericCrudTest();
	}
	
	@Override
	protected FuncionalitatCodiFont getFuncionalitatCodiFont() {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.fact.name()).get();
		return moduleInfo.getFuncionalitats().get("FAC_EMPRES");
	}

}
