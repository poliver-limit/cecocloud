/**
 * 
 */
package es.limit.cecoloud.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.base.boot.test.tester.UsuariCrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Tester pels objectes de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorCrudTester extends AbstractCrudTester<Identificador> {

	@Override
	public Identificador createDto() {
		Identificador dto = new Identificador();
		dto.setCodi("TST");
		dto.setDescripcio("Test");
		dto.setNumUsuaris(1);
		dto.setNumEmpreses(2);
		dto.setDataInici(new Date());
		dto.setDataFi(new Date());
		dto.setPropietari(
				GenericReference.toGenericReference(getUsuariTestCreat().getId()));
		return dto;
	}
	@Override
	public void updateDto(Identificador dto) {
		// No està permès canviar el codi d'un identificador
		dto.setDescripcio("Test2");
		dto.setNumUsuaris(2);
		dto.setNumEmpreses(3);
		dto.setDataInici(new Date());
		dto.setDataFi(new Date());
		dto.setPropietari(
				GenericReference.toGenericReference(getUsuariAdminCreat().getId()));
	}
	@Override
	public void compareDto(Identificador expected, Identificador actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getNumUsuaris(), actual.getNumUsuaris());
		assertEquals(expected.getNumEmpreses(), actual.getNumEmpreses());
		assertEquals(expected.getDataInici(), actual.getDataInici());
		assertEquals(expected.getDataFi(), actual.getDataFi());
		assertEquals(expected.getPropietari(), actual.getPropietari());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
				new UsuariCrudTester()
		};
	}

}
