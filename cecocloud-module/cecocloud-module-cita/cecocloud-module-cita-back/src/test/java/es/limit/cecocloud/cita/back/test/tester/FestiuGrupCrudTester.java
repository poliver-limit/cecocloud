/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.FestiuGrup;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels recursos de tipus grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class FestiuGrupCrudTester extends AbstractCrudTester<FestiuGrup> {

	@Override
	public FestiuGrup createDto() {
		FestiuGrup dto = new FestiuGrup();
		dto.setCodi("TEST");
		dto.setNom("TEST");
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(FestiuGrup dto) {
		dto.setNom("TEST2");
	}

	@Override
	public void compareDto(FestiuGrup expected, FestiuGrup actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
