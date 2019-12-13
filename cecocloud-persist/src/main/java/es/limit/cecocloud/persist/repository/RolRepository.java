/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.RolEntity;

/**
 * Repository per a gestionar les entitats de tipus rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface RolRepository extends BaseRepository<RolEntity, Long> {

	/*@Query(	"select r "
			+ "from "
			+ " RolEntity r "
			+ "where r.id in ( "
			+ "		select rue.rol.id "
			+ "		from 	RolUsuariEmpresaEntity rue, "
			+ " 			UsuariEmpresaEntity uem "
			+ " 	where 	rue.usuariEmpresa.id = uem.id "
			+ "		  and 	uem.usuari.embedded.codi = :usuariCodi "
			+ "		  and 	uem.empresa.embedded.codi = :empresaCodi "
			+ ") or r.id in ( "
			+ "		select 	pr.rol.id "
			+ "		from 	PerfilEntity p, "
			+ "				PerfilRolEntity pr, "
			+ "				PerfilUsuariEmpresaEntity pue, "
			+ "				UsuariEmpresaEntity uem "
			+ "		where	pr.perfil.id = p.id "
			+ "    	  and 	pue.perfil.id = p.id "
			+ "    	  and 	pue.usuariEmpresa.id = uem.id "
			+ "	      and 	uem.usuari.embedded.codi = :usuariCodi "
			+ "       and 	uem.empresa.embedded.codi = :empresaCodi "
			+ ") ")
	List<RolEntity> findByUsuariCodiEmpresaCodi(
			@Param("usuariCodi") String usuariCodi,
			@Param("empresaCodi") String empresaCodi);*/

	@Query(	"select r "
			+ "from "
			+ " RolEntity r "
			/*+ "where r.id in ( "
			+ "		select rue.rol.id "
			+ "		from 	RolUsuariIdentificadorEmpresaEntity ruie, "
			+ " 			UsuariEmpresaEntity uem "
			+ " 	where 	ruie.usuariEmpresa.id = uem.id "
			+ "		  and 	uem.usuari.embedded.codi = :usuariCodi "
			+ "		  and 	uem.empresa.id = :empresaId "
			+ ") or r.id in ( "
			+ "		select 	pr.rol.id "
			+ "		from 	PerfilEntity p, "
			+ "				PerfilRolEntity pr, "
			+ "				PerfilUsuariEmpresaEntity pue, "
			+ "				UsuariEmpresaEntity uem "
			+ "		where	pr.perfil.id = p.id "
			+ "    	  and 	pue.perfil.id = p.id "
			+ "    	  and 	pue.usuariEmpresa.id = uem.id "
			+ "	      and 	uem.usuari.embedded.codi = :usuariCodi "
			+ "       and 	uem.empresa.id = :empresaId "
			+ ") "*/)
	List<RolEntity> findByUsuariCodiEmpresa(
			@Param("usuariCodi") String usuariCodi,
			@Param("empresaId") Long empresaId);

}
