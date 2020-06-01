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

import es.limit.cecocloud.ecom.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleGammaEntity.ArticleGammaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.ArticleGammaRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article gamma
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleGammaEntity")
@Table(
		name = "tcom_gma",
		indexes = {
				@Index(name = "icom_gma_idf_fk", columnList = "gma_idf_cod"),
				@Index(name = "ircom_gma_pk", columnList = "gma_idf_cod,gma_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "gma_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "gma_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "gma_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "gma_des", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "gma_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "gma_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "gma_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "gma_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "gma_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_gma_idf_fk"))
})
@EntityListeners({ArticleGammaEntityListener.class})
public class ArticleGammaEntity extends AbstractWithIdentificadorAuditableEntity<ArticleGamma, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ArticleGamma embedded;

	@Builder
	public ArticleGammaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ArticleGamma embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleGamma embedded) {
		this.embedded = embedded;
	}
	
	public static class ArticleGammaEntityListener {
		@PrePersist
		public void calcular(ArticleGammaEntity articleGamma) {
			String codi = articleGamma.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						articleGamma.getId().getIdentificadorCodi(),
						"TCOM_GMA",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(articleGamma.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(ArticleGammaRepository.class));
				String seqST = addZeros(seq, 6);
				articleGamma.getEmbedded().setCodi(seqST);
				articleGamma.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 6);
					articleGamma.getEmbedded().setCodi(codi);
					articleGamma.getId().setCodi(codi);
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
