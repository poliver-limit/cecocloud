/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.ecom.logic.api.service.ProvinciaService;
import es.limit.cecocloud.ecom.persist.entity.ProvinciaEntity;


/**
 * Implementació del servei de gestió de articles traduccio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomProvinciaService")
public class ProvinciaServiceImpl extends AbstractGenericCompositePkServiceImpl<Provincia, ProvinciaEntity, ProvinciaPk> implements ProvinciaService {
	
	@Override
	protected ProvinciaPk getPkFromDto(Provincia dto) {	
		return new ProvinciaPk(
				dto.getIdentificador().getId(),				
				dto.getPais().getPk().getCodi(),
				dto.getCodi());
	}

}
