/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Pais;
import es.limit.cecocloud.fact.logic.api.dto.Provincia;
import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus CodiPostal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CodiPostalCrudTester extends AbstractCrudTester<CodiPostal> {

	@Override
	public CodiPostal createDto() {
		CodiPostal dto = new CodiPostal();
		dto.setCodi("TST");
		dto.setPoblacio("Poblacio TST");
		dto.setMunicipi("Municipi TST");
		dto.setPais(getGenericReferenceWithCompositePkFromParentCrudTester(Pais.class));
		dto.setProvincia(getGenericReferenceWithCompositePkFromParentCrudTester(Provincia.class));
		return dto;
	}

	@Override
	public void updateDto(CodiPostal dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setPoblacio("Poblacio TST2");
		dto.setMunicipi("Municipi TST2");
	}

	@Override
	public void compareDto(CodiPostal expected, CodiPostal actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getPoblacio(), actual.getPoblacio());
		assertEquals(expected.getMunicipi(), actual.getMunicipi());		
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new PaisCrudTester(),
			new ProvinciaCrudTester()
		};
	}

}
