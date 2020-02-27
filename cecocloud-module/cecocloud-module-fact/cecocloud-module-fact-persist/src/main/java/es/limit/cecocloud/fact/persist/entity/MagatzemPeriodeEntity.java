/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.fact.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un magatzem periode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_pmg",
		indexes = {
				@Index(name = "iges_pmg_idf_fk", columnList = "pmg_idf_cod"),
				@Index(name = "irges_pmg_pk", columnList = "pmg_idf_cod,pmg_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pmg_idf_cod", length = 4)),
	@AttributeOverride(name = "id.magatzemCodi", column = @Column(name = "pmg_mag_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pmg_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pmg_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "pmg_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "pmg_diaini", nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "pmg_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pmg_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pmg_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pmg_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pmg_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pmg_idf_fk"))
})
public class MagatzemPeriodeEntity extends AbstractWithIdentificadorAuditableEntity<MagatzemPeriode, MagatzemPeriodePk> {

	@Embedded
	protected MagatzemPeriode embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pmg_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pmg_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pmg_mag_fk"))
	private MagatzemEntity magatzem;

	@Builder
	public MagatzemPeriodeEntity(
			MagatzemPeriodePk pk,
			MagatzemPeriode embedded,
			IdentificadorEntity identificador,
			MagatzemEntity magatzem) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.magatzem = magatzem;
	}

	@Override
	public void update(MagatzemPeriode embedded) {
		this.embedded = embedded;
	}

}
