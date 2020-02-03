/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.marc.logic.api.service.SincronitzacioService;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

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
	private EmpresaRepository empresaRepository;
	@Autowired
	private MarcatgeRepository marcatgeRepository;
	@Autowired
	private UsuariRepository usuariRepository;

	@Override
	@Transactional(readOnly = true)
	public List<SincronitzacioMarcatge> marcatgeFind(
			String identificadorCodi,
			Date dataInici,
			Date dataFi) {
		/*Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(identificadorCodi);
		List<EmpresaEntity> emps = empresaRepository.findByIdentificador(identificador.get());
		List<SincronitzacioMarcatge> resposta = new ArrayList<SincronitzacioMarcatge>();
		if (!emps.isEmpty()) {
			List<MarcatgeEntity> marcatges = marcatgeRepository.findByEmpresaInAndBetweenDatesSync(
					emps,
					dataInici,
					dataFi == null,
					dataFi);
			for (MarcatgeEntity marcatge: marcatges) {
				SincronitzacioMarcatge sm = new SincronitzacioMarcatge();
				Operari smUsuariEmpresa = marcatge.getOperari().getEmbedded();
				EmpresaEntity smEmpresa = marcatge.getOperari().getEmpresa();
				sm.setEmpresaCodi(smEmpresa.getEmbedded().getCodi());
				sm.setOperariCodi(smUsuariEmpresa.getCodi());
				sm.setData(marcatge.getEmbedded().getData());
				sm.setLatitud(marcatge.getEmbedded().getLatitud());
				sm.setLongitud(marcatge.getEmbedded().getLongitud());
				resposta.add(sm);
			}
		}
		return resposta;*/
		// TODO
		return null;
	}

	@Override
	@Transactional
	public SincronitzacioResposta marcatgeCreate(
			String identificadorCodi,
			List<SincronitzacioMarcatge> marcatges) {
		/*Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(identificadorCodi);
		int createCount = 0;
		if (marcatges != null) {
			for (SincronitzacioMarcatge marcatge: marcatges) {
				Optional<OperariEntity> operari = operariRepository.findByEmpresaIdentificadorAndEmpresaEmbeddedCodiAndEmbeddedCodi(
						identificador.get(),
						marcatge.getEmpresaCodi(),
						marcatge.getOperariCodi());
				MarcatgeEntity marcatgeExistent = marcatgeRepository.findByOperariAndEmbeddedData(
						operari.get(),
						marcatge.getData());
				if (marcatgeExistent == null) {
					Marcatge embedded = new Marcatge();
					embedded.setData(marcatge.getData());
					embedded.setLatitud(marcatge.getLatitud());
					embedded.setLongitud(marcatge.getLongitud());
					embedded.setOrigen(MarcatgeOrigen.CECOGEST);
					marcatgeRepository.save(
							MarcatgeEntity.builder().
							operari(operari.get()).
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
				0);*/
		// TODO
		return null;
	}

}
