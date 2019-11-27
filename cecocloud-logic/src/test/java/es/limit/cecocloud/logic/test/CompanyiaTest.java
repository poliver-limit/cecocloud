/**
 * 
 */
package es.limit.cecocloud.logic.test;

/**
 * Test CRUD pels objectes de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class CompanyiaTest {

	/*@Autowired
	private EmpresaService empresaService;
	@Autowired
	private CompanyiaService companyiaService;

	private Companyia companyiaCreada1;
	private Companyia companyiaCreada2;

	@Before
	public void beforeTest() {
		log.debug("Execució del mètode beforeTest per a elements de tipus" + getDtoClassName());
		Companyia companyia = new Companyia();
		companyia.setCodi("TEST1");
		companyia.setNom("Test 1");
		companyiaCreada1 = companyiaService.create(companyia);
		companyia.setCodi("TEST2");
		companyia.setNom("Test 2");
		companyiaCreada2 = companyiaService.create(companyia);
		log.debug("...mètode beforeTest executat");
	}

	@After
	public void afterTest() {
		log.debug("Execució del mètode afterTest per a elements de tipus" + getDtoClassName());
		companyiaService.delete(companyiaCreada1.getId());
		companyiaService.delete(companyiaCreada2.getId());
		log.debug("...mètode afterTest executat");
	}

	@Override
	protected Empresa createDto() {
		Empresa dto = new Empresa();
		dto.setCompanyia(
				GenericReference.toGenericReference(
						companyiaCreada1.getId()));
		dto.setIdentificadorCodi("TEST");
		dto.setCodi("TEST");
		dto.setNom("Test");
		dto.setNif("12345678Z");
		dto.setActiva(false);
		return dto;
	}

	@Override
	protected void updateDto(Empresa dto) {
		dto.setCompanyia(
				GenericReference.toGenericReference(
						companyiaCreada2.getId()));
		dto.setIdentificadorCodi("TST2");
		dto.setCodi("TST2");
		dto.setNom("Test2");
		dto.setNif("00000000T");
		dto.setActiva(true);
	}

	@Override
	protected void compareDto(Empresa expected, Empresa actual) {
		assertEquals(expected.getCompanyia(), actual.getCompanyia());
		assertEquals(expected.getIdentificadorCodi(), actual.getIdentificadorCodi());
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getNif(), actual.getNif());
		assertEquals(expected.getNif(), actual.getNif());
		assertEquals(expected.isActiva(), actual.isActiva());
	}

	@Override
	protected EmpresaService getService() {
		return empresaService;
	}*/

}
