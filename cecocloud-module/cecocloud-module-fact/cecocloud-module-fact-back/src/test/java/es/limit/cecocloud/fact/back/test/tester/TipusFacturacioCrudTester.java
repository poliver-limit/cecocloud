/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus de facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TipusFacturacioCrudTester extends AbstractCrudTester<TipusFacturacio> {

	@Override
	public TipusFacturacio createDto() {
		TipusFacturacio dto = new TipusFacturacio();
		dto.setCodi("TEST");
		dto.setDescripcio("TST");
		dto.setConcedimCredit(true);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(TipusFacturacio dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TST2");
		dto.setConcedimCredit(false);
	}

	@Override
	public void compareDto(TipusFacturacio expected, TipusFacturacio actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.isConcedimCredit(), actual.isConcedimCredit());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
