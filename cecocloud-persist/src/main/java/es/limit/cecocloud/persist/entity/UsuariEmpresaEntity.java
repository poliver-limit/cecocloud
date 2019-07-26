/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
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
@Table(name = "usuari_empresa")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.operariCodi", column = @Column(name = "operari_codi", length = 6, nullable = false)),
	@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "data_inici", nullable = false)),
	@AttributeOverride(name = "embedded.dataFi", column = @Column(name = "data_fi", nullable = false))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "parent1",
			joinColumns = {@JoinColumn(name = "usuari_id")},
			foreignKey = @ForeignKey(name = "usuemp_usuari_fk")),
	@AssociationOverride(
			name = "parent2",
			joinColumns = {@JoinColumn(name = "empresa_id")},
			foreignKey = @ForeignKey(name = "usuemp_empresa_fk"))
})
public class UsuariEmpresaEntity extends AbstractChildChildEntity<UsuariEntity, EmpresaEntity, UsuariEmpresa, Long> {

	@Builder
    public UsuariEmpresaEntity(
    		UsuariEntity parent1,
    		EmpresaEntity parent2,
    		UsuariEmpresa embedded) {
		this.parent1 = parent1;
		this.parent2 = parent2;
        this.embedded = embedded;
    }

}
