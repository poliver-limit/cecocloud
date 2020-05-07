/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import es.limit.cecocloud.cita.logic.api.dto.MobileAppCita;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppEmpresa;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppFestiu;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHoraDisponible;
import es.limit.cecocloud.cita.logic.api.dto.MobileAppHorari;
import es.limit.cecocloud.cita.logic.api.exception.NotAvailableException;

/**
 * Servei encarregat de gestionar les peticions de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MobileAppService {

	/**
	 * Obté la llista d'empreses amb les cites activades.
	 * 
	 * @return la llista d'empreses.
	 */
	public List<MobileAppEmpresa> empresaFind();

	/**
	 * Obté la llista de festius d'un punt de venda per un any determinat.
	 * 
	 * @param identificadorCodi
	 *            el codi de l'identificador.
	 * @param empresaCodi
	 *            el codi de l'empresa.
	 * @param puntVendaCodi
	 *            el codi del punt de venda.
	 * @param any
	 *            l'any del qual es volen obtenir els festius.
	 * @return la llista de festius.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat el punt de venda especificat.
	 */
	public List<MobileAppFestiu> puntVendaFestiuFind(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			int any) throws EntityNotFoundException;

	/**
	 * Obté la llista d'intervals horaris d'un punt de venda per a un dia
	 * determinat.
	 * 
	 * @param identificadorCodi
	 *            el codi de l'identificador.
	 * @param empresaCodi
	 *            el codi de l'empresa.
	 * @param puntVendaCodi
	 *            el codi del punt de venda.
	 * @param data
	 *            la data.
	 * @return l'horari del punt de venda.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat el punt de venda especificat.
	 */
	public List<MobileAppHorari> puntVendaHorariFind(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			LocalDate data) throws EntityNotFoundException;

	/**
	 * Obté la llista d'hores disponibles per a cites per un dia determinat.
	 * 
	 * @param identificadorCodi
	 *            el codi de l'identificador.
	 * @param empresaCodi
	 *            el codi de l'empresa.
	 * @param puntVendaCodi
	 *            el codi del punt de venda.
	 * @param data
	 *            la data.
	 * @return la llista d'hores disponibles per a les cites.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat el punt de venda especificat.
	 */
	public List<MobileAppHoraDisponible> puntVendaDisponibilitat(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			LocalDate data) throws EntityNotFoundException;

	/**
	 * Crea una cita per l'usuari.
	 *
	 * @param identificadorCodi
	 *            el codi de l'identificador.
	 * @param empresaCodi
	 *            el codi de l'empresa.
	 * @param puntVendaCodi
	 *            el codi del punt de venda.
	 * @param cita
	 *            la informació per a crear la cita.
	 * @return la informació de la cita creada.
	 * @throws NotAvailableException
	 *            si l'hora de la cita no està disponible.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat el punt de venda especificat.
	 */
	public MobileAppCita create(
			String identificadorCodi,
			String empresaCodi,
			String puntVendaCodi,
			MobileAppCita cita) throws NotAvailableException, EntityNotFoundException;

}
