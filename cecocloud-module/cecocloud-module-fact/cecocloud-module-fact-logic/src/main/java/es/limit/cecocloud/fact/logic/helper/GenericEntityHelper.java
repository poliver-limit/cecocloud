/**
 * 
 */
package es.limit.cecocloud.fact.logic.helper;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.fact.logic.api.dto.Caixa;
import es.limit.cecocloud.fact.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;
import es.limit.cecocloud.fact.logic.api.dto.Divisa;
import es.limit.cecocloud.fact.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.Pais;
import es.limit.cecocloud.fact.logic.api.dto.Provincia;
import es.limit.cecocloud.fact.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.fact.logic.api.dto.RegimIva;
import es.limit.cecocloud.fact.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.fact.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.fact.logic.api.dto.enums.RebutsEnumDto;
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
import es.limit.cecocloud.rrhh.logic.api.dto.enums.TipusHorariEnumDto;
import es.limit.cecocloud.rrhh.persist.entity.HorariEntity;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import es.limit.cecocloud.rrhh.persist.repository.HorariRepository;
import es.limit.cecocloud.rrhh.persist.repository.OperariRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Helper per a la creació d'entitats genèriques.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
@Slf4j
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
		return getGenericCaixaInternal(
				identificadorCodi,
				empresaCodi,
				true);
	}

	public DivisaEntity getGenericDivisa(
			String identificadorCodi) {
		return getGenericDivisaInternal(
				identificadorCodi,
				true);
	}

	public ClientEntity getGenericClient(
			String identificadorCodi) {
		return getGenericClientInternal(
				identificadorCodi,
				true);
	}

	public FamiliaClientEntity getGenericFamiliaClient(
			String identificadorCodi) {
		return getGenericFamiliaClientInternal(
				identificadorCodi,
				true);
	}

	public TipusFacturacioEntity getGenericTipusFacturacio(
			String identificadorCodi) {
		return getGenericTipusFacturacioInternal(
				identificadorCodi,
				true);
	}

	public DocumentPagamentCobramentEntity getGenericDocumentPagamentCobrament(
			String identificadorCodi) {
		return getGenericDocumentPagamentCobramentInternal(
				identificadorCodi,
				true);
	}

	public RegimIvaEntity getGenericRegimIva(
			String identificadorCodi) {
		return getGenericRegimIvaInternal(
				identificadorCodi,
				true);
	}

	public TipusVencimentEntity getGenericTipusVenciment(
			String identificadorCodi) {
		return getGenericTipusVencimentInternal(
				identificadorCodi,
				true);
	}

	public MagatzemEntity getGenericMagatzem(
			String identificadorCodi) {
		return getGenericMagatzemInternal(
				identificadorCodi,
				true);
	}
	
	public CodiPostalEntity getGenericCodiPostal(
			String identificadorCodi) {
		return getGenericCodiPostalInternal(
				identificadorCodi,
				true);
	}

	public PaisEntity getGenericPais(
			String identificadorCodi) {
		return getGenericPaisInternal(
				identificadorCodi,
				true);
	}

	private ProvinciaEntity getGenericProvincia(
			String identificadorCodi) {
		return getGenericProvinciaInternal(
				identificadorCodi,
				true);
	}

	public OperariEntity getGenericOperari(
			String identificadorCodi) {
		return getGenericOperariInternal(
				identificadorCodi,
				true);
	}

	public HorariEntity getGenericHorari(
			String identificadorCodi) {
		return getGenericHorariInternal(
				identificadorCodi,
				true);
	}

	public void deleteEmpresaGenericEntities(
			String identificadorCodi,
			String empresaCodi) {
		CaixaEntity caixa = getGenericCaixaInternal(
				identificadorCodi,
				empresaCodi,
				true);
		if (caixa != null) {
			try {
				caixaRepository.delete(caixa);
				caixaRepository.flush();
				log.debug("Entitat genèrica esborrada: " + CaixaEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
	}

	public void deleteIdentificadorGenericEntities(
			String identificadorCodi) {
		ClientEntity client = getGenericClientInternal(
				identificadorCodi,
				true);
		if (client != null) {
			try {
				clientRepository.delete(client);
				clientRepository.flush();
				log.debug("Entitat genèrica esborrada: " + ClientEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		MagatzemEntity magatzem = getGenericMagatzemInternal(
				identificadorCodi,
				false);
		if (magatzem != null) {
			try {
				magatzemRepository.delete(magatzem);
				magatzemRepository.flush();
				log.debug("Entitat genèrica esborrada: " + MagatzemEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		DivisaEntity divisa = getGenericDivisaInternal(
				identificadorCodi,
				true);
		if (divisa != null) {
			try {
				divisaRepository.delete(divisa);
				divisaRepository.flush();
				log.debug("Entitat genèrica esborrada: " + DivisaEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		FamiliaClientEntity familiaClient = getGenericFamiliaClientInternal(
				identificadorCodi,
				true);
		if (familiaClient != null) {
			try {
				familiaClientRepository.delete(familiaClient);
				familiaClientRepository.flush();
				log.debug("Entitat genèrica esborrada: " + FamiliaClientEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		TipusFacturacioEntity tipusFacturacio = getGenericTipusFacturacioInternal(
				identificadorCodi,
				true);
		if (tipusFacturacio != null) {
			try {
				tipusFacturacioRepository.delete(tipusFacturacio);
				tipusFacturacioRepository.flush();
				log.debug("Entitat genèrica esborrada: " + TipusFacturacioEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		DocumentPagamentCobramentEntity documentPagamentCobrament = getGenericDocumentPagamentCobramentInternal(
				identificadorCodi,
				true);
		if (documentPagamentCobrament != null) {
			try {
				documentPagamentCobramentRepository.delete(documentPagamentCobrament);
				documentPagamentCobramentRepository.flush();
				log.debug("Entitat genèrica esborrada: " + DocumentPagamentCobramentEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		RegimIvaEntity regimIva = getGenericRegimIvaInternal(
				identificadorCodi,
				true);
		if (regimIva != null) {
			try {
				regimIvaRepository.delete(regimIva);
				regimIvaRepository.flush();
				log.debug("Entitat genèrica esborrada: " + RegimIvaEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		TipusVencimentEntity tipusVenciment = getGenericTipusVencimentInternal(
				identificadorCodi,
				true);
		if (tipusVenciment != null) {
			try {
				tipusVencimentRepository.delete(tipusVenciment);
				tipusVencimentRepository.flush();
				log.debug("Entitat genèrica esborrada: " + TipusVencimentEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		CodiPostalEntity codiPostal = getGenericCodiPostalInternal(
				identificadorCodi, false);
		if (codiPostal != null) {
			try {
				codiPostalRepository.delete(codiPostal);
				codiPostalRepository.flush();
				log.debug("Entitat genèrica esborrada: " + CodiPostalEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		ProvinciaEntity provincia = getGenericProvinciaInternal(
				identificadorCodi, false);
		if (provincia != null) {
			try {
				provinciaRepository.delete(provincia);
				provinciaRepository.flush();
				log.debug("Entitat genèrica esborrada: " + ProvinciaEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		PaisEntity pais = getGenericPaisInternal(
				identificadorCodi, false);
		if (pais != null) {
			try {
				paisRepository.delete(pais);
				paisRepository.flush();
				log.debug("Entitat genèrica esborrada: " + PaisEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		OperariEntity operari = getGenericOperariInternal(
				identificadorCodi, false);
		if (operari != null) {
			try {
				operariRepository.delete(operari);
				operariRepository.flush();
				log.debug("Entitat genèrica esborrada: " + OperariEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
		HorariEntity horari = getGenericHorariInternal(identificadorCodi, false);
		if (horari != null) {
			try {
				horariRepository.delete(horari);
				horariRepository.flush();
				log.debug("Entitat genèrica esborrada: " + HorariEntity.class.getName());
			} catch (DataIntegrityViolationException ignore) {}
		}
	}

	private CaixaEntity getGenericCaixaInternal(
			String identificadorCodi,
			String empresaCodi,
			boolean createIfNotExists) {
		CaixaPk pk = new CaixaPk(
				identificadorCodi,
				empresaCodi,
				GENERIC_CAIXA_CODI);
		Optional<CaixaEntity> entity = caixaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			Caixa dto = new Caixa();
			dto.setCodi(GENERIC_CAIXA_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setFerApuntComptable(false);
			CaixaEntity saved = caixaRepository.save(
					CaixaEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private DivisaEntity getGenericDivisaInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_DIVISA_CODI);
		Optional<DivisaEntity> entity = divisaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			Divisa dto = new Divisa();
			dto.setCodi(GENERIC_DIVISA_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			dto.setValorEuros(new BigDecimal(1));
			dto.setDecimalsPreus(2);
			dto.setDecimalsImports(2);
			DivisaEntity saved = divisaRepository.save(
					DivisaEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private ClientEntity getGenericClientInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_CLIENT_CODI);
		Optional<ClientEntity> entity = clientRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			Client dto = new Client();
			dto.setCodi(GENERIC_CLIENT_CODI);
			dto.setNomComercial(GENERIC_NOM_DESCRIPCIO);
			dto.setNomFiscal(GENERIC_NOM_DESCRIPCIO);
			dto.setPotencial(false);
			dto.setBloquejat(false);
			dto.setRebuts(RebutsEnumDto.NO);
			dto.setRecarrecEquivalencia(false);
			dto.setAlbaraValorat(false);
			dto.setTipusFactura(TipusFacturaEnumDto.GENERAL);
			dto.setEntitatPublica(false);
			dto.setMostrarPercentatgeFacturacioClase1(false);
			dto.setAplicarPreusPerVolum(false);
			dto.setTipusMissatge(TipusMissatgeEnumDto.CAP);
			dto.setPermesEntrarPartes(false);
			ClientEntity saved = clientRepository.save(
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
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private FamiliaClientEntity getGenericFamiliaClientInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_FAMILIA_CLIENT_CODI);
		Optional<FamiliaClientEntity> entity = familiaClientRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			FamiliaClient dto = new FamiliaClient();
			dto.setCodi(GENERIC_FAMILIA_CLIENT_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			FamiliaClientEntity saved = familiaClientRepository.save(
					FamiliaClientEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private TipusFacturacioEntity getGenericTipusFacturacioInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_TIPUS_FACTURACIO_CODI);
		Optional<TipusFacturacioEntity> entity = tipusFacturacioRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			TipusFacturacio dto = new TipusFacturacio();
			dto.setCodi(GENERIC_TIPUS_FACTURACIO_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			TipusFacturacioEntity saved = tipusFacturacioRepository.save(
					TipusFacturacioEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private DocumentPagamentCobramentEntity getGenericDocumentPagamentCobramentInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_DOCUMENT_PAGAMENT_COBRAMENT_CODI);
		Optional<DocumentPagamentCobramentEntity> entity = documentPagamentCobramentRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			DocumentPagamentCobrament dto = new DocumentPagamentCobrament();
			dto.setCodi(GENERIC_DOCUMENT_PAGAMENT_COBRAMENT_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setAsientoCompuesto(false);
			dto.setTranspasar(false);
			DocumentPagamentCobramentEntity saved = documentPagamentCobramentRepository.save(
					DocumentPagamentCobramentEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private RegimIvaEntity getGenericRegimIvaInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_REGIM_IVA_CODI);
		Optional<RegimIvaEntity> entity = regimIvaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			RegimIva dto = new RegimIva();
			dto.setCodi(GENERIC_REGIM_IVA_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setTip(TipusRegimEnumDto.GENERAL);
			RegimIvaEntity saved = regimIvaRepository.save(
					RegimIvaEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private TipusVencimentEntity getGenericTipusVencimentInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_TIPUS_VENCIMENT_CODI);
		Optional<TipusVencimentEntity> entity = tipusVencimentRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			TipusVenciment dto = new TipusVenciment();
			dto.setCodi(GENERIC_TIPUS_VENCIMENT_CODI);
			dto.setDescripcio(GENERIC_NOM_DESCRIPCIO);
			dto.setTipus(TipusVencimentEnumDto.IMPORT_FIXE);
			dto.setGenerarCobramentPagament(true);
			TipusVencimentEntity saved = tipusVencimentRepository.save(
					TipusVencimentEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private MagatzemEntity getGenericMagatzemInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_MAGATZEM_CODI);
		Optional<MagatzemEntity> entity = magatzemRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			Magatzem dto = new Magatzem();
			dto.setCodi(GENERIC_MAGATZEM_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			dto.setDomicili("N/D");
			dto.setValoracioInventariTraspas(ValoracioInventariTraspasEnum.ULTIM_PREU_DE_COST);
			MagatzemEntity saved = magatzemRepository.save(
					MagatzemEntity.builder().
					pk(pk).
					embedded(dto).
					codiPostal(getGenericCodiPostal(identificadorCodi)).
					divisa(getGenericDivisa(identificadorCodi)).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private CodiPostalEntity getGenericCodiPostalInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_CODI_POSTAL_CODI);
		Optional<CodiPostalEntity> entity = codiPostalRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			CodiPostal dto = new CodiPostal();
			dto.setCodi(GENERIC_CODI_POSTAL_CODI);
			dto.setPoblacio(GENERIC_NOM_DESCRIPCIO);
			CodiPostalEntity saved = codiPostalRepository.save(
					CodiPostalEntity.builder().
					pk(pk).
					embedded(dto).
					pais(getGenericPais(identificadorCodi)).
					provincia(getGenericProvincia(identificadorCodi)).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private PaisEntity getGenericPaisInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		WithIdentificadorAndCodiPk<String> pk = new WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_PAIS_CODI);
		Optional<PaisEntity> entity = paisRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			Pais dto = new Pais();
			dto.setCodi(GENERIC_PAIS_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			PaisEntity saved = paisRepository.save(
					PaisEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private ProvinciaEntity getGenericProvinciaInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		ProvinciaPk pk = new ProvinciaPk(
				identificadorCodi,
				GENERIC_PAIS_CODI,
				GENERIC_PROVINCIA_CODI);
		Optional<ProvinciaEntity> entity = provinciaRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			Provincia dto = new Provincia();
			dto.setCodi(GENERIC_PROVINCIA_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			ProvinciaEntity saved = provinciaRepository.save(
					ProvinciaEntity.builder().
					pk(pk).
					embedded(dto).
					pais(getGenericPais(identificadorCodi)).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private OperariEntity getGenericOperariInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String> pk = new es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_OPERARI_CODI);
		Optional<OperariEntity> entity = operariRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
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
			dto.setPtenmn(new Integer(0));
			dto.setAdo(false);
			OperariEntity saved = operariRepository.save(
					OperariEntity.builder().
					pk(pk).
					embedded(dto).
					horari(getGenericHorari(identificadorCodi)).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

	private HorariEntity getGenericHorariInternal(
			String identificadorCodi,
			boolean createIfNotExists) {
		es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String> pk = new es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>(
				identificadorCodi,
				GENERIC_HORARI_CODI);
		Optional<HorariEntity> entity = horariRepository.findById(pk);
		if (entity.isPresent()) {
			return entity.get();
		} else if (createIfNotExists) {
			Horari dto = new Horari();
			dto.setCodi(GENERIC_HORARI_CODI);
			dto.setNom(GENERIC_NOM_DESCRIPCIO);
			dto.setTipus(TipusHorariEnumDto.FLEXIBLE);
			HorariEntity saved = horariRepository.save(
					HorariEntity.builder().
					pk(pk).
					embedded(dto).
					build());
			log.debug("Nova entitat genèrica creada: " + saved.getClass().getName());
			return saved;
		} else {
			return null;
		}
	}

}
