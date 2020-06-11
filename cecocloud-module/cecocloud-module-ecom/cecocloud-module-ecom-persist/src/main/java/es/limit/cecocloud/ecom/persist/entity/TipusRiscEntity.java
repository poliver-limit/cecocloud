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

import es.limit.cecocloud.ecom.logic.api.dto.TipusRisc;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TipusRiscEntity.TipusRiscEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.TipusRiscRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomTipusRiscEntity")
@Table(
		name = "tcom_tri",
		indexes = {
				@Index(name = "icom_tri_idf_fk", columnList = "tri_idf_cod"),
				@Index(name = "ircom_tri_pk", columnList = "tri_idf_cod,tri_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tri_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tri_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tri_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tri_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.tri_pensrv", column = @Column(name = "tri_pensrv", length = 3)),
	@AttributeOverride(name = "embedded.tri_albnotfac", column = @Column(name = "tri_albnotfac", length = 3)),
	@AttributeOverride(name = "embedded.tri_vtopennotvnt", column = @Column(name = "tri_vtopennotvnt", length = 3)),
	@AttributeOverride(name = "embedded.tri_vtopenvnt", column = @Column(name = "tri_vtopenvnt", length = 3)),
	@AttributeOverride(name = "embedded.tri_vtopenvnt", column = @Column(name = "tri_vtopenvnt", length = 3)),
	@AttributeOverride(name = "embedded.tri_efeneg", column = @Column(name = "tri_efeneg", length = 3)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tri_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tri_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tri_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tri_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tri_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_tri_idf_fk"))
})
@EntityListeners({TipusRiscEntityListener.class})
public class TipusRiscEntity extends AbstractWithIdentificadorAuditableEntity<TipusRisc, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TipusRisc embedded;

	@Builder
	public TipusRiscEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusRisc embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusRisc embedded) {
		this.embedded = embedded;
	}
	
	public static class TipusRiscEntityListener {
		@PrePersist
		public void calcular(TipusRiscEntity tipusRisc) {
			String codi = tipusRisc.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						tipusRisc.getId().getIdentificadorCodi(),
						"TCOM_TRI",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(tipusRisc.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(TipusRiscRepository.class));
				String seqST = addZeros(seq, 4);
				tipusRisc.getEmbedded().setCodi(seqST);
				tipusRisc.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					tipusRisc.getEmbedded().setCodi(codi);
					tipusRisc.getId().setCodi(codi);
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
