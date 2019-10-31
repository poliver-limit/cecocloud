/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;

/**
 * Servei per a la gestió de usuari-empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariEmpresaService extends GenericService<UsuariEmpresa, Long> {
	public List<UsuariEmpresa> findByUsuariCodi(
			String usuariCodi,
			String identificadorCodi);
	
	public UsuariEmpresa findByUsuariCodiAndEmpresa(
			String usuariCodi, 
			Long empresaCodi);
	
	public List<String> findMenusPermesos(String modulActiu); //String usuariCodi, EmpresaPk parentPk);
}
