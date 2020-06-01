/**
 * 
 */
package es.limit.cecoloud.test.tester;

import static org.junit.Assert.assertEquals;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Empresa.EmpresaTipusEnum;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Tester pels objectes de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EmpresaCrudTester extends AbstractCrudTester<Empresa> {

	public static final String EMPRESA_CODI_TEST = "TEST";

	/*private FuncionalitatService funcionalitatService;
	private PerfilService perfilService;

	public EmpresaCrudTester(
			FuncionalitatService funcionalitatService,
			PerfilService perfilService) {
		super();
		this.funcionalitatService = funcionalitatService;
		this.perfilService = perfilService;
	}*/

	@Override
	public Empresa createDto() {
		Empresa dto = new Empresa();
		dto.setCodi(EMPRESA_CODI_TEST);
		dto.setNif("12345678Z");
		dto.setNom("Test");
		dto.setTipus(EmpresaTipusEnum.GESTIO);
		dto.setActiva(true);
		dto.setIdentificador(
				getGenericReference(Identificador.class));
		return dto;
	}

	@Override
	public void updateDto(Empresa dto) {
		dto.setCodi("TES2");
		dto.setNif("00000000T");
		dto.setNom("Test2");
		dto.setTipus(EmpresaTipusEnum.COMPTABLE);
		dto.setActiva(false);
	}

	@Override
	public void compareDto(Empresa expected, Empresa actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNif(), actual.getNif());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getTipus(), actual.getTipus());
		assertEquals(expected.isActiva(), actual.isActiva());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] {
			new IdentificadorCrudTester()
		};
	}

	/*@Override
	public void afterCreate(Empresa dto, boolean isParentResource) {
		if (isParentResource) {
			// Configurar perfil
			GenericReference<Perfil, Long> perfil = getGenericReferenceFromParentCrudTester(Perfil.class);
			FuncionalitatPermis funcionalitatPermis = new FuncionalitatPermis();
			funcionalitatService.findOneByRsqlQuery("codi==");
			funcionalitatPermis.setId(1L);
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
			// Configurar sessió
			UserSession session = (UserSession)getSession();
			if (session == null) {
				session = new UserSession();
			}
			session.setE(dto.getId());
			setSession(session);
		}
	}*/

}
