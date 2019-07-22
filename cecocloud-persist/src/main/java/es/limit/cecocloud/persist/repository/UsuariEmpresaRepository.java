/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEntity;
/**
 * Repository per a gestionar les entitats de tipus relació usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariEmpresaRepository extends BaseRepository<UsuariEmpresaEntity, Long> {

	List<UsuariEmpresaEntity> findByParent1(UsuariEntity usuari);

	List<UsuariEmpresaEntity> findByParent1AndParent2(UsuariEntity usuari, EmpresaEntity empresa);

}
