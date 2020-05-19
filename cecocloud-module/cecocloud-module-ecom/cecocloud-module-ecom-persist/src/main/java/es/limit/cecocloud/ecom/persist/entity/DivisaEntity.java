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

import es.limit.cecocloud.ecom.logic.api.dto.Divisa;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una divisa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomDivisaEntity")
@Table(
		name = "tcom_div",
		indexes = {
				@Index(name = "icom_div_idf_fk", columnList = "div_idf_cod"),
				@Index(name = "ircom_div_pk", columnList = "div_idf_cod,div_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "div_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "div_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "div_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "div_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.valorEuros", column = @Column(name = "div_valdiveur", nullable = false, precision = 15, scale = 8)),
	@AttributeOverride(name = "embedded.decimalsPreus", column = @Column(name = "div_decpru", nullable = false, precision = 1, scale = 0)),	
	@AttributeOverride(name = "embedded.decimalsImports", column = @Column(name = "div_decimp", nullable = false, precision = 1, scale = 0)),
	@AttributeOverride(name = "embedded.abreviatura", column = @Column(name = "div_abr", length = 5)),
	@AttributeOverride(name = "embedded.codiComptabilitat", column = @Column(name = "div_codcmp")),
	@AttributeOverride(name = "createdBy", column = @Column(name = "div_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "div_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "div_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "div_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "div_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_div_idf_fk"))
})
public class DivisaEntity extends AbstractWithIdentificadorAuditableEntity<Divisa, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Divisa embedded;

	@Builder
	public DivisaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Divisa embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Divisa embedded) {
		this.embedded = embedded;
	}

}
