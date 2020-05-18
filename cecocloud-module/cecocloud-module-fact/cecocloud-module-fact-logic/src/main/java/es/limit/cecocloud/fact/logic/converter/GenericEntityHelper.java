/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.fact.logic.api.dto.Caixa;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Pais;
import es.limit.cecocloud.fact.logic.api.dto.Provincia;
import es.limit.cecocloud.fact.logic.api.dto.RegimIva;
import es.limit.cecocloud.fact.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.fact.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.fact.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.fact.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusFacturaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusMissatgeEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusRegimEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusVencimentEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ValoracioInventariTraspasEnum;
import es.limit.cecocloud.fact.persist.entity.CaixaEntity;
import es.limit.cecocloud.fact.persist.entity.ClientEntity;
import es.limit.cecocloud.fact.persist.entity.CodiPostalEntity;
import es.limit.cecocloud.fact.persist.entity.DivisaEntity;
import es.limit.cecocloud.fact.persist.entity.DocumentPagamentCobramentEntity;
import es.limit.cecocloud.fact.persist.entity.FamiliaClientEntity;
import es.limit.cecocloud.fact.persist.entity.MagatzemEntity;
import es.limit.cecocloud.fact.persist.entity.PaisEntity;
import es.limit.cecocloud.fact.persist.entity.ProvinciaEntity;
import es.limit.cecocloud.fact.persist.entity.RegimIvaEntity;
import es.limit.cecocloud.fact.persist.entity.TipusFacturacioEntity;
import es.limit.cecocloud.fact.persist.entity.TipusVencimentEntity;
import es.limit.cecocloud.fact.persist.repository.CaixaRepository;
import es.limit.cecocloud.fact.persist.repository.ClientRepository;
import es.limit.cecocloud.fact.persist.repository.CodiPostalRepository;
import es.limit.cecocloud.fact.persist.repository.DivisaRepository;
import es.limit.cecocloud.fact.persist.repository.DocumentPagamentCobramentRepository;
import es.limit.cecocloud.fact.persist.repository.FamiliaClientRepository;
import es.limit.cecocloud.fact.persist.repository.MagatzemRepository;
import es.limit.cecocloud.fact.persist.repository.PaisRepository;
import es.limit.cecocloud.fact.persist.repository.ProvinciaRepository;
import es.limit.cecocloud.fact.persist.repository.RegimIvaRepository;
import es.limit.cecocloud.fact.persist.repository.TipusFacturacioRepository;
import es.limit.cecocloud.fact.persist.repository.TipusVencimentRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.OperariEnumDto;
import es.limit.cecocloud.rrhh.persist.entity.HorariEntity;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import es.limit.cecocloud.rrhh.persist.repository.HorariRepository;
import es.limit.cecocloud.rrhh.persist.repository.OperariRepository;

