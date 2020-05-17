package es.limit.cecocloud.back.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.test.context.support.WithMockUser;

import es.limit.base.boot.logic.api.dto.BaseBootPermission;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.logic.api.module.ResourceInfo;
import es.limit.base.boot.logic.api.permission.ExtendedPermission;
import es.limit.base.boot.logic.api.service.PermissionService;
import es.limit.base.boot.test.AbstractRestApiTest;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Agrupacio;
import es.limit.cecocloud.logic.api.dto.AgrupacioIdentificador;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificador;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermis;
import es.limit.cecocloud.logic.api.dto.FuncionalitatRecurs;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.Perfil;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFont;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
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
 * Test per als permisos
 *
 * @author Limit Tecnologies <limit@limit.es>
 *
 */
@Slf4j
public class FuncionalitatPermisosRestApiTest extends AbstractRestApiTest<Perfil, Long> {

	private static Map<String, FuncionalitatCodiFont> funcionalitats;
	private static ModuleInfo moduleInfo;
	
	private static final String FUNCIONALITAT_1 = "TST_FUNC1";
	private static final String FUNCIONALITAT_2 = "TST_FUNC2";
//	private static final String FUNCIONALITAT_3 = "TST_FUNC3";
	
	static {
		funcionalitats = new HashMap<String, FuncionalitatCodiFont>();
		funcionalitats.put(
				FUNCIONALITAT_1,
				new FuncionalitatCodiFontImpl(
						FUNCIONALITAT_1,
						FuncionalitatTipus.MANTENIMENT,
						"Funcionalitat 1",
						Agrupacio.class,
						Arrays.asList(
								AgrupacioIdentificador.class, 
								Empresa.class, 
								Funcionalitat.class, 
								FuncionalitatRecurs.class)));
		funcionalitats.put(
				FUNCIONALITAT_2,
				new FuncionalitatCodiFontImpl(
						FUNCIONALITAT_2,
						FuncionalitatTipus.MANTENIMENT,
						"Funcionalitat 2",
						AgrupacioIdentificador.class,
						Arrays.asList(
								FuncionalitatRecurs.class, 
								Perfil.class)));
		moduleInfo = new ModuleInfo(
				Modul.fact,
				Empresa.class.getPackage().getName(),
				null,
				funcionalitats);
		Modules.registerModule(moduleInfo);
	}
				
	@Autowired
	private FuncionalitatService funcionalitatService;
	@Autowired
	private FuncionalitatIdentificadorService funcionalitatIdentificadorService;
	@Autowired
	private UsuariIdentificadorService usuariIdentificadorService;
	@Autowired
	private UsuariIdentificadorEmpresaService usuariIdentificadorEmpresaService;
	@Autowired
	private PerfilUsuariIdentificadorEmpresaService perfilUsuariIdentificadorEmpresaService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private PerfilService perfilService;
	
	private FuncionalitatIdentificador funcionalitatIdentificador1 = null;
	private FuncionalitatIdentificador funcionalitatIdentificador2 = null;
//	private FuncionalitatIdentificador funcionalitatIdentificador3 = null;
	
	private FuncionalitatPermis funcionalitatPermis1 = null;
	private FuncionalitatPermis funcionalitatPermis2 = null;
//	private FuncionalitatPermis funcionalitatPermis3 = null;
	
	private FuncionalitatCodiFont funcionalitatCodiFont1 = null;
	private FuncionalitatCodiFont funcionalitatCodiFont2 = null;
//	private FuncionalitatCodiFont funcionalitatCodiFont3 = null;
	
	private Long perfilId = null;
	private List<Sid> sids = new ArrayList<Sid>();
	private List<String> rols = new ArrayList<String>();
	
	private CrudTester<? extends Identificable<?>>[] parentCrudTesters = new CrudTester<?>[] {
		new IdentificadorCrudTester(),
		new EmpresaCrudTester(),
		new PerfilCrudTester()
	};

