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
import es.limit.cecocloud.rrhh.logic.api.dto.Node;
import es.limit.cecocloud.rrhh.logic.api.dto.Servidor;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus node.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class NodeCrudTester extends AbstractCrudTester<Node> {

	@Override
	public Node createDto() {
		Node dto = new Node();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		dto.setZonaDesti(getGenericReferenceWithCompositePk(Zona.class));
		dto.setZonaOrigen(getGenericReferenceWithCompositePk(Zona.class));
		dto.setServidor(getGenericReferenceWithCompositePk(Servidor.class));
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Node dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Node update(Node dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setTipus("tipus");
		dto.setTipus1("tipus1");
		return dto;
	}

	@Override
	public void compareDto(Node expected, Node actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getTipus(), actual.getTipus());
		assertEquals(expected.getTipus1(), actual.getTipus1());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(), new ZonaCrudTester(), new ServidorCrudTester() };
	}

}
