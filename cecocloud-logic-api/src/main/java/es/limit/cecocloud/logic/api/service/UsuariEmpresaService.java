/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericCompositePkService;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresaPerfilTreeItem;

/**
 * Servei per a la gestió de usuari-empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariEmpresaService extends GenericCompositePkService<UsuariEmpresa> {

	public List<UsuariEmpresaPerfilTreeItem> buildPerfilTree();

}
