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

import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleFamiliaEntity.ArticleFamiliaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.ArticleFamiliaRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article familia
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleFamiliaEntity")
@Table(
		name = "tcom_far",
		indexes = {
				@Index(name = "icom_far_idf_fk", columnList = "far_idf_cod"),
				@Index(name = "ircom_far_pk", columnList = "far_idf_cod,far_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "far_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "far_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "far_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "far_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.artExportables", column = @Column(name = "far_pda", length = 1)),

	@AttributeOverride(name = "createdBy", column = @Column(name = "far_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "far_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "far_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "far_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "far_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_far_idf_fk"))
})
@EntityListeners({ArticleFamiliaEntityListener.class})
public class ArticleFamiliaEntity extends AbstractWithIdentificadorAuditableEntity<ArticleFamilia, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ArticleFamilia embedded;

	@Builder
	public ArticleFamiliaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ArticleFamilia embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
	}

	@Override
	public void update(ArticleFamilia embedded) {
		this.embedded = embedded;
	}
	
	public static class ArticleFamiliaEntityListener {
		@PrePersist
		public void calcular(ArticleFamiliaEntity articleFamilia) {
			String codi = articleFamilia.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						articleFamilia.getId().getIdentificadorCodi(),
						"TCOM_FAR",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(articleFamilia.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(ArticleFamiliaRepository.class));
				String seqST = addZeros(seq, 6);
				articleFamilia.getEmbedded().setCodi(seqST);
				articleFamilia.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 6);
					articleFamilia.getEmbedded().setCodi(codi);
					articleFamilia.getId().setCodi(codi);
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
