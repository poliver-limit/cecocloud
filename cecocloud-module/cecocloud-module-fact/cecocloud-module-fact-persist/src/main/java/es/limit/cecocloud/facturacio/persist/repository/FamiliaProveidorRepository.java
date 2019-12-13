/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.FamiliaProveidorEntity;

/**
 * Repositori per a gestionar les entitats de tipus familia proveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FamiliaProveidorRepository extends BaseRepository<FamiliaProveidorEntity, AmbIdentificadorICodiPk<String>> {
}