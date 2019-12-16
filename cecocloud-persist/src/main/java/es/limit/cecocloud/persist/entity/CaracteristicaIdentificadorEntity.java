/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableCompositePkEntity;
import es.limit.cecocloud.logic.api.dto.CaracteristicaIdentificador;
import es.limit.cecocloud.logic.api.dto.CaracteristicaIdentificador.CaracteristicaIdentificadorPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa una relació caracteristica-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "caracteristica_ident")
@AttributeOverrides({
	@AttributeOverride(name = "id.caracteristicaId", column = @Column(name = "caracteristica_id")),
	@AttributeOverride(name = "id.identificadorId", column = @Column(name = "identificador_id"))
})
public class CaracteristicaIdentificadorEntity extends AbstractAuditableVersionableCompositePkEntity<CaracteristicaIdentificador, CaracteristicaIdentificadorPk> {

	@Embedded
	protected CaracteristicaIdentificador embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "caracteristica_id", foreignKey = @ForeignKey(name = "perfilrol_perfil_fk"), insertable = false, updatable = false)
	protected CaracteristicaEntity caracteristica;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "identificador_id", foreignKey = @ForeignKey(name = "perfilrol_rol_fk"), insertable = false, updatable = false)
	protected IdentificadorEntity identificador;

	@Builder
	public CaracteristicaIdentificadorEntity(
			CaracteristicaIdentificadorPk pk,
			CaracteristicaIdentificador embedded,
			CaracteristicaEntity caracteristica,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.caracteristica = caracteristica;
		this.identificador = identificador;
	}

	@Override
	public void update(CaracteristicaIdentificador embedded) {
		this.embedded = embedded;
	}

}