	@Override
	protected void beforeCrudTest() {
//		FuncionalitatCodiFont funcionalitatCodiFont = getFuncionalitatCodiFont(FUNCIONALITAT_1);
		log.debug("Iniciant configuració del test de permisos");
		GenericReference<Empresa, Long> empresa = getGenericReferenceFromParentCrudTesters(Empresa.class, parentCrudTesters);
		GenericReference<Perfil, Long> perfil = getGenericReferenceFromParentCrudTesters(Perfil.class, parentCrudTesters);
		GenericReference<Identificador, Long> identificador = getGenericReferenceFromParentCrudTesters(Identificador.class, parentCrudTesters);
		
		perfilId = perfil.getId();
		rols.add("Perfil_" + perfilId);
		sids.add(new GrantedAuthoritySid("Perfil_" + perfilId));
			
		// Cream les funcionalitats-identificador
		Funcionalitat funcionalitat1 = funcionalitatService.findOneByRsqlQuery("codi==" + FUNCIONALITAT_1);
		Funcionalitat funcionalitat2 = funcionalitatService.findOneByRsqlQuery("codi==" + FUNCIONALITAT_2);
//		Funcionalitat funcionalitat3 = funcionalitatService.findOneByRsqlQuery("codi==" + FUNCIONALITAT_3);
		
		if (funcionalitat1 != null) {
			FuncionalitatIdentificador funcionalitatIdentificador = new FuncionalitatIdentificador();
			funcionalitatIdentificador.setFuncionalitat(GenericReference.toGenericReference(funcionalitat1.getId()));
			funcionalitatIdentificador.setIdentificador(identificador);
			funcionalitatIdentificador1 = funcionalitatIdentificadorService.create(funcionalitatIdentificador);
			funcionalitatPermis1 = new FuncionalitatPermis();
			funcionalitatPermis1.setFuncionalitatIdentificadorId(funcionalitatIdentificador1.getId());
			funcionalitatCodiFont1 = getFuncionalitatCodiFont(FUNCIONALITAT_1);
		} else {
			fail("No s'ha trobat la funcionalitat amb el codi " + FUNCIONALITAT_1);
		}
		
		if (funcionalitat2 != null) {
			FuncionalitatIdentificador funcionalitatIdentificador = new FuncionalitatIdentificador();
			funcionalitatIdentificador.setFuncionalitat(GenericReference.toGenericReference(funcionalitat2.getId()));
			funcionalitatIdentificador.setIdentificador(identificador);
			funcionalitatIdentificador2 = funcionalitatIdentificadorService.create(funcionalitatIdentificador);
			funcionalitatPermis2 = new FuncionalitatPermis();
			funcionalitatPermis2.setFuncionalitatIdentificadorId(funcionalitatIdentificador2.getId());
			funcionalitatCodiFont2 = getFuncionalitatCodiFont(FUNCIONALITAT_2);
		} else {
			fail("No s'ha trobat la funcionalitat amb el codi " + FUNCIONALITAT_2);
		}
		
//		if (funcionalitat3 != null) {
//			FuncionalitatIdentificador funcionalitatIdentificador = new FuncionalitatIdentificador();
//			funcionalitatIdentificador.setFuncionalitat(GenericReference.toGenericReference(funcionalitat3.getId()));
//			funcionalitatIdentificador.setIdentificador(identificador);
//			funcionalitatIdentificador3 = funcionalitatIdentificadorService.create(funcionalitatIdentificador);
//			funcionalitatPermis3 = new FuncionalitatPermis();
//			funcionalitatPermis3.setFuncionalitatIdentificadorId(funcionalitatIdentificador3.getId());
//			funcionalitatCodiFont3 = getFuncionalitatCodiFont(FUNCIONALITAT_3);
//		} else {
//			fail("No s'ha trobat la funcionalitat amb el codi " + FUNCIONALITAT_3);
//		}

		// Assignam l'usuari actual a l'empresa
		UsuariIdentificadorEmpresa usuariIdentificadorEmpresa = new UsuariIdentificadorEmpresa();
		UsuariIdentificador usuariIdentificador = usuariIdentificadorService.findOneByRsqlQuery("usuari.id==" + getCurrentUsuari().getId() + ";identificador.id==" + identificador.getId());
		usuariIdentificadorEmpresa.setUsuariIdentificador(GenericReference.toGenericReference(usuariIdentificador.getId()));
		usuariIdentificadorEmpresa.setEmpresa(empresa);
		UsuariIdentificadorEmpresa usuariIdentificadorEmpresaCreat = usuariIdentificadorEmpresaService.create(usuariIdentificadorEmpresa);
		// Assignam el perfil a l'usuari-identificador-empresa
		PerfilUsuariIdentificadorEmpresa perfilUsuariIdentificadorEmpresa = new PerfilUsuariIdentificadorEmpresa();
		perfilUsuariIdentificadorEmpresa.setPerfil(perfil);
		perfilUsuariIdentificadorEmpresa.setUsuariIdentificadorEmpresa(GenericReference.toGenericReference(usuariIdentificadorEmpresaCreat.getId()));
		perfilUsuariIdentificadorEmpresaService.create(perfilUsuariIdentificadorEmpresa);
		
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
		getService();
		setSession(session);
		log.debug("...configuració del test de permisos finalitzada");
	}

