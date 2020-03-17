/**
 * 
 */
package es.limit.cecocloud.back.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.client.HttpClientErrorException;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.BaseBootPermission.PermissionSidType;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.base.boot.test.RestServiceHelper;
import es.limit.cecocloud.back.controller.SincronitzacioApiController;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresaOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresaUsuari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorResposta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioUsuari;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.logic.api.service.OperariService;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorService;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;

/**
 * Test de la sincronització del grup d'empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class SincronitzacioRestApiTest extends AbstractRestApiTest<Identificador, Long> {

	private static final String IDENTIFICADOR_SYNC_DESC = "Límit";
	private static final String USUARI_CODI = USUARI_TEST_NOADMIN;
	private static final String OPERARI_CODI = "000000";
	private static final String EMPRESA_CODI = "0001";
	private static final String EMPRESA_NIF = "B07167448";
	private static final String EMPRESA_NOM = "Tecnologies";

	@Autowired
	private SincronitzacioApiController sincronitzacioApiController;
	@Autowired
	private IdentificadorService identificadorService;
	@Autowired
	private UsuariIdentificadorService usuariIdentificadorService;
	@Autowired
	private OperariService operariService;
	@Autowired
	private EmpresaService empresaService;
	
	@Override
	protected CrudTester<Identificador> getCrudTester() {
		return new IdentificadorCrudTester();
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void sincronitzacioTest() {
		resourceCustomTest("sincronització de la informació del grup d'empreses");
	}

	@Override
	protected void testWithResource(Identificador identificador) {
		logMessageDebug("Verificant que no es pot sincronitzar un identificador sense permís...");
		Throwable throwable = null;
		try {
			RestServiceHelper sincronitzacioRestServiceHelper = getRestServiceHelper(sincronitzacioApiController);
			SincronitzacioIdentificadorPeticio sincronitzacioPeticio = generarSincronitzacioPeticio(
					identificador.getCodi(),
					IDENTIFICADOR_SYNC_DESC);
			sincronitzacioRestServiceHelper.restTemplateExchange(
					"/identificador",
					HttpMethod.POST,
					sincronitzacioPeticio,
					SincronitzacioIdentificadorResposta.class);
			fail("No s'hauria de poder sincronitzar sense permís");
		} catch (Throwable ex) {
			throwable = ex;
		}
		assertNotNull(throwable);
		assertTrue(throwable instanceof HttpClientErrorException);
		HttpClientErrorException httpClientErrorException = (HttpClientErrorException)throwable;
		assertEquals(403, httpClientErrorException.getRawStatusCode());
		logMessageDebug("...verificat correctament");
		logMessageDebug("Verificant que no es pot sincronitzar un identificador que no existeix...");
		throwable = null;
		try {
			RestServiceHelper sincronitzacioRestServiceHelper = getRestServiceHelper(sincronitzacioApiController);
			SincronitzacioIdentificadorPeticio sincronitzacioPeticio = generarSincronitzacioPeticio(
					"0000",
					IDENTIFICADOR_SYNC_DESC);
			sincronitzacioRestServiceHelper.restTemplateExchange(
					"/identificador",
					HttpMethod.POST,
					sincronitzacioPeticio,
					SincronitzacioIdentificadorResposta.class);
			fail("No s'hauria de poder sincronitzar un identificador que no existeix");
		} catch (Throwable ex) {
			throwable = ex;
		}
		assertNotNull(throwable);
		assertTrue(throwable instanceof HttpClientErrorException);
		httpClientErrorException = (HttpClientErrorException)throwable;
		assertEquals(403, httpClientErrorException.getRawStatusCode()); // Si no existeix també retorna error HTTP 403
		logMessageDebug("...verificat correctament");
		logMessageDebug("Donam permisos de sincronització i verificam que l'usuari els te...");
		BaseBootPermission permission = new BaseBootPermission(PermissionSidType.PRINCIPAL, USUARI_TEST_NOADMIN);
		permission.setSyncGranted(true);
		identificadorService.permissionCreate(
				identificador.getId(),
				permission);
		assertTrue(
				checkPermissionForSids(
						Identificador.class,
						identificador.getId(),
						ExtendedPermission.SYNC,
						Arrays.asList(new PrincipalSid(USUARI_TEST_NOADMIN))));
		logMessageDebug("...verificat correctament");
		logMessageDebug("Sincronitzant i verificant resposta...");
		RestServiceHelper sincronitzacioRestServiceHelper = getRestServiceHelper(sincronitzacioApiController);
		SincronitzacioIdentificadorPeticio sincronitzacioPeticio = generarSincronitzacioPeticio(
				identificador.getCodi(),
				IDENTIFICADOR_SYNC_DESC);
		SincronitzacioIdentificadorResposta sincronitzacioResposta = sincronitzacioRestServiceHelper.restTemplateExchange(
				"/identificador",
				HttpMethod.POST,
				sincronitzacioPeticio,
				SincronitzacioIdentificadorResposta.class);
		assertNotNull(sincronitzacioResposta);
		assertEquals(0, sincronitzacioResposta.getUsuaris().getCreateCount());
		assertEquals(1, sincronitzacioResposta.getUsuaris().getUpdateCount());
		assertEquals(0, sincronitzacioResposta.getUsuaris().getDeleteCount());
		assertEquals(0, sincronitzacioResposta.getUsuaris().getErrorCount());
		assertEquals(1, sincronitzacioResposta.getOperaris().getCreateCount());
		assertEquals(0, sincronitzacioResposta.getOperaris().getUpdateCount());
		assertEquals(0, sincronitzacioResposta.getOperaris().getDeleteCount());
		assertEquals(0, sincronitzacioResposta.getOperaris().getErrorCount());
		assertEquals(1, sincronitzacioResposta.getEmpreses().getCreateCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getUpdateCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getDeleteCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getErrorCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getErrorCount());
		assertEquals(1, sincronitzacioResposta.getEmpreses().getUsuaris().getCreateCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getUsuaris().getUpdateCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getUsuaris().getDeleteCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getUsuaris().getErrorCount());
		assertEquals(1, sincronitzacioResposta.getEmpreses().getOperaris().getCreateCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getOperaris().getUpdateCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getOperaris().getDeleteCount());
		assertEquals(0, sincronitzacioResposta.getEmpreses().getOperaris().getErrorCount());
		// Verificam que l'identificador te la descripció correcta
		Identificador identificadorSincronitzat = identificadorService.getOne(identificador.getId());
		assertEquals(IDENTIFICADOR_SYNC_DESC, identificadorSincronitzat.getDescripcio());
		// Verificam l'usuari de l'identificador
		List<UsuariIdentificador> usuarisIdentificadors = usuariIdentificadorService.findByQuickFilterAndRsqlQuery(
				null,
				"identificador.id==" + identificador.getId(),
				Sort.unsorted());
		assertNotNull(usuarisIdentificadors);
		assertEquals(1, usuarisIdentificadors.size());
		assertEquals(USUARI_CODI, usuarisIdentificadors.get(0).getUsuariCodi());
		// Verificam l'operari de l'identificador
		List<Operari> operaris = operariService.findByQuickFilterAndRsqlQuery(
				null,
				"identificador.id==" + identificador.getId(),
				Sort.unsorted());
		assertNotNull(operaris);
		assertEquals(1, operaris.size());
		assertEquals(OPERARI_CODI, operaris.get(0).getCodi());
		assertEquals(USUARI_CODI, operaris.get(0).getUsuariCodi());
		// Verificam l'empresa de l'identificador
		List<Empresa> empreses = empresaService.findByQuickFilterAndRsqlQuery(
				null,
				"identificador.id==" + identificador.getId(),
				Sort.unsorted());
		assertNotNull(empreses);
		assertEquals(1, empreses.size());
		assertEquals(EMPRESA_CODI, empreses.get(0).getCodi());
		assertEquals(EMPRESA_NIF, empreses.get(0).getNif());
		assertEquals(EMPRESA_NOM, empreses.get(0).getNom());
		logMessageDebug("...verificat correctament");
	}

	private SincronitzacioIdentificadorPeticio generarSincronitzacioPeticio(
			String codi,
			String nom) {
		SincronitzacioIdentificadorPeticio sincronitzacioPeticio = new SincronitzacioIdentificadorPeticio();
		sincronitzacioPeticio.setCodi(codi);
		sincronitzacioPeticio.setNom(nom);
		sincronitzacioPeticio.setUsuaris(generarSincronitzacioUsuaris());
		sincronitzacioPeticio.setOperaris(generarSincronitzacioOperaris());
		sincronitzacioPeticio.setEmpreses(generarSincronitzacioEmpreses());
		return sincronitzacioPeticio;
	}

	private List<SincronitzacioUsuari> generarSincronitzacioUsuaris() {
		List<SincronitzacioUsuari> sincronitzacioUsuaris = new ArrayList<SincronitzacioUsuari>();
		sincronitzacioUsuaris.add(
				new SincronitzacioUsuari(USUARI_CODI));
		return sincronitzacioUsuaris;
	}

	private List<SincronitzacioOperari> generarSincronitzacioOperaris() {
		List<SincronitzacioOperari> sincronitzacioOperaris = new ArrayList<SincronitzacioOperari>();
		sincronitzacioOperaris.add(
				new SincronitzacioOperari(OPERARI_CODI, USUARI_CODI));
		return sincronitzacioOperaris;
	}

	private List<SincronitzacioEmpresa> generarSincronitzacioEmpreses() {
		List<SincronitzacioEmpresa> sincronitzacioEmpreses = new ArrayList<SincronitzacioEmpresa>();
		SincronitzacioEmpresa empresa = new SincronitzacioEmpresa(
				EMPRESA_CODI,
				EMPRESA_NIF,
				EMPRESA_NOM);
		List<SincronitzacioEmpresaUsuari> empresaUsuaris = new ArrayList<SincronitzacioEmpresaUsuari>();
		empresaUsuaris.add(
				new SincronitzacioEmpresaUsuari(USUARI_CODI));
		empresa.setUsuaris(empresaUsuaris);
		List<SincronitzacioEmpresaOperari> empresaOperaris = new ArrayList<SincronitzacioEmpresaOperari>();
		empresaOperaris.add(
				new SincronitzacioEmpresaOperari(OPERARI_CODI));
		empresa.setOperaris(empresaOperaris);
		sincronitzacioEmpreses.add(empresa);
		return sincronitzacioEmpreses;
	}

}
