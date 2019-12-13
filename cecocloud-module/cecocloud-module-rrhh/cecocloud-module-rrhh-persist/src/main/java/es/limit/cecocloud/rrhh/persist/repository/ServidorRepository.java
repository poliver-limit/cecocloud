/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.rrhh.persist.entity.ServidorEntity;

/**
 * Repositori per a gestionar les entitats de tipus Servidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ServidorRepository extends BaseRepository<ServidorEntity, AmbIdentificadorICodiPk<String>> {
}