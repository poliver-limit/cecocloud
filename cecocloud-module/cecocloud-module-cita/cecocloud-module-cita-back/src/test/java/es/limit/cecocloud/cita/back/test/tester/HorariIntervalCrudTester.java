/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.DiaSetmana;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels recursos de tipus interval horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class HorariIntervalCrudTester extends AbstractCrudTester<HorariInterval> {

	@Override
	public HorariInterval createDto() {
		HorariInterval dto = new HorariInterval();
		dto.setDiaSetmana(DiaSetmana.DILLUNS);
		dto.setHoraInici(LocalTime.of(10, 0));
		dto.setHoraFi(LocalTime.of(20, 0));
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setHorari(getGenericReferenceWithCompositePk(Horari.class));
		return dto;
	}

	@Override
	public void updateDto(HorariInterval dto) {
		dto.setDiaSetmana(DiaSetmana.DIMARTS);
		dto.setHoraInici(LocalTime.of(9, 0));
		dto.setHoraFi(LocalTime.of(21, 0));
	}

	@Override
	public void compareDto(HorariInterval expected, HorariInterval actual) {
		assertNotNull(actual.getSequencia());
		assertEquals(expected.getDiaSetmana(), actual.getDiaSetmana());
		assertEquals(expected.getHoraInici().truncatedTo(ChronoUnit.SECONDS), actual.getHoraInici().truncatedTo(ChronoUnit.SECONDS));
		assertEquals(expected.getHoraFi().truncatedTo(ChronoUnit.SECONDS), actual.getHoraFi().truncatedTo(ChronoUnit.SECONDS));
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new HorariCrudTester()
		};
	}

}
