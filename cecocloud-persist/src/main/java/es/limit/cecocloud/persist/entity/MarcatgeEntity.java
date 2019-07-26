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

import es.limit.cecocloud.logic.api.dto.Marcatge;
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
@Table(name = "marcatge")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.data", column = @Column(name = "data", nullable = false)),
	@AttributeOverride(name = "embedded.dataActual", column = @Column(name = "data_actual", nullable = false)),
})
@AssociationOverrides({
	@AssociationOverride(
			name = "parent",
			joinColumns = {@JoinColumn(name = "usuemp_id")},
			foreignKey = @ForeignKey(name = "marcatge_usuemp_fk"))
})
public class MarcatgeEntity extends AbstractChildEntity<UsuariEmpresaEntity, Marcatge, Long> {

	@Builder
    public MarcatgeEntity(
    		UsuariEmpresaEntity parent,
    		Marcatge embedded) {
		this.parent = parent;
        this.embedded = embedded;
    }

}
