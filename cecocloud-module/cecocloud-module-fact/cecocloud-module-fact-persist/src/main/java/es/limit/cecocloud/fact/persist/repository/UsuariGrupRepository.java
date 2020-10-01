/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup.UsuariGrupPk;
import es.limit.cecocloud.fact.persist.entity.UsuariGrupEntity;

/**
 * Repositori per a gestionar les entitats de tipus UsuariGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factUsuariGrupRepository")
public interface UsuariGrupRepository extends BaseRepository<UsuariGrupEntity, UsuariGrupPk> {
}