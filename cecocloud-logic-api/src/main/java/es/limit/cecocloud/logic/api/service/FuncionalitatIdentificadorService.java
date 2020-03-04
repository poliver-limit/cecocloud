/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificador;
import es.limit.cecocloud.logic.api.module.Modul;

/**
 * Servei encarregat de gestionar relacions funcionalitat-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatIdentificadorService extends GenericService<FuncionalitatIdentificador, Long> {

	/**
	 * Retorna una llista amb les funcionalitats relacionades amb un identificador.
	 * 
	 * @param identificadorId
	 *            l'id de l'identificador.
	 * @param modul
	 *            el mòdul per a filtrar.
	 * @return la llista de funcionalitats.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'identificador amb l'id especificat.
	 */
	public List<Funcionalitat> funcionalitatFindByIdentificadorIdAndModul(
			Long identificadorId,
			Modul modul) throws EntityNotFoundException;

}
