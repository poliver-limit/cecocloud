/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.Producte;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial;
import es.limit.cecocloud.fact.logic.api.dto.enums.RegistreComercialMitjaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RegistreComercialTipusEnumDto;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus RegistreComercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RegistreComercialCrudTester extends AbstractCrudTester<RegistreComercial> {

	@Override
	public RegistreComercial createDto() {
		RegistreComercial dto = new RegistreComercial();
		dto.setSequencia(new Integer("7357"));
		dto.setTipus(RegistreComercialTipusEnumDto.CORREU);
		dto.setMitja(RegistreComercialMitjaEnumDto.WEB);
		dto.setDescripcioMitja("TeSt@TeSt.TsT");
		dto.setInteressat("TeStEr");
		dto.setData(new Date());		
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		dto.setClient(getGenericReferenceWithCompositePkFromParentCrudTester(Client.class));
		dto.setProducte(getGenericReferenceWithCompositePkFromParentCrudTester(Producte.class));		
		return dto;
	}

	@Override
	public void updateDto(RegistreComercial dto) {
		// La seqüencia no es pot canviar perquè forma part de la clau primària
		dto.setTipus(RegistreComercialTipusEnumDto.CRIDADA);
		dto.setMitja(RegistreComercialMitjaEnumDto.PUBLICITAT);
		dto.setDescripcioMitja("TeSt2@TeSt.TsT");
		dto.setInteressat("TeStEr2");
		dto.setData(new Date());		
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		dto.setClient(getGenericReferenceWithCompositePkFromParentCrudTester(Client.class));
		dto.setProducte(getGenericReferenceWithCompositePkFromParentCrudTester(Producte.class));	
	}

	@Override
	public void compareDto(RegistreComercial expected, RegistreComercial actual) {		
		assertEquals(expected.getSequencia(), actual.getSequencia());
		assertEquals(expected.getTipus(), actual.getTipus());
		assertEquals(expected.getMitja(), actual.getMitja());
		assertEquals(expected.getDescripcioMitja(), actual.getDescripcioMitja());
		assertEquals(expected.getInteressat(), actual.getInteressat());
		assertEquals(expected.getData(), actual.getData());		
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester(),
			new ClientCrudTester(),
			new ProducteCrudTester()
		};
	}

}
