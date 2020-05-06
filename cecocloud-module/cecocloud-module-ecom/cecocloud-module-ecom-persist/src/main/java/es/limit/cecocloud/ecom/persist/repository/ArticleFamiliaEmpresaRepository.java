/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamiliaEmpresa.ArticleFamiliaEmpresaPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleFamiliaEmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleFamiliaEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleFamiliaEmpresaRepository")
public interface ArticleFamiliaEmpresaRepository extends BaseRepository<ArticleFamiliaEmpresaEntity, ArticleFamiliaEmpresaPk> {
}