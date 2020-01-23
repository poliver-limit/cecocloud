package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.ClasseRetencio;
import es.limit.cecocloud.facturacio.persist.entity.ClasseRetencioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus de ClasseRetencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ClasseRetencioEntityToDtoConverter extends AbstractEntityToDtoConverter<ClasseRetencioEntity, ClasseRetencio> {

}
