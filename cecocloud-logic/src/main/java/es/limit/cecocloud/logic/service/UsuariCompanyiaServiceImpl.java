/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;
import es.limit.cecocloud.logic.api.service.UsuariCompanyiaService;
import es.limit.cecocloud.persist.entity.UsuariCompanyiaEntity;
import es.limit.cecocloud.persist.repository.UsuariCompanyiaRepository;

/**
 * Implementació del servei de gestió d'usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariCompanyiaServiceImpl extends AbstractGenericServiceImpl<UsuariCompanyia, UsuariCompanyiaEntity, Long> implements UsuariCompanyiaService {

	@Autowired
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
	}

}

