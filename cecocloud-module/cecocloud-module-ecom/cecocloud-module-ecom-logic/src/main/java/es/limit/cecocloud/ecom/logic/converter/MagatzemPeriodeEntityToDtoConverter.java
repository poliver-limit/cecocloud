/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.ecom.persist.entity.MagatzemPeriodeEntity;

/**
 * Conversor cap a DTO de les entitats de tipus MagatzemPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomMagatzemPeriodeEntityToDtoConverter")
public class MagatzemPeriodeEntityToDtoConverter extends AbstractEntityToDtoConverter<MagatzemPeriodeEntity, MagatzemPeriode> {

}