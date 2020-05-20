/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.ecom.logic.api.dto.Iva;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomIvaEntity")
@Table(
		name = "tcom_iva",
		indexes = {
				@Index(name = "icom_iva_idf_fk", columnList = "iva_idf_cod"),
				@Index(name = "ircom_iva_pk", columnList = "iva_idf_cod,iva_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "iva_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "iva_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "iva_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "iva_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.percentatgeIva", column = @Column(name = "iva_pte", nullable = false)),
	@AttributeOverride(name = "embedded.percentatgeRecarrecEquivalencia", column = @Column(name = "iva_req", nullable = false)),
	@AttributeOverride(name = "embedded.codiComptabilitat", column = @Column(name = "iva_codcmp", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.codiRecarrecComptabilitat", column = @Column(name = "iva_codreqcmp", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.text", column = @Column(name = "iva_txt", length = 6)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "iva_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "iva_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "iva_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "iva_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "iva_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_iva_idf_fk"))
})
public class IvaEntity extends AbstractWithIdentificadorAuditableEntity<Iva, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Iva embedded;

	@Formula(value="(SELECT CONCAT(CONCAT(CONCAT(CONCAT(iva.iva_des,' - '),iva.iva_pte),' - '),iva.iva_cod) FROM tcom_iva iva where iva.iva_cod = iva_cod and iva.iva_idf_cod = iva_idf_cod)")
	private String descripcioPercentatgeCodiTxt;
	
	@Builder
	public IvaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Iva embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Iva embedded) {
		this.embedded = embedded;
	}

}
