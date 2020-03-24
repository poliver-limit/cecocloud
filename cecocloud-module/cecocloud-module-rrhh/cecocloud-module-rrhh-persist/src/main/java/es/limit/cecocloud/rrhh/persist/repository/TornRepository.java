/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.TornEntity;

/**
 * Repositori per a gestionar les entitats de tipus torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TornRepository extends BaseRepository<TornEntity, WithIdentificadorAndCodiPk<String>>{

}