	@WithMockUser(value = USUARI_TEST_NOADMIN)
	@Test
	public void crudTest() {
		try {
			log.info("------------------------------------------------------------------------------");
			log.info("- Test de PERMISOS");
			log.info("------------------------------------------------------------------------------");
			
			beforeCrudTest();

			log.info("Els tests es realitzaran utilitzant les funcionalitats: { ");
			log.info("      " + funcionalitatIdentificador1.getDescripcio());
			log.info("      " + funcionalitatIdentificador2.getDescripcio());
//			log.info("      " + funcionalitatIdentificador3.getDescripcio());
			log.info("  }");
			
			log.debug("\tVerificant usuari no disposa de permisos ...");
			Set<String> permisosActuals = getAllPermisos(rols);
			assertTrue(permisosActuals.isEmpty());
			log.debug("\t...verificacio ok");
			
			log.debug("\tAssignant permis de creacio i eliminacio a " + funcionalitatIdentificador1.getDescripcio() + "...");
			BaseBootPermission permission = new BaseBootPermission();
			permission.setCreateGranted(true);
			permission.setDeleteGranted(true);
			funcionalitatPermis1.setPermission(permission);
			try {
				perfilService.funcionalitatPermisSave(
						perfilId,
						funcionalitatPermis1);
				permisosActuals = getAllPermisos(rols);
				// Els permisos assignats han de ser els dels recursos, i cap mes
				// 2 x Recursos principals + Recursos secundaris
				assertEquals(2 + funcionalitatCodiFont1.getRecursosSecundaris().size(), permisosActuals.size());
				checkPermisos(funcionalitatCodiFont1, ExtendedPermission.CREATE, ExtendedPermission.DELETE);
			} catch (ClassNotFoundException e) {
				fail("...no s'han pogut assignar els permisos");
			}
			log.debug("...permisos assignats ok");
			
			log.debug("\tAssignant permis de lectura, creacio, modificacio i eliminacio a " + funcionalitatIdentificador2.getDescripcio() + "...");
			permission = new BaseBootPermission();
			permission.setReadGranted(true);
			permission.setCreateGranted(true);
			permission.setWriteGranted(true);
			permission.setDeleteGranted(true);
			funcionalitatPermis2.setPermission(permission);
			try {
				perfilService.funcionalitatPermisSave(
						perfilId,
						funcionalitatPermis2);
				permisosActuals = getAllPermisos(rols);
				// Els permisos assignats han de ser els dels recursos, i cap mes
				// 2 x Recursos principals func1 + 4 x Recursos principals func 2 + Recursos secundaris
				Set<Class<? extends Identificable<?>>> recursosSecundaris = new HashSet<Class<? extends Identificable<?>>>();
				recursosSecundaris.addAll(funcionalitatCodiFont1.getRecursosSecundaris());
				recursosSecundaris.addAll(funcionalitatCodiFont2.getRecursosSecundaris());
				// Si hem assignat READ com a permis a la func2, no els hem de comptar com a secundari
				recursosSecundaris.remove(AgrupacioIdentificador.class);
				assertEquals(6 + recursosSecundaris.size(), permisosActuals.size());
				checkPermisos(funcionalitatCodiFont1, ExtendedPermission.CREATE, ExtendedPermission.DELETE);
				checkPermisos(funcionalitatCodiFont2, ExtendedPermission.READ, ExtendedPermission.CREATE, ExtendedPermission.WRITE, ExtendedPermission.DELETE);
			} catch (ClassNotFoundException e) {
				fail("...no s'han pogut assignar els permisos");
			}
			log.debug("...permisos assignats ok");
			
			log.debug("\tDesassignant permis de lectura a " + funcionalitatIdentificador2.getDescripcio() + "...");
			permission = new BaseBootPermission();
			permission.setReadGranted(false);
			permission.setCreateGranted(true);
			permission.setWriteGranted(true);
			permission.setDeleteGranted(true);
			funcionalitatPermis2.setPermission(permission);
			try {
				perfilService.funcionalitatPermisSave(
						perfilId,
						funcionalitatPermis2);
				permisosActuals = getAllPermisos(rols);
				// Els permisos assignats han de ser els dels recursos, i cap mes
				// 2 x Recursos principals func1 + 3 x Recursos principals func 2 + Recursos secundaris
				Set<Class<? extends Identificable<?>>> recursosSecundaris = new HashSet<Class<? extends Identificable<?>>>();
				recursosSecundaris.addAll(funcionalitatCodiFont1.getRecursosSecundaris());
				recursosSecundaris.addAll(funcionalitatCodiFont2.getRecursosSecundaris());
				assertEquals(5 + recursosSecundaris.size(), permisosActuals.size());
				checkPermisos(funcionalitatCodiFont1, ExtendedPermission.CREATE, ExtendedPermission.DELETE);
				checkPermisos(funcionalitatCodiFont2, ExtendedPermission.CREATE, ExtendedPermission.WRITE, ExtendedPermission.DELETE);
			} catch (ClassNotFoundException e) {
				fail("...no s'ha pogut desassignar el permis");
			}
			log.debug("...permis desassignat ok");
			
			log.debug("\tAssignant permis de modificacio a " + funcionalitatIdentificador1.getDescripcio() + "...");
			permission = new BaseBootPermission();
			permission.setCreateGranted(true);
			permission.setWriteGranted(true);
			permission.setDeleteGranted(true);
			funcionalitatPermis1.setPermission(permission);
			try {
				perfilService.funcionalitatPermisSave(
						perfilId,
						funcionalitatPermis1);
				permisosActuals = getAllPermisos(rols);
				// Els permisos assignats han de ser els dels recursos, i cap mes
				// 3 x Recursos principals func1 + 3 x Recursos principals func 2 + Recursos secundaris
				Set<Class<? extends Identificable<?>>> recursosSecundaris = new HashSet<Class<? extends Identificable<?>>>();
				recursosSecundaris.addAll(funcionalitatCodiFont1.getRecursosSecundaris());
				recursosSecundaris.addAll(funcionalitatCodiFont2.getRecursosSecundaris());
				assertEquals(6 + recursosSecundaris.size(), permisosActuals.size());
				checkPermisos(funcionalitatCodiFont1, ExtendedPermission.CREATE, ExtendedPermission.WRITE, ExtendedPermission.DELETE);
				checkPermisos(funcionalitatCodiFont2, ExtendedPermission.CREATE, ExtendedPermission.WRITE, ExtendedPermission.DELETE);
			} catch (ClassNotFoundException e) {
				fail("...no s'han pogut assignar el permis");
			}
			log.debug("...permis assignat ok");
			
			log.debug("\tDesassignant permisos de " + funcionalitatIdentificador1.getDescripcio() + "...");
			permission = new BaseBootPermission();
			funcionalitatPermis1.setPermission(permission);
			try {
				perfilService.funcionalitatPermisSave(
						perfilId,
						funcionalitatPermis1);
				permisosActuals = getAllPermisos(rols);
				// Els permisos assignats han de ser els dels recursos de la func2, i cap mes
				// 3 x Recursos principals func2 + Recursos secundaris
				assertEquals(3 + funcionalitatCodiFont2.getRecursosSecundaris().size(), permisosActuals.size());
				checkPermisos(funcionalitatCodiFont2, ExtendedPermission.CREATE, ExtendedPermission.WRITE, ExtendedPermission.DELETE);
			} catch (ClassNotFoundException e) {
				fail("...no s'han pogut desassignar els permisos");
			}
			log.debug("...permisos desassignats ok");
			
			log.debug("\tDesassignant permisos de " + funcionalitatIdentificador2.getDescripcio() + "...");
			permission = new BaseBootPermission();
			funcionalitatPermis2.setPermission(permission);
			try {
				perfilService.funcionalitatPermisSave(
						perfilId,
						funcionalitatPermis2);
				permisosActuals = getAllPermisos(rols);
				// No hi toca haver permisos assignats
				assertEquals(0, permisosActuals.size());
			} catch (ClassNotFoundException e) {
				fail("...no s'han pogut desassignar els permisos");
			}
			log.debug("...permisos desassignats ok");
			
			log.info("- Test de PERMISOS ... OK");
			
		} catch (Exception ex) {
			log.error("\tEl test dels mètodes CRUD ha produït un error", ex);
			throw ex;
		} finally {
//			if (created != null) {
//				log.debug("\tEsborrant " + dtoClassName + " (id=" + created.getId() + ")...");
//				getService().delete(created.getId());
//				log.debug("\t...esborrat ok");
//			}
			afterCrudTest();
		}
	}

