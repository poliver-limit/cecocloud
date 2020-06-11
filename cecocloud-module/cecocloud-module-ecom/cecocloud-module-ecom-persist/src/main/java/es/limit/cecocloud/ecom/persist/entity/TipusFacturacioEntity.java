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

import es.limit.cecocloud.ecom.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TipusFacturacioEntity.TipusFacturacioEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.TipusFacturacioRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de facturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomTipusFacturacioEntity")
@Table(
		name = "tcom_tfc",
		indexes = {
				@Index(name = "icom_tfc_idf_fk", columnList = "tfc_idf_cod"),
				@Index(name = "ircom_tfc_pk", columnList = "tfc_idf_cod,tfc_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tfc_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tfc_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tfc_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tfc_des", nullable = false, length = 30)),
	@AttributeOverride(name = "embedded.concedimCredit", column = @Column(name = "tfc_crd", length = 1)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tfc_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tfc_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tfc_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tfc_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tfc_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tfc_idf_fk"))
})
@EntityListeners({TipusFacturacioEntityListener.class})
public class TipusFacturacioEntity extends AbstractWithIdentificadorAuditableEntity<TipusFacturacio, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TipusFacturacio embedded;

	@Builder
	public TipusFacturacioEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusFacturacio embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusFacturacio embedded) {
		this.embedded = embedded;
	}
	
	public static class TipusFacturacioEntityListener {
		@PrePersist
		public void calcular(TipusFacturacioEntity tipusFacturacio) {
			String codi = tipusFacturacio.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						tipusFacturacio.getId().getIdentificadorCodi(),
						"TCOM_TFC",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(tipusFacturacio.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(TipusFacturacioRepository.class));
				String seqST = addZeros(seq, 4);
				tipusFacturacio.getEmbedded().setCodi(seqST);
				tipusFacturacio.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					tipusFacturacio.getEmbedded().setCodi(codi);
					tipusFacturacio.getId().setCodi(codi);
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
		String codiSt = String.format("%04d",codi).toString();
		return codiSt;
	}

}
