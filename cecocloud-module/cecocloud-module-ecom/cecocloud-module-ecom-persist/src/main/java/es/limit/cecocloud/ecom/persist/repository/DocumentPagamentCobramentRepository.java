/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Repositori per a gestionar les entitats de tipus DocumentPagamentCobrament
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomDocumentPagamentCobramentRepository")
public interface DocumentPagamentCobramentRepository extends BaseRepository<DocumentPagamentCobramentEntity, WithIdentificadorAndCodiPk<String>> {
}