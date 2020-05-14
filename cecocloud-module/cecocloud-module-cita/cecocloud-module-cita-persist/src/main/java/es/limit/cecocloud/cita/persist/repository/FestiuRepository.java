/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.logic.api.dto.Festiu.FestiuPk;
import es.limit.cecocloud.cita.persist.entity.FestiuEntity;
import es.limit.cecocloud.cita.persist.entity.FestiuGrupEntity;

/**
 * Repositori per a gestionar les entitats de tipus festiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FestiuRepository extends BaseRepository<FestiuEntity, FestiuPk> {

	List<FestiuEntity> findByFestiuGrup(FestiuGrupEntity festiuGrup);

}