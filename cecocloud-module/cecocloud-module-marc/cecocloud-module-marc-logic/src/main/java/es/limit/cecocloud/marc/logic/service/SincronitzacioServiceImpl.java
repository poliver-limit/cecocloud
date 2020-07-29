/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeOrigen;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marc.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.repository.OperariEmpresaRepository;
import es.limit.cecocloud.persist.repository.OperariRepository;

/**
 * Implementació del servei encarregat de gestionar la sincronització de la informació provinent
 * de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("marcSincronitzacioServiceImpl")
public class SincronitzacioServiceImpl implements SincronitzacioService {

	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private OperariRepository operariRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private OperariEmpresaRepository operariEmpresaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;
	@Autowired
	private HttpServletRequest request;

	@Override
	@Transactional(readOnly = true)
	public List<SincronitzacioMarcatge> marcatgeFind(
			String identificadorCodi,
			String empresaCodi,
			Date dataInici,
			Date dataFi,
			Long idInici,
			Long idFi) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(identificadorCodi);
		if (identificador.isPresent()) {
			List<SincronitzacioMarcatge> resposta = new ArrayList<SincronitzacioMarcatge>();
			List<EmpresaEntity> empreses = empresaRepository.findByIdentificador(identificador.get());
			if (!empreses.isEmpty()) {
				List<MarcatgeEntity> marcatges = marcatgeRepository.findByEmpresaInAndBetweenDatesSync(
						empreses.stream().filter(empresa -> empresaCodi == null || empresa.getEmbedded().getCodi().equals(empresaCodi)).collect(Collectors.toList()),
						dataInici == null,
						dataInici,
						dataFi == null,
						dataFi,
						idInici == null,
						idInici,
						idFi == null,
						idFi);
				for (MarcatgeEntity marcatge: marcatges) {
					SincronitzacioMarcatge sm = new SincronitzacioMarcatge();
					sm.setId(marcatge.getId());
					Operari operari = marcatge.getOperariEmpresa().getOperari().getEmbedded();
					sm.setOperariCodi(operari.getCodi());
					EmpresaEntity empresa = marcatge.getOperariEmpresa().getEmpresa();
					sm.setEmpresaCodi(empresa.getEmbedded().getCodi());
					sm.setData(marcatge.getEmbedded().getData());
					sm.setLatitud(marcatge.getEmbedded().getLatitud());
					sm.setLongitud(marcatge.getEmbedded().getLongitud());
					resposta.add(sm);
				}
			}
			return resposta;
		} else {
			throw new EntityNotFoundException("IdentificadorEntity#codi=" + identificadorCodi);
		}
	}

	@Override
	@Transactional
	public SincronitzacioResposta marcatgeCreate(
			String identificadorCodi,
			List<SincronitzacioMarcatge> marcatges) {
		Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(identificadorCodi);
		if (identificador.isPresent()) {
			int createCount = 0;
			if (marcatges != null) {
				for (SincronitzacioMarcatge marcatge: marcatges) {
					Optional<OperariEntity> operari = operariRepository.findByIdentificadorAndEmbeddedCodi(
							identificador.get(),
							marcatge.getOperariCodi());
					Optional<EmpresaEntity> empresa = empresaRepository.findByIdentificadorAndEmbeddedCodi(
							identificador.get(),
							marcatge.getEmpresaCodi());
					Optional<OperariEmpresaEntity> operariEmpresa = operariEmpresaRepository.findByOperariAndEmpresa(
							operari.get(),
							empresa.get());
					MarcatgeEntity marcatgeExistent = marcatgeRepository.findByOperariEmpresaAndEmbeddedData(
							operariEmpresa.get(),
							marcatge.getData());
					if (marcatgeExistent == null) {
						Marcatge embedded = new Marcatge();
						embedded.setData(marcatge.getData());
						embedded.setLatitud(marcatge.getLatitud());
						embedded.setLongitud(marcatge.getLongitud());
						embedded.setOrigen(MarcatgeOrigen.CECOGEST);
						embedded.setAdressaIp(request.getRemoteAddr());
						marcatgeRepository.save(
								MarcatgeEntity.builder().
								operariEmpresa(operariEmpresa.get()).
								embedded(embedded).
								build());
						createCount++;
					}
				}
			}
			return new SincronitzacioResposta(
					createCount,
					0,
					0,
					0);
		} else {
			throw new EntityNotFoundException("IdentificadorEntity#codi=" + identificadorCodi);
		}
	}

}
