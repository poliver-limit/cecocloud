/*
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusComissio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un tipus de comissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "rrhhTipusComissioEntity")
@Table(
		/*name = "trhu_tcs",
		indexes = {
				@Index(name = "irhu_tcs_idf_fk", columnList = "tcs_idf_cod"),
				@Index(name = "irrhu_tcs_pk", columnList = "tcs_idf_cod,tcs_cod", unique = true)*/
		
		name = "tges_tcs",
		indexes = {
				@Index(name = "iges_tcs_idf_fk", columnList = "tcs_idf_cod"),
				@Index(name = "irges_tcs_pk", columnList = "tcs_idf_cod,tcs_cod", unique = true)
		
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tcs_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tcs_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tcs_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tcs_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tcs_des", length = 1000)),
	@AttributeOverride(name = "embedded.percentatge", column = @Column(name = "tcs_pte", precision=5, scale=3)),
	@AttributeOverride(name = "embedded.minim", column = @Column(name = "tcs_min", precision=15, scale=3)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tcs_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tcs_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tcs_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tcs_datmod"))
})

@AssociationOverrides({
	/*@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tcs_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_tcs_idf_fk"))*/
	
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tcs_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tcs_idf_fk"))	
})

public class TipusComissioEntity extends AbstractWithIdentificadorAuditableEntity<TipusComissio, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected TipusComissio embedded;

	@Builder
	public TipusComissioEntity(
			WithIdentificadorAndCodiPk<String> pk,
			TipusComissio embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(TipusComissio embedded) {
		this.embedded = embedded;
	}

}
