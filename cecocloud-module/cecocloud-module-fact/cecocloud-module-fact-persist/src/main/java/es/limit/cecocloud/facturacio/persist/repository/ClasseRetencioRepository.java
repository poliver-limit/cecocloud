package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.persist.entity.ClasseRetencioEntity;

/**
 * Repositori per a gestionar les entitats de tipus ClasseRetencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ClasseRetencioRepository extends BaseRepository<ClasseRetencioEntity, WithIdentificadorAndCodiPk<String>> {
}
