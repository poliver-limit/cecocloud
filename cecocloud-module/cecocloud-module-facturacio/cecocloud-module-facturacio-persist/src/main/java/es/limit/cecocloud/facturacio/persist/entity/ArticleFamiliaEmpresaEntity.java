/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamiliaEmpresa;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamiliaEmpresa.ArticleFamiliaEmpresaPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una article familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_fae",
		indexes = {
				@Index(name = "iges_fae_idf_fk", columnList = "fae_idf_cod"),
				@Index(name = "irges_fae_pk", columnList = "fae_idf_cod,fae_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "fae_idf_cod", length = 4)),
	@AttributeOverride(name = "id.articleFamiliaCodi", column = @Column(name = "fae_far_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "fae_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "dfs_emp_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.web", column = @Column(name = "fae_web")),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "fae_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "fae_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "fae_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "fae_datmod"))
})
public class ArticleFamiliaEmpresaEntity extends AbstractAuditableCompositePkEntity<ArticleFamiliaEmpresa, ArticleFamiliaEmpresaPk> {

	@Embedded
	protected ArticleFamiliaEmpresa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "fae_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_fae_idf_fk"))
	protected IdentificadorEntity identificador;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "fae_idf_cod", referencedColumnName = "far_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "fae_far_cod", referencedColumnName = "far_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_fae_far_fk"))			
	protected ArticleFamiliaEntity familia;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "fae_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fae_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_fae_emp_fk"))
	protected EmpresaEntity empresa;
	
	@Builder
	public ArticleFamiliaEmpresaEntity(
			ArticleFamiliaEmpresaPk pk,			
			IdentificadorEntity identificador,
			ArticleFamiliaEmpresa embedded,
			ArticleFamiliaEntity familia,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.familia = familia;
		this.empresa = empresa;
	}

	@Override
	public void update(ArticleFamiliaEmpresa embedded) {
		this.embedded = embedded;
	}

}
