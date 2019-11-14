/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades de tipus usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface UsuariEmpresaRepository extends BaseRepository<UsuariEmpresaEntity, UsuariEmpresaPk> {

	List<UsuariEmpresaEntity> findByUsuariEmbeddedCodiAndEmpresaIdentificadorCompanyiaIdOrderByEmpresaEmbeddedNom(String usuariCodi, Long companyiaId);

}
