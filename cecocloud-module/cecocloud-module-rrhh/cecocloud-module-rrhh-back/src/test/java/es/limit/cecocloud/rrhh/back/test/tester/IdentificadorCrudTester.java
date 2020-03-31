/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;

/**
 * Tester pels objectes de tipus Identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorCrudTester extends AbstractCrudTester<Identificador> {

	@Override
	public Identificador createDto() {
		Identificador dto = new Identificador();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		dto.setPerfilDefecte(getGenericReferenceFromParentCrudTester(Perfil.class));
		dto.setPropietari(getGenericReferenceFromParentCrudTester(Usuari.class));
		return dto;
	}

	@Override
	public void updateDto(Identificador dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Identificador update(Identificador dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio(TestUtils.DES_TEST);
		dto.setDataFi(new Date());
		dto.setDataInici(new Date());
		dto.setEmpresesCount(1);
		dto.setNumEmpreses(1);
		dto.setNumOperaris(1);
		dto.setNumUsuaris(1);
		dto.setOperarisCount(1);
		dto.setUsuarisCount(1);
		return dto;
	}

	@Override
	public void compareDto(Identificador expected, Identificador actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
	assertEquals(expected.getDataFi(), actual.getDataFi());
	assertEquals(expected.getDataInici(), actual.getDataInici());
	assertEquals(expected.getEmpresesCount(), actual.getEmpresesCount());
	assertEquals(expected.getNumEmpreses(), actual.getNumEmpreses());
	assertEquals(expected.getNumOperaris(), actual.getNumOperaris());
	assertEquals(expected.getNumUsuaris(), actual.getNumUsuaris());
	assertEquals(expected.getOperarisCount(), actual.getOperarisCount());
	assertEquals(expected.getUsuarisCount(), actual.getUsuarisCount());

	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester() };
	}

}
