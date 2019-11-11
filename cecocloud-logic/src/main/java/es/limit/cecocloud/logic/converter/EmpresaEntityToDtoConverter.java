/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

/**
 * Conversor cap a DTO de les entitats de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class EmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<EmpresaEntity, Empresa> {

	@Override
	public Empresa convert(EmpresaEntity source, Type<? extends Empresa> destinationType,
			MappingContext mappingContext) {
		Empresa empresa = super.convert(source, destinationType, mappingContext);
		empresa.setCompanyiaId(source.getIdentificador().getCompanyia().getId());
		return empresa;
	}

	
}