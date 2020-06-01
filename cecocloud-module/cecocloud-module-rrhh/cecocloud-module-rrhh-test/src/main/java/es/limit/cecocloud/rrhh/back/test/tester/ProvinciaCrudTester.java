/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Pais;
import es.limit.cecocloud.rrhh.logic.api.dto.Provincia;

/**
 * Tester pels objectes de tipus Provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProvinciaCrudTester extends AbstractCrudTester<Provincia> {

	@Override
	public Provincia createDto() {
		Provincia dto = new Provincia();
		dto.setCodi("TST");
		dto.setNom(TestUtils.NOM_TEST);
		dto.setPais(getGenericReferenceWithCompositePk(Pais.class));
		return dto;
	}

	@Override
	public void updateDto(Provincia dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
	}

	@Override
	public void compareDto(Provincia expected, Provincia actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new PaisCrudTester() };
	}

}
