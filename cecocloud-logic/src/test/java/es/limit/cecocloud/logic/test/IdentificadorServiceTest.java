/**
 * 
 */
package es.limit.cecocloud.logic.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.test.AbstractServiceTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Test pels objectes de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorServiceTest extends AbstractServiceTest<Identificador, Long> {

	// TODO: Refer test amb canvis de model
	@Override
	protected CrudTester<Identificador> getCrudTester() {
		return new CrudTester<Identificador>() {
			@Override
			public Identificador createDto() {
				Identificador dto = new Identificador();
				dto.setDescripcio("Test");
				dto.setNumUsuaris(1);
				dto.setNumEmpreses(2);
				dto.setDataInici(new Date());
				dto.setDataFi(new Date());
				dto.setLlicencia("1");
				dto.setLlicenciaOk(true);
				return dto;
			}
			@Override
			public void updateDto(Identificador dto) {
				dto.setDescripcio("Test2");
				dto.setNumUsuaris(2);
				dto.setNumEmpreses(3);
				dto.setDataInici(new Date());
				dto.setDataFi(new Date());
				dto.setLlicencia("1234");
				dto.setLlicenciaOk(false);
			}
			@Override
			public void compareDto(Identificador expected, Identificador actual) {
				assertEquals(expected.getCodi(), actual.getCodi());
				assertEquals(expected.getDescripcio(), actual.getDescripcio());
				assertEquals(expected.getNumUsuaris(), actual.getNumUsuaris());
				assertEquals(expected.getNumEmpreses(), actual.getNumEmpreses());
				assertEquals(expected.getDataInici(), actual.getDataInici());
				assertEquals(expected.getDataFi(), actual.getDataFi());
				assertEquals(expected.getLlicencia(), actual.getLlicencia());
				assertEquals(expected.isLlicenciaOk(), actual.isLlicenciaOk());
			}
			@Override
			public List<Class<? extends Identificable<?>>> toCreateBeforeTest() {
				return null;
			}
		};
	}

}
