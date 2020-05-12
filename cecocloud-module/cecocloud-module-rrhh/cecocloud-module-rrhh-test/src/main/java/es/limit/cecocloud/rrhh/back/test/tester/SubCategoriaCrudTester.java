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
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus subCategoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class SubCategoriaCrudTester extends AbstractCrudTester<Subcategoria> {

	@Override
	public Subcategoria createDto() {
		Subcategoria dto = new Subcategoria();
		dto.setCodi(TestUtils.CODI_TEST);
		dto = this.update(dto);
		dto.setCategoria(getGenericReferenceWithCompositePkFromParentCrudTester(Categoria.class));
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Subcategoria dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Subcategoria update(Subcategoria dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
		dto.setObservacio(TestUtils.OBS_TEST);
		dto.setActiu(true);
		return dto;
	}

	@Override
	public void compareDto(Subcategoria expected, Subcategoria actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getActiu(), actual.getActiu());
		assertEquals(expected.getObservacio(), actual.getObservacio());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
				new IdentificadorCrudTester(),
				new CategoriaCrudTester()
		};
	}

}
