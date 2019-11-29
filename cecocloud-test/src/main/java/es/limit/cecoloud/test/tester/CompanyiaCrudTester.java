/**
 * 
 */
package es.limit.cecoloud.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.List;

import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Companyia;

/**
 * Tester pels objectes de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CompanyiaCrudTester implements CrudTester<Companyia> {

	@Override
	public Companyia createDto() {
		Companyia dto = new Companyia();
		dto.setCodi("TEST");
		dto.setNom("Test");
		dto.setTelefon("+34 555443322");
		dto.setEmail("test@test.com");
		return dto;
	}

	@Override
	public void updateDto(Companyia dto) {
		dto.setCodi("TEST2");
		dto.setNom("Test2");
		dto.setTelefon("+34 555443321");
		dto.setEmail("test2@test.com");
	}

	@Override
	public void compareDto(Companyia expected, Companyia actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getTelefon(), actual.getTelefon());
		assertEquals(expected.getEmail(), actual.getEmail());
	}

	@Override
	public List<Class<? extends Identificable<?>>> toCreateBeforeTest() {
		return null;
	}

}
