/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.SerieCompra;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus serie de compra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class SerieCompraCrudTester extends AbstractCrudTester<SerieCompra> {

	@Override
	public SerieCompra createDto() {
		SerieCompra dto = new SerieCompra();
		dto.setCodi("TT");
		dto.setDescripcio("TEST");
		dto.setTipusSeientComptable("TT");
		dto.setDiariComptable("TT");
		dto.setCompteComptableCompres("TEST");
		dto.setDiariComptableProformes("TT");
		dto.setCompteComptableCompresProformes("TEST");
		dto.setValidDesde(new Date());
		dto.setValidFins(new Date());
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		return dto;
	}

	@Override
	public void updateDto(SerieCompra dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setTipusSeientComptable("T2");
		dto.setDiariComptable("T2");
		dto.setCompteComptableCompres("TEST2");
		dto.setDiariComptableProformes("T2");
		dto.setCompteComptableCompresProformes("TEST2");
		dto.setValidDesde(new Date());
		dto.setValidFins(new Date());
	}

	@Override
	public void compareDto(SerieCompra expected, SerieCompra actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getTipusSeientComptable(), actual.getTipusSeientComptable());
		assertEquals(expected.getDiariComptable(), actual.getDiariComptable());
		assertEquals(expected.getCompteComptableCompres(), actual.getCompteComptableCompres());
		assertEquals(expected.getDiariComptableProformes(), actual.getDiariComptableProformes());
		assertEquals(expected.getCompteComptableCompresProformes(), actual.getCompteComptableCompresProformes());
		assertEquals(expected.getValidDesde(), actual.getValidDesde());
		assertEquals(expected.getValidFins(), actual.getValidFins());
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
