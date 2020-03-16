/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.BancEntity;

/**
 * Repositori per a gestionar les entitats de tipus Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Repository("rrhhBancRepository")
public interface BancRepository extends BaseRepository<BancEntity, WithIdentificadorAndCodiPk<Integer>> {
}