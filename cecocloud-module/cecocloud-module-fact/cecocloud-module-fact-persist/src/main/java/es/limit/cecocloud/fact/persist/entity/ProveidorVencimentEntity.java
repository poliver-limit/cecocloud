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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.ProveidorVenciment;
import es.limit.cecocloud.fact.logic.api.dto.ProveidorVenciment.ProveidorVencimentPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de ProveidorVenciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_vpp",
		indexes = {
				@Index(name = "rges_vpp_pk", columnList = "vpp_idf_cod, vpp_emp_cod, vpp_prj_num, vpp_pro_cod", unique = true),
				@Index(name = "iges_vpp_emp_fk", columnList = "vpp_idf_cod, vpp_emp_cod"),
				@Index(name = "iges_vpp_prj_fk", columnList = "vpp_idf_cod, vpp_prj_num"),
				@Index(name = "iges_vpp_pro_fk", columnList = "vpp_idf_cod, vpp_pro_cod"),
				@Index(name = "iges_vpp_tve_fk", columnList = "vpp_idf_cod, vpp_tve_cod"),
		}
)
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "vpp_idf_cod", length = 4)),
		@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "vpp_emp_cod", length = 4)),
		@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "vpp_prj_num", length = 6)),
		@AttributeOverride(name = "id.proveidorCodi", column = @Column(name = "vpp_pro_cod", length = 6)),	
		
		@AttributeOverride(name = "createdBy", column = @Column(name = "vpp_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "vpp_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "vpp_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "vpp_datmod")) 
})

@AssociationOverrides({ 
		@AssociationOverride(
					name = "identificador", 
					joinColumns = {
							@JoinColumn(name = "vpp_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(name = "rges_vpp_idf_fk"))
})

public class ProveidorVencimentEntity extends AbstractWithIdentificadorAuditableEntity<ProveidorVenciment, ProveidorVencimentPk> {

	@Embedded
	protected ProveidorVenciment embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "vpp_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "vpp_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_vpp_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "vpp_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "vpp_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "vpp_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_vpp_prj_fk"))
	protected ProjecteEntity projecte;	

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "vpp_idf_cod", referencedColumnName = "pro_idf_cod", insertable = false, updatable = false),						
						@JoinColumn(name = "vpp_pro_cod", referencedColumnName = "pro_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_vpp_pro_fk"))
	protected ProveidorEntity proveidor;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "vpp_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),						
						@JoinColumn(name = "vpp_tve_cod", referencedColumnName = "tve_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_vpp_tve_fk"))
	protected TipusVencimentEntity tipusVenciment;
	@Column(name = "vpp_tve_cod", length = 4, nullable = false)
	private String tipusVencimentCodi;
	
	@Builder
	public ProveidorVencimentEntity(
			ProveidorVencimentPk pk, 
			ProveidorVenciment embedded, 
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProjecteEntity projecte,
			ProveidorEntity proveidor,
			TipusVencimentEntity tipusVenciment) {
		
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.projecte = projecte;
		this.proveidor = proveidor;
		
		this.updateTipusVenciment(tipusVenciment);
		
	}

	@Override
	public void update(ProveidorVenciment embedded) {
		this.embedded = embedded;
	}	
	
	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVenciment = tipusVenciment;
		if (tipusVenciment!=null) tipusVencimentCodi = tipusVenciment.getEmbedded().getCodi();
	}

}
