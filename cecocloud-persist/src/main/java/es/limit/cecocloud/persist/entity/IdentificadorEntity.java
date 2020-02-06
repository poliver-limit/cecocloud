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

import org.hibernate.annotations.Formula;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un identificador (IDF).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "identificador")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "id", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.numUsuaris", column = @Column(name = "num_usuaris", nullable = false)),
	@AttributeOverride(name = "embedded.numEmpreses", column = @Column(name = "num_empreses", nullable = false)),
	@AttributeOverride(name = "embedded.numOperaris", column = @Column(name = "num_operaris", nullable = false)),
	@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "data_inici", nullable = false)),
	@AttributeOverride(name = "embedded.dataFi", column = @Column(name = "data_fi", nullable = false)),
	@AttributeOverride(name = "embedded.llicencia", column = @Column(name = "llicencia", length = 2000, nullable = false)),
	@AttributeOverride(name = "embedded.llicenciaOk", column = @Column(name = "llicencia_ok", nullable = false))
})
public class IdentificadorEntity extends AbstractAuditableVersionableEntity<Identificador, Long> {

	@Embedded
	protected Identificador embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "propietari_id",
			foreignKey = @ForeignKey(name = "identificador_propietari_fk"))
	protected UsuariEntity propietari;

	@OneToMany(mappedBy = "identificador", cascade = CascadeType.ALL)
	protected Set<UsuariIdentificadorEntity> usuariIdentificadors;

	@Formula(value="(select count(*) from empresa emp where emp.identificador_id = id)")
	private int usuarisCount;
	@Formula(value="(select count(*) from usuari_ident uid where uid.identificador_id = id)")
	private int empresesCount;
	/*//@ElementCollection(targetClass = String.class)
    @Formula("select distinct fun.modul from funcionalitat fun, funcionalitat_ident fid where fun.id = fid.funcionalitat_id and fid.identificador_id = id")
    private List<String> moduls;*/

	@Builder
    public IdentificadorEntity(
    		Identificador embedded,
    		UsuariEntity propietari) {
        this.embedded = embedded;
        this.propietari = propietari;
	}

	@Override
	public void update(Identificador embedded) {
		this.embedded = embedded;
	}
	public void updatePropietari(UsuariEntity propietari) {
		this.propietari = propietari;
	}

}
