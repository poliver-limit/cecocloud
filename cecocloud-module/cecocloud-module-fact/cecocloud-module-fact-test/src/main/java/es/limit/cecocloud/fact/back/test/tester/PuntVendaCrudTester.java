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
import es.limit.cecocloud.fact.logic.api.dto.Caixa;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.EnumeracioTipus;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.ImpressioTipus;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.tester.OperariCrudTester;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
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
		dto.setDescripcio("TST");
		dto.setTicketIvaInclos(true);
		dto.setEnumeracio(EnumeracioTipus.DIARIA);
		dto.setTicketNumLiniesEnBlancFinal(1);
		dto.setImpressioTipus(ImpressioTipus.DEMANAR);
		dto.setCodiApertura("TST");
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
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		dto.setCaixa(getGenericReferenceWithCompositePkFromParentCrudTester(Caixa.class));
		dto.setDivisa(getGenericReferenceWithCompositePkFromParentCrudTester(Divisa.class));
		dto.setClient(getGenericReferenceWithCompositePkFromParentCrudTester(Client.class));
		dto.setDocumentPagamentCobrament(getGenericReferenceWithCompositePkFromParentCrudTester(DocumentPagamentCobrament.class));
		dto.setMagatzem(getGenericReferenceWithCompositePkFromParentCrudTester(Magatzem.class));
		dto.setOperari(getGenericReferenceWithCompositePkFromParentCrudTester(Operari.class));
		dto.setSerie(getGenericReferenceWithCompositePkFromParentCrudTester(SerieVenda.class));
		dto.setDivisaSecundaria(getGenericReferenceWithCompositePkFromParentCrudTester(Divisa.class));
		return dto;
	}

	@Override
	public void updateDto(PuntVenda dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TST2");
		dto.setTicketIvaInclos(true);
		dto.setEnumeracio(EnumeracioTipus.GLOBAL);
		dto.setTicketNumLiniesEnBlancFinal(2);
		dto.setImpressioTipus(ImpressioTipus.MAI);
		dto.setCodiApertura("TST2");
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
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getEnumeracio(), actual.getEnumeracio());
		assertEquals(expected.getTicketNumLiniesEnBlancFinal(), actual.getTicketNumLiniesEnBlancFinal());
		assertEquals(expected.getImpressioTipus(), actual.getImpressioTipus());
		assertEquals(expected.getCodiApertura(), actual.getCodiApertura());
		assertEquals(expected.getDarrerAz(), actual.getDarrerAz());
		// TODO verificar el camp horaIniciDia
		/*ystem.out.println(">>> expected: " + expected.getHoraIniciDia() + ", " + expected.getHoraIniciDia().getTime());
		System.out.println(">>> actual: " + actual.getHoraIniciDia() + ", " + actual.getHoraIniciDia().getTime());
		assertEquals(
				getOnlyTimeWithoutMillisecondsFromDate(expected.getHoraIniciDia()),
				getOnlyTimeWithoutMillisecondsFromDate(actual.getHoraIniciDia()));*/
		assertEquals(expected.getTicketCapçalera(), actual.getTicketCapçalera());
		assertEquals(expected.getTicketPeu(), actual.getTicketPeu());
		assertEquals(expected.getTallPaper(), actual.getTallPaper());
		assertEquals(expected.getAdreçaIp(), actual.getAdreçaIp());
		assertEquals(expected.getCarpetaImatges(), actual.getCarpetaImatges());
		// TODO verificar el camp dataImp
		//assertEquals(expected.getDataImp(), actual.getDataImp());
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

	/*private static long getOnlyTimeWithoutMillisecondsFromDate(Date date) {
		return (date.getTime() % (24*60*60*1000L)) / 1000;
	}*/

}
