/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.ecom.persist.entity.PeuDocumentEntity;

/**
 * Repositori per a gestionar les entitats de tipus PeuDocument.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomPeuDocumentRepository")
public interface PeuDocumentRepository extends BaseRepository<PeuDocumentEntity, PeuDocumentPk> {
}