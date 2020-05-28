/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.logic.api.dto.PuntVenda;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels recursos que relacionen un punt de venda amb un horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PuntVendaHorariCrudTester extends AbstractCrudTester<PuntVendaHorari> {

	@Override
	public PuntVendaHorari createDto() {
		PuntVendaHorari dto = new PuntVendaHorari();
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setPuntVenda(getGenericReferenceWithCompositePk(PuntVenda.class));
		dto.setHorari(getGenericReferenceWithCompositePk(Horari.class));
		// La següent cridada crea un interval per a l'horari
		getResource(HorariInterval.class);
		return dto;
	}

	@Override
	public void updateDto(PuntVendaHorari dto) {
	}

	@Override
	public void compareDto(PuntVendaHorari expected, PuntVendaHorari actual) {
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new PuntVendaCrudTester(),
			new HorariCrudTester(),
			new HorariIntervalCrudTester()
		};
	}

}
