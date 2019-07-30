/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Arrays;
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

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.dto.MarcatgeMobil;
import es.limit.cecocloud.logic.api.dto.MarcatgeMobilConsulta;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.service.MobileMarcatgeService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.repository.UsuariEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariRepository;
import ma.glasnost.orika.MapperFacade;

/**
 * Implementació del servei encarregat de generar tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MobileMarcatgeServiceImpl implements MobileMarcatgeService {

	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private UsuariEmpresaRepository usuariEmpresaRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;

	/*private DtoConverter<Marcatge, MarcatgeEntity, Long> marcatgeDtoConverter;*/
	private DtoConverter<Empresa, EmpresaEntity, Long> empresaDtoConverter;

	@Autowired
	public MobileMarcatgeServiceImpl(MapperFacade orikaMapperFacade) {
		super();
		/*this.marcatgeDtoConverter = new DtoConverter<Marcatge, MarcatgeEntity, Long>(
				Marcatge.class,
				MarcatgeEntity.class,
				orikaMapperFacade);*/
		this.empresaDtoConverter = new DtoConverter<Empresa, EmpresaEntity, Long>(
				Empresa.class,
				EmpresaEntity.class,
				orikaMapperFacade);
	}

	@Override
	public MarcatgeMobil create(MarcatgeMobil marcatgeMobil) {
		UsuariEmpresaEntity usuariEmpresa = getUsuariEmpresaPerMarcatge(marcatgeMobil);
		Marcatge marcatge = new Marcatge();
		marcatge.setParentId(usuariEmpresa.getId());
		marcatge.setData(marcatgeMobil.getData());
		marcatge.setDataCreacio(new Date());
		MarcatgeEntity entity = MarcatgeEntity.builder().
				parent(usuariEmpresa).
				embedded(marcatge).
				build();
		// Marcatge dtoCreat = marcatgeDtoConverter.toDto(marcatgeRepository.save(entity));
		return toMarcatgeMobil(marcatgeRepository.save(entity));
	}

	@Override
	public List<MarcatgeMobil> find(MarcatgeMobilConsulta consulta) {
		List<UsuariEmpresaEntity> usuariEmpreses = findUsuarisEmpresesActius();
		EmpresaEntity empresa = null;
		for (UsuariEmpresaEntity usuariEmpresa: usuariEmpreses) {
			if (usuariEmpresa.getParent2().getId().equals(consulta.getEmpresaId())) {
				empresa = usuariEmpresa.getParent2();
				break;
			}
		}
		if (empresa != null) {
			Calendar dataFi = Calendar.getInstance();
			dataFi.setTime(consulta.getData());
			dataFi.set(Calendar.HOUR_OF_DAY, 23);
			dataFi.set(Calendar.MINUTE, 59);
			dataFi.set(Calendar.SECOND, 59);
			dataFi.set(Calendar.MILLISECOND, 999);
			List<MarcatgeEntity> marcatges = marcatgeRepository.findByEmpresaInAndBetweenDates(
					Arrays.asList(empresa),
					consulta.getData(),
					false,
					dataFi.getTime());
			return marcatges.stream().map(marcatge -> toMarcatgeMobil(marcatge)).collect(Collectors.toList());
		} else {
			throw new EntityNotFoundException("Empresa autoritzada amb id " + consulta.getEmpresaId());
		}
	}

	@Override
	public List<Empresa> empresesFindAll() {
		List<UsuariEmpresaEntity> usuariEmpreses = findUsuarisEmpresesActius();
		return empresaDtoConverter.toDto(
				usuariEmpreses.stream().map(UsuariEmpresaEntity::getParent2).collect(Collectors.toList()));
	}

	private UsuariEmpresaEntity getUsuariEmpresaPerMarcatge(MarcatgeMobil marcatgeMobil) {
		if (marcatgeMobil.getEmpresa() != null) {
			Date ara = new Date();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String currentUserName = auth.getName();
			Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(currentUserName);
			Optional<EmpresaEntity> empresa = empresaRepository.findById(marcatgeMobil.getEmpresa().getId());
			if (empresa.get().getEmbedded().isActiva()) {
				List<UsuariEmpresaEntity> usuariEmpreses = usuariEmpresaRepository.findByParent1AndParent2(
						usuari.get(),
						empresa.get());
				UsuariEmpresaEntity trobat = null;
				for (UsuariEmpresaEntity usuariEmpresa: usuariEmpreses) {
					UsuariEmpresa embedded = usuariEmpresa.getEmbedded();
					if (ara.after(embedded.getDataInici()) && (embedded.getDataFi() == null || ara.before(embedded.getDataFi()))) {
						trobat = usuariEmpresa;
						break;
					}
				}
				return trobat;
			} else {
				throw new EntityNotFoundException("Empresa autoritzada amb id " + marcatgeMobil.getEmpresa().getId());
			}
		} else {
			throw new IllegalArgumentException("S'ha enviat un marcatge sense empresa");
		}
	}

	private List<UsuariEmpresaEntity> findUsuarisEmpresesActius() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = auth.getName();
		Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(currentUserName);
		return usuariEmpresaRepository.findByParent1AndDataFiNullAndEmpresaActiva(
				usuari.get(),
				new Date(),
				true);
	}

	private MarcatgeMobil toMarcatgeMobil(MarcatgeEntity marcatge) {
		MarcatgeMobil marcatgeMobil = new MarcatgeMobil();
		marcatgeMobil.setData(marcatge.getEmbedded().getData());
		marcatgeMobil.setDataCreacio(marcatge.getEmbedded().getDataCreacio());
		marcatgeMobil.setEmpresa(
				new GenericReference<Empresa, Long>(
						marcatge.getParent().getParent2().getId(),
						null));
		return marcatgeMobil;
	}

}
