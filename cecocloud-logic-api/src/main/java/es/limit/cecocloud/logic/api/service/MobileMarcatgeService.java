/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.MarcatgeMobil;

/**
 * Servei encarregat de gestionar els registres d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MobileMarcatgeService {

	/**
	 * Crea un nou marcatge associat a l'usuari.
	 * 
	 * @param marcatgeMobil
	 *            informació del marcatge.
	 * 
	 * @return el marcatge creat.
	 */
	public MarcatgeMobil marcatgeCreate(MarcatgeMobil marcatgeMobil);

	/**
	 * Retorna la llista d'empreses disponibles per a que l'usuari
	 * faci marcatges.
	 * 
	 * @return la llista d'empreses.
	 */
	public List<Empresa> empresaFindAll();

}
