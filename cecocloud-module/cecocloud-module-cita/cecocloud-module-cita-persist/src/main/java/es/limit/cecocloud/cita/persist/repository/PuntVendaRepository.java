/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.persist.entity.PuntVendaEntity;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("citaPuntVendaRepository")
public interface PuntVendaRepository extends BaseRepository<PuntVendaEntity, PuntVendaPk> {

	@Query("from citaPuntVendaEntity pve")
	List<PuntVendaEntity> findByEmbeddedCitaActivaTrue();

	@Query(
			"select distinct emp " +
			"from citaPuntVendaEntity pve join pve.empresa emp " +
			//"where pve.citaActiva = true "
			"order by emp.embedded.nomComercial")
	List<EmpresaEntity> findEmpresesByEmbeddedCitaActivaTrue();

}