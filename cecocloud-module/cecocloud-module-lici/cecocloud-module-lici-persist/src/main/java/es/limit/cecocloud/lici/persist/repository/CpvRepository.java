/**
 * 
 */
package es.limit.cecocloud.lici.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.lici.persist.entity.CpvEntity;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;

/**
 * Repository per a gestionar l'entitat de CPV.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface CpvRepository extends BaseRepository<CpvEntity, Long>{

	List<CpvEntity> findByLicitacio(LicitacioEntity licitacio);

}
