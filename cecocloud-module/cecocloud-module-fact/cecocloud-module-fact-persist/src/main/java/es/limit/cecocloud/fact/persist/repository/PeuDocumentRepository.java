/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.fact.persist.entity.PeuDocumentEntity;

/**
 * Repositori per a gestionar les entitats de tipus PeuDocument.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PeuDocumentRepository extends BaseRepository<PeuDocumentEntity, PeuDocumentPk> {
}