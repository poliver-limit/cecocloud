/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Departament;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.PeuDocument;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda;
import es.limit.cecocloud.fact.logic.api.dto.enums.SerieFacturaRectificativaEnumDto;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.EmpresaCrudTester;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus serie de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class SerieVendaCrudTester extends AbstractCrudTester<SerieVenda> {

	@Override
	public SerieVenda createDto() {
		SerieVenda dto = new SerieVenda();
		dto.setCodi("TT");
		dto.setDescripcio("TEST");
		dto.setDarrerAlbara(1);
		dto.setDarreraFactura(1);
		dto.setDarrerPressupost(1);
		dto.setDarreraFacturaProforma(1);
		dto.setDarrerAlbaraProforma(1);
		dto.setDarreraFacturaAnyAnterior(1);
		dto.setTraspassarAComptabilitat(false);
		dto.setCombinarCompteVendaAmbClient(false);
		dto.setTipusAssentamentContable("TT");
		dto.setDiariContable("TT");
		dto.setCompteVendes("TEST");
		dto.setCompteVendesEntitatsPubliques("TEST");
		dto.setDiariContableProformes("TT");
		dto.setCompteVendesProformaEntPub("TEST");
		dto.setComptePressupost("TEST");
		dto.setCompteEntPubPressupost("TEST");
		dto.setCompteProformaPressupost("TEST");
		dto.setCompteProformaEntPubPressupost("TEST");
		dto.setFacturaTitol("TEST");
		dto.setCompteVendesProforma("TEST");
		dto.setValidDesde(new Date());
		dto.setValidFins(new Date());
		dto.setNcf("TEST");
		dto.setNumeracioManual(false);
		dto.setAplicarDescompte(false);
		dto.setFacturaRectificativa(SerieFacturaRectificativaEnumDto.SI);
		dto.setDesglossarIva(false);
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		Empresa empresa = getResource(Empresa.class);
		dto.setEmpresa(
				GenericReferenceWithCompositePk.toGenericReference(
						new WithIdentificadorAndCodiPk<String>(
								identificador.getCodi(),
								empresa.getCodi())));
		dto.setCondicioPagamentPressupost(getGenericReferenceWithCompositePk(PeuDocument.class));
		dto.setPeuDocument(getGenericReferenceWithCompositePk(PeuDocument.class));
		dto.setMagatzem(getGenericReferenceWithCompositePk(Magatzem.class));
		dto.setEmpresaOp(
				GenericReferenceWithCompositePk.toGenericReference(
						new WithIdentificadorAndCodiPk<String>(
								identificador.getCodi(),
								empresa.getCodi())));
		dto.setDepartament(getGenericReferenceWithCompositePk(Departament.class));
		return dto;
	}

	@Override
	public void updateDto(SerieVenda dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setDarrerAlbara(2);
		dto.setDarreraFactura(2);
		dto.setDarrerPressupost(2);
		dto.setDarreraFacturaProforma(2);
		dto.setDarrerAlbaraProforma(2);
		dto.setDarreraFacturaAnyAnterior(2);
		dto.setTraspassarAComptabilitat(true);
		dto.setCombinarCompteVendaAmbClient(true);
		dto.setTipusAssentamentContable("T2");
		dto.setDiariContable("T2");
		dto.setCompteVendes("TEST2");
		dto.setCompteVendesEntitatsPubliques("TEST2");
		dto.setDiariContableProformes("T2");
		dto.setCompteVendesProformaEntPub("TEST2");
		dto.setComptePressupost("TEST2");
		dto.setCompteEntPubPressupost("TEST2");
		dto.setCompteProformaPressupost("TEST2");
		dto.setCompteProformaEntPubPressupost("TEST2");
		dto.setFacturaTitol("TEST2");
		dto.setCompteVendesProforma("TEST2");
		dto.setValidDesde(new Date());
		dto.setValidFins(new Date());
		dto.setNcf("TEST2");
		dto.setNumeracioManual(true);
		dto.setAplicarDescompte(true);
		dto.setFacturaRectificativa(SerieFacturaRectificativaEnumDto.NO);
		dto.setDesglossarIva(true);
	}

	@Override
	public void compareDto(SerieVenda expected, SerieVenda actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getDarrerAlbara(), actual.getDarrerAlbara());
		assertEquals(expected.getDarreraFactura(), actual.getDarreraFactura());
		assertEquals(expected.getDarrerPressupost(), actual.getDarrerPressupost());
		assertEquals(expected.getDarreraFacturaProforma(), actual.getDarreraFacturaProforma());
		assertEquals(expected.getDarrerAlbaraProforma(), actual.getDarrerAlbaraProforma());
		assertEquals(expected.getDarreraFacturaAnyAnterior(), actual.getDarreraFacturaAnyAnterior());
		assertEquals(expected.getTraspassarAComptabilitat(), actual.getTraspassarAComptabilitat());
		assertEquals(expected.getCombinarCompteVendaAmbClient(), actual.getCombinarCompteVendaAmbClient());
		assertEquals(expected.getTipusAssentamentContable(), actual.getTipusAssentamentContable());
		assertEquals(expected.getDiariContable(), actual.getDiariContable());
		assertEquals(expected.getCompteVendes(), actual.getCompteVendes());
		assertEquals(expected.getCompteVendesEntitatsPubliques(), actual.getCompteVendesEntitatsPubliques());
		assertEquals(expected.getDiariContableProformes(), actual.getDiariContableProformes());
		assertEquals(expected.getCompteVendesProformaEntPub(), actual.getCompteVendesProformaEntPub());
		assertEquals(expected.getComptePressupost(), actual.getComptePressupost());
		assertEquals(expected.getCompteProformaEntPubPressupost(), actual.getCompteProformaEntPubPressupost());
		assertEquals(expected.getFacturaTitol(), actual.getFacturaTitol());
		assertEquals(expected.getCompteVendesProforma(), actual.getCompteVendesProforma());
		assertEquals(expected.getValidDesde(), actual.getValidDesde());
		assertEquals(expected.getValidFins(), actual.getValidFins());
		assertEquals(expected.getNcf(), actual.getNcf());
		assertEquals(expected.isNumeracioManual(), actual.isNumeracioManual());
		assertEquals(expected.isAplicarDescompte(), actual.isAplicarDescompte());
		assertEquals(expected.getFacturaRectificativa(), actual.getFacturaRectificativa());
		assertEquals(expected.isDesglossarIva(), actual.isDesglossarIva());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester(),
			new PeuDocumentCrudTester(),
			new MagatzemCrudTester(),
			new DepartamentCrudTester()
		};
	}

}
