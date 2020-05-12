/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Caixa;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus caixa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CaixaCrudTester extends AbstractCrudTester<Caixa> {

	@Override
	public Caixa createDto() {
		Caixa dto = new Caixa();
		dto.setCodi("TEST");
		dto.setDescripcio("TST");
		dto.setFerApuntComptable(true);
		dto.setObservacions("TST");
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		return dto;
	}

	@Override
	public void updateDto(Caixa dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TST2");
		dto.setFerApuntComptable(false);
		dto.setObservacions("TST2");
	}

	@Override
	public void compareDto(Caixa expected, Caixa actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getFerApuntComptable(), actual.getFerApuntComptable());
		assertEquals(expected.getObservacions(), actual.getObservacions());
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
