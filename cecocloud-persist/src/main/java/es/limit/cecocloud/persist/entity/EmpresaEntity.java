/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.util.Set;

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
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "nif", length = 12, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "tipus", nullable = false)),
	@AttributeOverride(name = "embedded.origen", column = @Column(name = "origen", nullable = false)),
	@AttributeOverride(name = "embedded.activa", column = @Column(name = "activa", nullable = false))
})
public class EmpresaEntity extends AbstractAuditableVersionableEntity<Empresa, Long> {

	@Embedded
	protected Empresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "empresa_identificador_fk"))
	protected IdentificadorEntity identificador;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_comptable_id",
			foreignKey = @ForeignKey(name = "empresa_comptable_fk"))
	protected EmpresaEntity empresaComptable;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	protected Set<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpreses;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	protected Set<OperariEmpresaEntity> operariEmpreses;

	@Builder
    public EmpresaEntity(
    		Empresa embedded,
    		IdentificadorEntity identificador,
    		EmpresaEntity empresaComptable) {
        this.embedded = embedded;
        this.identificador = identificador;
        this.empresaComptable = empresaComptable;
    }

	@Override
	public void update(Empresa embedded) {
		this.embedded = embedded;
	}
	public void updateIdentificador(IdentificadorEntity identificador) {
		this.identificador = identificador;
	}
	public void updateEmpresaComptable(EmpresaEntity empresaComptable) {
		this.empresaComptable = empresaComptable;
	}

}
