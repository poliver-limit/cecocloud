/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa.CompteCorrentEmpresaPk;
import es.limit.cecocloud.fact.persist.entity.CompteCorrentEmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus compte corrent empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CompteCorrentEmpresaRepository extends BaseRepository<CompteCorrentEmpresaEntity, CompteCorrentEmpresaPk> {
}