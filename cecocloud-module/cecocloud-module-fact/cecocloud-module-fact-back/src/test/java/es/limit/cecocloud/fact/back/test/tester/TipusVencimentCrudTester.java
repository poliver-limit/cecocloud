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
import es.limit.cecocloud.fact.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.fact.logic.api.dto.enums.MesosEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusVencimentEnumDto;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus de venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TipusVencimentCrudTester extends AbstractCrudTester<TipusVenciment> {

	@Override
	public TipusVenciment createDto() {
		TipusVenciment dto = new TipusVenciment();
		dto.setCodi("TEST");
		dto.setDescripcio("TEST");
		dto.setTipus(TipusVencimentEnumDto.ESCALAT);
		dto.setGenerarCobramentPagament(false);
		dto.setImportTermini(new BigDecimal(1));
		dto.setDiaTermini(1);
		dto.setTerminiAMesosComplets(false);
		dto.setNombreTerminis(1);
		dto.setPercentatgePrimerTermini(new Float(1));
		dto.setPercentatgeSegonTermini(new Float(1));
		dto.setPercentatgeTercerTermini(new Float(1));
		dto.setPercentatgeQuartTermini(new Float(1));
		dto.setPercentatgeQuintTermini(new Float(1));
		dto.setDiesPrimerTermini(1);
		dto.setDiesSegonTermini(1);
		dto.setDiesTercerTermini(1);
		dto.setDiesQuartTermini(1);
		dto.setDiesQuintTermini(1);
		dto.setMinimDies(1);
		dto.setDia2Terminis(1);
		dto.setMesTan(MesosEnumDto.GENER);
		dto.setDiaPagament(1);
		dto.setMesPagament(MesosEnumDto.GENER);
		dto.setDarrerDiaMesVentes(false);
		dto.setDarrerDiaMesCompres(false);
		dto.setClasseVenciment("TEST");
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(TipusVenciment dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TEST2");
		dto.setTipus(TipusVencimentEnumDto.IMPORT_FIXE);
		dto.setGenerarCobramentPagament(true);
		dto.setImportTermini(new BigDecimal(2));
		dto.setDiaTermini(2);
		dto.setTerminiAMesosComplets(true);
		dto.setNombreTerminis(2);
		dto.setPercentatgePrimerTermini(new Float(2));
		dto.setPercentatgeSegonTermini(new Float(2));
		dto.setPercentatgeTercerTermini(new Float(2));
		dto.setPercentatgeQuartTermini(new Float(2));
		dto.setPercentatgeQuintTermini(new Float(2));
		dto.setDiesPrimerTermini(2);
		dto.setDiesSegonTermini(2);
		dto.setDiesTercerTermini(2);
		dto.setDiesQuartTermini(2);
		dto.setDiesQuintTermini(2);
		dto.setMinimDies(2);
		dto.setDia2Terminis(2);
		dto.setMesTan(MesosEnumDto.FEBRER);
		dto.setDiaPagament(2);
		dto.setMesPagament(MesosEnumDto.FEBRER);
		dto.setDarrerDiaMesVentes(true);
		dto.setDarrerDiaMesCompres(true);
		dto.setClasseVenciment("TST2");
	}

	@Override
	public void compareDto(TipusVenciment expected, TipusVenciment actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getTipus(), actual.getTipus());
		assertEquals(expected.isGenerarCobramentPagament(), actual.isGenerarCobramentPagament());
		assertTrue(expected.getImportTermini().compareTo(actual.getImportTermini()) == 0);
		assertEquals(expected.getDiaTermini(), actual.getDiaTermini());
		assertEquals(expected.getTerminiAMesosComplets(), actual.getTerminiAMesosComplets());
		assertEquals(expected.getPercentatgePrimerTermini(), actual.getPercentatgePrimerTermini());
		assertEquals(expected.getPercentatgeSegonTermini(), actual.getPercentatgeSegonTermini());
		assertEquals(expected.getPercentatgeTercerTermini(), actual.getPercentatgeTercerTermini());
		assertEquals(expected.getPercentatgeQuartTermini(), actual.getPercentatgeQuartTermini());
		assertEquals(expected.getPercentatgeQuintTermini(), actual.getPercentatgeQuintTermini());
		assertEquals(expected.getDiesPrimerTermini(), actual.getDiesPrimerTermini());
		assertEquals(expected.getDiesSegonTermini(), actual.getDiesSegonTermini());
		assertEquals(expected.getDiesTercerTermini(), actual.getDiesTercerTermini());
		assertEquals(expected.getDiesQuartTermini(), actual.getDiesQuartTermini());
		assertEquals(expected.getDiesQuintTermini(), actual.getDiesQuintTermini());
		assertEquals(expected.getMinimDies(), actual.getMinimDies());
		assertEquals(expected.getDia2Terminis(), actual.getDia2Terminis());
		assertEquals(expected.getMesTan(), actual.getMesTan());
		assertEquals(expected.getDiaPagament(), actual.getDiaPagament());
		assertEquals(expected.getMesPagament(), actual.getMesPagament());
		assertEquals(expected.isDarrerDiaMesVentes(), actual.isDarrerDiaMesVentes());
		assertEquals(expected.isDarrerDiaMesCompres(), actual.isDarrerDiaMesCompres());
		assertEquals(expected.getClasseVenciment(), actual.getClasseVenciment());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
