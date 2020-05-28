/**
 * 
 */
package es.limit.cecoloud.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.Perfil;

/**
 * Tester pels objectes de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PerfilCrudTester extends AbstractCrudTester<Perfil> {

	@Override
	public Perfil createDto() {
		Perfil dto = new Perfil();
		dto.setCodi("TST");
		dto.setDescripcio("Test");
		dto.setIdentificador(
				getGenericReference(Identificador.class));
		return dto;
	}
	@Override
	public void updateDto(Perfil dto) {
		dto.setCodi("TST2");
		dto.setDescripcio("Test2");
	}
	@Override
	public void compareDto(Perfil expected, Perfil actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
				new IdentificadorCrudTester()
		};
	}

	@Override
	public void afterCreate(Perfil dto, boolean isParentResource) {
		if (isParentResource) {
			// Configurar perfil amb accés a la funcionalitat
		}
	}

}
