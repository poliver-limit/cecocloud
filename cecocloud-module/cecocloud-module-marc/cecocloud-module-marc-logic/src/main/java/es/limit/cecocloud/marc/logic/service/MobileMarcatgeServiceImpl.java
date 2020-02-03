/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeMobil;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeMobilConsulta;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeOrigen;
import es.limit.cecocloud.marc.logic.api.service.MobileMarcatgeService;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.OperariEmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

/**
 * Implementació del servei encarregat de generar tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service
public class MobileMarcatgeServiceImpl implements MobileMarcatgeService {

	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private OperariEmpresaRepository operariEmpresaRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;

	@Autowired
	protected MapperFacade orikaMapperFacade;
	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Override
	public MarcatgeMobil create(MarcatgeMobil marcatgeMobil) {
		OperariEmpresaEntity operariEmpresa = getOperariEmpresaPerMarcatge(marcatgeMobil);
		Marcatge marcatge = new Marcatge();
		log.info("Rebut marcatge de l'app mòbil (" +
				"operari=" + /*operariEmpresa.getEmbedded().getDescripcio() + */", " +
				"data=" + marcatgeMobil.getData() + ", " +
				"dataActual=" + new Date() + ")");
		/*marcatge.setData(marcatgeMobil.getData());
		marcatge.setOrigen(MarcatgeOrigen.MOBIL);
		marcatge.setLatitud(marcatgeMobil.getLatitud());
		marcatge.setLongitud(marcatgeMobil.getLongitud());
		MarcatgeEntity entity = MarcatgeEntity.builder().
				operariEmpresa(operariEmpresa).
				embedded(marcatge).
				build();
		return toMarcatgeMobil(marcatgeRepository.save(entity));*/
		// TODO
		return null;
	}

	@Override
	public List<MarcatgeMobil> find(MarcatgeMobilConsulta consulta) {
		/*Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(authenticationHelper.getPrincipalName());
		EmpresaEntity empresa = empresaRepository.getOne(consulta.getEmpresaId());
		Optional<OperariEntity> operari = operariRepository.findByUsuariAndEmpresaAndEmbeddedDataFiNull(
				usuari.get(),
				empresa);
		Calendar dataFi = Calendar.getInstance();
		dataFi.setTime(consulta.getData());
		dataFi.set(Calendar.HOUR_OF_DAY, 23);
		dataFi.set(Calendar.MINUTE, 59);
		dataFi.set(Calendar.SECOND, 59);
		dataFi.set(Calendar.MILLISECOND, 999);
		List<MarcatgeEntity> marcatges = marcatgeRepository.findByOperariAndBetweenDatesMobile(
				operari.get(),
				consulta.getData(),
				false,
				dataFi.getTime());
		return marcatges.stream().map(marcatge -> toMarcatgeMobil(marcatge)).collect(Collectors.toList());*/
		// TODO
		return null;
	}

	@Override
	public List<Empresa> empresesFindDisponiblesPerUsuariActual() {
		/*List<OperariEntity> operaris = findOperarisActiusIAmbEmpresaActivaPerUsuariActual();
		// TODO: Controlar si es retornen empreses repetides
		return orikaMapperFacade.mapAsList(
				operaris.stream().map(OperariEntity::getEmpresa).collect(Collectors.toList()),
				Empresa.class);*/
		// TODO
		return null;
	}

	private OperariEmpresaEntity getOperariEmpresaPerMarcatge(MarcatgeMobil marcatgeMobil) {
		/*if (marcatgeMobil.getEmpresa() != null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String currentUserName = auth.getName();
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(currentUserName);
			Optional<EmpresaEntity> empresa = empresaRepository.findById(marcatgeMobil.getEmpresa().getId());
			if (empresa.get().getEmbedded().isActiva()) {
				List<OperariEntity> operaris = operariRepository.findByUsuariAndEmpresa(
						usuari.get(),
						empresa.get());
				OperariEntity trobat = null;
				for (OperariEntity operari: operaris) {
					Operari embedded = operari.getEmbedded();
					Date marcatgeData = marcatgeMobil.getData();
					if (marcatgeData.after(embedded.getDataInici()) && (embedded.getDataFi() == null || marcatgeData.before(embedded.getDataFi()))) {
						trobat = operari;
						break;
					}
				}
				return trobat;
			} else {
				throw new EntityNotFoundException("Empresa autoritzada amb id " + marcatgeMobil.getEmpresa().getId());
			}
		} else {
			throw new IllegalArgumentException("S'ha enviat un marcatge sense empresa");
		}*/
		// TODO
		return null;
	}

	private List<OperariEntity> findOperarisActiusIAmbEmpresaActivaPerUsuariActual() {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = auth.getName();
		Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(currentUserName);
		return operariRepository.findByUsuariAndDataFiNullAndEmpresaActiva(
				usuari.get(),
				new Date(),
				true);*/
		// TODO
		return null;
	}

	private MarcatgeMobil toMarcatgeMobil(MarcatgeEntity marcatge) {
		/*MarcatgeMobil marcatgeMobil = new MarcatgeMobil();
		marcatgeMobil.setEmpresa(
				GenericReference.toGenericReference(
						marcatge.getOperari().getEmpresa().getId()));
		marcatgeMobil.setData(marcatge.getEmbedded().getData());
		marcatgeMobil.setLatitud(marcatge.getEmbedded().getLatitud());
		marcatgeMobil.setLongitud(marcatge.getEmbedded().getLongitud());
		return marcatgeMobil;*/
		// TODO
		return null;
	}

}
