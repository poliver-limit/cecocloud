package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.persist.entity.TipusAdresaEntity;

/**
 * Repositori per a gestionar les entitats de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusAdresaRepository extends BaseRepository<TipusAdresaEntity, WithIdentificadorAndCodiPk<String>> {
}
