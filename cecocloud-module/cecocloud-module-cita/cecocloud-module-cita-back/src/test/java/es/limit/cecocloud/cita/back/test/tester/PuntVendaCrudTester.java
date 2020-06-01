/**
 * 
 */
package es.limit.cecocloud.cita.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.cita.logic.api.dto.PuntVenda;
import es.limit.cecocloud.fact.back.test.tester.CaixaCrudTester;
import es.limit.cecocloud.fact.back.test.tester.ClientCrudTester;
import es.limit.cecocloud.fact.back.test.tester.DivisaCrudTester;
import es.limit.cecocloud.fact.back.test.tester.DocumentPagamentCobramentCrudTester;
import es.limit.cecocloud.fact.back.test.tester.MagatzemCrudTester;
import es.limit.cecocloud.fact.back.test.tester.SerieVendaCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.Caixa;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.EnumeracioTipus;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.ImpressioTipus;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.tester.OperariCrudTester;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecoloud.test.tester.EmpresaCrudTester;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PuntVendaCrudTester extends AbstractCrudTester<PuntVenda> {

	@Override
	public PuntVenda createDto() {
		PuntVenda dto = new PuntVenda();
		dto.setCodi("TEST");
		dto.setNom("TEST");
		dto.setTicketIvaInclos(true);
		dto.setEnumeracioTipus(EnumeracioTipus.DIARIA);
		dto.setTicketNumLiniesEnBlancFinal(1);
		dto.setImpressioTipus(ImpressioTipus.DEMANAR);
		dto.setCodiAperturaCaixa("TST");
		dto.setDarrerAz(1);
		dto.setHoraIniciDia(new Date());
		dto.setTicketCapçalera("TST");
		dto.setTicketPeu("TST");
		dto.setTallPaper("TST");
		dto.setAdreçaIp("TST");
		dto.setCarpetaImatges("TST");
		dto.setDataImp(new Date());
		dto.setTpvCarpeta("TST");
		dto.setTpvBaseDadesNom("TST");
		dto.setCitaActiva(true);
		dto.setCitaIntervalMinuts(10);
		dto.setCitaNumPlaces(1);
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		Empresa empresa = getResource(Empresa.class);
		dto.setEmpresa(
				GenericReferenceWithCompositePk.toGenericReference(
						new WithIdentificadorAndCodiPk<String>(
								identificador.getCodi(),
								empresa.getCodi())));
		dto.setCaixa(getGenericReferenceWithCompositePk(Caixa.class));
		dto.setDivisa(getGenericReferenceWithCompositePk(Divisa.class));
		dto.setClient(getGenericReferenceWithCompositePk(Client.class));
		dto.setDocumentPagamentCobrament(getGenericReferenceWithCompositePk(DocumentPagamentCobrament.class));
		dto.setMagatzem(getGenericReferenceWithCompositePk(Magatzem.class));
		dto.setOperari(getGenericReferenceWithCompositePk(Operari.class));
		dto.setSerie(getGenericReferenceWithCompositePk(SerieVenda.class));
		dto.setDivisaSecundaria(getGenericReferenceWithCompositePk(Divisa.class));
		return dto;
	}

	@Override
	public void updateDto(PuntVenda dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom("TEST2");
		dto.setTicketIvaInclos(true);
		dto.setEnumeracioTipus(EnumeracioTipus.GLOBAL);
		dto.setTicketNumLiniesEnBlancFinal(2);
		dto.setImpressioTipus(ImpressioTipus.MAI);
		dto.setCodiAperturaCaixa("TST2");
		dto.setDarrerAz(2);
		dto.setHoraIniciDia(new Date());
		dto.setTicketCapçalera("TST2");
		dto.setTicketPeu("TST2");
		dto.setTallPaper("TST2");
		dto.setAdreçaIp("TST2");
		dto.setCarpetaImatges("TST2");
		dto.setDataImp(new Date());
		dto.setTpvCarpeta("TST2");
		dto.setTpvBaseDadesNom("TST2");
	}

	@Override
	public void compareDto(PuntVenda expected, PuntVenda actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getEnumeracioTipus(), actual.getEnumeracioTipus());
		assertEquals(expected.getTicketNumLiniesEnBlancFinal(), actual.getTicketNumLiniesEnBlancFinal());
		assertEquals(expected.getImpressioTipus(), actual.getImpressioTipus());
		assertEquals(expected.getCodiAperturaCaixa(), actual.getCodiAperturaCaixa());
		assertEquals(expected.getDarrerAz(), actual.getDarrerAz());
		assertEquals(expected.getTicketCapçalera(), actual.getTicketCapçalera());
		assertEquals(expected.getTicketPeu(), actual.getTicketPeu());
		assertEquals(expected.getTallPaper(), actual.getTallPaper());
		assertEquals(expected.getAdreçaIp(), actual.getAdreçaIp());
		assertEquals(expected.getCarpetaImatges(), actual.getCarpetaImatges());
		assertEquals(expected.getTpvCarpeta(), actual.getTpvCarpeta());
		assertEquals(expected.getTpvBaseDadesNom(), actual.getTpvBaseDadesNom());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester(),
			new CaixaCrudTester(),
			new DivisaCrudTester(),
			new ClientCrudTester(),
			new DocumentPagamentCobramentCrudTester(),
			new MagatzemCrudTester(),
			new OperariCrudTester(),
			new SerieVendaCrudTester()
		};
	}

}
