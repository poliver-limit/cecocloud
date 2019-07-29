/**
 * 
 */
package es.limit.cecocloud.logic.service;

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

	private DtoConverter<Marcatge, MarcatgeEntity, Long> marcatgeDtoConverter;
	private DtoConverter<Empresa, EmpresaEntity, Long> empresaDtoConverter;

	@Autowired
	public MobileMarcatgeServiceImpl(MapperFacade orikaMapperFacade) {
		super();
		this.marcatgeDtoConverter = new DtoConverter<Marcatge, MarcatgeEntity, Long>(
				Marcatge.class,
				MarcatgeEntity.class,
				orikaMapperFacade);
		this.empresaDtoConverter = new DtoConverter<Empresa, EmpresaEntity, Long>(
				Empresa.class,
				EmpresaEntity.class,
				orikaMapperFacade);
	}

	@Override
	public MarcatgeMobil marcatgeCreate(MarcatgeMobil marcatgeMobil) {
		UsuariEmpresaEntity usuariEmpresa = getUsuariEmpresaPerMarcatge(marcatgeMobil);
		Marcatge marcatge = new Marcatge();
		marcatge.setParentId(usuariEmpresa.getId());
		marcatge.setData(marcatgeMobil.getData());
		marcatge.setDataCreacio(new Date());
		MarcatgeEntity entity = MarcatgeEntity.builder().
				parent(usuariEmpresa).
				embedded(marcatge).
				build();
		Marcatge dtoCreat = marcatgeDtoConverter.toDto(
				marcatgeRepository.save(entity));
		MarcatgeMobil creat = new MarcatgeMobil();
		creat.setData(dtoCreat.getData());
		creat.setDataCreacio(dtoCreat.getDataCreacio());
		creat.setEmpresa(
				new GenericReference<Empresa, Long>(
						usuariEmpresa.getParent2().getId(),
						null));
		return creat;
	}

	@Override
	public List<Empresa> empresaFindAll() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = auth.getName();
		Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(currentUserName);
		List<UsuariEmpresaEntity> usuariEmpreses = usuariEmpresaRepository.findByParent1AndEmpresaActiva(
				usuari.get(),
				true);
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
				throw new EntityNotFoundException("Empresa activa amb id " + marcatgeMobil.getEmpresa().getId());
			}
		} else {
			throw new IllegalArgumentException("S'ha enviat un marcatge sense empresa");
		}
	}

}
