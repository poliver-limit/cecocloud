/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio.ArticleInformacioPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleInformacioEntity.ArticleInformacioEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Article Informacio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleInformacioEntity")
@Table(
		name = "tcom_ain",
		indexes = {
				@Index(name = "rcom_ain_pk", columnList = "ain_idf_cod,ain_art_cod,ain_num", unique = true),
				@Index(name = "icom_ain_art_fk", columnList = "ain_idf_cod, ain_art_cod, ain_num")				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ain_idf_cod", length = 4)),
	@AttributeOverride(name = "id.articleCodi", column = @Column(name = "ain_art_cod", length = 15)),
	@AttributeOverride(name = "id.referenciaSequencial", column = @Column(name = "ain_num", precision = 10)),
	@AttributeOverride(name = "embedded.referenciaSequencial", column = @Column(name = "ain_num", precision = 10, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ain_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.web", column = @Column(name = "ain_web")),	
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "ain_tip", length = 1)),
	@AttributeOverride(name = "embedded.rutaInforme", column = @Column(name = "ain_fitnom", length = 250)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "ain_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ain_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ain_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ain_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ain_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
@EntityListeners({ArticleInformacioEntityListener.class})
public class ArticleInformacioEntity extends AbstractWithIdentificadorAuditableEntity<ArticleInformacio, ArticleInformacioPk> {

	@Embedded
	protected ArticleInformacio embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ain_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ain_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_ain_art_fk"))
	protected ArticleEntity article;
	
	@Formula(value="(SELECT ain_fitnom FROM tcom_ain ain where ain.ain_idf_cod = ain_idf_cod and ain.ain_art_cod = ain_art_cod and ain.ain_num = ain_num)")
	private String urlImatgeTxt;

	@Builder
	public ArticleInformacioEntity(
			ArticleInformacioPk pk,
			ArticleInformacio embedded,
			IdentificadorEntity identificador,
			ArticleEntity article) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.article = article;
		
	}

	@Override
	public void update(ArticleInformacio embedded) {
		this.embedded = embedded;
	}	

	public static class ArticleInformacioEntityListener {
		@PrePersist
		public void calcular(ArticleInformacioEntity articleInformacio) {
			int num = EntityListenerUtil.getSeguentNumComptador(
					articleInformacio.getIdentificador().getId(),
					"TCOM_AIN");
			articleInformacio.getEmbedded().setReferenciaSequencial(num);
			articleInformacio.getId().setReferenciaSequencial(num);
		}
	}

}
