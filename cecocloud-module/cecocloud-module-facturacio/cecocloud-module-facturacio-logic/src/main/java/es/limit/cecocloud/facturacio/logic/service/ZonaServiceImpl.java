/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona.ZonaPk;
import es.limit.cecocloud.facturacio.logic.api.service.ZonaService;
import es.limit.cecocloud.facturacio.persist.entity.ZonaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ZonaServiceImpl extends AbstractGenericCompositePkServiceImpl<Zona, ZonaEntity, ZonaPk> implements ZonaService {

	@Autowired
	IdentificadorRepository identificadorRepository;
	@Override
	protected ZonaPk getPkFromDto(Zona dto) {
		IdentificadorEntity idf = identificadorRepository.getOne(dto.getIdentificador().getId());
		return new ZonaPk(
				idf.getEmbedded().getCodi(),
				dto.getCodi());
	}


}
