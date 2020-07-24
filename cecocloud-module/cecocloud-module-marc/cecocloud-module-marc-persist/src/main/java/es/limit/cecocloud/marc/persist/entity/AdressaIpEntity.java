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
import es.limit.cecocloud.marc.logic.api.dto.AdressaIp;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una adressa IP per a restringir la
 * creació/modificació de marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tmar_adressa_ip")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.adressa", column = @Column(name = "adressa", length = 15, nullable = false))
})
public class AdressaIpEntity extends AbstractAuditableVersionableEntity<AdressaIp, Long> {

	@Embedded
	protected AdressaIp embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "adressaip_empresa_fk"))
	protected EmpresaEntity empresa;

	@Builder
    public AdressaIpEntity(
    		AdressaIp embedded,
    		EmpresaEntity empresa) {
        this.embedded = embedded;
		this.empresa = empresa;
    }

	@Override
	public void update(AdressaIp embedded) {
		this.embedded = embedded;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}
