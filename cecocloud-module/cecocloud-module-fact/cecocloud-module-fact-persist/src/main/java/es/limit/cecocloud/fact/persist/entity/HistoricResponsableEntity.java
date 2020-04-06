/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable;
import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable.HistoricResponsablePk;
import es.limit.cecocloud.fact.persist.listener.HistoricResponsableEntityListener;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un HistoricResponsable
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_hop",
		indexes = {
				@Index(name = "rges_hop_pk", columnList = "hop_idf_cod,hop_emp_cod,hop_prj_num,hop_seq", unique = true),
				@Index(name = "iges_hop_emp_fk", columnList = "hop_idf_cod, hop_emp_cod"),
				@Index(name = "iges_hop_prj_fk", columnList = "hop_idf_cod, hop_prj_num"),
				@Index(name = "iges_hop_ope_fk", columnList = "hop_idf_cod, hop_ope_cod"),
				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "hop_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "hop_emp_cod", length = 4)),
	@AttributeOverride(name = "id.projecteNumero", column = @Column(name = "hop_prj_num", length = 6)),
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "hop_seq", precision = 18)),	
	
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "hop_seq", precision = 10, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.tipusOperari", column = @Column(name = "hop_tipope", nullable = false)),
	@AttributeOverride(name = "embedded.dataInicial", column = @Column(name = "hop_datini")),
	@AttributeOverride(name = "embedded.dataFinal", column = @Column(name = "hop_datfin")),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "hop_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "hop_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "hop_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "hop_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "hop_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
})
@EntityListeners({HistoricResponsableEntityListener.class})
public class HistoricResponsableEntity extends AbstractWithIdentificadorAuditableEntity<HistoricResponsable, HistoricResponsablePk> {

	@Embedded
	protected HistoricResponsable embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "hop_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "hop_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false)
					
			},
			foreignKey = @ForeignKey(name = "rges_hop_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "hop_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "hop_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "hop_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_hop_prj_fk"))
	protected ProjecteEntity projecte;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "hop_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "hop_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "hop_ope_cod_fk"))
	private OperariEntity operari;
	@Column(name = "hop_ope_cod", length = 6)
	private String operariCodi;
	
	@Builder
	public HistoricResponsableEntity(
			HistoricResponsablePk pk,
			HistoricResponsable embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			ProjecteEntity projecte,
			OperariEntity operari) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;		
		this.projecte = projecte;
		
		this.updateOperari(operari);	
	}

	@Override
	public void update(HistoricResponsable embedded) {
		this.embedded = embedded;
	}

	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getEmbedded().getCodi();
		}
	}

}
