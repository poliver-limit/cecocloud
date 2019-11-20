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
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle;
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(	name = "tges_mtr",
		indexes = { 
//				@Index(name = "iges_zon_idf_fk", columnList = "zon_idf_cod"),
//				@Index(name = "irges_zon_pk", columnList = "zon_idf_cod,zon_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mtr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "mtr_cod", length = 4)),	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mtr_cod", length = 4, insertable = false, updatable = false)),	
	
	// Propis de l'entitat (Definits anteriorment a la classe de la Entity ~ public class VehicleEntity)		
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "mtr_des", length = 1000)),
	@AttributeOverride(name = "embedded.matricula", column = @Column(name = "mtr_mtr001")),
	@AttributeOverride(name = "embedded.matricula_remolc", column = @Column(name = "mtr_mtr002")),
	@AttributeOverride(name = "embedded.DNI", column = @Column(name = "mtr_nif")),
	@AttributeOverride(name = "embedded.conductorHabitual", column = @Column(name = "mtr_cdu")),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "mtr_obs")),
	@AttributeOverride(name = "embedded.tara", column = @Column(name = "mtr_tara")),
	@AttributeOverride(name = "embedded.pesMaxim", column = @Column(name = "mtr_pesmax")),
	
	// Join Columns
	@AttributeOverride(name = "embedded.transportistaCodi", column = @Column(name = "mtr_tra_cod", insertable = false, updatable = false)),
	
	// Auditoria ~ (Normalment, sempre els mateixos camps):
	@AttributeOverride(name = "createdBy", column = @Column(name = "mtr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mtr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mtr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mtr_datmod"))
})
public class VehicleEntity extends AbstractAuditableCompositePkEntity<Vehicle, VehiclePk> {
	
	// Definir la part embedded (DTO)
	@Embedded
	protected Vehicle embedded;
	
	// Definicions per a la part hibernate:
	// La part ManyToOne de l'identificador no es definia anteriorment. Sí a partir de Cecocloud
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "zon_idf_cod",
			foreignKey = @ForeignKey(name = "rges_zon_idf_cod"),
			insertable = false, updatable = false)
	protected IdentificadorEntity identificador;
	
	// Aqui van les altres definicions hibernate definides a Cecogest
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(
				name = "mtr_idf_cod",
				referencedColumnName = "tra_idf_cod",
				insertable = false,
				updatable = false),
		@JoinColumn(
				name = "mtr_tra_cod",
				referencedColumnName = "tra_cod",
				insertable = false,
				updatable = false),
	})
	protected TransportistaEntity transportista;

	@Builder
	public VehicleEntity(
			VehiclePk pk,
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
