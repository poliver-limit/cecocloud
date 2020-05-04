/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.dto.Node;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusTransaccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class TransaccioCrudTester extends AbstractCrudTester<Transaccio> {

	@Override
	public Transaccio createDto() {
		Transaccio dto = new Transaccio();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		dto.setNode(getGenericReferenceWithCompositePkFromParentCrudTester(Node.class));
		dto.setOperari(getGenericReferenceWithCompositePkFromParentCrudTester(Operari.class));
		dto.setTipusTransaccio(getGenericReferenceWithCompositePkFromParentCrudTester(TipusTransaccio.class));
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Transaccio dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Transaccio update(Transaccio dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setObservacions(TestUtils.OBS_TEST);
		dto.setDataHora(new Date());
		return dto;
	}

	@Override
	public void compareDto(Transaccio expected, Transaccio actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDataHora(), actual.getDataHora());
		assertEquals(expected.getObservacions(), actual.getObservacions());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(),
				new EmpresaCrudTester(),
				new NodeCrudTester(),
				new OperariCrudTester(),
				new TipusTransaccioCrudTester()
				 };
	}

}
