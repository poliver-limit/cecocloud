/**
 * 
 */
package es.limit.cecocloud.logic.test;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.cecocloud.logic.api.dto.Companyia;

/**
 * Test pels objectes de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CompanyiaTest extends AbstractServiceTest<Companyia, Long> {

	@Override
	protected Companyia createDto() {
		Companyia dto = new Companyia();
		dto.setCodi("TEST");
		dto.setNom("Test");
		dto.setTelefon("+34 555443322");
		dto.setEmail("test@test.com");
		return dto;
	}

	@Override
	protected void updateDto(Companyia dto) {
		dto.setCodi("TEST2");
		dto.setNom("Test2");
		dto.setTelefon("+34 555443321");
		dto.setEmail("test2@test.com");
	}

	@Override
	protected void compareDto(Companyia expected, Companyia actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getTelefon(), actual.getTelefon());
		assertEquals(expected.getEmail(), actual.getEmail());
	}

}
