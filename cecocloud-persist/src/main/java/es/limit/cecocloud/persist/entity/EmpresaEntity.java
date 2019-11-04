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
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractEntity;
import es.limit.cecocloud.logic.api.dto.Empresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "empresa",
		uniqueConstraints = {
				@UniqueConstraint(name = "empresa_uk", columnNames = {"identificador_id", "codi"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "nif", length = 12, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "tipus", nullable = false)),
	@AttributeOverride(name = "embedded.activa", column = @Column(name = "activa", nullable = false))
})
public class EmpresaEntity extends AbstractEntity<Empresa, Long> {

	@Embedded
	protected Empresa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "empresa_identificador_fk"))
	protected IdentificadorEntity identificador;

	@Builder
    public EmpresaEntity(
    		Empresa embedded,
    		IdentificadorEntity identificador) {
        this.embedded = embedded;
        this.identificador = identificador;
    }

	@Override
	public void update(Empresa embedded) {
		this.embedded = embedded;
	}
	public void updateIdentificador(IdentificadorEntity identificador) {
		this.identificador = identificador;
	}

}
