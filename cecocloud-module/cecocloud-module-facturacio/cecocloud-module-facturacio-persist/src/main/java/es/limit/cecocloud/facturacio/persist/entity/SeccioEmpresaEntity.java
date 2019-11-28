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
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioEmpresa;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioEmpresa.SeccioEmpresaPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una seccio empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_dfs",
		indexes = {
				@Index(name = "iges_dfs_idf_fk", columnList = "dfs_idf_cod"),
				@Index(name = "irges_dfs_pk", columnList = "dfs_idf_cod,dfs_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "dfs_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "dfs_emp_cod", length = 4)),
	@AttributeOverride(name = "id.articleFamiliaCodi", column = @Column(name = "dfs_far_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "dfs_cod", length = 4)),	
	
	@AttributeOverride(name = "embedded.seccioCodi", column = @Column(name = "dfs_sec_cod", insertable = false, updatable = false)),			
	@AttributeOverride(name = "embedded.valorPercentual", column = @Column(name = "dfs_pte")),			
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "dfs_obs", length = 1000)),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "dfs_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "dfs_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "dfs_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "dfs_datmod"))
})
public class SeccioEmpresaEntity extends AbstractAuditableCompositePkEntity<SeccioEmpresa, SeccioEmpresaPk> {

	@Embedded
	protected SeccioEmpresa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "dfs_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_dfs_idf_fk"))
	protected IdentificadorEntity identificador;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dfs_idf_cod", referencedColumnName = "fae_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dfs_far_cod", referencedColumnName = "fae_far_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dfs_emp_cod", referencedColumnName = "fae_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dfs_fae_fk"))
	protected ArticleFamiliaEmpresaEntity familiaEmpresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dfs_idf_cod", referencedColumnName = "far_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dfs_far_cod", referencedColumnName = "far_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dfs_far_fk"))
	protected ArticleFamiliaEntity familia;	

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dfs_idf_cod", referencedColumnName = "sec_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dfs_emp_cod", referencedColumnName = "sec_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dfs_sec_cod", referencedColumnName = "sec_cod", insertable = false,	updatable = false)
			},
					foreignKey = @ForeignKey(name = "rges_dfs_sec_fk"))
	protected SeccioEntity seccio;	

	@Builder
	public SeccioEmpresaEntity(
			SeccioEmpresaPk pk,
			SeccioEmpresa embedded,
			IdentificadorEntity identificador,
			ArticleFamiliaEmpresaEntity familiaEmpresa,
			ArticleFamiliaEntity familia,
			SeccioEntity seccio
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.familiaEmpresa = familiaEmpresa;
		this.familia = familia;
		this.seccio = seccio;
	}

	@Override
	public void update(SeccioEmpresa embedded) {
		this.embedded = embedded;
	}

}
