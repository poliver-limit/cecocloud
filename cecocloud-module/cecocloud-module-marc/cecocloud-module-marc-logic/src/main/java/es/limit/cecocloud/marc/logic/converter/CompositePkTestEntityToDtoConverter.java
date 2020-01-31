/**
 * 
 */
package es.limit.cecocloud.marc.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.marc.logic.api.dto.CompositePkTest;
import es.limit.cecocloud.marc.persist.entity.CompositePkTestEntity;

/**
 * Conversor cap a DTO de les entitats de tipus cpktest.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CompositePkTestEntityToDtoConverter extends AbstractEntityToDtoConverter<CompositePkTestEntity, CompositePkTest> {

}