/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamiliaEmpresa.ArticleFamiliaEmpresaPk;
import es.limit.cecocloud.facturacio.persist.entity.ArticleFamiliaEmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleFamiliaEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ArticleFamiliaEmpresaRepository extends BaseRepository<ArticleFamiliaEmpresaEntity, ArticleFamiliaEmpresaPk> {
}