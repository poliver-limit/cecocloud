/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto;

import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.Article;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO amb informació d'un Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource()
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class ArticleEcom extends Article {

}
