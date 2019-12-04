/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieVenda;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.facturacio.logic.api.service.SerieVendaService;
import es.limit.cecocloud.facturacio.persist.entity.SerieVendaEntity;

/**
 * Implementació del servei de gestió de series venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SerieVendaServiceImpl extends AbstractGenericCompositePkServiceImpl<SerieVenda, SerieVendaEntity, SerieVendaPk> implements SerieVendaService {

	@Override
	protected SerieVendaPk getPkFromDto(SerieVenda dto) {
		return new SerieVendaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getEmpresa().getId());
	}


}
