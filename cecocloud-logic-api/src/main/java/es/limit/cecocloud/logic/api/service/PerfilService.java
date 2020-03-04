/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermis;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPermisModule;
import es.limit.cecocloud.logic.api.dto.Perfil;

/**
 * Servei encarregat de gestionar perfils.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PerfilService extends GenericService<Perfil, Long> {

	/**
	 * Retorna una llista de les funcionalitat-permis ordenats per mòdul.
	 * 
	 * @param id
	 *            l'id del perfil.
	 * @param idsAddicionals
	 *            ids de perfils addicionals a incloure a la consulta.
	 * @return la llista ordenada de les funcionalitat-permis.
	 */
	public List<FuncionalitatPermisModule> funcionalitatPermisFindOrderedByModul(
			Long id,
			Long[] idsAddicionals);

	/**
	 * Guarda els permisos per a una funcionalitat.
	 * 
	 * @param id
	 *            l'id del perfil.
	 * @param modul
	 *            el codi del mòdul.
	 * @param funcionalitatPermis
	 *            la informació a guardar.
	 * @throws ClassNotFoundException
	 *            si no es troba la classe d'alguna de les funcionalitats.
	 */
	public void funcionalitatPermisSave(
			Long id,
			String modul,
			FuncionalitatPermis funcionalitatPermis) throws ClassNotFoundException;

	/**
	 * Refresca els permisos d'un perfil.
	 * 
	 * @param id
	 *            l'id del perfil.
	 * @throws ClassNotFoundException
	 *            si no es troba la classe d'alguna de les funcionalitats.
	 */
	public void funcionalitatPermisRefresh(
			Long id) throws ClassNotFoundException;

}
