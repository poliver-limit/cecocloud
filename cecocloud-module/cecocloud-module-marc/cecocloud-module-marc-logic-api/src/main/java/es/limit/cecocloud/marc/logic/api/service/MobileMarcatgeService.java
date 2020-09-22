/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.service;

import java.util.List;

import es.limit.cecocloud.marc.logic.api.dto.AcumulatInfo;
import es.limit.cecocloud.marc.logic.api.dto.AcumulatMobilConsulta;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeMobil;
import es.limit.cecocloud.marc.logic.api.dto.MarcatgeMobilConsulta;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioEmpresa;

/**
 * Servei encarregat de gestionar els registres d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MobileMarcatgeService {

	/**
	 * Crea un nou marcatge associat a l'usuari.
	 * 
	 * @param marcatge
	 *            informació del marcatge.
	 * @return el marcatge creat.
	 */
	public MarcatgeMobil create(MarcatgeMobil marcatge);

	/**
	 * Consulta els marcatges en una data concreta.
	 * 
	 * @param consulta
	 *            paràmetres de la consulta.
	 * @return la llista de marcatges.
	 */
	public List<MarcatgeMobil> find(MarcatgeMobilConsulta consulta);

	/**
	 * Retorna la llista d'empreses disponibles per a que l'usuari
	 * faci marcatges.
	 * 
	 * @return la llista d'empreses.
	 */
	public List<SincronitzacioEmpresa> empresesFindDisponiblesPerUsuariActual();

	/**
	 * Consulta els temps acumulats en una data concreta.
	 * 
	 * @param consulta
	 *            paràmetres de la consulta.
	 * @return la informació dels acumulats.
	 */
	public AcumulatInfo acumulatFind(AcumulatMobilConsulta consulta);

}
