/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Zona;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ZonaCrudTester extends AbstractCrudTester<Zona> {

	private static final String CODI = "tst";
	private static final String CODI_PROCESSAT = CODI.toUpperCase();

	@Override
	public Zona createDto() {
		Zona dto = new Zona();
		dto.setCodi(CODI);
		dto.setNom("Test");
		dto.setDescripcio("Descripció de prova");
		dto.setRadioKm(1);
		
		dto.setPreu(new BigDecimal(1));
		
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@Override
	public void updateDto(Zona dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom("Test2");
		dto.setDescripcio("Descripció de prova2");
		dto.setRadioKm(2);
		
		dto.setPreu(new BigDecimal(2));
	}

	@Override
	public void compareDto(Zona expected, Zona actual) {
		assertEquals(CODI_PROCESSAT, actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getRadioKm(), actual.getRadioKm());
		
		assertEquals(expected.getPreu().compareTo(actual.getPreu()), 0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
