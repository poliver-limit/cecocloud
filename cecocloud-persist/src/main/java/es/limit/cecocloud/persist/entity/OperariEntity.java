/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.util.Set;

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
import es.limit.cecocloud.logic.api.dto.Operari;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "operari",
		uniqueConstraints = {
				@UniqueConstraint(name = "operari_codi_uk", columnNames = {"identificador_id", "codi"}),
				@UniqueConstraint(name = "operari_usuari_uk", columnNames = {"identificador_id", "usuari_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 6, nullable = false)),
	@AttributeOverride(name = "embedded.origen", column = @Column(name = "origen", nullable = false)),
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "actiu", nullable = false))
})
public class OperariEntity extends AbstractAuditableVersionableEntity<Operari, Long> {

	@Embedded
	protected Operari embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuari_id",
			foreignKey = @ForeignKey(name = "operari_usuari_fk"))
	protected UsuariEntity usuari;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "operari_identificador_fk"))
	protected IdentificadorEntity identificador;
	@OneToMany(mappedBy = "operari", cascade = CascadeType.ALL)
	protected Set<OperariEmpresaEntity> operarisEmpreses;

	@Formula(value="(select ('[' || codi || '] ' || usu.nom || ' ' || usu.llinatges) from usuari usu where usu.id = usuari_id)")
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
	public OperariEntity(
			Operari embedded,
			UsuariEntity usuari,
			IdentificadorEntity identificador) {
		this.embedded = embedded;
		this.usuari = usuari;
		this.identificador = identificador;
	}

	@Override
	public void update(Operari embedded) {
		this.embedded = embedded;
	}
	public void updateUsuari(UsuariEntity usuari) {
		this.usuari = usuari;
	}
	public void updateIdentificador(IdentificadorEntity identificador) {
		this.identificador = identificador;
	}

}
