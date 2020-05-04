/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.PeuDocument;
import es.limit.cecocloud.fact.logic.api.dto.SerieCompra;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus peu de document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PeuDocumentCrudTester extends AbstractCrudTester<PeuDocument> {

	@Override
	public PeuDocument createDto() {
		PeuDocument dto = new PeuDocument();
		dto.setCodi("TEST");
		dto.setDescripcio("TEST");
		dto.setFactura(true);
		dto.setAlbara(true);
		dto.setPre(true);
		dto.setCom(true);
		dto.setImprimirPeuCertificacio(true);
		dto.setFamiliaCliProv(true);
		dto.setPie("TEST");
		dto.setImpCls(true);
		dto.setOrdre(new BigDecimal(1));
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		dto.setSerieCompra(getGenericReferenceWithCompositePkFromParentCrudTester(SerieCompra.class));
		return dto;
	}

	@Override
	public void updateDto(PeuDocument dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setFactura(false);
		dto.setAlbara(false);
		dto.setPre(false);
		dto.setCom(false);
		dto.setImprimirPeuCertificacio(false);
		dto.setFamiliaCliProv(false);
		dto.setPie("TEST2");
		dto.setImpCls(false);
		dto.setOrdre(new BigDecimal(2));
	}

	@Override
	public void compareDto(PeuDocument expected, PeuDocument actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getFactura(), actual.getFactura());
		assertEquals(expected.getAlbara(), actual.getAlbara());
		assertEquals(expected.getPre(), actual.getPre());
		assertEquals(expected.getCom(), actual.getCom());
		assertEquals(expected.getImprimirPeuCertificacio(), actual.getImprimirPeuCertificacio());
		assertEquals(expected.getFamiliaCliProv(), actual.getFamiliaCliProv());
		assertEquals(expected.getPie(), actual.getPie());
		assertEquals(expected.getImpCls(), actual.getImpCls());
		assertTrue(expected.getOrdre().compareTo(actual.getOrdre()) == 0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester(),
			new SerieCompraCrudTester()
		};
	}

}
