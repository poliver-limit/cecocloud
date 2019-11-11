/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia.UsuariCompanyiaPk;
import es.limit.cecocloud.persist.entity.UsuariCompanyiaEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades de tipus usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariCompanyiaRepository extends BaseRepository<UsuariCompanyiaEntity, UsuariCompanyiaPk> {
	
	List<UsuariCompanyiaEntity> findByUsuariEmbeddedCodiOrderByCompanyiaEmbeddedNom(String usuariCodi);
	
//	List<UsuariCompanyiaEntity> findByCompanyiaEmbeddedCodi(String companyiaCodi);
//	UsuariCompanyiaEntity findUsuariCompanyiaByUsuariEmbeddedCodiAndCompanyiaEmbeddedCodi(String usuariCodi, String companyiaCodi);
}