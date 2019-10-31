/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.cecocloud.logic.api.dto.UsuariCompanyia;

/**
 * Servei per a la gestió de usuari-companyia
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariCompanyiaService extends GenericService<UsuariCompanyia, Long> {
		public List<UsuariCompanyia>findUsuariCompanyiaByUsuariCodi(String usuariCodi);
		public List<UsuariCompanyia>findUsuariCompanyiaByCompanyiaCodi(String companyiaCodi);
		public UsuariCompanyia findUsuariCompanyiaByUsuariCodiAndCompanyiaCodi(String usuariCodi, String companyiaCodi);
}
