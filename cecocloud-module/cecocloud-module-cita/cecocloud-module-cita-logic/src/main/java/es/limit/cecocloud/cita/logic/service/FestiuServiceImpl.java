/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.cita.logic.api.dto.Festiu;
import es.limit.cecocloud.cita.logic.api.dto.Festiu.FestiuPk;
import es.limit.cecocloud.cita.logic.api.service.FestiuService;
import es.limit.cecocloud.cita.persist.entity.FestiuEntity;

/**
 * Implementació del servei de gestió de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FestiuServiceImpl extends AbstractGenericCompositePkServiceImpl<Festiu, FestiuEntity, FestiuPk> implements FestiuService {

	@Override
	protected FestiuPk getPkFromDto(Festiu dto) {
		return new FestiuPk(
				dto.getIdentificador().getId(),
				dto.getFestiuGrup().getId(),
				0);
	}

}
