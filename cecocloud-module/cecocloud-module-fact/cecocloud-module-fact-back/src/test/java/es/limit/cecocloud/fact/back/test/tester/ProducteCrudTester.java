/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.Producte;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Producte.
 * 
 * TO DO
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProducteCrudTester extends AbstractCrudTester<Producte> {

	@Override
	public Producte createDto() {
		Producte dto = new Producte();		
		dto.setReferencia(1);
		dto.setCodi("TST");
		dto.setNom("Nom TST");
		dto.setDescripcio("Desc TST");
		dto.setObservacions("Obs TST");
		
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
//		dto.setProducte(getGenericReferenceWithCompositePkFromParentCrudTester(Producte.class));
		
		return dto;
	}

	@Override
	public void updateDto(Producte dto) {	
		dto.setCodi("TST2");
		dto.setNom("Nom TST2");
		dto.setDescripcio("Desc TST2");
		dto.setObservacions("Obs TST2");
	}

	@Override
	public void compareDto(Producte expected, Producte actual) {		
		assertEquals(expected.getReferencia(),actual.getReferencia());
		assertEquals(expected.getCodi(),actual.getCodi());
		assertEquals(expected.getDescripcio(),actual.getDescripcio());
		assertEquals(expected.getObservacions(),actual.getObservacions());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester()
//			new ProducteCrudTester()
		};
	}

}
