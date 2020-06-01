/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Servidor;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus servidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ServidorCrudTester extends AbstractCrudTester<Servidor> {

	@Override
	public Servidor createDto() {
		Servidor dto = new Servidor();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Servidor dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Servidor update(Servidor dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio(TestUtils.DES_TEST);
		return dto;
	}

	@Override
	public void compareDto(Servidor expected, Servidor actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
	}


	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
