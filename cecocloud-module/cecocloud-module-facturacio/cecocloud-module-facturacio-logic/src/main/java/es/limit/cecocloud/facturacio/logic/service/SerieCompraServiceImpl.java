/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieCompra;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieCompra.SerieCompraPk;
import es.limit.cecocloud.facturacio.logic.api.service.SerieCompraService;
import es.limit.cecocloud.facturacio.persist.entity.SerieCompraEntity;

/**
 * Implementació del servei de gestió de series compra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SerieCompraServiceImpl extends AbstractGenericCompositePkServiceImpl<SerieCompra, SerieCompraEntity, SerieCompraPk> implements SerieCompraService {

	@Override
	protected SerieCompraPk getPkFromDto(SerieCompra dto) {
		return new SerieCompraPk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getEmpresa().getId());
	}


}
