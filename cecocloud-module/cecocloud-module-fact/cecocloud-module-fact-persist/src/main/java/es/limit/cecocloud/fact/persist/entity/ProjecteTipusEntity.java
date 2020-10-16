/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.fact.logic.api.dto.ProjecteTipus;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un idioma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_tpj",
		indexes = {
				@Index(name = "iges_tpj_idf_fk", columnList = "tpj_idf_cod"),
				@Index(name = "irges_tpj_pk", columnList = "tpj_idf_cod,tpj_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "tpj_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "tpj_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "tpj_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "tpj_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "tpj_des", length = 30)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "tpj_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "tpj_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "tpj_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "tpj_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "tpj_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_tpj_idf_fk"))
})
public class ProjecteTipusEntity extends AbstractWithIdentificadorAuditableEntity<ProjecteTipus, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ProjecteTipus embedded;
	
	@Formula(value="(SELECT CONCAT(CONCAT(tpj.tpj_nom,' - '),tpj.tpj_cod) FROM tges_tpj tpj where tpj.tpj_cod = tpj_cod and tpj.tpj_idf_cod = tpj_idf_cod)")
	private String descNomCodi;

	@Builder
	public ProjecteTipusEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ProjecteTipus embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(ProjecteTipus embedded) {
		this.embedded = embedded;
	}

}

