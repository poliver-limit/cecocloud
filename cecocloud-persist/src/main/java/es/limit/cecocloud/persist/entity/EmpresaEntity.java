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
@Table(name = "empresa")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.identificadorCodi", column = @Column(name = "identificador_codi", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "nif", length = 12, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.activa", column = @Column(name = "activa", nullable = false))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "parent",
			joinColumns = {@JoinColumn(name = "companyia_id")},
			foreignKey = @ForeignKey(name = "empresa_companyia_fk"))
})
public class EmpresaEntity extends AbstractChildEntity<CompanyiaEntity, Empresa, Long> {

	@Builder
    public EmpresaEntity(
    		CompanyiaEntity parent,
    		Empresa embedded) {
		this.parent = parent;
        this.embedded = embedded;
    }

}
