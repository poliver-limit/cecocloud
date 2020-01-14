/**
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
import es.limit.cecocloud.rrhh.logic.api.dto.TipusTransaccio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un TipusTransaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_ttr",
		indexes = {
				@Index(name = "irhu_ttr_idf_fk", columnList = "ttr_idf_cod"),
				@Index(name = "irrhu_ttr_pk", columnList = "ttr_idf_cod,ttr_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ttr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "ttr_cod")),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ttr_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "ttr_des", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "ttr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ttr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ttr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ttr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ttr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_ttr_idf_fk"))
})
//public class TipusTransaccioEntity extends AbstractAmbIdentificadorEntity<TipusTransaccio, AmbIdentificadorICodiPk<Integer>> {
public class TipusTransaccioEntity extends AbstractWithIdentificadorEntity<TipusTransaccio, WithIdentificadorAndCodiPk<String>> {


	@Embedded
	protected TipusTransaccio embedded;

	@Builder
	public TipusTransaccioEntity(
//			AmbIdentificadorICodiPk<Integer> pk,
			WithIdentificadorAndCodiPk<String> pk,

			TipusTransaccio embedded,
			IdentificadorEntity identificador) {
		
		setId(pk);		
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(TipusTransaccio embedded) {
		this.embedded = embedded;
	}

}
