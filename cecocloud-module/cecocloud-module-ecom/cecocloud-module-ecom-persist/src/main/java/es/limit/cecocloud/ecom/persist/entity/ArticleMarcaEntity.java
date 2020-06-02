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

import es.limit.cecocloud.ecom.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleMarcaEntity.ArticleMarcaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.ArticleMarcaRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article marca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleMarcaEntity")
@Table(
		name = "tcom_mca",
		indexes = {
				@Index(name = "icom_mca_idf_fk", columnList = "mca_idf_cod"),
				@Index(name = "ircom_mca_pk", columnList = "mca_idf_cod,mca_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mca_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "mca_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mca_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "mca_des", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "mca_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mca_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mca_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mca_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "mca_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mca_idf_fk"))
})
@EntityListeners({ArticleMarcaEntityListener.class})
public class ArticleMarcaEntity extends AbstractWithIdentificadorAuditableEntity<ArticleMarca, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ArticleMarca embedded;

	@Builder
	public ArticleMarcaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ArticleMarca embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleMarca embedded) {
		this.embedded = embedded;
	}
	
	public static class ArticleMarcaEntityListener {
		@PrePersist
		public void calcular(ArticleMarcaEntity articleMarca) {
			String codi = articleMarca.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						articleMarca.getId().getIdentificadorCodi(),
						"TCOM_MCA",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(articleMarca.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(ArticleMarcaRepository.class));
				String seqST = addZeros(seq, 6);
				articleMarca.getEmbedded().setCodi(seqST);
				articleMarca.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 6);
					articleMarca.getEmbedded().setCodi(codi);
					articleMarca.getId().setCodi(codi);
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
