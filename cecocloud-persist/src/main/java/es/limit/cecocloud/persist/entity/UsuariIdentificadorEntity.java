/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa una relacio usuari-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "usuari_ident",
		uniqueConstraints = {
				@UniqueConstraint(name = "usuident_uk", columnNames = {"usuari_id", "identificador_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.origen", column = @Column(name = "origen", nullable = false)),
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "actiu", nullable = false))
})
public class UsuariIdentificadorEntity extends AbstractAuditableVersionableEntity<UsuariIdentificador, Long> {

	@Embedded
	protected UsuariIdentificador embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuari_id",
			foreignKey = @ForeignKey(name = "usuident_usuari_fk"))
	protected UsuariEntity usuari;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "usuident_identificador_fk"))
	protected IdentificadorEntity identificador;

	@OneToMany(mappedBy = "usuariIdentificador", cascade = CascadeType.ALL)
	protected List<UsuariIdentificadorEmpresaEntity>usuarisIdentificadorsEmpreses;

	@Formula(value="(select (usu.nom || ' ' || usu.llinatges) from usuari usu where usu.id = usuari_id)")
	private String description;
	@Formula(value="(select usu.codi from usuari usu where usu.id = usuari_id)")
	private String usuariCodi;
	@Formula(value="(select usu.nom from usuari usu where usu.id = usuari_id)")
	private String usuariNom;
	@Formula(value="(select usu.llinatges from usuari usu where usu.id = usuari_id)")
	private String usuariLlinatges;
	@Formula(value="(select usu.email from usuari usu where usu.id = usuari_id)")
	private String usuariEmail;

	@Builder
	public UsuariIdentificadorEntity(
			UsuariIdentificador embedded,
			UsuariEntity usuari,
			IdentificadorEntity identificador) {
		this.embedded = embedded;
		this.usuari = usuari;
		this.identificador = identificador;
	}

	@Override
	public void update(UsuariIdentificador embedded) {
		this.embedded = embedded;
	}
	public void updateUsuari(UsuariEntity usuari) {
		this.usuari = usuari;
	}
	public void updateIdentificador(IdentificadorEntity identificador) {
		this.identificador = identificador;
	}

}
