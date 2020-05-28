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
import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus tipusDia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TipusDiaCrudTester extends AbstractCrudTester<TipusDia> {

	@Override
	public TipusDia createDto() {
		TipusDia dto = new TipusDia();
		dto.setCodi(TestUtils.CODI_TEST);
		dto.setNom(TestUtils.NOM_TEST);
		dto.setRegim(getGenericReferenceWithCompositePk(Regim.class));
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(TipusDia dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
	}


	@Override
	public void compareDto(TipusDia expected, TipusDia actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(), new RegimCrudTester()  };
	}

}
