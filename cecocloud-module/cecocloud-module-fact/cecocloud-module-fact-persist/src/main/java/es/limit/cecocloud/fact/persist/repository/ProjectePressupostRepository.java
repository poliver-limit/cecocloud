/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost.ProjectePressupostPk;
import es.limit.cecocloud.fact.persist.entity.ProjectePressupostEntity;

/**
 * Repositori per a gestionar les entitats de tipus ProjectePressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ProjectePressupostRepository extends BaseRepository<ProjectePressupostEntity, ProjectePressupostPk> {
}