/**
 * 
 */
package es.limit.cecocloud.back.test;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecoloud.test.tester.EmpresaCrudTester;

/**
 * Test pels objectes de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaRestApiTest extends AbstractRestApiTest<Empresa, Long> {

	@Override
	protected CrudTester<Empresa> getCrudTester() {
		return new EmpresaCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected void beforeCrudTest() {
		logMessageDebug("Configuram la sessió amb l'identificador creat...");
		logLevelAdd(1);
		GenericReference<Identificador, Long> identificador = getGenericReferenceFromCrudTester(
				Identificador.class,
				getCrudTester());
		UserSession session = (UserSession)getSession();
		if (session == null) {
			session = new UserSession(
					identificador.getId(),
					null);
		} else {
			session.setI(identificador.getId());
		}
		setSession(session);
		logLevelAdd(-1);
		logMessageDebug("...sessió configurada correctament");
	}

}
