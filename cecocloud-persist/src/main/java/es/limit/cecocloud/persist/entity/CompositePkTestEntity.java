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

import es.limit.base.boot.persist.entity.AbstractCompositePkEntity;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.CompositePkTest;
import es.limit.cecocloud.logic.api.dto.CompositePkTest.CompositePkTestPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un cpktest.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "cpktest")
@AttributeOverrides({
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.empresaId", column = @Column(name = "empresa_id")),
	@AttributeOverride(name = "id.codi", column = @Column(name = "codi", length = 16)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 100))
})
public class CompositePkTestEntity extends AbstractCompositePkEntity<CompositePkTest, CompositePkTestPk> {

	@Embedded
	protected CompositePkTest embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuari_id",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "cpktest_usuari_fk"))
	protected UsuariEntity usuari;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "cpktest_empresa_fk"))
	protected EmpresaEntity empresa;

	@Builder
    public CompositePkTestEntity(
    		CompositePkTestPk pk,
    		CompositePkTest embedded,
    		UsuariEntity usuari,
    		EmpresaEntity empresa) {
		setId(pk);
        this.embedded = embedded;
		this.usuari = usuari;
		this.empresa = empresa;
    }

	@Override
	public void update(CompositePkTest embedded) {
		this.embedded = embedded;
	}

}
