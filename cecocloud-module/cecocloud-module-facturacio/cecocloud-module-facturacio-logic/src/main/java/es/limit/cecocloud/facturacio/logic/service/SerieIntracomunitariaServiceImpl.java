/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieIntracomunitaria;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import es.limit.cecocloud.facturacio.logic.api.service.SerieIntracomunitariaService;
import es.limit.cecocloud.facturacio.persist.entity.SerieIntracomunitariaEntity;

/**
 * Implementació del servei de gestió de series intracomunitaries.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SerieIntracomunitariaServiceImpl extends AbstractGenericCompositePkServiceImpl<SerieIntracomunitaria, SerieIntracomunitariaEntity, SerieIntracomunitariaPk> implements SerieIntracomunitariaService {

	@Override
	protected SerieIntracomunitariaPk getPkFromDto(SerieIntracomunitaria dto) {
		return new SerieIntracomunitariaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getEmpresa().getId());
	}


}
