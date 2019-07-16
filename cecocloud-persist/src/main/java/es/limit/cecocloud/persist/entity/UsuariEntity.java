/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import es.limit.cecocloud.logic.api.dto.Usuari;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "usuari")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 64, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "email", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.imatgeUrl", column = @Column(name = "imatgeUrl", length = 255)),
	@AttributeOverride(name = "embedded.proveidorAuth", column = @Column(name = "proveidorAuth", length = 50)),
	@AttributeOverride(name = "embedded.contrasenya", column = @Column(name = "contrasenya", length = 255))
})
public class UsuariEntity extends AbstractEntity<Usuari, Long> {

	@Builder
    public UsuariEntity(Usuari embedded) {
        this.embedded = embedded;
    }

}