	@Override
	protected CrudTester<Perfil> getCrudTester() {
		return null;
	}
	
	private FuncionalitatCodiFont getFuncionalitatCodiFont(String codi) {
		ModuleInfo moduleInfo = (ModuleInfo)Modules.registeredGetOne(Modul.fact.name()).get();
		return moduleInfo.getFuncionalitats().get(codi);
	}

	private Set<String> getAllPermisos(List<String> rols) {
		Set<String> permisos = new HashSet<String>();
		List<ResourceInfo> ris = permissionService.findPermisosByRols(rols);
		for (ResourceInfo ri: ris) {
			List<Permission> perms = ri.getPermission().getPermissionAdded(new BaseBootPermission());
			for (Permission perm: perms) {
				permisos.add(ri.getResourceName() + " - " + perm.getMask());
			}
		}
		return permisos;
	}
	
	private void checkPermisos(
			FuncionalitatCodiFont funcionalitatCodiFont,
			Permission... permisos) {
		for (Permission permis: permisos) {
			assertEquals(true, permissionService.checkPermissionForSids(
					funcionalitatCodiFont.getRecursPrincipal(), 
					0, 
					permis, 
					sids));
		}
		for (Class<? extends Identificable<?>> recursSecundari: funcionalitatCodiFont.getRecursosSecundaris()) {
			assertEquals(true, permissionService.checkPermissionForSids(
					recursSecundari, 
					0, 
					ExtendedPermission.READ, 
					sids));
		}
	}
	
}