/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Servei encarregat de sincronitzar els identificadors i les empreses de
 * Cecocloud a les taules corresponents de dins un mòdul en concret.
 * 
 * @author Limit Tecnologies
 */
public interface EmpresaIdentificadorSyncService {

	/**
	 * Propaga la creació d'un identificador.
	 * 
	 * @param identificador
	 *            informació de l'identificador.
	 */
	public void identificadorCreate(Identificador identificador);

	/**
	 * Propaga la modificació d'un identificador.
	 * 
	 * @param identificador
	 *            informació de l'identificador.
	 */
	public void identificadorUpdate(Identificador identificador);

	/**
	 * Propaga l'eliminació d'un identificador.
	 * 
	 * @param identificador
	 *            informació de l'identificador.
	 */
	public void identificadorDelete(Identificador identificador);

	/**
	 * Propaga la creació d'una empresa de gestió.
	 * 
	 * @param empresa
	 *            informació de l'empresa.
	 */
	public void empresaGestioCreate(Empresa empresa);

	/**
	 * Propaga la modificació d'una empresa de gestió.
	 * 
	 * @param empresa
	 *            informació de l'empresa.
	 */
	public void empresaGestioUpdate(Empresa empresa);

	/**
	 * Propaga l'eliminació d'una empresa de gestió.
	 * 
	 * @param empresa
	 *            informació de l'empresa.
	 */
	public void empresaGestioDelete(Empresa empresa);

	/**
	 * Propaga la creació d'una empresa comptable.
	 * 
	 * @param empresa
	 *            informació de l'empresa.
	 */
	public void empresaComptableCreate(Empresa empresa);

	/**
	 * Propaga la modificació d'una empresa comptable.
	 * 
	 * @param empresa
	 *            informació de l'empresa.
	 */
	public void empresaComptableUpdate(Empresa empresa);

	/**
	 * Propaga l'eliminació d'una empresa comptable.
	 * 
	 * @param empresa
	 *            informació de l'empresa.
	 */
	public void empresaComptableDelete(Empresa empresa);

}
