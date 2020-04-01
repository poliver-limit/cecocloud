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
import es.limit.cecocloud.rrhh.logic.api.dto.Parametre;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus parametre.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ParametreCrudTester extends AbstractCrudTester<Parametre> {

	@Override
	public Parametre createDto() {
		Parametre dto = new Parametre();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Parametre dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Parametre update(Parametre dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio(TestUtils.DES_TEST);
		dto.setValor("valor");
		return dto;
	}

	@Override
	public void compareDto(Parametre expected, Parametre actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getValor(), actual.getValor());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
