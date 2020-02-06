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
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.cecocloud.marc.logic.api.dto.EmpresaMobil;
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
import es.limit.cecocloud.persist.repository.OperariRepository;
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
	private OperariRepository operariRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private OperariEmpresaRepository operariEmpresaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;

	@Autowired
	protected MapperFacade orikaMapperFacade;
	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Override
	public MarcatgeMobil create(MarcatgeMobil marcatgeMobil) {
		if (marcatgeMobil.getEmpresa() != null && marcatgeMobil.getEmpresa().getId() != null) {
			OperariEmpresaEntity operariEmpresa = getOperariEmpresaPerMarcatge(marcatgeMobil.getEmpresa().getId());
			log.info("Rebut marcatge de l'app mòbil (" +
					"operari=" + operariEmpresa.getEmbedded().getDescription() + ", " +
					"data=" + marcatgeMobil.getData() + ", " +
					"dataActual=" + new Date() + ")");
			Marcatge marcatge = new Marcatge();
			marcatge.setData(marcatgeMobil.getData());
			marcatge.setOrigen(MarcatgeOrigen.MOBIL);
			marcatge.setLatitud(marcatgeMobil.getLatitud());
			marcatge.setLongitud(marcatgeMobil.getLongitud());
			MarcatgeEntity entity = MarcatgeEntity.builder().
					operariEmpresa(operariEmpresa).
					embedded(marcatge).
					build();
			return toMarcatgeMobil(marcatgeRepository.save(entity));
		} else {
			throw new IllegalArgumentException("S'ha enviat un marcatge sense empresa");
		}
	}

	@Override
	public List<MarcatgeMobil> find(MarcatgeMobilConsulta consulta) {
		if (consulta.getEmpresaId() != null) {
			OperariEmpresaEntity operariEmpresa = getOperariEmpresaPerMarcatge(consulta.getEmpresaId());
			Calendar dataFi = Calendar.getInstance();
			dataFi.setTime(consulta.getData());
			dataFi.set(Calendar.HOUR_OF_DAY, 23);
			dataFi.set(Calendar.MINUTE, 59);
			dataFi.set(Calendar.SECOND, 59);
			dataFi.set(Calendar.MILLISECOND, 999);
			List<MarcatgeEntity> marcatges = marcatgeRepository.findByOperariEmpresaAndBetweenDatesMobile(
					operariEmpresa,
					consulta.getData(),
					false,
					dataFi.getTime());
			return marcatges.stream().map(marcatge -> toMarcatgeMobil(marcatge)).collect(Collectors.toList());
		} else {
			throw new IllegalArgumentException("S'ha enviat una consulta sense empresa");
		}
	}

	@Override
	public List<EmpresaMobil> empresesFindDisponiblesPerUsuariActual() {
		List<OperariEntity> operaris = operariRepository.findByUsuariEmbeddedCodiAndEmbeddedActiu(
				authenticationHelper.getPrincipalName(),
				true);
		List<OperariEmpresaEntity> operarisEmpreses = operariEmpresaRepository.findByOperariInAndEmbeddedActiuAndEmpresaEmbeddedActiva(
				operaris,
				true,
				true);
		return orikaMapperFacade.mapAsList(
				operarisEmpreses.stream().map(OperariEmpresaEntity::getEmpresa).collect(Collectors.toList()),
				EmpresaMobil.class);
	}

	private OperariEmpresaEntity getOperariEmpresaPerMarcatge(Long empresaId) {
		Optional<EmpresaEntity> empresa = empresaRepository.findById(empresaId);
		if (empresa.get().getEmbedded().isActiva()) {
			Optional<OperariEntity> operari = operariRepository.findByIdentificadorAndEmbeddedActiuAndUsuariEmbeddedCodi(
					empresa.get().getIdentificador(),
					true,
					authenticationHelper.getPrincipalName());
			Optional<OperariEmpresaEntity> operariEmpresa = operariEmpresaRepository.findByOperariAndEmpresaAndEmbeddedActiu(
					operari.get(),
					empresa.get(),
					true);
			return operariEmpresa.get();
		} else {
			throw new EntityNotFoundException("Empresa autoritzada amb id " + empresaId);
		}
	}

	private MarcatgeMobil toMarcatgeMobil(MarcatgeEntity marcatge) {
		MarcatgeMobil marcatgeMobil = new MarcatgeMobil();
		marcatgeMobil.setEmpresa(
				GenericReference.toGenericReference(
						marcatge.getOperariEmpresa().getEmpresa().getId()));
		marcatgeMobil.setData(marcatge.getEmbedded().getData());
		marcatgeMobil.setLatitud(marcatge.getEmbedded().getLatitud());
		marcatgeMobil.setLongitud(marcatge.getEmbedded().getLongitud());
		return marcatgeMobil;
	}

}
