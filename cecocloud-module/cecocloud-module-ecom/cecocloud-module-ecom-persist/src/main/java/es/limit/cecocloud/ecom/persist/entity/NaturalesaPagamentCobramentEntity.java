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

import es.limit.cecocloud.ecom.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.NaturalesaPagamentCobramentEntity.NaturalesaPagamentCobramentEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.NaturalesaPagamentCobramentRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una naturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomNaturalesaPagamentCobramentEntity")
@Table(
		name = "tcom_npg",
		indexes = {
				@Index(name = "icom_npg_idf_fk", columnList = "npg_idf_cod"),
				@Index(name = "ircom_npg_pk", columnList = "npg_idf_cod,npg_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "npg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "npg_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "npg_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "npg_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "npg_obs", length = 1000, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "npg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "npg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "npg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "npg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "npg_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_npg_idf_fk"))
})
@EntityListeners({NaturalesaPagamentCobramentEntityListener.class})
public class NaturalesaPagamentCobramentEntity extends AbstractWithIdentificadorAuditableEntity<NaturalesaPagamentCobrament, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected NaturalesaPagamentCobrament embedded;

	@Builder
	public NaturalesaPagamentCobramentEntity(
			WithIdentificadorAndCodiPk<String> pk,
			NaturalesaPagamentCobrament embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(NaturalesaPagamentCobrament embedded) {
		this.embedded = embedded;
	}
	
	public static class NaturalesaPagamentCobramentEntityListener {
		@PrePersist
		public void calcular(NaturalesaPagamentCobramentEntity naturalesaPagamentCobrament) {
			String codi = naturalesaPagamentCobrament.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						naturalesaPagamentCobrament.getId().getIdentificadorCodi(),
						"TCOM_NPG",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(naturalesaPagamentCobrament.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(NaturalesaPagamentCobramentRepository.class));
				String seqST = addZeros(seq, 4);
				naturalesaPagamentCobrament.getEmbedded().setCodi(seqST);
				naturalesaPagamentCobrament.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					naturalesaPagamentCobrament.getEmbedded().setCodi(codi);
					naturalesaPagamentCobrament.getId().setCodi(codi);
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
