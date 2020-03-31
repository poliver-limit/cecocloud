/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Banc;
import es.limit.cecocloud.rrhh.logic.api.dto.CodiPostal;
import es.limit.cecocloud.rrhh.logic.api.dto.OficinaBancaria;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus oficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class OficinaBancariaCrudTester extends AbstractCrudTester<OficinaBancaria> {

	@Override
	public OficinaBancaria createDto() {
		OficinaBancaria dto = new OficinaBancaria();
		dto.setCodi(TestUtils.CODI_INTEGER_TEST);
		dto = this.update(dto);
		dto.setCodiPostal(getGenericReferenceWithCompositePkFromParentCrudTester(CodiPostal.class));
		dto.setBanc(getGenericReferenceWithCompositePkFromParentCrudTester(Banc.class));
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(OficinaBancaria dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public OficinaBancaria update(OficinaBancaria dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setContacte("contacte");
		dto.setDomicili("domicili");
		dto.setFax("630690159");
		dto.setTelefon("630690159");
		dto.setObservacions(TestUtils.OBS_TEST);
		return dto;
	}

	@Override
	public void compareDto(OficinaBancaria expected, OficinaBancaria actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getContacte(), actual.getContacte());
		assertEquals(expected.getDomicili(), actual.getDomicili());
		assertEquals(expected.getFax(), actual.getFax());
		assertEquals(expected.getTelefon(), actual.getTelefon());
		assertEquals(expected.getObservacions(), actual.getObservacions());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
