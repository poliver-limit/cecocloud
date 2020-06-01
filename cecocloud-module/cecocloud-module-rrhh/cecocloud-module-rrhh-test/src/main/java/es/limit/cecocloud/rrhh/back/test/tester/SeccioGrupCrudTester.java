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
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus seccioGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class SeccioGrupCrudTester extends AbstractCrudTester<SeccioGrup> {

	@Override
	public SeccioGrup createDto() {
		SeccioGrup dto = new SeccioGrup();
		dto.setCodi(TestUtils.CODI_TEST);
		dto.setNom(TestUtils.NOM_TEST);
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setEmpresa(getGenericReferenceWithCompositePk(Empresa.class));
		return dto;
	}

	@Override
	public void updateDto(SeccioGrup dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST + "2");
	}

	@Override
	public void compareDto(SeccioGrup expected, SeccioGrup actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
				new IdentificadorCrudTester(),
				new EmpresaCrudTester()
		};
	}

}
