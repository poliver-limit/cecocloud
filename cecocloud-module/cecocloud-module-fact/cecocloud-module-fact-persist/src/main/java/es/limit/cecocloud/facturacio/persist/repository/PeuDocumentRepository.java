/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.facturacio.persist.entity.PeuDocumentEntity;

/**
 * Repositori per a gestionar les entitats de tipus PeuDocument.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PeuDocumentRepository extends BaseRepository<PeuDocumentEntity, PeuDocumentPk> {
}