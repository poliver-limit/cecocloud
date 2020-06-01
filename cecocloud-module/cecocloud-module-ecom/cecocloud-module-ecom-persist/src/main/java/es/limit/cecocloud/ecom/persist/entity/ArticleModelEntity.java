/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import java.util.regex.Pattern;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleModel;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleModelEntity.ArticleModelEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.ArticleModelRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article model
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleModelEntity")
@Table(
		name = "tcom_mod",
		indexes = {
				@Index(name = "icom_mod_idf_fk", columnList = "mod_idf_cod"),
				@Index(name = "ircom_mod_pk", columnList = "mod_idf_cod,mod_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mod_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "mod_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mod_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "mod_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.control", column = @Column(name = "mod_nounitra", length = 1)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "mod_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mod_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mod_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mod_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "mod_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mod_idf_fk"))
})
@EntityListeners({ArticleModelEntityListener.class})
public class ArticleModelEntity extends AbstractWithIdentificadorAuditableEntity<ArticleModel, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ArticleModel embedded;

	@Builder
	public ArticleModelEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ArticleModel embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleModel embedded) {
		this.embedded = embedded;
	}
	
	public static class ArticleModelEntityListener {
		@PrePersist
		public void calcular(ArticleModelEntity articleModel) {
			String codi = articleModel.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						articleModel.getId().getIdentificadorCodi(),
						"TCOM_MOD",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(articleModel.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(ArticleModelRepository.class));
				String seqST = addZeros(seq, 6);
				articleModel.getEmbedded().setCodi(seqST);
				articleModel.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 6);
					articleModel.getEmbedded().setCodi(codi);
					articleModel.getId().setCodi(codi);
				}
			}
		}
	}
	
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	 
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	public static String addZeros(int codi, int tamanyCodi) {
		String codiSt = String.format("%06d",codi).toString();
		return codiSt;
	}

}
