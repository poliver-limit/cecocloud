/**
 * 
 */
package es.limit.cecocloud.logic.test;

import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecoloud.test.tester.CompanyiaCrudTester;

/**
 * Test pels objectes de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CompanyiaServiceTest extends AbstractServiceTest<Companyia, Long> {

	@Override
	protected CrudTester<Companyia> getCrudTester() {
		return new CompanyiaCrudTester();
	}

}
