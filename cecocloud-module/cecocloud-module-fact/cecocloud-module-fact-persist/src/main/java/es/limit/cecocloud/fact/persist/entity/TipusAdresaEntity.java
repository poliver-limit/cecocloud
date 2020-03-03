/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractEntity;
import es.limit.cecocloud.fact.logic.api.dto.TipusAdresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació sobre el TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factTipusAdresaEntity")
@Table(
		/*name = "tlim_tad",
		indexes = {
				@Index(name = "iges_tad_idf_fk", columnList = "tad_idf_cod"),
				@Index(name = "irges_tad_pk", columnList = "tad_idf_cod,tad_cod", unique = true)*/
		
		name = "tlim_tad",
		uniqueConstraints = {
		@UniqueConstraint(name = "rlim_tad_pk", columnNames = "tad_cod")
}
		
		
)
@AttributeOverrides({
	//@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tad_idf_cod", length = 4)),
	//@AttributeOverride(name = "id.codi", column = @Column(name = "tad_cod", length = 4)),
	@AttributeOverride(name = "id", column = @Column(name = "tad_cod")),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tad_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tad_des", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tad_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tad_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tad_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tad_datmod"))
})
/*@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tad_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tad_idf_fk"))
})*/

//public class TipusAdresaEntity extends AbstractWithIdentificadorAuditableEntity<TipusAdresa, WithIdentificadorAndCodiPk<String>> {
public class TipusAdresaEntity extends AbstractEntity<TipusAdresa, String>{
	
	@Embedded
	protected TipusAdresa embedded;

	@Builder
	public TipusAdresaEntity(
			//WithIdentificadorAndCodiPk<String> pk,
			TipusAdresa embedded
			//IdentificadorEntity identificador
			) {
		//setId(pk);
		this.embedded = embedded;
		//this.identificador = identificador;
	}

	@Override
	public void update(TipusAdresa embedded) {
		this.embedded = embedded;
	}

}

