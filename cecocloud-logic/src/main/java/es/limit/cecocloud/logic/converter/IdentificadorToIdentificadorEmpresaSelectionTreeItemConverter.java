/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Conversor de les entitats de tipus identificador a DTO IdentificadorEmpresaSelectionTree.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class IdentificadorToIdentificadorEmpresaSelectionTreeItemConverter extends AbstractEntityToDtoConverter<IdentificadorEntity, IdentificadorEmpresaSelectionTreeItem> {

}