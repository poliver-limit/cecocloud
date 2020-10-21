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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte;
import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte.EstudiProjectePk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un EstudiProjecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factEstudiProjecteEntity")
@Table(
		name = "tges_etp",
		indexes = {
				@Index(name = "iges_etp_emp_fk", columnList = "etp_idf_cod,etp_emp_cod,etp_prj_num,etp_cod,etp_num")
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "etp_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "etp_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "etp_cod", length = 4)),
	@AttributeOverride(name = "id.projecteCodi", column = @Column(name = "etp_prj_num", length = 6)),
	@AttributeOverride(name = "id.numero", column = @Column(name = "etp_num", length = 22)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "etp_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "etp_num", length = 22, precision = 3, scale = 0, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.diaInici", column = @Column(name = "etp_diaini", length = 7, nullable = false)),
	@AttributeOverride(name = "embedded.diaFi", column = @Column(name = "etp_diafin", length = 7)),
	@AttributeOverride(name = "embedded.valDivEur", column = @Column(name = "etp_valdiveur", length = 22, precision = 15, scale = 8, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "etp_obs", length = 1000)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "etp_des", length = 1000, nullable = false)),
	@AttributeOverride(name = "embedded.tan", column = @Column(name = "etp_tan", length = 1)),
	@AttributeOverride(name = "embedded.revisioEstudi", column = @Column(name = "etp_revetp", length = 1)),
	@AttributeOverride(name = "embedded.despesesFinanceres", column = @Column(name = "etp_dspfnr", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.tip", column = @Column(name = "etp_tip", length = 22, scale = 127)),
	@AttributeOverride(name = "embedded.estimacionTramite", column = @Column(name = "etp_esttra", length = 22, scale = 127)),
	@AttributeOverride(name = "embedded.magatzemManual", column = @Column(name = "etp_magman", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.revisatResponsable", column = @Column(name = "etp_revres", length = 1)),
	@AttributeOverride(name = "embedded.revisatCapGrup", column = @Column(name = "etp_revgru", length = 1)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "etp_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "etp_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "etp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "etp_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "etp_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_etp_idf_fk"))
})
public class EstudiProjecteEntity extends AbstractWithIdentificadorAuditableEntity<EstudiProjecte, EstudiProjectePk> {

	@Embedded
	protected EstudiProjecte embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "etp_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "etp_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private EmpresaEntity empresa;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "etp_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "etp_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_etp_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "etp_div_cod", length = 4, nullable = false)
	private String divisaCodi;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "etp_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "etp_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false),
					@JoinColumn(name = "etp_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_etp_prj_fk"))
	private ProjecteEntity projecte;

	@Builder
	public EstudiProjecteEntity(
			EstudiProjectePk pk,
			EstudiProjecte embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			DivisaEntity divisa,
			ProjecteEntity projecte) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.projecte = projecte;
		updateDivisa(divisa);
	}

	@Override
	public void update(EstudiProjecte embedded) {
		this.embedded = embedded;
	}

	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getEmbedded().getCodi();
		}
	}

}
