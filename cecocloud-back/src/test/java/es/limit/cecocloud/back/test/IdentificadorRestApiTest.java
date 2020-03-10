/**
 * 
 */
package es.limit.cecocloud.back.test;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Test pels objectes de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorRestApiTest extends AbstractRestApiTest<Identificador, Long> {

	//@Autowired
	//private UsuariService usuariService;

	@Override
	protected CrudTester<Identificador> getCrudTester() {
		return new IdentificadorCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_ADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	protected void testWithVerifiedResource(Identificador identificador) {
		//Usuari usuari = usuariService.getOne(identificador.getPropietari().getId());
		boolean adminGranted = checkPermissionForSids(
				Identificador.class,
				identificador.getId(),
				ExtendedPermission.ADMINISTRATION,
				Arrays.asList(new PrincipalSid(USUARI_TEST_ADMIN)));
		System.out.println(">>> adminGranted: " + adminGranted);
		boolean noadminGranted = checkPermissionForSids(
				Identificador.class,
				identificador.getId(),
				ExtendedPermission.ADMINISTRATION,
				Arrays.asList(new PrincipalSid(USUARI_TEST_NOADMIN)));
		System.out.println(">>> noadminGranted: " + noadminGranted);
		//assertTrue();
	}

}
