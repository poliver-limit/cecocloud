/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus naturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class NaturalesaPagamentCobramentCrudTester extends AbstractCrudTester<NaturalesaPagamentCobrament> {

	@Override
	public NaturalesaPagamentCobrament createDto() {
		NaturalesaPagamentCobrament dto = new NaturalesaPagamentCobrament();
		dto.setCodi("TEST");
		dto.setDescripcio("TEST");
		dto.setObservacions("TEST");
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(NaturalesaPagamentCobrament dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setObservacions("TEST2");
	}

	@Override
	public void compareDto(NaturalesaPagamentCobrament expected, NaturalesaPagamentCobrament actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getObservacions(), actual.getObservacions());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
