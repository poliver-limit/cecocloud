/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.rrhh.logic.api.dto.Torn;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TornCrudTester extends AbstractCrudTester<Torn> {

	@Override
	public Torn createDto() {
		Torn dto = new Torn();
		dto.setCodi("TEST");
		dto.setNom("Test");
		dto.setObservacions("Observacions");
		dto.setPrevalecenLosFestivos(true);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Torn dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom("Test");
		dto.setObservacions("Observacions");
		dto.setPrevalecenLosFestivos(true);
	}

	@Override
	public void compareDto(Torn expected, Torn actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getObservacions(), actual.getObservacions());
		assertEquals(expected.isPrevalecenLosFestivos(), actual.isPrevalecenLosFestivos());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
