/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
import es.limit.cecocloud.rrhh.logic.api.dto.Interval;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus interval.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IntervalCrudTester extends AbstractCrudTester<Interval> {

	@Override
	public Interval createDto() {
		Interval dto = new Interval();
		dto.setCodi(TestUtils.CODI_TEST);
		dto.setOperari(getGenericReferenceWithCompositePk(Operari.class));
		dto.setDiaCalendari(getGenericReferenceWithCompositePk(Calendari.class));
		dto.setZona(getGenericReferenceWithCompositePk(Zona.class));
	
		dto = this.update(dto);
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Interval dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Interval update(Interval dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setConcepteFeinaCodi("cFCo");
		dto.setDataEntrada(new Date());
		dto.setDataFi(new Date());
		dto.setDataInici(new Date());
		dto.setFullFeinaOperariCodi(1);
		dto.setNumeroNodeEnt(1);
		dto.setNumeroNodeSor(1);
		dto.setObservacio(TestUtils.OBS_TEST);
	
		return dto;
	}

	@Override
	public void compareDto(Interval expected, Interval actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getConcepteFeinaCodi(), actual.getConcepteFeinaCodi());
		assertEquals(expected.getDataEntrada(), actual.getDataEntrada());
		assertEquals(expected.getDataFi(), actual.getDataFi());
		assertEquals(expected.getDataInici(), actual.getDataInici());
		assertEquals(expected.getFullFeinaOperariCodi(), actual.getFullFeinaOperariCodi());
		assertEquals(expected.getNumeroNodeEnt(), actual.getNumeroNodeEnt());
		assertEquals(expected.getNumeroNodeSor(), actual.getNumeroNodeSor());
		assertEquals(expected.getObservacio(), actual.getObservacio());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(),
				new OperariCrudTester(),
				new ZonaCrudTester(),
				new CalendariCrudTester()};
	}

}
