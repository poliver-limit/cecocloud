/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.service.GenericCompositePkService;
import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;

/**
 * Servei per a la gestió d'intervals horaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface HorariIntervalService extends GenericCompositePkService<HorariInterval> {

	/**
	 * Retorna una llista dels intervals que pertanyen a un mateix horari.
	 * 
	 * @param horariRef
	 *            la referència a l'horari.
	 * @return la llista d'intervals.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 */
	List<HorariInterval> findByHorari(
			GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horariRef) throws EntityNotFoundException;

}
