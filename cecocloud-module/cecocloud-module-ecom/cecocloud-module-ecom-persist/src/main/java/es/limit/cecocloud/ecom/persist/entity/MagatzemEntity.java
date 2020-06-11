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
import es.limit.cecocloud.ecom.logic.api.dto.Magatzem;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.MagatzemEntity.MagatzemEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.MagatzemRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomMagatzemEntity")
@Table(
		name = "tcom_mag",
		indexes = {
				@Index(name = "icom_mag_idf_fk", columnList = "mag_idf_cod"),
				@Index(name = "ircom_mag_pk", columnList = "mag_idf_cod,mag_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mag_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "mag_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mag_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "mag_nom", length = 30, nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "mag_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mag_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mag_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mag_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "mag_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mag_idf_fk"))
})
@EntityListeners({MagatzemEntityListener.class})
public class MagatzemEntity extends AbstractWithIdentificadorAuditableEntity<Magatzem, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Magatzem embedded;


	@Builder
	public MagatzemEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Magatzem embedded,
			IdentificadorEntity identificador) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;		
	
	}

	@Override
	public void update(Magatzem embedded) {
		
		this.embedded = embedded;
	}
	
	public static class MagatzemEntityListener {
		@PrePersist
		public void calcular(MagatzemEntity magatzem) {
			String codi = magatzem.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						magatzem.getId().getIdentificadorCodi(),
						"TCOM_MAG",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(magatzem.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(MagatzemRepository.class));
				String seqST = addZeros(seq, 4);
				magatzem.getEmbedded().setCodi(seqST);
				magatzem.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					magatzem.getEmbedded().setCodi(codi);
					magatzem.getId().setCodi(codi);
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
