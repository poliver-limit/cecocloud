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
import javax.persistence.OneToOne;
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
				@UniqueConstraint(name = "funcionalitat_uk", columnNames = {"codi", "modul"}),
				@UniqueConstraint(name = "funcionalitat_recprincipal_uk", columnNames = {"recurs_principal_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 8, nullable = false)),
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
	
	@OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(
			name = "recurs_principal_id",
			foreignKey = @ForeignKey(name = "funcrecu_principal_fk"))
	protected FuncionalitatRecursEntity recursPrincipal;
	
	@OneToMany(mappedBy = "funcionalitat", cascade = CascadeType.ALL)
	protected List<FuncionalitatRecursEntity> recursosAuxiliars;
	
	// TODO: Afegir traduccions per a les funcionalitats
	// @OneToMany(mappedBy = "funcionalitat", cascade = CascadeType.ALL)
	// protected Set<FuncionalitatTraduccioEntity> traduccions;

	@Builder
    public FuncionalitatEntity(
    		Funcionalitat embedded,
    		FuncionalitatRecursEntity recursPrincipal) {
        this.embedded = embedded;
        this.recursPrincipal = recursPrincipal;
    }

	@Override
	public void update(Funcionalitat embedded) {
		this.embedded = embedded;
	}
	public void updatePare(FuncionalitatEntity pare) {
		this.pare = pare;
	}
	public void updateRecursPrincipal(FuncionalitatRecursEntity recursPrincipal) {
		this.recursPrincipal = recursPrincipal;
	}

}
