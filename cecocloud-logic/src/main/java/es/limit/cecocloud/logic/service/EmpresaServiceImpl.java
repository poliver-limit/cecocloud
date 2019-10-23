/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceWithPermissionsImpl;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.service.EmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Implementació del servei encarregat de gestionar empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class EmpresaServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Empresa, EmpresaEntity, Long> implements EmpresaService {

//	@Override
//	public List<Empresa> getAllowedEmpreses() {
//		
//		List<Empresa> empreses = toDto(getRepository().findAll());
//		List<Empresa> empresesPermeses = new ArrayList<Empresa>(); 
//		for (Empresa empresa: empreses) {
//			if (hasPermission(empresa.getId(), ExtendedPermission.ADMINISTRATION)) {
//				empresesPermeses.add(empresa);
//			}
//		}
//		
//		return empresesPermeses;
//	}

}
