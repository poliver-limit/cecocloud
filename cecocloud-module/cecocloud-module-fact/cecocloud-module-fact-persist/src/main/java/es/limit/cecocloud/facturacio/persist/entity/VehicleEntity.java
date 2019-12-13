/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un vehicle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_mtr"/*,
		indexes = { 
				@Index(name = "iges_zon_idf_fk", columnList = "zon_idf_cod"),
				@Index(name = "irges_zon_pk", columnList = "zon_idf_cod,zon_cod", unique = true)
		}*/
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mtr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "mtr_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mtr_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "mtr_des", length = 1000)),
	@AttributeOverride(name = "embedded.matricula", column = @Column(name = "mtr_mtr001")),
	@AttributeOverride(name = "embedded.matriculaRemolc", column = @Column(name = "mtr_mtr002")),
	@AttributeOverride(name = "embedded.DNI", column = @Column(name = "mtr_nif")),
	@AttributeOverride(name = "embedded.conductorHabitual", column = @Column(name = "mtr_cdu")),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "mtr_obs")),
	@AttributeOverride(name = "embedded.tara", column = @Column(name = "mtr_tara")),
	@AttributeOverride(name = "embedded.pesMaxim", column = @Column(name = "mtr_pesmax")),
	@AttributeOverride(name = "embedded.transportistaCodi", column = @Column(name = "mtr_tra_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "mtr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mtr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mtr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mtr_datmod"))
})
public class VehicleEntity extends AbstractAuditableCompositePkEntity<Vehicle, AmbIdentificadorICodiPk<String>> {

	@Embedded
	protected Vehicle embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "mtr_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_mtr_idf_fk"))
	protected IdentificadorEntity identificador;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mtr_idf_cod", referencedColumnName = "tra_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mtr_tra_cod", referencedColumnName = "tra_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_zon_tra_fk"))
	protected TransportistaEntity transportista;

	@Builder
	public VehicleEntity(
			AmbIdentificadorICodiPk<String> pk,
			Vehicle embedded,
			IdentificadorEntity identificador,
			TransportistaEntity transportista) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.transportista = transportista;
	}

	@Override
	public void update(Vehicle embedded) {
		this.embedded = embedded;
	}

}
