/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificador;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

/**
 * Conversor cap a DTO de les entitats de tipus perfilUsuariIdentificadorEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FuncionalitatIdentificadorEntityToDtoConverter extends AbstractEntityToDtoConverter<FuncionalitatIdentificadorEntity, FuncionalitatIdentificador> {

	@Override
	public FuncionalitatIdentificador convert(FuncionalitatIdentificadorEntity source,
			Type<? extends FuncionalitatIdentificador> destinationType, MappingContext mappingContext) {
		FuncionalitatIdentificador funcionalitatIdentificador = super.convert(source, destinationType, mappingContext);
		if (source != null && source.getFuncionalitat() != null)
			funcionalitatIdentificador.setModul(source.getFuncionalitat().getEmbedded().getModul());
		return funcionalitatIdentificador;
	}

}