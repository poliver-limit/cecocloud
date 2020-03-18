/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.CodiPostalEntity;

/**
 * Repositori per a gestionar les entitats de tipus codi postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Repository("rrhhCodiPostalRepository")
public interface CodiPostalRepository extends BaseRepository<CodiPostalEntity, WithIdentificadorAndCodiPk<String>> {
}
