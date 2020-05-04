/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.RegimIva;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusRegimEnumDto;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus règim d'IVA.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RegimIvaCrudTester extends AbstractCrudTester<RegimIva> {

	@Override
	public RegimIva createDto() {
		RegimIva dto = new RegimIva();
		dto.setCodi("TT");
		dto.setDescripcio("TEST");
		dto.setCodiComptabilitat("TT");
		dto.setTip(TipusRegimEnumDto.AGRARI);
		dto.setCodiFacturaElectronica("TT");
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(RegimIva dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setCodiComptabilitat("T2");
		dto.setTip(TipusRegimEnumDto.GENERAL);
		dto.setCodiFacturaElectronica("T2");
	}

	@Override
	public void compareDto(RegimIva expected, RegimIva actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getCodiComptabilitat(), actual.getCodiComptabilitat());
		assertEquals(expected.getTip(), actual.getTip());
		assertEquals(expected.getCodiFacturaElectronica(), actual.getCodiFacturaElectronica());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
