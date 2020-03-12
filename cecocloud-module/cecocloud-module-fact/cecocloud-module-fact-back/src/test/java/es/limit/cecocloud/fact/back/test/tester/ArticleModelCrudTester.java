/**
 * 
 */
package es.limit.cecocloud.fact.back.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.logic.api.dto.ArticleModel;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Tester pels objectes de tipus Article Model.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ArticleModelCrudTester extends AbstractCrudTester<ArticleModel> {

	@Override
	public ArticleModel createDto() {
		ArticleModel dto = new ArticleModel();
		dto.setCodi("TEST");
		dto.setDescripcio("TeSt");
		dto.setControl(true);	
		Identificador identificador = getResourceFromParentCrudTester(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(ArticleModel dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setDescripcio("TeSt2");
		dto.setControl(false);	
	}

	@Override
	public void compareDto(ArticleModel expected, ArticleModel actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getDescripcio(), actual.getDescripcio());
		assertEquals(expected.getControl(), actual.getControl());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

}
