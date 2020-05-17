/**
 * 
 */
package es.limit.cecocloud.test;

import static org.junit.Assert.fail;

import java.io.Serializable;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.logic.api.dto.IdentificableWithCompositePk;
import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificador;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermis;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.service.FuncionalitatIdentificadorService;
import es.limit.cecocloud.logic.api.service.FuncionalitatService;
import es.limit.cecocloud.logic.api.service.PerfilService;
import es.limit.cecocloud.logic.api.service.PerfilUsuariIdentificadorEmpresaService;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorEmpresaService;
import es.limit.cecocloud.logic.api.service.UsuariIdentificadorService;
import es.limit.cecoloud.test.tester.EmpresaCrudTester;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;
import es.limit.cecoloud.test.tester.PerfilCrudTester;
import lombok.extern.slf4j.Slf4j;

/**
 * Test pels recursos d'un mòdul que requereixen un identificador i una empresa
 * seleccionades a dins la sessió. Abans d'executar el test s'assignen els
 * permisos necessaris per a accedir a la funcionalitat i es configura la sessió
 * amb l'identificador i l'empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public abstract class ModuleResourceRestApiTest<D extends IdentificableWithCompositePk<? extends Serializable>> extends AbstractRestApiTest<D, String> {

	@Autowired
	private FuncionalitatService funcionalitatService;
	@Autowired
	private FuncionalitatIdentificadorService funcionalitatIdentificadorService;
	@Autowired
	private PerfilService perfilService;
	@Autowired
	private UsuariIdentificadorService usuariIdentificadorService;
	@Autowired
	private UsuariIdentificadorEmpresaService usuariIdentificadorEmpresaService;
	@Autowired
	private PerfilUsuariIdentificadorEmpresaService perfilUsuariIdentificadorEmpresaService;

	private CrudTester<? extends Identificable<?>>[] parentCrudTesters = new CrudTester<?>[] {
			new IdentificadorCrudTester(),
			new EmpresaCrudTester(),
			new PerfilCrudTester()
	};

	@Override
	protected void beforeCrudTest() {
		FuncionalitatCodiFont funcionalitatCodiFont = getFuncionalitatCodiFont();
		log.debug("Iniciant configuració del test per a la funcionalitat " + funcionalitatCodiFont.getCodi());
		GenericReference<Empresa, Long> empresa = getGenericReferenceFromParentCrudTesters(Empresa.class, parentCrudTesters);
		GenericReference<Perfil, Long> perfil = getGenericReferenceFromParentCrudTesters(Perfil.class, parentCrudTesters);
		GenericReference<Identificador, Long> identificador = getGenericReferenceFromParentCrudTesters(Identificador.class, parentCrudTesters);
		// Cream la funcionalitat-identificador
		Funcionalitat funcionalitat = funcionalitatService.findOneByRsqlQuery(
				"codi==" + funcionalitatCodiFont.getCodi());
		if (funcionalitat != null) {
			FuncionalitatIdentificador funcionalitatIdentificador = new FuncionalitatIdentificador();
			funcionalitatIdentificador.setFuncionalitat(
					GenericReference.toGenericReference(funcionalitat.getId()));
			funcionalitatIdentificador.setIdentificador(
					identificador);
			FuncionalitatIdentificador funcionalitatIdentificadorCreat = funcionalitatIdentificadorService.create(funcionalitatIdentificador);
			// Assignam els permisos sobre la funcionalitat-identificador al perfil
			FuncionalitatPermis funcionalitatPermis = new FuncionalitatPermis();
			funcionalitatPermis.setFuncionalitatIdentificadorId(funcionalitatIdentificadorCreat.getId());
			BaseBootPermission permission = new BaseBootPermission();
			permission.setReadGranted(true);
			permission.setWriteGranted(true);
			permission.setCreateGranted(true);
			permission.setDeleteGranted(true);
			funcionalitatPermis.setPermission(permission);
			try {
				perfilService.funcionalitatPermisSave(
						perfil.getId(),
						funcionalitatPermis);
			} catch (ClassNotFoundException e) {
				fail("No s'ha pogut configurar el permís per a accedir a la funcionalitat");
			}
			// Assignam l'usuari actual a l'empresa
			UsuariIdentificadorEmpresa usuariIdentificadorEmpresa = new UsuariIdentificadorEmpresa();
			UsuariIdentificador usuariIdentificador = usuariIdentificadorService.findOneByRsqlQuery("usuari.id==" + getCurrentUsuari().getId() + ";identificador.id==" + identificador.getId());
			usuariIdentificadorEmpresa.setUsuariIdentificador(
					GenericReference.toGenericReference(usuariIdentificador.getId()));
			usuariIdentificadorEmpresa.setEmpresa(empresa);
			UsuariIdentificadorEmpresa usuariIdentificadorEmpresaCreat = usuariIdentificadorEmpresaService.create(usuariIdentificadorEmpresa);
			// Assignam el perfil a l'usuari-identificador-empresa
			PerfilUsuariIdentificadorEmpresa perfilUsuariIdentificadorEmpresa = new PerfilUsuariIdentificadorEmpresa();
			perfilUsuariIdentificadorEmpresa.setPerfil(perfil);
			perfilUsuariIdentificadorEmpresa.setUsuariIdentificadorEmpresa(
					GenericReference.toGenericReference(usuariIdentificadorEmpresaCreat.getId()));
			perfilUsuariIdentificadorEmpresaService.create(perfilUsuariIdentificadorEmpresa);
		} else {
			fail("No s'ha trobat la funcionalitat amb el codi " + funcionalitatCodiFont.getCodi());
		}
		// Configuram la sessió amb l'identificador i l'empresa
		UserSession session = (UserSession)getSession();
		if (session == null) {
			session = new UserSession(
					identificador.getId(),
					empresa.getId());
		} else {
			session.setI(identificador.getId());
			session.setE(empresa.getId());
		}
		setSession(session);
		log.debug("...configuració del test per a la funcionalitat " + funcionalitatCodiFont.getCodi() + " finalitzada");
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		genericCrudTest();
	}

	protected abstract FuncionalitatCodiFont getFuncionalitatCodiFont();

}
