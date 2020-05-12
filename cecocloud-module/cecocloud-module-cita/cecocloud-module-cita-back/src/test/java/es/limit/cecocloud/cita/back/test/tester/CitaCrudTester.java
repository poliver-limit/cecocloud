/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.fact.back.test.tester.EmpresaCrudTester;
import es.limit.cecocloud.fact.back.test.tester.PuntVendaCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda;
import es.limit.cecocloud.logic.api.dto.Identificador;
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
		//dto.setCodi("TEST");
		dto.setData(LocalDateTime.now());
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		dto.setPuntVenda(getGenericReferenceWithCompositePkFromParentCrudTester(PuntVenda.class));
		return dto;
	}

	@Override
	public void updateDto(Cita dto) {
		dto.setData(LocalDateTime.now().plusDays(1));
	}

	@Override
	public void compareDto(Cita expected, Cita actual) {
		assertNotNull(actual.getSequencia());
		assertNotNull(actual.getCodi());
		System.out.println(">>> codi:" + actual.getCodi());
		assertEquals(expected.getData(), actual.getData());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester(),
			new PuntVendaCrudTester()
		};
	}

}
