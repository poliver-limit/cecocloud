/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Formula;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificador;
import es.limit.cecocloud.logic.api.module.Modul;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa una relació identificador-funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "funcionalitat_ident",
		uniqueConstraints = {
				@UniqueConstraint(name = "funcident_uk", columnNames = {"funcionalitat_id", "identificador_id"})
		}
)
public class FuncionalitatIdentificadorEntity extends AbstractAuditableVersionableEntity<FuncionalitatIdentificador, Long> {
	
	@Embedded
	protected FuncionalitatIdentificador embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "funcionalitat_id",
			foreignKey = @ForeignKey(name = "funcident_funcionalitat_fk"))
	protected FuncionalitatEntity funcionalitat;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "funcident_identificador_fk"))
	protected IdentificadorEntity identificador;
	@OneToMany(mappedBy = "funcionalitatIdentificador", cascade = CascadeType.ALL)
	protected List<FuncionalitatIdentificadorPerfilEntity> funcionalitatIdentificadorPerfils;

	@Formula(value="(select fun.modul from funcionalitat fun where fun.id = identificador_id)")
	private Modul funcionalitatModul;

	@Builder
	public FuncionalitatIdentificadorEntity(
			FuncionalitatIdentificador embedded,
			FuncionalitatEntity funcionalitat,
			IdentificadorEntity identificador) {
		this.embedded = embedded;
		this.funcionalitat = funcionalitat;
		this.identificador = identificador;
	}

	@Override
	public void update(FuncionalitatIdentificador embedded) {
		this.embedded = embedded;
	}
	public void updateFuncionalitat(FuncionalitatEntity funcionalitat) {
		this.funcionalitat = funcionalitat;
	}
	public void updateIdentificador(IdentificadorEntity identificador) {
		this.identificador = identificador;
	}
	
}
