/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.MantenimentDeTipusEntity;

/**
 * Repositori per a gestionar les entitats de tipus mantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MantenimentDeTipusRepository extends BaseRepository<MantenimentDeTipusEntity, WithIdentificadorAndCodiPk<String>>{

}
