/**
 * 
 */
package es.limit.cecoloud.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.List;

import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Empresa.EmpresaTipusEnum;

/**
 * Tester pels objectes de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaCrudTester implements CrudTester<Empresa> {

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

	@Override
	public List<Class<? extends Identificable<?>>> toCreateBeforeTest() {
		return null;
	}

}
