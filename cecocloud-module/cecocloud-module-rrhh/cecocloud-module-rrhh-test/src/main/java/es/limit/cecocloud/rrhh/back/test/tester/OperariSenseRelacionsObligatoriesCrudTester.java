/**
 * 
 */
package es.limit.cecocloud.rrhh.back.test.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.base.boot.test.AbstractCrudTester;
import es.limit.base.boot.test.CrudTester;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.back.test.utils.TestUtils;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.OperariEnumDto;
import es.limit.cecoloud.test.tester.IdentificadorCrudTester;
/**
 * Tester pels objectes de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class OperariSenseRelacionsObligatoriesCrudTester extends AbstractCrudTester<Operari> {

	@Override
	public Operari createDto() {
		Operari dto = new Operari();
		dto.setCodi("000001");
		dto = this.update(dto);
		dto.setHorari(getGenericReferenceWithCompositePk(Horari.class));
		Identificador identificador = getResource(Identificador.class);
		dto.setIdentificador(GenericReference.toGenericReference(identificador.getCodi()));
		return dto;
	}

	@Override
	public void updateDto(Operari dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		this.update(dto);
	}

	public Operari update(Operari dto) {
		// El codi no es pot canviar perquè forma part de la clau primària
		dto.setNom(TestUtils.NOM_TEST);
		dto.setObservacions(TestUtils.OBS_TEST);
		dto.setActiu(true);
		dto.setAdo(true);
		dto.setAli("ali");
		dto.setAnecmp("anecmp");
		dto.setAplicaDiesLab(true);
		dto.setApp(true);
		dto.setCodiAlternatiu("codA");
		dto.setCodiPostalPoblacio("cp");
		dto.setComercial(true);
		dto.setComplementSalarial1(1);
		dto.setComplementSalarial2(2);
		dto.setCompteComptable("cComp");
		dto.setCompteCorrent( 1f);
		dto.setControlHoresExtras(OperariEnumDto.SEGUNSECCIO);
		dto.setControlPartes(OperariEnumDto.SI);
		dto.setCosteAdicional(1);
		dto.setCostIndirecte(true);
		dto.setDataAltaEmpresa(new Date());
		dto.setDataIniciTorn(new Date());
		dto.setDataNaixement(new Date());
		dto.setDataPrejubilacio(new Date());
		dto.setDatvaltrg(new Date());
		dto.setDepcmp("depcmp");
		dto.setDepcmpfxe(true);
		dto.setDietes(true);
		dto.setDigitsControl("dC");
		dto.setDiscos("discos");
		dto.setDomicili("domicili");
		dto.setDtehor(1);
		dto.setEmail("email");
		dto.setEmailEmpresa("emailEmpresa");
		dto.setEnc(true);
		dto.setEntitatBancaria(1);
		dto.setEntsor(true);
		dto.setEstadoCivil("C");
		dto.setHorasCalculNominas("h");
		dto.setHoresAnualsPrejubilacio(1);
		dto.setHoresLliures(1);
		dto.setHoresp(true);
		dto.setHoresLliuresPerAny(1);
		dto.setHoresPendentsAnysAnteriorJubilacio(1);
		dto.setHoresRuta(true);
		dto.setHoresVacances(1);
		dto.setIbnbic("ibnbic");
		dto.setIbndcc("ibndcc");
		dto.setIbnpai("ibnpai");
		dto.setImportHoresExtresDilluns(1);
		dto.setImportHoresExtresDimarts(1);
		dto.setImportHoresExtresDimecres(1);
		dto.setImportHoresExtresDijous(1);
		dto.setImportHoresExtresDivendres(1);
		dto.setImportHoresExtresDisabte(1);
		dto.setImportHoresExtresDiumenge(1);
		dto.setIncidencia(true);
		dto.setLaboralDilluns(true);
		dto.setLaboralDimarts(true);
		dto.setLaboralDimecres(true);
		dto.setLaboralDijous(true);
		dto.setLaboralDivendres(true);
		dto.setLaboralDissabte(true);
		dto.setLaboralDiumenge(true);
		dto.setLlocNaixement("llocNaixement");
		dto.setMaxhoe001(1);
		dto.setMdcntf(true);
		dto.setMostrTurno(true);
		dto.setNif("47627685N");
		dto.setNmn1(1);
		dto.setNmn2(1);
		dto.setNomDeLaMare(TestUtils.NOM_TEST);
		dto.setNomDelPare(TestUtils.NOM_TEST);
		dto.setNonGrato(true);
		dto.setNothorext(true);
		dto.setNumeroFills(1);
		dto.setNumeroMatricula(1);
//		dto.setNumeroSeguretatSocial("numSS");
		dto.setObservacionsPrejubilacio(TestUtils.OBS_TEST);
		dto.setOficinaBancaria(1);
		dto.setOperariPrejubilat(true);
		dto.setPas("pas");
		dto.setPercentatgeMinusvalia(1);
		dto.setPin("pin");
		dto.setPlusProductivitat(true);
		dto.setPoblacio("poblacio");
		dto.setProvincia("provincia");
		dto.setPrunitdcs(1);
		dto.setPrunitdls(1);
		dto.setPrunitdjs(1);
		dto.setPrunitdme(1);
		dto.setPrunitdms(1);
		dto.setPrunitdse(1);
		dto.setPrunitdvs(1);
		dto.setPtenmn(1);
		dto.setPtenmn002(2);
		dto.setSexe("H");
		dto.setTelefon("630690159");
		dto.setTelefonEmpresa("630690159");
		dto.setTgtcod("tgtcod");
		dto.setUsucld("usucld");
		return dto;
	}

	@Override
	public void compareDto(Operari expected, Operari actual) {
		assertEquals(expected.getCodi(), actual.getCodi());
		assertEquals(expected.getNom(), actual.getNom());
		assertEquals(expected.getObservacions(), actual.getObservacions());
		assertEquals(expected.isActiu(), actual.isActiu());
		assertEquals(expected.isAdo(), actual.isAdo());
		assertEquals(expected.getAli(), actual.getAli());
		assertEquals(expected.getAnecmp(), actual.getAnecmp());
		assertEquals(expected.isAplicaDiesLab(), actual.isAplicaDiesLab());
		assertEquals(expected.getApp(), actual.getApp());
		assertEquals(expected.getCodiAlternatiu(), actual.getCodiAlternatiu());
		assertEquals(expected.getCodiPostalPoblacio(), actual.getCodiPostalPoblacio());
		assertEquals(expected.isComercial(), actual.isComercial());
		assertEquals(expected.getComplementSalarial1(), actual.getComplementSalarial1());
		assertEquals(expected.getComplementSalarial2(), actual.getComplementSalarial2());
		assertEquals(expected.getCompteComptable(), actual.getCompteComptable());
		assertEquals(expected.getCompteCorrent(), actual.getCompteCorrent());
		assertEquals(expected.getControlHoresExtras(), actual.getControlHoresExtras());
		assertEquals(expected.getControlPartes(), actual.getControlPartes());
		assertEquals(expected.getCosteAdicional(), actual.getCosteAdicional());
		assertEquals(expected.getCostIndirecte(), actual.getCostIndirecte());
		assertEquals(expected.getDataAltaEmpresa(), actual.getDataAltaEmpresa());
		assertEquals(expected.getDataIniciTorn(), actual.getDataIniciTorn());
		assertEquals(expected.getDataIniciTorn(), actual.getDataIniciTorn());
		assertEquals(expected.getDataNaixement(), actual.getDataNaixement());
		assertEquals(expected.getDataPrejubilacio(), actual.getDataPrejubilacio());
		assertEquals(expected.getDatvaltrg(), actual.getDatvaltrg());
		assertEquals(expected.getDepcmp(), actual.getDepcmp());
		assertEquals(expected.getDepcmpfxe(), actual.getDepcmpfxe());
		assertEquals(expected.getDietes(), actual.getDietes());
		assertEquals(expected.getDigitsControl(), actual.getDigitsControl());
		assertEquals(expected.getDiscos(), actual.getDiscos());
		assertEquals(expected.getDomicili(), actual.getDomicili());
		assertEquals(expected.getDtehor(), actual.getDtehor());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getEmailEmpresa(), actual.getEmailEmpresa());
		assertEquals(expected.isEnc(), actual.isEnc());
		assertEquals(expected.getEntitatBancaria(), actual.getEntitatBancaria());
		assertEquals(expected.isEntsor(), actual.isEntsor());
		assertEquals(expected.getEstadoCivil(), actual.getEstadoCivil());
		assertEquals(expected.getHorasCalculNominas(), actual.getHorasCalculNominas());
		assertEquals(expected.getHoresAnualsPrejubilacio(), actual.getHoresAnualsPrejubilacio());
		assertEquals(expected.getHoresLliuresPerAny(), actual.getHoresLliuresPerAny());
		assertEquals(expected.getHoresLliures(), actual.getHoresLliures());
		assertEquals(expected.isHoresp(), actual.isHoresp());
		assertEquals(expected.getHoresPendentsAnysAnteriorJubilacio(), actual.getHoresPendentsAnysAnteriorJubilacio());
		assertEquals(expected.getHoresRuta(), actual.getHoresRuta());
		assertEquals(expected.getHoresVacances(), actual.getHoresVacances());
		assertEquals(expected.getIbnbic(), actual.getIbnbic());
		assertEquals(expected.getIbndcc(), actual.getIbndcc());
		assertEquals(expected.getIbnpai(), actual.getIbnpai());
		assertEquals(expected.getImportHoresExtresDilluns(), actual.getImportHoresExtresDilluns());
		assertEquals(expected.getImportHoresExtresDimarts(), actual.getImportHoresExtresDimarts());
		assertEquals(expected.getImportHoresExtresDimecres(), actual.getImportHoresExtresDimecres());
		assertEquals(expected.getImportHoresExtresDijous(), actual.getImportHoresExtresDijous());
		assertEquals(expected.getImportHoresExtresDivendres(), actual.getImportHoresExtresDivendres());
		assertEquals(expected.getImportHoresExtresDisabte(), actual.getImportHoresExtresDisabte());
		assertEquals(expected.getImportHoresExtresDiumenge(), actual.getImportHoresExtresDiumenge());
		assertEquals(expected.isIncidencia(), actual.isIncidencia());
		assertEquals(expected.getImportHoresExtresDilluns(), actual.getImportHoresExtresDilluns());
		assertEquals(expected.getImportHoresExtresDimarts(), actual.getImportHoresExtresDimarts());
		assertEquals(expected.getImportHoresExtresDimecres(), actual.getImportHoresExtresDimecres());
		assertEquals(expected.getImportHoresExtresDijous(), actual.getImportHoresExtresDijous());
		assertEquals(expected.getImportHoresExtresDivendres(), actual.getImportHoresExtresDivendres());
		assertEquals(expected.getImportHoresExtresDisabte(), actual.getImportHoresExtresDisabte());
		assertEquals(expected.getImportHoresExtresDiumenge(), actual.getImportHoresExtresDiumenge());
		assertEquals(expected.isLaboralDivendres(), actual.isLaboralDivendres());
		assertEquals(expected.isLaboralDissabte(), actual.isLaboralDissabte());
		assertEquals(expected.isLaboralDiumenge(), actual.isLaboralDiumenge());
		assertEquals(expected.getLlocNaixement(), actual.getLlocNaixement());
		assertEquals(expected.getMaxhoe001(), actual.getMaxhoe001());
		assertEquals(expected.getMdcntf(), actual.getMdcntf());
		assertEquals(expected.isMostrTurno(), actual.isMostrTurno());
		assertEquals(expected.getNif(), actual.getNif());
		assertEquals(expected.getNmn1(), actual.getNmn1());
		assertEquals(expected.getNmn2(), actual.getNmn2());
		assertEquals(expected.getNomDeLaMare(), actual.getNomDeLaMare());
		assertEquals(expected.getNomDelPare(), actual.getNomDelPare());
		assertEquals(expected.isNonGrato(), actual.isNonGrato());
		assertEquals(expected.getNothorext(), actual.getNothorext());
		assertEquals(expected.getNumeroFills(), actual.getNumeroFills());
		assertEquals(expected.getNumeroMatricula(), actual.getNumeroMatricula());
//		assertEquals(expected.getNumeroSeguretatSocial(), actual.getNumeroSeguretatSocial());
		assertEquals(expected.getObservacionsPrejubilacio(), actual.getObservacionsPrejubilacio());
		assertEquals(expected.getOficinaBancaria(), actual.getOficinaBancaria());
		assertEquals(expected.getOperariPrejubilat(), actual.getOperariPrejubilat());
		assertEquals(expected.getPas(), actual.getPas());
		assertEquals(expected.getPercentatgeMinusvalia(), actual.getPercentatgeMinusvalia());
		assertEquals(expected.getPin(), actual.getPin());
		assertEquals(expected.getPlusProductivitat(), actual.getPlusProductivitat());
		assertEquals(expected.getPoblacio(), actual.getPoblacio());
		assertEquals(expected.getProvincia(), actual.getProvincia());
		assertEquals(expected.getPrunitdcs(), actual.getPrunitdcs());
		assertEquals(expected.getPrunitdls(), actual.getPrunitdls());
		assertEquals(expected.getPrunitdjs(), actual.getPrunitdjs());
		assertEquals(expected.getPrunitdme(), actual.getPrunitdme());
		assertEquals(expected.getPrunitdms(), actual.getPrunitdms());
		assertEquals(expected.getPrunitdse(), actual.getPrunitdse());
		assertEquals(expected.getPrunitdvs(), actual.getPrunitdvs());
		assertEquals(expected.getPtenmn(), actual.getPtenmn());
		assertEquals(expected.getPtenmn002(), actual.getPtenmn002());
		assertEquals(expected.getSexe(), actual.getSexe());
		assertEquals(expected.getTelefon(), actual.getTelefon());
		assertEquals(expected.getTelefonEmpresa(), actual.getTelefonEmpresa());
		assertEquals(expected.getTgtcod(), actual.getTgtcod());
		assertEquals(expected.getUsucld(), actual.getUsucld());
	}

	@Override
	@SuppressWarnings("unchecked")
	public CrudTester<? extends Identificable<?>>[] getParentCrudTesters() {
		return new CrudTester[] { new IdentificadorCrudTester(),
				new HorariCrudTester()};
	}

}
