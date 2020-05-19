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

import es.limit.cecocloud.ecom.logic.api.dto.PressupostLinia;
import es.limit.cecocloud.ecom.logic.api.dto.PressupostLinia.PressupostLiniaPk;
import es.limit.cecocloud.ecom.persist.entity.PressupostLiniaEntity.PressupostLiniaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomPressupostLiniaEntity")
@Table(
		name = "tcom_lpr",
		indexes = {				
				@Index(name = "rcom_lpr_pk", columnList = "lpr_idf_cod,lpr_emp_cod,lpr_pre_cod,lpr_num", unique = true),
				@Index(name = "icom_lpr_emp_fk", columnList = "lpr_idf_cod, lpr_emp_cod"),
				@Index(name = "icom_lpr_pre_fk", columnList = "lpr_idf_cod, lpr_emp_cod, lpr_pre_cod")
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "lpr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "lpr_emp_cod", length = 4)),
	@AttributeOverride(name = "id.pressupostCodi", column = @Column(name = "lpr_pre_cod", length = 22, precision = 10)),
	@AttributeOverride(name = "id.numero", column = @Column(name = "lpr_num",length = 22, precision = 10)),
	
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "lpr_num", length = 22, precision = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.unitats", column = @Column(name = "lpr_uni", length = 22, precision = 15, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "lpr_des", length = 4000, nullable = false)),
	@AttributeOverride(name = "embedded.preu", column = @Column(name = "lpr_pru", length = 22, precision = 17, nullable = false)),
	@AttributeOverride(name = "embedded.factorConversioSortides", column = @Column(name = "lpr_fcs", length = 22, precision = 15, nullable = false)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "lpr_imp", length = 22, precision = 15, nullable = false)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "lpr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "lpr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "lpr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "lpr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "lpr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
@EntityListeners({PressupostLiniaEntityListener.class})
public class PressupostLiniaEntity extends AbstractWithIdentificadorAuditableEntity<PressupostLinia, PressupostLiniaPk> {

	@Embedded
	protected PressupostLinia embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "lpr_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lpr_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_lpr_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "lpr_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lpr_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lpr_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_lpr_pre_fk"))
	protected PressupostEntity pressupost;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "lpr_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lpr_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)						
				},
				foreignKey = @ForeignKey(name = "rcom_lpr_art_fk"))
	protected ArticleEntity article;
	@Column(name = "lpr_art_cod", length = 15, nullable = false)
	private String articleCodi;
	
	@Builder
	public PressupostLiniaEntity(
			PressupostLiniaPk pk,
			PressupostLinia embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			PressupostEntity pressupost,
			ArticleEntity article
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.pressupost = pressupost;
		
		this.updateArticle(article);
			
	}

	@Override
	public void update(PressupostLinia embedded) {
		this.embedded = embedded;
	}	
	
	public void updateArticle(ArticleEntity article) {
		this.article = article;		
		if (article!=null) this.articleCodi = article.getEmbedded().getCodi();
	}
	
	public static class PressupostLiniaEntityListener {
		@PrePersist
		public void calcular(PressupostLiniaEntity pressupostLinia) {
			int numeroPressupost = pressupostLinia.getPressupost().getEmbedded().getNumero();
			int num = EntityListenerUtil.getSeguentNumComptador(
					pressupostLinia.getIdentificador().getId(),
					"TCOM_LPR_"+numeroPressupost);
			pressupostLinia.getEmbedded().setNumero(num);
			pressupostLinia.getId().setCodi(num);
		}
	}

}
