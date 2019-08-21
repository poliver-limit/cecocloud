/**
 * 
 */
package es.limit.cecocloud.logic.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.service.AuthService;
import es.limit.cecocloud.logic.helper.TokenHelper;

/**
 * Test d'enviament de correus electrònics.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTokenTest {

	@Autowired
	private AuthService authService;
	@Autowired
	private TokenHelper tokenHelper;

	public void testCreate() {
		String token = getNewToken();
		System.out.println(">>> Token creat: " + token);
	}

	@Test
	public void testRefresh() {
		// expirat String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJjZWNvY2xvdWQiLCJhdWQiOiJhdXRoIiwic3ViIjoiYWRtaW4iLCJleHAiOjE1NjYyMDYxMjQsIm5hbWUiOiJBZG1pbmlzdHJhZG9yIiwiZW1haWwiOiJhZG1pbkBsaW1pdC5lcyIsInJleHAiOjE1NjQ1MDMwOTc0ODksInJvbCI6WyJBRE1JTiJdfQ.kR9j-06Q-Ue4mlYPfm_7gYqy375kkh_MMs0e1cvNsvgy-pSm6LJ14F7izqErN8RS9chcit1uBvOIlCqGTB8jEQ";
		String token = getNewToken();
		System.out.println(">>> Token creat: " + token);
		authService.tokenCheck(token);
		System.out.println(">>> Token validat");
		String refrescat = authService.tokenRefresh(token, null);
		System.out.println(">>> Token refrescat: " + refrescat);
	}

	private String getNewToken() {
		Usuari usuari = new Usuari();
		usuari.setCodi("admin");
		usuari.setNom("Administrador");
		usuari.setEmail("admin@limit.es");
		return tokenHelper.buildAuth(usuari, Arrays.asList(Rol.ADMIN), null);
	}
}