/**
 * Helper per a la creació d'entitats genèriques.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class GenericEntityHelper {

	private static final String GENERIC_CAIXA_CODI = ".";
	private static final String GENERIC_DIVISA_CODI = ".";
	private static final String GENERIC_CLIENT_CODI = ".";
	private static final String GENERIC_FAMILIA_CLIENT_CODI = ".";
	private static final String GENERIC_TIPUS_FACTURACIO_CODI = ".";
	private static final String GENERIC_DOCUMENT_PAGAMENT_COBRAMENT_CODI = ".";
	private static final String GENERIC_REGIM_IVA_CODI = ".";
	private static final String GENERIC_TIPUS_VENCIMENT_CODI = ".";
	private static final String GENERIC_MAGATZEM_CODI = ".";
	private static final String GENERIC_CODI_POSTAL_CODI = ".";
	private static final String GENERIC_PAIS_CODI = ".";
	private static final String GENERIC_PROVINCIA_CODI = ".";
	private static final String GENERIC_OPERARI_CODI = ".";
	private static final String GENERIC_HORARI_CODI = ".";
	private static final String GENERIC_NOM_DESCRIPCIO = "Generic";

	@Autowired
	private CaixaRepository caixaRepository;
	@Autowired
	private DivisaRepository divisaRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private FamiliaClientRepository familiaClientRepository;
	@Autowired
	private TipusFacturacioRepository tipusFacturacioRepository;
	@Autowired
	private DocumentPagamentCobramentRepository documentPagamentCobramentRepository;
	@Autowired
	private RegimIvaRepository regimIvaRepository;
	@Autowired
	private TipusVencimentRepository tipusVencimentRepository;
	@Autowired
	private MagatzemRepository magatzemRepository;
	@Autowired
	private CodiPostalRepository codiPostalRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private OperariRepository operariRepository;
	@Autowired
	private HorariRepository horariRepository;

	public CaixaEntity getGenericCaixa(
			String identificadorCodi,
			String empresaCodi) {
		CaixaPk pk = new CaixaPk(
				identificadorCodi,
				empresaCodi,
				GENERIC_CAIXA_CODI);
		Optional<CaixaEntity> entity = caixaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Caixa dto = new Caixa();
			dto.setCodi(GENERIC_CAIXA_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setFerApuntComptable(false);
			return caixaRepository.save(
					CaixaEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	public DivisaEntity getGenericDivisa(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_DIVISA_CODI);
		Optional<DivisaEntity> entity = divisaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Divisa dto = new Divisa();
			dto.setCodi(GENERIC_DIVISA_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			dto.setValorEuros(new BigDecimal(1));
			dto.setDecimalsPreus(2);
			dto.setDecimalsImports(2);
			return divisaRepository.save(
					DivisaEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	public ClientEntity getGenericClient(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_CLIENT_CODI);
		Optional<ClientEntity> entity = clientRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Client dto = new Client();
			dto.setCodi(GENERIC_CLIENT_CODI);
			dto.setNomComercial(GENERIC_NOM_DESCRIPCIO);
			dto.setNomFiscal(GENERIC_NOM_DESCRIPCIO);
			dto.setTipusMissatge(TipusMissatgeEnumDto.CAP);
			dto.setTipusFactura(TipusFacturaEnumDto.GENERAL);
			return clientRepository.save(
					ClientEntity.builder().
					pk(pk).
					embedded(dto).
					familiaClient(getGenericFamiliaClient(identificadorCodi)).
					tipusFacturacio(getGenericTipusFacturacio(identificadorCodi)).
					documentPagament(getGenericDocumentPagamentCobrament(identificadorCodi)).
					regimIva(getGenericRegimIva(identificadorCodi)).
					tipusVenciment(getGenericTipusVenciment(identificadorCodi)).
					divisa(getGenericDivisa(identificadorCodi)).
					build());
		}
	}

	public FamiliaClientEntity getGenericFamiliaClient(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_FAMILIA_CLIENT_CODI);
		Optional<FamiliaClientEntity> entity = familiaClientRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			FamiliaClient dto = new FamiliaClient();
			dto.setCodi(GENERIC_FAMILIA_CLIENT_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			return familiaClientRepository.save(
					FamiliaClientEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	public TipusFacturacioEntity getGenericTipusFacturacio(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_TIPUS_FACTURACIO_CODI);
		Optional<TipusFacturacioEntity> entity = tipusFacturacioRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			TipusFacturacio dto = new TipusFacturacio();
			dto.setCodi(GENERIC_TIPUS_FACTURACIO_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			return tipusFacturacioRepository.save(
					TipusFacturacioEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	public DocumentPagamentCobramentEntity getGenericDocumentPagamentCobrament(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_DOCUMENT_PAGAMENT_COBRAMENT_CODI);
		Optional<DocumentPagamentCobramentEntity> entity = documentPagamentCobramentRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			DocumentPagamentCobrament dto = new DocumentPagamentCobrament();
			dto.setCodi(GENERIC_DOCUMENT_PAGAMENT_COBRAMENT_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setAsientoCompuesto(false);
			dto.setTranspasar(false);
			return documentPagamentCobramentRepository.save(
					DocumentPagamentCobramentEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	public RegimIvaEntity getGenericRegimIva(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_REGIM_IVA_CODI);
		Optional<RegimIvaEntity> entity = regimIvaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			RegimIva dto = new RegimIva();
			dto.setCodi(GENERIC_REGIM_IVA_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setTip(TipusRegimEnumDto.GENERAL);
			return regimIvaRepository.save(
					RegimIvaEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	public TipusVencimentEntity getGenericTipusVenciment(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_TIPUS_VENCIMENT_CODI);
		Optional<TipusVencimentEntity> entity = tipusVencimentRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			TipusVenciment dto = new TipusVenciment();
			dto.setCodi(GENERIC_TIPUS_VENCIMENT_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setTipus(TipusVencimentEnumDto.IMPORT_FIXE);
			dto.setGenerarCobramentPagament(true);
			return tipusVencimentRepository.save(
					TipusVencimentEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	public MagatzemEntity getGenericMagatzem(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_MAGATZEM_CODI);
		Optional<MagatzemEntity> entity = magatzemRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Magatzem dto = new Magatzem();
			dto.setCodi(GENERIC_MAGATZEM_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			dto.setDomicili("N/D");
			dto.setValoracioInventariTraspas(ValoracioInventariTraspasEnum.ULTIM_PREU_DE_COST);
			return magatzemRepository.save(
					MagatzemEntity.builder().
					pk(pk).
					embedded(dto).
					codiPostal(getGenericCodiPostal(identificadorCodi)).
					divisa(getGenericDivisa(identificadorCodi)).
					build());
		}
	}
	
	public CodiPostalEntity getGenericCodiPostal(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_CODI_POSTAL_CODI);
		Optional<CodiPostalEntity> entity = codiPostalRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			CodiPostal dto = new CodiPostal();
			dto.setCodi(GENERIC_CODI_POSTAL_CODI);
			dto.setPoblacio(GENERIC_NOM_DESCRIPCIO);
			return codiPostalRepository.save(
					CodiPostalEntity.builder().
					pk(pk).
					embedded(dto).
					pais(getGenericPais(identificadorCodi)).
					provincia(getGenericProvincia(identificadorCodi)).
					build());
		}
	}

	public PaisEntity getGenericPais(
			String identificadorCodi) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_PAIS_CODI);
		Optional<PaisEntity> entity = paisRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Pais dto = new Pais();
			dto.setCodi(GENERIC_PAIS_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			return paisRepository.save(
					PaisEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

	private ProvinciaEntity getGenericProvincia(
			String identificadorCodi) {
		ProvinciaPk pk = new ProvinciaPk(
				identificadorCodi,
				GENERIC_PAIS_CODI,
				GENERIC_PROVINCIA_CODI);
		Optional<ProvinciaEntity> entity = provinciaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Provincia dto = new Provincia();
			dto.setCodi(GENERIC_PROVINCIA_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			return provinciaRepository.save(
					ProvinciaEntity.builder().
					pk(pk).
					embedded(dto).
					pais(getGenericPais(identificadorCodi)).
					build());
		}
	}

	public OperariEntity getGenericOperari(
			String identificadorCodi) {
		es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String> pk = new es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_OPERARI_CODI);
		Optional<OperariEntity> entity = operariRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Operari dto = new Operari();
			dto.setCodi(GENERIC_OPERARI_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			dto.setActiu(true);
			dto.setEntsor(false);
			dto.setComercial(false);
			dto.setMostrTurno(false);
			dto.setPin("1234");
			dto.setEnc(false);
			dto.setIncidencia(false);
			dto.setHoresp(false);
			dto.setAplicaDiesLab(false);
			dto.setLaboralDilluns(false);
			dto.setLaboralDimarts(false);
			dto.setLaboralDimecres(false);
			dto.setLaboralDijous(false);
			dto.setLaboralDivendres(false);
			dto.setLaboralDissabte(false);
			dto.setLaboralDiumenge(false);
			dto.setNonGrato(false);
			dto.setControlPartes(OperariEnumDto.NO);
			dto.setControlHoresExtras(OperariEnumDto.NO);
			return operariRepository.save(
					OperariEntity.builder().
					pk(pk).
					embedded(dto).
					horari(getGenericHorari(identificadorCodi)).
					build());
		}
	}

	public HorariEntity getGenericHorari(
			String identificadorCodi) {
		es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String> pk = new es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_HORARI_CODI);
		Optional<HorariEntity> entity = horariRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			Horari dto = new Horari();
			dto.setCodi(GENERIC_HORARI_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			return horariRepository.save(
					HorariEntity.builder().
					pk(pk).
					embedded(dto).
					build());
		}
	}

}
