/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.AgrupacioEntity;
import es.limit.cecocloud.persist.entity.AgrupacioFuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;

/**
 * Repository per a gestionar les entitats de tipus agrupacio-agrupacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface AgrupacioFuncionalitatRepository extends BaseRepository<AgrupacioFuncionalitatEntity, Long> {

	List<AgrupacioFuncionalitatEntity> findByAgrupacio(AgrupacioEntity agrupacio);
	AgrupacioFuncionalitatEntity findByAgrupacioAndFuncionalitat(
			AgrupacioEntity agrupacio,
			FuncionalitatEntity funcionalitat);
	
	
}
