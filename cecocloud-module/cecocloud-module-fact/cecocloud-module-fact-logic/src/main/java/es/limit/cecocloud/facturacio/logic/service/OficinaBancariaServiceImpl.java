package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.OficinaBancaria;
import es.limit.cecocloud.facturacio.logic.api.dto.OficinaBancaria.OficinaBancariaPk;
import es.limit.cecocloud.facturacio.logic.api.service.OficinaBancariaService;
import es.limit.cecocloud.facturacio.persist.entity.OficinaBancariaEntity;

/**
 * Implementació del servei de gestió de OficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OficinaBancariaServiceImpl extends AbstractGenericCompositePkServiceImpl<OficinaBancaria, OficinaBancariaEntity, OficinaBancariaPk> implements OficinaBancariaService{

	@Override
	protected OficinaBancariaPk getPkFromDto(OficinaBancaria dto) {
		return new OficinaBancariaPk(
				dto.getIdentificador().getId(),				
				dto.getBanc().getPk().getCodi(),
				dto.getCodi());
	}
}
