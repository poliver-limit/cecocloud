/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertTrue;

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
		dto.setCalendariData(getGenericReferenceWithCompositePk(Calendari.class));
		dto.setOperari(getGenericReferenceWithCompositePk(Operari.class));
		dto.setHorari(getGenericReferenceWithCompositePk(Horari.class));
		dto.setRegim(getGenericReferenceWithCompositePk(Regim.class));
		dto.setEmpresa(getGenericReferenceWithCompositePk(Empresa.class));
		dto.setSeccio(getGenericReferenceWithCompositePk(Seccio.class));
		dto.setCategoria(getGenericReferenceWithCompositePk(Categoria.class));
		dto.setSubcategoria(getGenericReferenceWithCompositePk(Subcategoria.class));
		Identificador identificador = getResource(Identificador.class);
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
		assertTrue(expected.getHoresExtras().compareTo(actual.getHoresExtras()) == 0);
		assertTrue(expected.getHoresNit().compareTo(actual.getHoresNit()) == 0);
		assertTrue(expected.getHoresNormals().compareTo(actual.getHoresNormals()) == 0);
		assertTrue(expected.getHoresTeoriques().compareTo(actual.getHoresTeoriques()) == 0);
		assertTrue(expected.getPreuHoraNit().compareTo(actual.getPreuHoraNit()) == 0);
		assertTrue(expected.getPreuHoraNormal().compareTo(actual.getPreuHoraNormal()) == 0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
				new IdentificadorCrudTester(),
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
