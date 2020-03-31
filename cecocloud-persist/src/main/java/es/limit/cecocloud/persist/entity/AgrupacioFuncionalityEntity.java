/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.AgrupacioFuncionalitat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa una relació identificador-agrupacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "agrupacio_ident",
		uniqueConstraints = {
				@UniqueConstraint(name = "agrupident_uk", columnNames = {"agrupacio_id", "identificador_id"})
		}
)
public class AgrupacioFuncionalityEntity extends AbstractAuditableVersionableEntity<AgrupacioFuncionalitat, Long> {

	@Embedded
	protected AgrupacioFuncionalitat embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "agrupacio_id",
			foreignKey = @ForeignKey(name = "agrupident_agrupacio_fk"))
	protected AgrupacioEntity agrupacio;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "agrupident_identificador_fk"))
	protected FuncionalitatEntity identificador;

	@Builder
	public AgrupacioFuncionalityEntity(
			AgrupacioFuncionalitat embedded,
			AgrupacioEntity agrupacio,
			FuncionalitatEntity identificador) {
		this.embedded = embedded;
		this.agrupacio = agrupacio;
		this.identificador = identificador;
	}

	@Override
	public void update(AgrupacioFuncionalitat embedded) {
		this.embedded = embedded;
	}
	public void updateAgrupacio(AgrupacioEntity agrupacio) {
		this.agrupacio = agrupacio;
	}
	public void updateFuncionalitat(FuncionalitatEntity identificador) {
		this.identificador = identificador;
	}

}
