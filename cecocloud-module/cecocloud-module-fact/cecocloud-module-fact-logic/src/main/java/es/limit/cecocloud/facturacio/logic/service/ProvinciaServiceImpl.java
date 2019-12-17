/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Pais;
import es.limit.cecocloud.facturacio.logic.api.dto.Provincia;
import es.limit.cecocloud.facturacio.logic.api.dto.Provincia.ProvinciaPk;
import es.limit.cecocloud.facturacio.logic.api.service.ProvinciaService;
import es.limit.cecocloud.facturacio.persist.entity.ProvinciaEntity;

/**
 * Implementació del servei de gestió de provincies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProvinciaServiceImpl extends AbstractGenericCompositePkServiceImpl<Provincia, ProvinciaEntity, ProvinciaPk> implements ProvinciaService {

	@Override
	protected ProvinciaPk getPkFromDto(Provincia dto) {
		AmbIdentificadorICodiPk<String> paisPk = getPkFromSerializedId(
				dto.getPais().getId(),
				Pais.class,
				AmbIdentificadorICodiPk.class);
		return new ProvinciaPk(
				dto.getIdentificador().getId(),
				paisPk.getCodi(),				
				dto.getCodi());
	}


}
