/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.CaracteristicaIdentificador.CaracteristicaIdentificadorPk;
import es.limit.cecocloud.persist.entity.CaracteristicaIdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus caracteristica-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CaracteristicaIdentificadorRepository extends BaseRepository<CaracteristicaIdentificadorEntity, CaracteristicaIdentificadorPk> {

}
