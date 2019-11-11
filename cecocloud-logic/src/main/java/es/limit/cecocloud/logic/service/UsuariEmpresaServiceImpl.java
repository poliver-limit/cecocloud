/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import es.limit.cecocloud.logic.api.service.UsuariEmpresaService;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;

/**
 * Implementació del servei de gestió d'usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<UsuariEmpresa, UsuariEmpresaEntity, UsuariEmpresaPk> implements UsuariEmpresaService {

	/*@Autowired
	private UsuariEmpresaRepository usuariEmpresaRepository;*/

	/*@Transactional
	@Override
	public List<UsuariEmpresa> findByUsuariCodi(
			String usuariCodi,
			String identificadorCodi) {
		return toDto(usuariEmpresaRepository.findByUsuariCodiAndIdentificadorCodi(
					usuariCodi,
					identificadorCodi));
	}

	@Override
	public UsuariEmpresa findByUsuariCodiAndEmpresa(
			String usuariCodi, 
			Long empresaCodi) {
		return toDto(usuariEmpresaRepository.getByUsuariEmbeddedCodiAndEmpresaEmbeddedCodi(
					usuariCodi, 
					empresaCodi));
	}*/

}
