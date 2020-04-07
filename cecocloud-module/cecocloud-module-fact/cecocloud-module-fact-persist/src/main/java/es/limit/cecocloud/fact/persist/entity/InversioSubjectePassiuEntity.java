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

import es.limit.cecocloud.fact.logic.api.dto.InversioSubjectePassiu;
import es.limit.cecocloud.fact.logic.api.dto.InversioSubjectePassiu.InversioSubjectePassiuPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de InversioSubjectePassiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_ppj",
		indexes = {
				@Index(name = "rges_ppj_pk", columnList = "ppj_idf_cod, ppj_emp_cod, ppj_prj_num, ppj_pro_cod", unique = true),
				@Index(name = "iges_ppj_emp_fk", columnList = "ppj_idf_cod, ppj_emp_cod"),
				@Index(name = "iges_ppj_prj_fk", columnList = "ppj_idf_cod, ppj_prj_num"),
				@Index(name = "iges_ppj_pro_fk", columnList = "ppj_idf_cod, ppj_pro_cod")				
		}
)
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ppj_idf_cod", length = 4)),
		@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "ppj_emp_cod", length = 4)),
		@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "ppj_prj_num", length = 6)),
		@AttributeOverride(name = "id.proveidorCodi", column = @Column(name = "ppj_pro_cod", length = 6)),	
		
		@AttributeOverride(name = "createdBy", column = @Column(name = "ppj_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "ppj_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ppj_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ppj_datmod")) 
})

@AssociationOverrides({ 
		@AssociationOverride(
					name = "identificador", 
					joinColumns = {
							@JoinColumn(name = "ppj_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(name = "rges_ppj_idf_fk"))
})

public class InversioSubjectePassiuEntity extends AbstractWithIdentificadorAuditableEntity<InversioSubjectePassiu, InversioSubjectePassiuPk> {

	@Embedded
	protected InversioSubjectePassiu embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ppj_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ppj_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_ppj_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ppj_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ppj_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ppj_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_ppj_prj_fk"))
	protected ProjecteEntity projecte;	

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ppj_idf_cod", referencedColumnName = "pro_idf_cod", insertable = false, updatable = false),						
						@JoinColumn(name = "ppj_pro_cod", referencedColumnName = "pro_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_ppj_pro_fk"))
	protected ProveidorEntity proveidor;
	
	@Builder
	public InversioSubjectePassiuEntity(
			InversioSubjectePassiuPk pk, 
			InversioSubjectePassiu embedded, 
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProjecteEntity projecte,
			ProveidorEntity proveidor) {
		
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.projecte = projecte;
		this.proveidor = proveidor;		
		
	}

	@Override
	public void update(InversioSubjectePassiu embedded) {
		this.embedded = embedded;
	}
	
}
