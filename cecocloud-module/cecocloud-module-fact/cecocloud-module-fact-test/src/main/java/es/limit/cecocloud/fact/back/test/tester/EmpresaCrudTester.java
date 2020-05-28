/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.enums.FacturacioTipusEnum;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusComptabilitatClientEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusEstrangerEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusPersonaEnumDto;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Empresa.
 * 
 * TO DO
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaCrudTester extends AbstractCrudTester<Empresa> {

	@Override
	public Empresa createDto() {
		
		Empresa dto = new Empresa();

		dto.setCodi(es.limit.cecoloud.test.tester.EmpresaCrudTester.EMPRESA_CODI_TEST);
		dto.setNif("12345678Z");
		dto.setNomComercial("NomComercial TST");
		dto.setDomiciliComercial("DomComercial TST");
		dto.setNomFiscal("NomFiscal TST");
		dto.setDomiciliFiscal("DomFiscal TST");
		dto.setRecarrecEquivalencia(true);
		dto.setTelefon("73757");
		dto.setFax("73757");
		dto.setEmail("Test@Test.TST");
		dto.setWeb("Web TST");
		dto.setComptabilitatAssentamentTipus("AA");
		dto.setDiarioFactProveedores("AB");
		dto.setDiarioProfProveedores("AC");
		dto.setComptabilitatCodi("CodiCmpt TST");
		dto.setRegistreMercantil("RegMerc TST");
		dto.setValorFacturacio(new BigDecimal("7357.71"));
		dto.setRegimCriteriCaixa(true);
		dto.setNomFiscal1("NomFisc1 TST");
		dto.setLlinatgeFiscal1("LlinFisc1 TST");
		dto.setLlinatgeFiscal2("LlinFisc2 TST");
		dto.setLogoImprimir(true);
		dto.setLogoPath("Path TST");
		dto.setTancamentData(new Date());		
		
		dto.setFacturacioTipus(FacturacioTipusEnum.ADMINISTRACIO);		
		dto.setComptabilitatClients(TipusComptabilitatClientEnumDto.ALTA);
		dto.setComptabilitatProveidors(TipusComptabilitatClientEnumDto.NO_TRACTAR);
		dto.setPersonaTipus(TipusPersonaEnumDto.FISICA);
		dto.setTipoResidencia(TipusEstrangerEnumDto.ESTRANGER);		
		
		dto.setCodiPostalComercial(getGenericReferenceWithCompositePk(CodiPostal.class));
		dto.setCodiPostalFiscal(getGenericReferenceWithCompositePk(CodiPostal.class));
		dto.setDivisa(getGenericReferenceWithCompositePk(Divisa.class));
		dto.setMagatzem(getGenericReferenceWithCompositePk(Magatzem.class));		
		
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@Override
	public void updateDto(Empresa dto) {	
		dto.setNif("00000000T");
		dto.setNomComercial("NomComercial TST2");
		dto.setDomiciliComercial("DomComercial TST2");
		dto.setNomFiscal("NomFiscal TST2");
		dto.setDomiciliFiscal("DomFiscal TST2");
		dto.setRecarrecEquivalencia(false);
		dto.setTelefon("737572");
		dto.setFax("737572");
		dto.setEmail("Test@Test2.TST");
		dto.setWeb("Web TST2");
		dto.setComptabilitatAssentamentTipus("BA");
		dto.setDiarioFactProveedores("BB");
		dto.setDiarioProfProveedores("BC");
		dto.setComptabilitatCodi("CodiCmpt TST2");
		dto.setRegistreMercantil("RegMerc TST2");
		dto.setValorFacturacio(new BigDecimal("7357.72"));
		dto.setRegimCriteriCaixa(false);
		dto.setNomFiscal1("NomFisc1 TST2");
		dto.setLlinatgeFiscal1("LlinFisc1 TST2");
		dto.setLlinatgeFiscal2("LlinFisc2 TST2");
		dto.setLogoImprimir(false);
		dto.setLogoPath("Path TST2");
		dto.setTancamentData(new Date());		
		
		dto.setFacturacioTipus(FacturacioTipusEnum.PRESSUPOST);		
		dto.setComptabilitatClients(TipusComptabilitatClientEnumDto.NO_TRACTAR);
		dto.setComptabilitatProveidors(TipusComptabilitatClientEnumDto.ALTA);
		dto.setPersonaTipus(TipusPersonaEnumDto.JURIDICA);
		dto.setTipoResidencia(TipusEstrangerEnumDto.RESIDENT);	
	}

	@Override
	public void compareDto(Empresa expected, Empresa actual) {		
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNomComercial(),actual.getNomComercial());
		assertEquals(expected.getDomiciliComercial(),actual.getDomiciliComercial());
		assertEquals(expected.getNomFiscal(),actual.getNomFiscal());
		assertEquals(expected.getDomiciliFiscal(),actual.getDomiciliFiscal());
		assertEquals(expected.getRecarrecEquivalencia(), actual.getRecarrecEquivalencia());
		assertEquals(expected.getTelefon(),actual.getTelefon());
		assertEquals(expected.getFax(),actual.getFax());
		assertEquals(expected.getEmail(),actual.getEmail());
		assertEquals(expected.getWeb(),actual.getWeb());
		assertEquals(expected.getComptabilitatAssentamentTipus(),actual.getComptabilitatAssentamentTipus());
		assertEquals(expected.getDiarioFactProveedores(),actual.getDiarioFactProveedores());
		assertEquals(expected.getDiarioProfProveedores(),actual.getDiarioProfProveedores());
		assertEquals(expected.getComptabilitatCodi(),actual.getComptabilitatCodi());
		assertEquals(expected.getRegistreMercantil(),actual.getRegistreMercantil());		
		assertTrue(expected.getValorFacturacio().compareTo(actual.getValorFacturacio()) == 0);	
		assertEquals(expected.getRegimCriteriCaixa(), actual.getRegimCriteriCaixa());
		assertEquals(expected.getNomFiscal1(),actual.getNomFiscal1());
		assertEquals(expected.getLlinatgeFiscal1(),actual.getLlinatgeFiscal1());
		assertEquals(expected.getLlinatgeFiscal2(),actual.getLlinatgeFiscal2());
		assertEquals(expected.getLogoImprimir(), actual.getLogoImprimir());
		assertEquals(expected.getLogoPath(),actual.getLogoPath());
		assertEquals(expected.getTancamentData(), actual.getTancamentData());		

		assertEquals(expected.getFacturacioTipus(), actual.getFacturacioTipus());		
		assertEquals(expected.getComptabilitatClients(), actual.getComptabilitatClients());
		assertEquals(expected.getComptabilitatProveidors(), actual.getComptabilitatProveidors());
		assertEquals(expected.getPersonaTipus(), actual.getPersonaTipus());
		assertEquals(expected.getTipoResidencia(), actual.getTipoResidencia());	
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new CodiPostalCrudTester(),
			new DivisaCrudTester(),
			new MagatzemCrudTester()			
		};
	}

}
