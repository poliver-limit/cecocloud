/**
 * 
 */
package es.limit.cecocloud.lici.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.lici.persist.entity.DocumentEntity;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;

/**
 * Repository per a gestionar l'entitat de document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface DocumentRepository extends BaseRepository<DocumentEntity, Long>{

	List<DocumentEntity> findByLicitacio(LicitacioEntity licitacio);

}
