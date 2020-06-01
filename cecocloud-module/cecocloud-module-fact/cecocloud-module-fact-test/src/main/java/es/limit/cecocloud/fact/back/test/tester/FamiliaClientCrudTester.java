/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.fact.logic.api.dto.TipusRisc;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester per a recursos de tipus família de client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class FamiliaClientCrudTester extends AbstractCrudTester<FamiliaClient> {

	@Override
	public FamiliaClient createDto() {
		FamiliaClient dto = new FamiliaClient();
		dto.setCodi("TEST");
		dto.setNom("TEST");
		dto.setCompteVendesComptabilitat("TEST");
		dto.setObservacions("TEST");
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		dto.setTipusRisc(getGenericReferenceWithCompositePk(TipusRisc.class));
		return dto;
	}

	@Override
	public void updateDto(FamiliaClient dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom("TEST2");
		dto.setCompteVendesComptabilitat("TEST2");
		dto.setObservacions("TEST2");
	}

	@Override
	public void compareDto(FamiliaClient expected, FamiliaClient actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getCompteVendesComptabilitat(), actual.getCompteVendesComptabilitat());
		assertEquals(expected.getObservacions(), actual.getObservacions());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester(),
			new TipusRiscCrudTester()
		};
	}

}
