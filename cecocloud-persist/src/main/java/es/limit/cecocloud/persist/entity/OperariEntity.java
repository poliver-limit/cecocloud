/**
 * 
 */
package es.limit.cecocloud.persist.entity;

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

import es.limit.cecocloud.logic.api.dto.Operari;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "operari")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 6, nullable = false)),
	@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "data_inici", nullable = false)),
	@AttributeOverride(name = "embedded.dataFi", column = @Column(name = "data_fi"))
})
public class OperariEntity extends AbstractEntity<Operari, Long> {

	@Embedded
	protected Operari embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuari_id",
			foreignKey = @ForeignKey(name = "operari_usuari_fk"))
	protected UsuariEntity usuari;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "operari_empresa_fk"))
	protected EmpresaEntity empresa;

	@Builder
    public OperariEntity(
    		Operari embedded,
    		UsuariEntity usuari,
    		EmpresaEntity empresa) {
        this.embedded = embedded;
		this.usuari = usuari;
		this.empresa = empresa;
    }

	@Override
	public void update(Operari embedded) {
		this.embedded = embedded;
	}
	public void updateUsuari(UsuariEntity usuari) {
		this.usuari = usuari;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}
