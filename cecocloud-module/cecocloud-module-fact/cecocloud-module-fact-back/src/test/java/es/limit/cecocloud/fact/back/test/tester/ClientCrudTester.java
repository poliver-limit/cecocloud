/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientSubtipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.EnviamentFacturaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RebutsEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusDescompteEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusEstrangerEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusFacturaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusMissatgeEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusNifEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusPersonaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusRetencioEnumDto;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Client.
 * 
 * TO DO
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ClientCrudTester extends AbstractCrudTester<Client> {

	@Override
	public Client createDto() {
		Client dto = new Client();
		dto.setCodi("TEST");
		dto.setNomComercial("nomCom TST");
		dto.setBloquejat(true);
		dto.setPotencial(true);
		dto.setRecarrecEquivalencia(true);
		dto.setAlbaraValorat(true);
		dto.setNomFiscal("nomFis TST");
		dto.setAlias("ali TST");
		dto.setNif("nif TST");
		dto.setDomiciliFiscal("domFis TST");
		dto.setTelefon("tlf TST");
		dto.setFax("fax TST");
		dto.setEmail("eml TST");
		dto.setAdresaWeb("web TST");
		dto.setPersonaContacte("perCon TST");
		dto.setCompteContable("cCon TST");
		dto.setCompteVentesComptabilitat("comVC TST");
		dto.setNumeroCC(1L);
		dto.setDigitsControl("TT");
		dto.setObservacions("obs TST");
		dto.setParametreTxt1("parTxt1 TST");
		dto.setParametreTxt2("parTxt2 TST");
		dto.setParametreTxt3("parTxt3 TST");
		dto.setParametreTxt4("parTxt4 TST");
		dto.setParametreTxt5("parTxt5 TST");
		dto.setFacturesSenseDescompte(true);
		dto.setCopiesFactura(1);
		dto.setEntitatPublica(true);
		dto.setCensadoAEAT(true);
		dto.setProximaVisitaComercial(new Date());
		dto.setSituacioComercialCodi("sCTT");
		dto.setParametreTxtComercial1("parTxtCom1 TST");
		dto.setParametreTxtComercial2("parTxtCom2 TST");
		dto.setParametreTxtComercial3("parTxtCom3 TST");
		dto.setParametreTxtComercial4("parTxtCom4 TST");
		dto.setParametreTxtComercial5("parTxtCom5 TST");
		dto.setMostrarPercentatgeFacturacioClase1(true);
		dto.setAplicarPreusPerVolum(true);
		dto.setNomDomicili("nomDom TST");
		dto.setNumeroDomicili("numTT");
		dto.setEscalaDomicili("TT");
		dto.setPisDomicili("TT");
		dto.setPortaDomicili("TT");
		dto.setEmailFactura("emlFac TST");
		dto.setPublicarDocumentsWeb(true);
		dto.setObservacionsFactura("obsFac TST");
		dto.setAplicarImpostPuntVerd(true);
		dto.setAplicarImpostServei(true);
		dto.setImpostInclos(true);
		dto.setPermesEntrarPartes(true);
		dto.setPaisIban("TT");
		dto.setDigitsControlIban("TT");
		dto.setBicIban("bicIbn TST");
		dto.setEmailEnviamentAlbarans("emlEnvAlb TST");
		dto.setNoImprimirSubclient(true);
		dto.setNoImprimirPaletsRetornats(true);
		dto.setNomFiscal001("nomFis1 TST");
		dto.setLlinatgeFiscal001("lliFis1 TST");
		dto.setLlinatgeFiscal002("lliFis2 TST");
		dto.setOficinaComptable("ofiCom TST");
		dto.setDomiciliOficinaComptable("domOfiCom TST");
		dto.setOrganGestor("orgGes TST");
		dto.setDomiciliOrganGestor("domOrgGes TST");
		dto.setUnitatTramitadora("uniTra TST");
		dto.setDomiciliUnitatTramitadora("domUniTra TST");
		dto.setTelefonFacturaElectronica("telFacEle TST");
		dto.setEmailFacturaElectronica("emlFacEle TST");
		dto.setContacteFacturaElectronica("conFacEle TST");
		dto.setReferenciaUnicaMandat("refUniMan TST");
		dto.setDataFirmaMandat(new Date());
		dto.setFacturaElectronica(true);
		dto.setCobrarDiesLloguer(true);
		
		dto.setRebuts(RebutsEnumDto.PAPER);
		dto.setTipusFactura(TipusFacturaEnumDto.GENERAL);
		dto.setEnviamentFactura(EnviamentFacturaEnumDto.AVIS_TELEFON);
		dto.setTipusDescompte(TipusDescompteEnumDto.PRIMER_DESCOMPTE);
		dto.setTipusRetencio(TipusRetencioEnumDto.ABANS_BASE);
		dto.setTipusMissatge(TipusMissatgeEnumDto.CAP);
		dto.setAlbaraClientSubtipus(AlbaraClientSubtipusEnumDto.CLASE_0);
		dto.setTipusNif(TipusNifEnumDto.ALTRE_DOCUMENT);
		dto.setTipusPersona(TipusPersonaEnumDto.FISICA);
		dto.setTipusEstranger(TipusEstrangerEnumDto.ESTRANGER);
		
		dto.setFacturacioMinima(new BigDecimal(1));
		dto.setRiscMaxim(new BigDecimal(1));
		dto.setParametreNum1(new BigDecimal(1));
		dto.setParametreNum2(new BigDecimal(1));
		dto.setParametreNum3(new BigDecimal(1));
		dto.setParametreNum4(new BigDecimal(1));
		dto.setParametreNum5(new BigDecimal(1));
		dto.setParametreNumComercial1(new BigDecimal(1));
		dto.setParametreNumComercial2(new BigDecimal(1));
		dto.setParametreNumComercial3(new BigDecimal(1));
		dto.setParametreNumComercial4(new BigDecimal(1));
		dto.setParametreNumComercial5(new BigDecimal(1));
		dto.setRiscLimit(new BigDecimal(1));
		dto.setLatitud(new BigDecimal(1));
		dto.setLongitud(new BigDecimal(1));
		
		dto.setDescompteComptats(new Float("7357.757"));
		dto.setDescompteTermini(new Float("7357.757"));
		dto.setPercentatgeRetencio(new Float("7357.757"));
		dto.setDescompteFinalFacturesComptatClase1(new Float("7357.757"));
		dto.setDescompteFinalFacturesTerminiClase1(new Float("7357.757"));
		dto.setPercentatgePermesFacturesClase1(new Float("7357.757"));
		
		// FALTA FER LES RELACIONS AMB ELS RECURSOS
		
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateDto(Client dto) {
		
		dto.setNomComercial("nomCom TST2");
		dto.setBloquejat(false);
		dto.setPotencial(false);
		dto.setRecarrecEquivalencia(false);
		dto.setAlbaraValorat(false);
		dto.setNomFiscal("nomFis TST2");
		dto.setAlias("ali TST2");
		dto.setNif("nif TST");
		dto.setDomiciliFiscal("domFis TST2");
		dto.setTelefon("tlf TST2");
		dto.setFax("fax TST2");
		dto.setEmail("eml TST2");
		dto.setAdresaWeb("web TST2");
		dto.setPersonaContacte("perCon TST2");
		dto.setCompteContable("cCon TT2");
		dto.setCompteVentesComptabilitat("comVC TST2");
		dto.setNumeroCC(2L);
		dto.setDigitsControl("T2");
		dto.setObservacions("obs TST2");
		dto.setParametreTxt1("parTxt1 TST2");
		dto.setParametreTxt2("parTxt2 TST2");
		dto.setParametreTxt3("parTxt3 TST2");
		dto.setParametreTxt4("parTxt4 TST2");
		dto.setParametreTxt5("parTxt5 TST2");
		dto.setFacturesSenseDescompte(false);
		dto.setCopiesFactura(2);
		dto.setEntitatPublica(false);
		dto.setCensadoAEAT(false);
		dto.setProximaVisitaComercial(new Date(new Date().getYear()+1, new Date().getMonth(), new Date().getDate()));
		dto.setSituacioComercialCodi("sCT2");
		dto.setParametreTxtComercial1("parTxtCom1 TST2");
		dto.setParametreTxtComercial2("parTxtCom2 TST2");
		dto.setParametreTxtComercial3("parTxtCom3 TST2");
		dto.setParametreTxtComercial4("parTxtCom4 TST2");
		dto.setParametreTxtComercial5("parTxtCom5 TST2");
		dto.setMostrarPercentatgeFacturacioClase1(false);
		dto.setAplicarPreusPerVolum(false);
		dto.setNomDomicili("nomDom TST2");
		dto.setNumeroDomicili("numT2");
		dto.setEscalaDomicili("T2");
		dto.setPisDomicili("T2");
		dto.setPortaDomicili("T2");
		dto.setEmailFactura("emlFac TST2");
		dto.setPublicarDocumentsWeb(false);
		dto.setObservacionsFactura("obsFac TST2");
		dto.setAplicarImpostPuntVerd(false);
		dto.setAplicarImpostServei(false);
		dto.setImpostInclos(false);
		dto.setPermesEntrarPartes(false);
		dto.setPaisIban("T2");
		dto.setDigitsControlIban("T2");
		dto.setBicIban("bicIbn TST2");
		dto.setEmailEnviamentAlbarans("emlEnvAlb TST2");
		dto.setNoImprimirSubclient(false);
		dto.setNoImprimirPaletsRetornats(false);
		dto.setNomFiscal001("nomFis1 TST2");
		dto.setLlinatgeFiscal001("lliFis1 TST2");
		dto.setLlinatgeFiscal002("lliFis2 TST2");
		dto.setOficinaComptable("ofiCom TST2");
		dto.setDomiciliOficinaComptable("domOfiCom TST2");
		dto.setOrganGestor("orgGes TST2");
		dto.setDomiciliOrganGestor("domOrgGes TST2");
		dto.setUnitatTramitadora("uniTra TST2");
		dto.setDomiciliUnitatTramitadora("domUniTra TST2");
		dto.setTelefonFacturaElectronica("telFacEle TST2");
		dto.setEmailFacturaElectronica("emlFacEle TST2");
		dto.setContacteFacturaElectronica("conFacEle TST2");
		dto.setReferenciaUnicaMandat("refUniMan TST2");
		dto.setDataFirmaMandat(new Date());
		dto.setFacturaElectronica(false);
		dto.setCobrarDiesLloguer(false);
		
		dto.setRebuts(RebutsEnumDto.DISQUET);
		dto.setTipusFactura(TipusFacturaEnumDto.DOMICILI_COMERCIAL);
		dto.setEnviamentFactura(EnviamentFacturaEnumDto.EN_MA);
		dto.setTipusDescompte(TipusDescompteEnumDto.QUART_DESCOMPTE);
		dto.setTipusRetencio(TipusRetencioEnumDto.SOBRE_BASE);
		dto.setTipusMissatge(TipusMissatgeEnumDto.EMAIL);
		dto.setAlbaraClientSubtipus(AlbaraClientSubtipusEnumDto.CLASE_1);
		dto.setTipusNif(TipusNifEnumDto.CERTIFICAT_RESIDENCIA_FISCAL);
		dto.setTipusPersona(TipusPersonaEnumDto.JURIDICA);
		dto.setTipusEstranger(TipusEstrangerEnumDto.RESIDENT);
		
		dto.setFacturacioMinima(new BigDecimal(2));
		dto.setRiscMaxim(new BigDecimal(2));
		dto.setParametreNum1(new BigDecimal(2));
		dto.setParametreNum2(new BigDecimal(2));
		dto.setParametreNum3(new BigDecimal(2));
		dto.setParametreNum4(new BigDecimal(2));
		dto.setParametreNum5(new BigDecimal(2));
		dto.setParametreNumComercial1(new BigDecimal(2));
		dto.setParametreNumComercial2(new BigDecimal(2));
		dto.setParametreNumComercial3(new BigDecimal(2));
		dto.setParametreNumComercial4(new BigDecimal(2));
		dto.setParametreNumComercial5(new BigDecimal(2));
		dto.setRiscLimit(new BigDecimal(2));
		dto.setLatitud(new BigDecimal(2));
		dto.setLongitud(new BigDecimal(2));
		
		dto.setDescompteComptats(new Float("7357.772"));
		dto.setDescompteTermini(new Float("7357.772"));
		dto.setPercentatgeRetencio(new Float("7357.772"));
		dto.setDescompteFinalFacturesComptatClase1(new Float("7357.772"));
		dto.setDescompteFinalFacturesTerminiClase1(new Float("7357.772"));
		dto.setPercentatgePermesFacturesClase1(new Float("7357.772"));
		
	}

	@Override
	public void compareDto(Client expected, Client actual) {
		assertEquals(expected.getCodi(),actual.getCodi());
		assertEquals(expected.getNomComercial(),actual.getNomComercial());
		assertEquals(expected.getBloquejat(),actual.getBloquejat());
		assertEquals(expected.getPotencial(),actual.getPotencial());
		assertEquals(expected.getRecarrecEquivalencia(),actual.getRecarrecEquivalencia());
		assertEquals(expected.getAlbaraValorat(),actual.getAlbaraValorat());
		assertEquals(expected.getNomFiscal(),actual.getNomFiscal());
		assertEquals(expected.getAlias(),actual.getAlias());
		assertEquals(expected.getNif(),actual.getNif());
		assertEquals(expected.getDomiciliFiscal(),actual.getDomiciliFiscal());
		assertEquals(expected.getTelefon(),actual.getTelefon());
		assertEquals(expected.getFax(),actual.getFax());
		assertEquals(expected.getEmail(),actual.getEmail());
		assertEquals(expected.getAdresaWeb(),actual.getAdresaWeb());
		assertEquals(expected.getPersonaContacte(),actual.getPersonaContacte());
		assertEquals(expected.getCompteContable(),actual.getCompteContable());
		assertEquals(expected.getCompteVentesComptabilitat(),actual.getCompteVentesComptabilitat());
		assertEquals(expected.getNumeroCC(),actual.getNumeroCC());
		assertEquals(expected.getDigitsControl(),actual.getDigitsControl());
		assertEquals(expected.getObservacions(),actual.getObservacions());
		assertEquals(expected.getParametreTxt1(),actual.getParametreTxt1());
		assertEquals(expected.getParametreTxt2(),actual.getParametreTxt2());
		assertEquals(expected.getParametreTxt3(),actual.getParametreTxt3());
		assertEquals(expected.getParametreTxt4(),actual.getParametreTxt4());
		assertEquals(expected.getParametreTxt5(),actual.getParametreTxt5());
		assertEquals(expected.getFacturesSenseDescompte(),actual.getFacturesSenseDescompte());
		assertEquals(expected.getCopiesFactura(),actual.getCopiesFactura());
		assertEquals(expected.getEntitatPublica(),actual.getEntitatPublica());
		assertEquals(expected.getCensadoAEAT(),actual.getCensadoAEAT());
		assertEquals(expected.getProximaVisitaComercial(),actual.getProximaVisitaComercial());
		assertEquals(expected.getSituacioComercialCodi(),actual.getSituacioComercialCodi());
		assertEquals(expected.getParametreTxtComercial1(),actual.getParametreTxtComercial1());
		assertEquals(expected.getParametreTxtComercial2(),actual.getParametreTxtComercial2());
		assertEquals(expected.getParametreTxtComercial3(),actual.getParametreTxtComercial3());
		assertEquals(expected.getParametreTxtComercial4(),actual.getParametreTxtComercial4());
		assertEquals(expected.getParametreTxtComercial5(),actual.getParametreTxtComercial5());
		assertEquals(expected.getMostrarPercentatgeFacturacioClase1(),actual.getMostrarPercentatgeFacturacioClase1());
		assertEquals(expected.getAplicarPreusPerVolum(),actual.getAplicarPreusPerVolum());
		assertEquals(expected.getNomDomicili(),actual.getNomDomicili());
		assertEquals(expected.getNumeroDomicili(),actual.getNumeroDomicili());
		assertEquals(expected.getEscalaDomicili(),actual.getEscalaDomicili());
		assertEquals(expected.getPisDomicili(),actual.getPisDomicili());
		assertEquals(expected.getPortaDomicili(),actual.getPortaDomicili());
		assertEquals(expected.getEmailFactura(),actual.getEmailFactura());
		assertEquals(expected.getPublicarDocumentsWeb(),actual.getPublicarDocumentsWeb());
		assertEquals(expected.getObservacionsFactura(),actual.getObservacionsFactura());
		assertEquals(expected.getAplicarImpostPuntVerd(),actual.getAplicarImpostPuntVerd());
		assertEquals(expected.getAplicarImpostServei(),actual.getAplicarImpostServei());
		assertEquals(expected.getImpostInclos(),actual.getImpostInclos());
		assertEquals(expected.getPermesEntrarPartes(),actual.getPermesEntrarPartes());
		assertEquals(expected.getPaisIban(),actual.getPaisIban());
		assertEquals(expected.getDigitsControlIban(),actual.getDigitsControlIban());
		assertEquals(expected.getBicIban(),actual.getBicIban());
		assertEquals(expected.getEmailEnviamentAlbarans(),actual.getEmailEnviamentAlbarans());
		assertEquals(expected.getNoImprimirSubclient(),actual.getNoImprimirSubclient());
		assertEquals(expected.getNoImprimirPaletsRetornats(),actual.getNoImprimirPaletsRetornats());
		assertEquals(expected.getNomFiscal001(),actual.getNomFiscal001());
		assertEquals(expected.getLlinatgeFiscal001(),actual.getLlinatgeFiscal001());
		assertEquals(expected.getLlinatgeFiscal002(),actual.getLlinatgeFiscal002());
		assertEquals(expected.getOficinaComptable(),actual.getOficinaComptable());
		assertEquals(expected.getDomiciliOficinaComptable(),actual.getDomiciliOficinaComptable());
		assertEquals(expected.getOrganGestor(),actual.getOrganGestor());
		assertEquals(expected.getDomiciliOrganGestor(),actual.getDomiciliOrganGestor());
		assertEquals(expected.getUnitatTramitadora(),actual.getUnitatTramitadora());
		assertEquals(expected.getDomiciliUnitatTramitadora(),actual.getDomiciliUnitatTramitadora());
		assertEquals(expected.getTelefonFacturaElectronica(),actual.getTelefonFacturaElectronica());
		assertEquals(expected.getEmailFacturaElectronica(),actual.getEmailFacturaElectronica());
		assertEquals(expected.getContacteFacturaElectronica(),actual.getContacteFacturaElectronica());
		assertEquals(expected.getReferenciaUnicaMandat(),actual.getReferenciaUnicaMandat());
		assertEquals(expected.getDataFirmaMandat(),actual.getDataFirmaMandat());
		assertEquals(expected.getFacturaElectronica(),actual.getFacturaElectronica());
		assertEquals(expected.getCobrarDiesLloguer(), actual.getCobrarDiesLloguer());
		
		assertEquals(expected.getRebuts(), actual.getRebuts());
		assertEquals(expected.getTipusFactura(), actual.getTipusFactura());
		assertEquals(expected.getEnviamentFactura(), actual.getEnviamentFactura());
		assertEquals(expected.getTipusDescompte(), actual.getTipusDescompte());
		assertEquals(expected.getTipusRetencio(), actual.getTipusRetencio());
		assertEquals(expected.getTipusMissatge(), actual.getTipusMissatge());
		assertEquals(expected.getAlbaraClientSubtipus(), actual.getAlbaraClientSubtipus());
		assertEquals(expected.getTipusNif(), actual.getTipusNif());
		assertEquals(expected.getTipusPersona(), actual.getTipusPersona());
		assertEquals(expected.getTipusEstranger(), actual.getTipusEstranger());
		
		assertEquals(expected.getFacturacioMinima().compareTo(actual.getFacturacioMinima()), 0);
		assertEquals(expected.getRiscMaxim().compareTo(actual.getRiscMaxim()), 0);
		assertEquals(expected.getParametreNum1().compareTo(actual.getParametreNum1()), 0);
		assertEquals(expected.getParametreNum2().compareTo(actual.getParametreNum2()), 0);
		assertEquals(expected.getParametreNum3().compareTo(actual.getParametreNum3()), 0);
		assertEquals(expected.getParametreNum4().compareTo(actual.getParametreNum4()), 0);
		assertEquals(expected.getParametreNum5().compareTo(actual.getParametreNum5()), 0);
		assertEquals(expected.getParametreNumComercial1().compareTo(actual.getParametreNumComercial1()), 0);
		assertEquals(expected.getParametreNumComercial2().compareTo(actual.getParametreNumComercial2()), 0);
		assertEquals(expected.getParametreNumComercial3().compareTo(actual.getParametreNumComercial3()), 0);
		assertEquals(expected.getParametreNumComercial4().compareTo(actual.getParametreNumComercial4()), 0);
		assertEquals(expected.getParametreNumComercial5().compareTo(actual.getParametreNumComercial5()), 0);
		assertEquals(expected.getRiscLimit().compareTo(actual.getRiscLimit()), 0);
		assertEquals(expected.getLatitud().compareTo(actual.getLatitud()), 0);
		assertEquals(expected.getLongitud().compareTo(actual.getLongitud()), 0);
		
		assertEquals(expected.getDescompteComptats(),actual.getDescompteComptats());
		assertEquals(expected.getDescompteTermini(),actual.getDescompteTermini());
		assertEquals(expected.getPercentatgeRetencio(),actual.getPercentatgeRetencio());
		assertEquals(expected.getDescompteFinalFacturesComptatClase1(),actual.getDescompteFinalFacturesComptatClase1());
		assertEquals(expected.getDescompteFinalFacturesTerminiClase1(),actual.getDescompteFinalFacturesTerminiClase1());
		assertEquals(expected.getPercentatgePermesFacturesClase1(),actual.getPercentatgePermesFacturesClase1());
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
