package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.facturacio.persist.entity.TipusAdresaEntity;

/**
 * Conversor cap a DTO de les entitats de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusAdresaEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusAdresaEntity, TipusAdresa> {

}
