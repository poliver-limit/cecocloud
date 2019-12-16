/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.rrhh.persist.entity.ParametreEntity;

/**
 * Repositori per a gestionar les entitats de tipus Parametre.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ParametreRepository extends BaseRepository<ParametreEntity, AmbIdentificadorICodiPk<String>> {
}