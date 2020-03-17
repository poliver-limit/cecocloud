/**
 * 
 */
package es.limit.cecocloud.back.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Test pels objectes de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class IdentificadorRestApiTest extends AbstractRestApiTest<Identificador, Long> {

	@Override
	protected CrudTester<Identificador> getCrudTester() {
		return new IdentificadorCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_ADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	@Override
	protected void testWithCrudVerifiedResource(Identificador identificador) {
		logMessageDebug("Verificam que l'usuari administrador te permisos d'administració...");
		boolean adminAdminGranted = checkPermissionForSids(
				Identificador.class,
				identificador.getId(),
				ExtendedPermission.ADMINISTRATION,
				Arrays.asList(new PrincipalSid(USUARI_TEST_ADMIN)));
		assertTrue(adminAdminGranted);
		logMessageDebug("...verificat correctament");
		logMessageDebug("Verificam que l'usuari no administrador no te permisos d'administració...");
		boolean noadminAdminGranted = checkPermissionForSids(
				Identificador.class,
				identificador.getId(),
				ExtendedPermission.ADMINISTRATION,
				Arrays.asList(new PrincipalSid(USUARI_TEST_NOADMIN)));
		assertFalse(noadminAdminGranted);
		logMessageDebug("...verificat correctament");
		logMessageDebug("Canviam el propietari de l'identificador per l'usuari no administrador...");
		identificador.setPropietari(
				GenericReference.toGenericReference(getUsuariTestCreat().getId()));
		getService().update(
				identificador.getId(),
				identificador);
		logMessageDebug("...canviat");
		logMessageDebug("Verificam que l'usuari no administrador te permisos d'administració...");
		adminAdminGranted = checkPermissionForSids(
				Identificador.class,
				identificador.getId(),
				ExtendedPermission.ADMINISTRATION,
				Arrays.asList(new PrincipalSid(USUARI_TEST_NOADMIN)));
		assertTrue(adminAdminGranted);
		logMessageDebug("...verificat correctament");
	}

}
