/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.CompteComptableEmpresa;
import es.limit.cecocloud.fact.persist.entity.CompteComptableEmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus CompteComptableEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CompteComptableEmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<CompteComptableEmpresaEntity, CompteComptableEmpresa> {

}