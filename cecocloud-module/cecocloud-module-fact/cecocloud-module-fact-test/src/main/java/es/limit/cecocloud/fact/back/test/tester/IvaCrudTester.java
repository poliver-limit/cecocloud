/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Iva;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus IVA.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IvaCrudTester extends AbstractCrudTester<Iva> {

	@Override
	public Iva createDto() {
		Iva dto = new Iva();
		dto.setCodi("TEST");
		dto.setDescripcio("TEST");
		dto.setPercentatgeIva(new BigDecimal(1));
		dto.setPercentatgeRecarrecEquivalencia(new BigDecimal(1));
		dto.setCodiComptabilitat("TEST");
		dto.setCodiRecarrecComptabilitat("TEST");
		dto.setText("TEST");
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Iva dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setPercentatgeIva(new BigDecimal(2));
		dto.setPercentatgeRecarrecEquivalencia(new BigDecimal(2));
		dto.setCodiComptabilitat("TES2");
		dto.setCodiRecarrecComptabilitat("TES2");
		dto.setText("TEST2");
	}

	@Override
	public void compareDto(Iva expected, Iva actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertTrue(expected.getPercentatgeIva().compareTo(actual.getPercentatgeIva()) == 0);
		assertTrue(expected.getPercentatgeRecarrecEquivalencia().compareTo(actual.getPercentatgeRecarrecEquivalencia()) == 0);
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getCodiComptabilitat(), actual.getCodiComptabilitat());
		assertEquals(expected.getCodiRecarrecComptabilitat(), actual.getCodiRecarrecComptabilitat());
		assertEquals(expected.getText(), actual.getText());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
