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

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.ecom.logic.api.dto.RegimIva;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.RegimIvaEntity.RegimIvaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.RegimIvaRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un regim d'iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomRegimIvaEntity")
@Table(
		name = "tcom_rgi",
		indexes = {
				@Index(name = "icom_rgi_idf_fk", columnList = "rgi_idf_cod"),
				@Index(name = "ircom_rgi_pk", columnList = "rgi_idf_cod,rgi_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "rgi_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "rgi_cod", length = 2)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "rgi_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "rgi_des", nullable = false, length = 30)),
	@AttributeOverride(name = "embedded.codiComptabilitat", column = @Column(name = "rgi_codcmp", length = 30)),
	@AttributeOverride(name = "embedded.tip", column = @Column(name = "rgi_tip", nullable = false, length = 1)),
	@AttributeOverride(name = "embedded.codiFacturaElectronica", column = @Column(name = "rgi_codele", length = 2)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "rgi_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "rgi_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "rgi_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "rgi_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "rgi_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_rgi_idf_fk"))
})
@EntityListeners({RegimIvaEntityListener.class})
public class RegimIvaEntity extends AbstractWithIdentificadorAuditableEntity<RegimIva, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected RegimIva embedded;

	@Formula(value="(SELECT CONCAT(CONCAT(rgi.rgi_des,' - '),rgi.rgi_cod) FROM tcom_rgi rgi where rgi.rgi_cod = rgi_cod and rgi.rgi_idf_cod = rgi_idf_cod)")
	private String descripcioCodiTxt;
	
	@Builder
	public RegimIvaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			RegimIva embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(RegimIva embedded) {
		this.embedded = embedded;
	}
	
	public static class RegimIvaEntityListener {
		@PrePersist
		public void calcular(RegimIvaEntity regimIva) {
			String codi = regimIva.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						regimIva.getId().getIdentificadorCodi(),
						"TCOM_RGI",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(regimIva.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(RegimIvaRepository.class));
				String seqST = addZeros(seq, 2);
				regimIva.getEmbedded().setCodi(seqST);
				regimIva.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 2);
					regimIva.getEmbedded().setCodi(codi);
					regimIva.getId().setCodi(codi);
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
		String codiSt = String.format("%02d",codi).toString();
		return codiSt;
	}

}
