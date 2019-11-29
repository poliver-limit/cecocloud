/**
 * 
 */
package es.limit.cecocloud.logic.test;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Empresa.EmpresaTipusEnum;

/**
 * Test pels objectes de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaTest extends AbstractServiceTest<Empresa, Long> {

	@Override
	protected CrudTester<Empresa> getCrudTester() {
		return new CrudTester<Empresa>() {
			@Override
			public Empresa createDto() {
				Empresa dto = new Empresa();
				dto.setCodi("TEST");
				dto.setNif("12345678Z");
				dto.setNom("Test");
				dto.setTipus(EmpresaTipusEnum.GESTIO);
				dto.setActiva(true);
				return dto;
			}
			@Override
			public void updateDto(Empresa dto) {
				dto.setCodi("TEST2");
				dto.setNif("00000000T");
				dto.setNom("Test2");
				dto.setTipus(EmpresaTipusEnum.COMPTABLE);
				dto.setActiva(false);
			}
			@Override
			public void compareDto(Empresa expected, Empresa actual) {
				assertEquals(expected.getCodi(), actual.getCodi());
				assertEquals(expected.getNif(), actual.getNif());
				assertEquals(expected.getNom(), actual.getNom());
				assertEquals(expected.getTipus(), actual.getTipus());
				assertEquals(expected.isActiva(), actual.isActiva());
			}
		};
	}

}
