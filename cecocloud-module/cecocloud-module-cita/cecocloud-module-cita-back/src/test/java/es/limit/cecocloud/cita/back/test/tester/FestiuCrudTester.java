/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Festiu;
import es.limit.cecocloud.cita.logic.api.dto.FestiuGrup;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels recursos de tipus festiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class FestiuCrudTester extends AbstractCrudTester<Festiu> {

	@Override
	public Festiu createDto() {
		Festiu dto = new Festiu();
		dto.setNom("TEST");
		dto.setDiaMes(LocalDate.now());
		dto.setAny(1);
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setFestiuGrup(getGenericReferenceWithCompositePkFromParentCrudTester(FestiuGrup.class));
		return dto;
	}

	@Override
	public void updateDto(Festiu dto) {
		dto.setNom("TEST2");
		dto.setDiaMes(LocalDate.now().plusDays(1));
		dto.setAny(2);
	}

	@Override
	public void compareDto(Festiu expected, Festiu actual) {
		assertNotNull(actual.getSequencia());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getDiaMes(), actual.getDiaMes());
		assertEquals(expected.getAny(), actual.getAny());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new FestiuGrupCrudTester()
		};
	}

}
