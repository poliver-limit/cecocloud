/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "funcionalitat",
		uniqueConstraints = {
				@UniqueConstraint(name = "funcionalitat_uk", columnNames = {"codi", "modul"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 64, nullable = false, unique = true)),
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "tipus", nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.modul", column = @Column(name = "modul", length = 4, nullable = false))
})
public class FuncionalitatEntity extends AbstractAuditableVersionableEntity<Funcionalitat, Long> {

	@Embedded
	protected Funcionalitat embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "pare_id",
			foreignKey = @ForeignKey(name = "funcionalitat_pare_fk"))
	protected FuncionalitatEntity pare;
	
	@OneToMany(mappedBy = "funcionalitat", cascade = CascadeType.ALL)
	protected List<FuncionalitatRecursEntity> recursos;
	
	@OneToMany(mappedBy = "funcionalitat", cascade = CascadeType.ALL)
	protected List<FuncionalitatIdentificadorEntity> funcionalitatIdentificadors;
	
	@Builder
    public FuncionalitatEntity(
    		Funcionalitat embedded) {
        this.embedded = embedded;
    }

	@Override
	public void update(Funcionalitat embedded) {
		this.embedded = embedded;
	}
	public void updatePare(FuncionalitatEntity pare) {
		this.pare = pare;
	}

}
