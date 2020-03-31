/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusComissio;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus tipusComissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TipusComissioCrudTester extends AbstractCrudTester<TipusComissio> {

	@Override
	public TipusComissio createDto() {
		TipusComissio dto = new TipusComissio();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(TipusComissio dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public TipusComissio update(TipusComissio dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
		dto.setDescripcio(TestUtils.DES_TEST);
		dto.setMinim(TestUtils.BDECIMAL_TEST);
		dto.setPercentatge(TestUtils.BDECIMAL_TEST);
		return dto;
	}

	@Override
	public void compareDto(TipusComissio expected, TipusComissio actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getMinim(), actual.getMinim());
		assertEquals(expected.getPercentatge(), actual.getPercentatge());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
