/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleEntity;

/**
 * Repositori per a gestionar les entitats de tipus Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleRepository")
public interface ArticleRepository extends BaseRepository<ArticleEntity, WithIdentificadorAndCodiPk<String>> {
	
	@Query(	"from" +
			"    es.limit.cecocloud.ecom.persist.entity.ArticleEntity art " +
			"where " +
			"    (art.identificador.id = :identificadorCodi)" +
			"    and (art.embedded.bloquejat = false) "
			)
	List<ArticleEntity> findByIdentificador(
			@Param("identificadorCodi") String identificadorCodi
		);
}