/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.dto.PuntVenda;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.EmpresaCrudTester;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels recursos de tipus cita.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CitaCrudTester extends AbstractCrudTester<Cita> {

	@Override
	public Cita createDto() {
		Cita dto = new Cita();
		// Per a que hi hagi disponibilitat hem de triar el primer dilluns a les 10.00 del matí
		LocalDateTime data = LocalDateTime.now().withHour(10).withMinute(0).withSecond(0).withNano(0);
		while (data.getDayOfWeek() != DayOfWeek.MONDAY) {
			data = data.plusDays(1);
		}
		dto.setData(data);
		dto.setNom("Test");
		dto.setLlinatges("Test");
		dto.setTelefon("123456789");
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		Empresa empresa = getResource(Empresa.class);
		dto.setEmpresa(
				GenericReferenceWithCompositePk.toGenericReference(
						new WithIdentificadorAndCodiPk<String>(
								identificador.getCodi(),
								empresa.getCodi())));
		dto.setPuntVenda(getGenericReferenceWithCompositePk(PuntVenda.class));
		// La següent cridada crea un horari pel punt de venda
		getResource(PuntVendaHorari.class);
		return dto;
	}

	@Override
	public void updateDto(Cita dto) {
		dto.setData(dto.getData().plusMinutes(10));
		dto.setNom("Test1");
		dto.setLlinatges("Test1");
		dto.setTelefon("123456780");
	}

	@Override
	public void compareDto(Cita expected, Cita actual) {
		assertNotNull(actual.getSequencia());
		assertNotNull(actual.getCodi());
		assertEquals(expected.getData(), actual.getData());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester(),
			new PuntVendaCrudTester(),
			new PuntVendaHorariCrudTester()
		};
	}

}
