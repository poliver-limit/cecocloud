/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Pais;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PaisCrudTester extends AbstractCrudTester<Pais> {

	@Override
	public Pais createDto() {
		Pais dto = new Pais();
		dto.setCodi("TEST");
		dto.setNif("TT");
		dto.setNom("Test");
		dto.setCodiso("TST");
		dto.setCodiso002("TT");
		dto.setCee(true);
		
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@Override
	public void updateDto(Pais dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNif("T2");
		dto.setNom("Test2");
		dto.setCodiso("TS2");
		dto.setCodiso002("T2");
		dto.setCee(false);
	}

	@Override
	public void compareDto(Pais expected, Pais actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNif(), actual.getNif());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getCodiso(), actual.getCodiso());
		assertEquals(expected.getCodiso002(), actual.getCodiso002());
		assertEquals(expected.isCee(), actual.isCee());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
