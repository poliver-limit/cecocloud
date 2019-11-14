/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.CompanyiaSelectionTreeItem;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CompanyiaToCompanyiaSelectionTreeItemConverter extends AbstractEntityToDtoConverter<CompanyiaEntity, CompanyiaSelectionTreeItem> {

}