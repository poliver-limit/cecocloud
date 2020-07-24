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
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tmar_marcatge")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.data", column = @Column(name = "data", nullable = false)),
	@AttributeOverride(name = "embedded.origen", column = @Column(name = "origen", nullable = false)),
	@AttributeOverride(name = "embedded.adressaIp", column = @Column(name = "adressa_ip", length = 15, nullable = false)),
	@AttributeOverride(name = "embedded.latitud", column = @Column(name = "latitud", precision = 12, scale = 8)),
	@AttributeOverride(name = "embedded.longitud", column = @Column(name = "longitud", precision = 12, scale = 8))
})
public class MarcatgeEntity extends AbstractAuditableVersionableEntity<Marcatge, Long> {

	@Embedded
	protected Marcatge embedded;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "operariemp_id",
			foreignKey = @ForeignKey(name = "marcatge_operariemp_fk"))
	protected OperariEmpresaEntity operariEmpresa;

	@Builder
    public MarcatgeEntity(
    		Marcatge embedded,
    		OperariEmpresaEntity operariEmpresa) {
        this.embedded = embedded;
		this.operariEmpresa = operariEmpresa;
    }

	@Override
	public void update(Marcatge embedded) {
		this.embedded = embedded;
	}
	public void updateOperariEmpresa(OperariEmpresaEntity operariEmpresa) {
		this.operariEmpresa = operariEmpresa;
	}

}
