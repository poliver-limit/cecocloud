/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CompanyiaEntityToDtoConverter extends AbstractEntityToDtoConverter<CompanyiaEntity, Companyia> {

}