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
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.Iva;
import es.limit.cecocloud.fact.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.RegimIva;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus document de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DocumentPagamentCobramentCrudTester extends AbstractCrudTester<DocumentPagamentCobrament> {

	@Override
	public DocumentPagamentCobrament createDto() {
		DocumentPagamentCobrament dto = new DocumentPagamentCobrament();
		dto.setCodi("TEST");
		dto.setDescripcio("TST");
		dto.setControlarEfectes(false);
		dto.setAgruparVencimentsRemeses(false);
		dto.setNumeroDias(1);
		dto.setDiaEfectosNegociados(1);
		dto.setAplicarDescuentosProntoPago(false);
		dto.setTranspasar(false);
		dto.setAsientoCompuesto(false);
		dto.setCodigoContable("TEST");
		dto.setCodigoFacturaElectronica("TT");
		dto.setPercentatgeComisio(new BigDecimal(1));
		dto.setCompteContableComissio("TEST");
		dto.setConcepteContable("TEST");
		dto.setCompteContableOrigenIngressos("TEST");
		dto.setTipusSeientIngressos("TT");
		dto.setDiariContableIngressos("TT");
		dto.setDiariContableIngressos2("TT");
		dto.setCompteContableDestiPagos("TT");
		dto.setTipusSeientPagos("TT");
		dto.setDiariContablePagos("TT");
		dto.setDiariContablePagos2("TT");
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setNaturalesaPagamentCobrament(getGenericReferenceWithCompositePk(NaturalesaPagamentCobrament.class));
		dto.setIva(getGenericReferenceWithCompositePk(Iva.class));
		dto.setRegimIva(getGenericReferenceWithCompositePk(RegimIva.class));
		return dto;
	}

	@Override
	public void updateDto(DocumentPagamentCobrament dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setControlarEfectes(true);
		dto.setAgruparVencimentsRemeses(true);
		dto.setNumeroDias(2);
		dto.setDiaEfectosNegociados(2);
		dto.setAplicarDescuentosProntoPago(true);
		dto.setTranspasar(true);
		dto.setAsientoCompuesto(true);
		dto.setCodigoContable("TST2");
		dto.setCodigoFacturaElectronica("T2");
		dto.setPercentatgeComisio(new BigDecimal(2));
		dto.setCompteContableComissio("TEST2");
		dto.setConcepteContable("TEST2");
		dto.setCompteContableOrigenIngressos("TEST2");
		dto.setTipusSeientIngressos("T2");
		dto.setDiariContableIngressos("T2");
		dto.setDiariContableIngressos2("T2");
		dto.setCompteContableDestiPagos("T2");
		dto.setTipusSeientPagos("T2");
		dto.setDiariContablePagos("T2");
		dto.setDiariContablePagos2("T2");
	}

	@Override
	public void compareDto(DocumentPagamentCobrament expected, DocumentPagamentCobrament actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getControlarEfectes(), actual.getControlarEfectes());
		assertEquals(expected.getAgruparVencimentsRemeses(), actual.getAgruparVencimentsRemeses());
		assertEquals(expected.getNumeroDias(), actual.getNumeroDias());
		assertEquals(expected.getDiaEfectosNegociados(), actual.getDiaEfectosNegociados());
		assertEquals(expected.getAplicarDescuentosProntoPago(), actual.getAplicarDescuentosProntoPago());
		assertEquals(expected.isTranspasar(), actual.isTranspasar());
		assertEquals(expected.isAsientoCompuesto(), actual.isAsientoCompuesto());
		assertEquals(expected.getCodigoContable(), actual.getCodigoContable());
		assertEquals(expected.getCodigoFacturaElectronica(), actual.getCodigoFacturaElectronica());
		assertTrue(expected.getPercentatgeComisio().compareTo(actual.getPercentatgeComisio()) == 0);
		assertEquals(expected.getCompteContableComissio(), actual.getCompteContableComissio());
		assertEquals(expected.getTipusSeientIngressos(), actual.getTipusSeientIngressos());
		assertEquals(expected.getDiariContableIngressos(), actual.getDiariContableIngressos());
		assertEquals(expected.getDiariContableIngressos2(), actual.getDiariContableIngressos2());
		assertEquals(expected.getCompteContableDestiPagos(), actual.getCompteContableDestiPagos());
		assertEquals(expected.getTipusSeientPagos(), actual.getTipusSeientPagos());
		assertEquals(expected.getDiariContablePagos(), actual.getDiariContablePagos());
		assertEquals(expected.getDiariContablePagos2(), actual.getDiariContablePagos2());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new NaturalesaPagamentCobramentCrudTester(),
			new IvaCrudTester(),
			new RegimIvaCrudTester()
		};
	}

}
