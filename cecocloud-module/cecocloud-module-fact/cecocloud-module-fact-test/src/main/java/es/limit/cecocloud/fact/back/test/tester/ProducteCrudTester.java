/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.Producte;
import es.limit.cecocloud.fact.logic.api.dto.enums.ProducteTipusEnumDto;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Producte.
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
		dto.setActiu(true);
		
		dto.setTipus(ProducteTipusEnumDto.PRODUCTE);		
		
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@Override
	public void updateDto(Producte dto) {	
		dto.setCodi("TST2");
		dto.setNom("Nom TST2");
		dto.setDescripcio("Desc TST2");
		dto.setObservacions("Obs TST2");
		dto.setActiu(false);
		
		dto.setTipus(ProducteTipusEnumDto.APLICACIO);		
	}

	@Override
	public void compareDto(Producte expected, Producte actual) {		
		assertEquals(expected.getReferencia(),actual.getReferencia());
		assertEquals(expected.getCodi(),actual.getCodi());
		assertEquals(expected.getDescripcio(),actual.getDescripcio());
		assertEquals(expected.getObservacions(),actual.getObservacions());
		assertEquals(expected.getActiu(),actual.getActiu());
		
		assertEquals(expected.getTipus(),actual.getTipus());
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
