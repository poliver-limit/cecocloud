/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamiliaEmpresa;
import es.limit.cecocloud.ecom.persist.entity.ArticleFamiliaEmpresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ArticleFamiliaEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomArticleFamiliaEmpresaEntityToDtoConverter")
public class ArticleFamiliaEmpresaEntityToDtoConverter extends AbstractEntityToDtoConverter<ArticleFamiliaEmpresaEntity, ArticleFamiliaEmpresa> {

}