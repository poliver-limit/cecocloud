/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericCompositePkService;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresaPerfilTreeItem;

/**
 * Servei encarregat de gestionar les relacions (usuari-identificador)-empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariIdentificadorEmpresaService extends GenericCompositePkService<UsuariIdentificadorEmpresa> {

	public List<UsuariIdentificadorEmpresaPerfilTreeItem> buildPerfilTree();

}
