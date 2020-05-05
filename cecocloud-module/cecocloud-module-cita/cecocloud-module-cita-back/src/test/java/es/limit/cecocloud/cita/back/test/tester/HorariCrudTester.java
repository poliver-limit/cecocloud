/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels recursos de tipus horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class HorariCrudTester extends AbstractCrudTester<Horari> {

	@Override
	public Horari createDto() {
		Horari dto = new Horari();
		dto.setCodi("TEST");
		dto.setNom("TEST");
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Horari dto) {
		dto.setNom("TEST2");
	}

	@Override
	public void compareDto(Horari expected, Horari actual) {
		assertEquals(expected.getCodi(),actual.getCodi());
		assertEquals(expected.getNom(),actual.getNom());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
