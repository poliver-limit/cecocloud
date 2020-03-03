/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.fact.back.test.tester.ArticleModelCrudTester;
import es.limit.cecocloud.fact.logic.api.dto.ArticleModel;

/**
 * Test pels objectes de tipus Article Model.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ArticleModelRestApiTest extends AbstractRestApiTest<ArticleModel, String> {

	@Override
	protected CrudTester<ArticleModel> getCrudTester() {
		return new ArticleModelCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

}
