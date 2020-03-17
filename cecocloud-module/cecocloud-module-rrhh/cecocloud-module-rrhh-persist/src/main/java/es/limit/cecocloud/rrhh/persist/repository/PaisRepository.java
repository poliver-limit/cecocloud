/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.PaisEntity;

/**
 * Repositori per a gestionar les entitats de tipus pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Repository("rrhhPaisRepository")
public interface PaisRepository extends BaseRepository<PaisEntity, WithIdentificadorAndCodiPk<String>> {
}
