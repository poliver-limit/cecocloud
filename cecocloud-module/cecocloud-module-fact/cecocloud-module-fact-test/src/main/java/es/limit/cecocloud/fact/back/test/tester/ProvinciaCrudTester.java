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
import es.limit.cecocloud.fact.logic.api.dto.Provincia;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

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
		dto.setNom("Test");
		
		dto.setPais(getGenericReferenceWithCompositePkFromParentCrudTester(Pais.class));
		
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@Override
	public void updateDto(Provincia dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom("Test2");
	}

	@Override
	public void compareDto(Provincia expected, Provincia actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new PaisCrudTester()
		};
	}

}
