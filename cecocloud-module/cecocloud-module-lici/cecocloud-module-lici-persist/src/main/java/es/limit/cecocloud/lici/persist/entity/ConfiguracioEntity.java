/**
 * 
 */
package es.limit.cecocloud.lici.persist.entity;

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
import es.limit.cecocloud.lici.logic.api.dto.Configuracio;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de model de dades que conté la informació d'un CPV.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tlic_config")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.sincronitzacioActiva", column = @Column(name = "sinact", nullable = false)),
	@AttributeOverride(name = "embedded.filtreProvincia", column = @Column(name = "filprv", length = 1000)),
	@AttributeOverride(name = "embedded.filtreCpv", column = @Column(name = "filcpv", length = 1000))
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
