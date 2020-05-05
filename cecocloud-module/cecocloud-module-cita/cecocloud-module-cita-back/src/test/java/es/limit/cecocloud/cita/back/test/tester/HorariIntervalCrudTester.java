/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

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
		dto.setHoraInici(new Date());
		dto.setHoraFi(new Date());
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setHorari(getGenericReferenceWithCompositePkFromParentCrudTester(Horari.class));
		return dto;
	}

	@Override
	public void updateDto(HorariInterval dto) {
		dto.setDiaSetmana(DiaSetmana.DIMARTS);
		dto.setHoraInici(new Date());
		dto.setHoraFi(new Date());
	}

	@Override
	public void compareDto(HorariInterval expected, HorariInterval actual) {
		assertNotNull(actual.getSequencia());
		assertEquals(expected.getDiaSetmana(), actual.getDiaSetmana());
		assertEquals(expected.getHoraInici(), actual.getHoraInici());
		assertEquals(expected.getHoraFi(), actual.getHoraFi());
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
