/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Servei per a la gestió d'identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificadorService extends GenericService<Identificador, String> {
	public List<Identificador> findIdentificadorByCompanyiaCodi(String companyiaCodi);
}
