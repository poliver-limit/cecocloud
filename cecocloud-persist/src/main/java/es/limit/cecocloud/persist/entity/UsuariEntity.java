/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import es.limit.cecocloud.logic.api.dto.Rol;
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

	@ElementCollection
    @CollectionTable(name = "usuari_rols", joinColumns = @JoinColumn(name = "usuari_id"))
    @Column(name = "rol", length = 10)
	@Enumerated(EnumType.STRING)
    private Set<Rol> rols = new HashSet<>();

	@Builder
    public UsuariEntity(Usuari embedded) {
        this.embedded = embedded;
        if (embedded.getRols() != null) {
        	this.rols = embedded.getRols();
        }
    }

	public void updateContrasenya(String contrasenya) {
		this.embedded.setContrasenya(contrasenya);
		this.embedded.setValidat(true);
	}

}
