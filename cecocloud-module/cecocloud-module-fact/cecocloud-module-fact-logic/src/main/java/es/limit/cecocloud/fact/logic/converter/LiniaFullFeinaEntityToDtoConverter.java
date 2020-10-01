/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina;
import es.limit.cecocloud.fact.persist.entity.LiniaFullFeinaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus LiniaFullFeina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factLiniaFullFeinaEntityToDtoConverter")
public class LiniaFullFeinaEntityToDtoConverter extends AbstractEntityToDtoConverter<LiniaFullFeinaEntity, LiniaFullFeina> {

}