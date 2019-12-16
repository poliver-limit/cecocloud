/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.facturacio.persist.entity.TipusVencimentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusVenciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusVencimentEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusVencimentEntity, TipusVenciment> {

}