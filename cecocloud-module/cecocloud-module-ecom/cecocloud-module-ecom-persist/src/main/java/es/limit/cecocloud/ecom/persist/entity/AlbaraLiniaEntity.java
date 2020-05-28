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

import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia;
import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia.AlbaraLiniaPk;
import es.limit.cecocloud.ecom.persist.entity.AlbaraLiniaEntity.AlbaraLiniaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un AlbaraLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomAlbaraLiniaEntity")
@Table(
		name = "tcom_lac",
		indexes = {				
				@Index(name = "rcom_lac_pk", columnList = "lac_idf_cod,lac_emp_cod,lac_alb_numdoc,lac_num", unique = true),
				@Index(name = "icom_lac_emp_fk", columnList = "lac_idf_cod, lac_emp_cod"),
				@Index(name = "icom_lac_alb_fk", columnList = "lac_idf_cod, lac_emp_cod, lac_alb_numdoc")
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "lac_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "lac_emp_cod", length = 4)),
	@AttributeOverride(name = "id.albaraNumeroDocument", column = @Column(name = "lac_alb_numdoc", length = 22, precision = 10)),
	@AttributeOverride(name = "id.numero", column = @Column(name = "lac_num",length = 22, precision = 10)),
	
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "lac_num", length = 22, precision = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "lac_des", length = 2000, nullable = false)),
	@AttributeOverride(name = "embedded.factorConversioSortides", column = @Column(name = "lac_fcs", length = 22, precision = 15, nullable = false)),	
	@AttributeOverride(name = "embedded.unitats", column = @Column(name = "lac_uni", length = 22, precision = 15, nullable = false)),
	@AttributeOverride(name = "embedded.preu", column = @Column(name = "lac_pru", length = 22, precision = 17, nullable = false)),	
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "lac_imp", length = 22, precision = 15, nullable = false)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "lac_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "lac_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "lac_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "lac_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "lac_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
@EntityListeners({AlbaraLiniaEntityListener.class})
public class AlbaraLiniaEntity extends AbstractWithIdentificadorAuditableEntity<AlbaraLinia, AlbaraLiniaPk> {

	@Embedded
	protected AlbaraLinia embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "lac_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lac_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_lac_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "lac_idf_cod", referencedColumnName = "alb_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lac_emp_cod", referencedColumnName = "alb_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lac_alb_numdoc", referencedColumnName = "alb_numdoc", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_lac_alb_fk"))
	protected AlbaraEntity albara;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "lac_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lac_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)						
				},
				foreignKey = @ForeignKey(name = "rcom_lac_art_fk"))
	protected ArticleEntity article;
	@Column(name = "lac_art_cod", length = 15, nullable = false)
	private String articleCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "lac_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "lac_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_lac_iva_fk"))
	private IvaEntity iva;
	@Column(name = "lac_iva_cod", length = 4)
	private String ivaCodi;
	
	@Builder
	public AlbaraLiniaEntity(
			AlbaraLiniaPk pk,
			AlbaraLinia embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			AlbaraEntity albara,
			ArticleEntity article,
			IvaEntity iva
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.albara = albara;
		
		this.updateArticle(article);
		this.updateIva(iva);
			
	}

	@Override
	public void update(AlbaraLinia embedded) {
		this.embedded = embedded;
	}	
	
	public void updateArticle(ArticleEntity article) {
		this.article = article;		
		if (article!=null) this.articleCodi = article.getEmbedded().getCodi();
	}
	
	public void updateIva(IvaEntity iva) {
		this.iva = iva;		
		if (iva!=null) this.ivaCodi = iva.getEmbedded().getCodi();
	}
	
	public static class AlbaraLiniaEntityListener {
		@PrePersist
		public void calcular(AlbaraLiniaEntity albaraLinia) {
			int numeroAlbara = albaraLinia.getAlbara().getEmbedded().getNumero();
			int num = EntityListenerUtil.getSeguentNumComptador(
					albaraLinia.getIdentificador().getId(),
					"TCOM_LAC_"+numeroAlbara);
			albaraLinia.getEmbedded().setNumero(num);
			albaraLinia.getId().setNumero(num);
		}
	}

}
