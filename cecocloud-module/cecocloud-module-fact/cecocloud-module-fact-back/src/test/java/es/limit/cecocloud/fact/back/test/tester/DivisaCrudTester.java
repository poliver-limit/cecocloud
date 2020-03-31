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
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Divisa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DivisaCrudTester extends AbstractCrudTester<Divisa> {

	@Override
	public Divisa createDto() {
		Divisa dto = new Divisa();
		dto.setCodi("TEST");		
		dto.setNom("Test");
		dto.setAbreviatura("Tst");
		dto.setValorEuros(new BigDecimal("7357.757"));
		dto.setDecimalsPreus(7);
		dto.setDecimalsImports(7);
		dto.setCodiComptabilitat("A");	
		
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@Override
	public void updateDto(Divisa dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom("Test2");
		dto.setAbreviatura("Tst2");
		dto.setValorEuros(new BigDecimal("7357.772"));
		dto.setDecimalsPreus(72);
		dto.setDecimalsImports(72);
		dto.setCodiComptabilitat("B");	
	}

	@Override
	public void compareDto(Divisa expected, Divisa actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getAbreviatura(), actual.getAbreviatura());
		assertTrue(expected.getValorEuros().compareTo(actual.getValorEuros()) == 0);		
		assertEquals(expected.getDecimalsPreus(), actual.getDecimalsPreus());
		assertEquals(expected.getDecimalsImports(), actual.getDecimalsImports());
		assertEquals(expected.getCodiComptabilitat(), actual.getCodiComptabilitat());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
