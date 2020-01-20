/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.limit.cecocloud.rrhh.persist.entity.EmpresaEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una seccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "trhu_sec",
		indexes = {
				@Index(name = "irhu_sec_idf_fk", columnList = "sec_idf_cod"),
				@Index(name = "irrhu_sec_pk", columnList = "sec_idf_cod,sec_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "sec_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "sec_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "sec_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "sec_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "sec_nom", length = 30)),			
	@AttributeOverride(name = "embedded.compteSous", column = @Column(name = "sec_cte", length = 10)),			
	@AttributeOverride(name = "embedded.controlPartes", column = @Column(name = "sec_ctlffo", nullable = true)),			
	@AttributeOverride(name = "embedded.controlHoresExtras", column = @Column(name = "sec_ctlhoe", nullable = true)),			
	@AttributeOverride(name = "embedded.depcmp", column = @Column(name = "sec_depcmp", length = 4)),			
	@AttributeOverride(name = "embedded.discos", column = @Column(name = "sec_discos", length = 2)),			
	@AttributeOverride(name = "embedded.dtehor", column = @Column(name = "sec_dtehor", length = 2)),			
	@AttributeOverride(name = "embedded.horesLaboralesDia", column = @Column(name = "sec_fct")),			
//	@AttributeOverride(name = "embedded.seccioGrupCodi", column = @Column(name = "sec_gse_cod", length = 4)),			
	@AttributeOverride(name = "embedded.observaciones", column = @Column(name = "sec_obs", length = 1000)),			
	@AttributeOverride(name = "embedded.rolVistas", column = @Column(name = "sec_rolvis", length = 15)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "sec_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sec_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sec_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sec_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "sec_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_sec_idf_fk"))
})
public class SeccioEntity extends AbstractWithIdentificadorEntity<Seccio, SeccioPk> {

	@Embedded
	protected Seccio embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "sec_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "sec_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rrhu_sec_emp_fk"))
	protected EmpresaEntity empresa;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "sec_idf_cod", referencedColumnName = "gse_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sec_emp_cod", referencedColumnName = "gse_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sec_gse_cod", referencedColumnName = "gse_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_sec_gse_fk"))
	protected SeccioGrupEntity seccioGrup;	
	@Column(name = "sec_gse_cod", length = 4)
	private String seccioGrupCodi;

	@Builder
	public SeccioEntity(
			SeccioPk pk,
			Seccio embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SeccioGrupEntity seccioGrup) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
				
		this.seccioGrupCodi = seccioGrup.getEmbedded().getCodi();
	}

	@Override
	public void update(Seccio embedded) {
		this.embedded = embedded;
	}
	
	public void updateSeccioGrup(SeccioGrupEntity seccioGrup) {
		this.seccioGrupCodi = seccioGrup.getEmbedded().getCodi();
	}

}
