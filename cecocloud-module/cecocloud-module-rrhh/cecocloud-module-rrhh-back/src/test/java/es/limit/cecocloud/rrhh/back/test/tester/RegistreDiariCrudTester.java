/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria;
import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;
/**
 * Tester pels objectes de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class RegistreDiariCrudTester extends AbstractCrudTester<RegistreDiari> {

	@Override
	public RegistreDiari createDto() {
		RegistreDiari dto = new RegistreDiari();
		dto = this.update(dto);
		dto.setCalendariData(getGenericReferenceWithCompositePkFromParentCrudTester(Calendari.class));
		dto.setOperari(getGenericReferenceWithCompositePkFromParentCrudTester(Operari.class));
		dto.setHorari(getGenericReferenceWithCompositePkFromParentCrudTester(Horari.class));
		dto.setRegim(getGenericReferenceWithCompositePkFromParentCrudTester(Regim.class));
		dto.setEmpresa(getGenericReferenceWithCompositePkFromParentCrudTester(Empresa.class));
		dto.setSeccio(getGenericReferenceWithCompositePkFromParentCrudTester(Seccio.class));
		dto.setCategoria(getGenericReferenceWithCompositePkFromParentCrudTester(Categoria.class));
		dto.setSubcategoria(getGenericReferenceWithCompositePkFromParentCrudTester(Subcategoria.class));
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(RegistreDiari dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public RegistreDiari update(RegistreDiari dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setHoresExtras(TestUtils.BDECIMAL_TEST);
		dto.setHoresNit(TestUtils.BDECIMAL_TEST);
		dto.setHoresNormals(TestUtils.BDECIMAL_TEST);
		dto.setHoresTeoriques(TestUtils.BDECIMAL_TEST);
		dto.setPreuHoraNit(TestUtils.BDECIMAL_TEST);
		dto.setPreuHoraNormal(TestUtils.BDECIMAL_TEST);
		dto.setPreuHoresExtras(TestUtils.BDECIMAL_TEST);
		return dto;
	}

	@Override
	public void compareDto(RegistreDiari expected, RegistreDiari actual) {
		assertEquals(expected.getHoresExtras(), actual.getHoresExtras());
		assertEquals(expected.getHoresNit(), actual.getHoresNit());
		assertEquals(expected.getHoresNormals(), actual.getHoresNormals());
		assertEquals(expected.getHoresTeoriques(), actual.getHoresTeoriques());
		assertEquals(expected.getPreuHoraNit(), actual.getPreuHoraNit());
		assertEquals(expected.getPreuHoraNormal(), actual.getPreuHoraNormal());
		assertEquals(expected.getPreuHoraNormal(), actual.getPreuHoraNormal());
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(),
				new CalendariCrudTester(),
				new OperariCrudTester(),
				new HorariCrudTester(),
				new RegimCrudTester(),
				new HorariCrudTester(),
				new EmpresaCrudTester(),
				new SeccioCrudTester(),
				new CategoriaCrudTester(),
				new SubCategoriaCrudTester()};
	}

}
