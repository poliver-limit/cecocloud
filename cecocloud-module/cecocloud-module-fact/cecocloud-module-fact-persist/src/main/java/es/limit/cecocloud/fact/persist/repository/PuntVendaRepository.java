/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;

/**
 * Repositori per a gestionar les entitats de tipus punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PuntVendaRepository extends BaseRepository<PuntVendaEntity, PuntVendaPk> {

	@Query("from PuntVendaEntity pve")
	List<PuntVendaEntity> findByEmbeddedCitaActivaTrue();

	@Query(
			"select distinct emp " +
			"from PuntVendaEntity pve join pve.empresa emp " +
			//"where pve.citaActiva = true "
			"order by emp.embedded.nomComercial")
	List<EmpresaEntity> findEmpresesByEmbeddedCitaActivaTrue();

}