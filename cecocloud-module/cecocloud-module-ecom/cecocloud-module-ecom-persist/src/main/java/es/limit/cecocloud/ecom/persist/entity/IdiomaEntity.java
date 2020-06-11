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

import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.IdiomaEntity.IdiomaEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.IdiomaRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un idioma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomIdiomaEntity")
@Table(
		name = "tcom_idi",
		indexes = {
				@Index(name = "icom_idi_idf_fk", columnList = "idi_idf_cod"),
				@Index(name = "ircom_idi_pk", columnList = "idi_idf_cod,idi_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "idi_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "idi_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "idi_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "idi_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.codiIso", column = @Column(name = "idi_codiso", length = 2, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "idi_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "idi_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "idi_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "idi_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "idi_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_idi_idf_fk"))
})
@EntityListeners({IdiomaEntityListener.class})
public class IdiomaEntity extends AbstractWithIdentificadorAuditableEntity<Idioma, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Idioma embedded;

	@Formula(value="(SELECT CONCAT(CONCAT(idi.idi_des,' - '),idi.idi_cod) FROM tcom_idi idi where idi.idi_cod = idi_cod and idi.idi_idf_cod = idi_idf_cod)")
	private String descripcioCodiTxt;
	
	@Builder
	public IdiomaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Idioma embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Idioma embedded) {
		this.embedded = embedded;
	}
	
	public static class IdiomaEntityListener {
		@PrePersist
		public void calcular(IdiomaEntity idioma) {
			String codi = idioma.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						idioma.getId().getIdentificadorCodi(),
						"TCOM_IDI",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(idioma.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(IdiomaRepository.class));
				String seqST = addZeros(seq, 4);
				idioma.getEmbedded().setCodi(seqST);
				idioma.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 4);
					idioma.getEmbedded().setCodi(codi);
					idioma.getId().setCodi(codi);
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
