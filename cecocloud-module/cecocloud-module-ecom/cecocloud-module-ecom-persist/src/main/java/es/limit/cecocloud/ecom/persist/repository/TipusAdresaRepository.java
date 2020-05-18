/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.persist.entity.TipusAdresaEntity;

/**
 * Repositori per a gestionar les entitats de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
/*public interface TipusAdresaRepository extends BaseRepository<TipusAdresaEntity, WithIdentificadorAndCodiPk<String>> {
}*/

@Repository("ecomTipusAdresaRepository")
public interface TipusAdresaRepository extends BaseRepository<TipusAdresaEntity, String> {

}