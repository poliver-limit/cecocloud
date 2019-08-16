/**
 * 
 */
package es.limit.cecocloud.logic.test;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.service.UsuariService;

/**
 * Test CRUD pels objectes de tipus Usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class UsuariTest extends AbstractGenericCrudTest<UsuariService, Usuari, Long> {

	@Autowired
	private UsuariService usuariService;

	@Override
	protected Usuari createDto() {
		Usuari dto = new Usuari();
		dto.setCodi("TEST");
		dto.setNom("Test");
		dto.setEmail("test@test.com");
		dto.setContrasenya("test");
		dto.setImatgeUrl("http://test.com/test");
		return dto;
	}

	@Override
	protected void updateDto(Usuari dto) {
		dto.setCodi("TEST2");
		dto.setNom("Test2");
		dto.setEmail("test2@test.com");
		dto.setContrasenya("test2");
		dto.setImatgeUrl("http://test.com/test2");
	}

	@Override
	protected void compareDto(Usuari expected, Usuari actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getContrasenya(), actual.getContrasenya());
		assertEquals(expected.getImatgeUrl(), actual.getImatgeUrl());
	}

	@Override
	protected UsuariService getService() {
		return usuariService;
	}

}
