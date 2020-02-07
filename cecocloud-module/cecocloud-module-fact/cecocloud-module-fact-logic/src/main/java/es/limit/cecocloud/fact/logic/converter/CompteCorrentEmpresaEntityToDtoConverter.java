/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa;
import es.limit.cecocloud.fact.persist.entity.CompteCorrentEmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus CompteCorrentEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CompteCorrentEmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<CompteCorrentEmpresaEntity, CompteCorrentEmpresa> {

}