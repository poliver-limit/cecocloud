/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia.UsuariCompanyiaPk;
import es.limit.cecocloud.logic.api.service.UsuariCompanyiaService;
import es.limit.cecocloud.persist.entity.UsuariCompanyiaEntity;

/**
 * Implementació del servei de gestió d'usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariCompanyiaServiceImpl extends AbstractGenericCompositePkServiceImpl<UsuariCompanyia, UsuariCompanyiaEntity, UsuariCompanyiaPk> implements UsuariCompanyiaService {

	/*@Autowired
	private UsuariCompanyiaRepository usuariCompanyiaRepository;

	@Transactional
	@Override
	public List<UsuariCompanyia> findUsuariCompanyiaByUsuariCodi(String usuariCodi) {
		return toDto(usuariCompanyiaRepository.findByUsuariEmbeddedCodi(usuariCodi));
	}
	@Transactional
	@Override
	public List<UsuariCompanyia> findUsuariCompanyiaByCompanyiaCodi(String companyiaCodi) {
		return toDto(usuariCompanyiaRepository.findByCompanyiaEmbeddedCodi(companyiaCodi));
	}
	
	@Transactional
	@Override
	public UsuariCompanyia findUsuariCompanyiaByUsuariCodiAndCompanyiaCodi(String usuariCodi, String companyiaCodi) {
		return toDto(usuariCompanyiaRepository.findUsuariCompanyiaByUsuariEmbeddedCodiAndCompanyiaEmbeddedCodi(usuariCodi, companyiaCodi));
	}*/

}

