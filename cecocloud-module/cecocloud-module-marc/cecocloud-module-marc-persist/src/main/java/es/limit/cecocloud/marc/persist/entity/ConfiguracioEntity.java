/**
 * 
 */
package es.limit.cecocloud.marc.persist.entity;

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

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.marc.logic.api.dto.Configuracio;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de model de dades que conté la configuració del mòdul de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "marcConfiguracioEntity")
@Table(name = "tmar_config")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.intervalValidacio", column = @Column(name = "intval")),
	@AttributeOverride(name = "embedded.offlinePermes", column = @Column(name = "offper")),
	@AttributeOverride(name = "embedded.validacioOfflineAutomatica", column = @Column(name = "vofaut")),
	@AttributeOverride(name = "embedded.mostrarTempsAcumulat", column = @Column(name = "motacu")),
	@AttributeOverride(name = "embedded.maxDistanciaInterval", column = @Column(name = "maxdin"))
})
public class ConfiguracioEntity extends AbstractAuditableVersionableEntity<Configuracio, Long> {

	@Embedded
	protected Configuracio embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "configuracio_empresa_fk"))
	protected EmpresaEntity empresa;

	@Builder
	public ConfiguracioEntity(
			Configuracio embedded,
			EmpresaEntity empresa) {
		this.embedded = embedded;
		this.empresa = empresa;
	}

	@Override
	public void update(Configuracio embedded) {
		this.embedded = embedded;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}
