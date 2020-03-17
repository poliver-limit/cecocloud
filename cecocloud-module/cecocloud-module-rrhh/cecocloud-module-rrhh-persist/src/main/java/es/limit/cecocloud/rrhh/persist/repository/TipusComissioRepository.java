/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.TipusComissioEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusComissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Repository("rrhhTipusComissioRepository")
public interface TipusComissioRepository extends BaseRepository<TipusComissioEntity, WithIdentificadorAndCodiPk<String>> {
}