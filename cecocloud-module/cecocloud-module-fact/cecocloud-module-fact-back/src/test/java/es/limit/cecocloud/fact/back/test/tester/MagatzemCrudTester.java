/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.enums.ValoracioInventariTraspasEnum;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MagatzemCrudTester extends AbstractCrudTester<Magatzem> {

	@Override
	public Magatzem createDto() {
		Magatzem dto = new Magatzem();
		dto.setCodi("TST");
		dto.setNom("Nom TST");
		dto.setDomicili("Domicili TST");
		dto.setValoracioInventariTraspas(ValoracioInventariTraspasEnum.PREU_COMPRA_TEORIC_DE_ARTICLE);
		dto.setTelefon("73757");
		dto.setFax("73757");
		dto.setEmail("Test@Test.TST");
		dto.setResponsable("Responsable TST");
		dto.setObservacions("Observacions TST");
		dto.setTipusAssentamentComptable("AA");
		dto.setDiariComptableTraspassos1("AB");
		dto.setDiariComptableTraspassos2("AC");
		dto.setCompteTraspassos("Compte TST");
//		dto.setPeriodeActualCodi("Periode actual codi TST");
//		dto.setPeriodeActualData("Periode actual data TST");		
		
		dto.setCodiPostal(getGenericReferenceWithCompositePkFromParentCrudTester(CodiPostal.class));
		dto.setDivisa(getGenericReferenceWithCompositePkFromParentCrudTester(Divisa.class));
		
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		
		return dto;
	}

	@Override
	public void updateDto(Magatzem dto) {
		// El codi no es pot canviar perquè forma part de la clau primària		
		dto.setNom("Nom TST2");
		dto.setDomicili("Domicili TST2");
		dto.setValoracioInventariTraspas(ValoracioInventariTraspasEnum.ULTIM_PREU_DE_COST);
		dto.setTelefon("737572");
		dto.setFax("737572");
		dto.setEmail("Test@Test.TST2");
		dto.setResponsable("Responsable TST2");
		dto.setObservacions("Observacions TST2");
		dto.setTipusAssentamentComptable("BA");
		dto.setDiariComptableTraspassos1("BB");
		dto.setDiariComptableTraspassos2("BC");
		dto.setCompteTraspassos("CompteTST2");
//		dto.setPeriodeActualCodi("Periode actual codi TST2");
//		dto.setPeriodeActualData("Periode actual data TST2");		
	}

	@Override
	public void compareDto(Magatzem expected, Magatzem actual) {
		assertEquals(expected.getCodi(), actual.getCodi());                    
		assertEquals(expected.getNom(), actual.getNom());               
		assertEquals(expected.getDomicili(), actual.getDomicili());                 
		assertEquals(expected.getValoracioInventariTraspas(), actual.getValoracioInventariTraspas());
		assertEquals(expected.getTelefon(), actual.getTelefon());
		assertEquals(expected.getFax(), actual.getFax());
		assertEquals(expected.getEmail(), actual.getEmail());                      
		assertEquals(expected.getResponsable(), actual.getResponsable());                
		assertEquals(expected.getObservacions(), actual.getObservacions());               
		assertEquals(expected.getTipusAssentamentComptable(), actual.getTipusAssentamentComptable());  
		assertEquals(expected.getDiariComptableTraspassos1(), actual.getDiariComptableTraspassos1());  
		assertEquals(expected.getDiariComptableTraspassos2(), actual.getDiariComptableTraspassos2());  
		assertEquals(expected.getCompteTraspassos(), actual.getCompteTraspassos());           
//		assertEquals(expected.getPeriodeActualCodi(), actual.getPeriodeActualCodi());          
//		assertEquals(expected.getPeriodeActualData(), actual.getPeriodeActualData());          
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new CodiPostalCrudTester(),
			new DivisaCrudTester()
		};
	}

}
