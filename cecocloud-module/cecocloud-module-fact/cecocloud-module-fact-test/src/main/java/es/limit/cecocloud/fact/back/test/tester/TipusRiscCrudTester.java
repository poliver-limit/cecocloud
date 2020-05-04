/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.TipusRisc;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus de risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TipusRiscCrudTester extends AbstractCrudTester<TipusRisc> {

	@Override
	public TipusRisc createDto() {
		TipusRisc dto = new TipusRisc();
		dto.setCodi("TEST");
		dto.setDescripcio("TEST");
		dto.setTri_pensrv(1);
		dto.setTri_albnotfac(1);
		dto.setTri_vtopennotvnt(1);
		dto.setTri_vtopenvnt(1);
		dto.setTri_efeneg(1);
		dto.setTri_albnotfac(1);
		dto.setTri_nifigu(true);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(TipusRisc dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setTri_pensrv(2);
		dto.setTri_albnotfac(2);
		dto.setTri_vtopennotvnt(2);
		dto.setTri_vtopenvnt(2);
		dto.setTri_efeneg(2);
		dto.setTri_albnotfac(2);
		dto.setTri_nifigu(false);
	}

	@Override
	public void compareDto(TipusRisc expected, TipusRisc actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getTri_pensrv(), actual.getTri_pensrv());
		assertEquals(expected.getTri_albnotfac(), actual.getTri_albnotfac());
		assertEquals(expected.getTri_vtopennotvnt(), actual.getTri_vtopennotvnt());
		assertEquals(expected.getTri_vtopenvnt(), actual.getTri_vtopenvnt());
		assertEquals(expected.getTri_efeneg(), actual.getTri_efeneg());
		assertEquals(expected.getTri_albnotfac(), actual.getTri_albnotfac());
		assertEquals(expected.getTri_nifigu(), actual.getTri_nifigu());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
