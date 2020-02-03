/**
 * 
 */
package es.limit.cecocloud.lici.persist.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.lici.logic.api.dto.Licitacio;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tlic_licitacio"
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 200, nullable = false)),
	@AttributeOverride(name = "embedded.uri", column = @Column(name = "uri", length = 255, nullable = false)),
	@AttributeOverride(name = "embedded.url", column = @Column(name = "url", length = 200, nullable = false)),
	@AttributeOverride(name = "embedded.dataActualitzacio", column = @Column(name = "datact", nullable = false)),
	@AttributeOverride(name = "embedded.resum", column = @Column(name = "resum", length = 500, nullable = false)),
	@AttributeOverride(name = "embedded.expedientId", column = @Column(name = "expid", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.expedientEstat", column = @Column(name = "expest", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.expedientEstatDescripcio", column = @Column(name = "expeds", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.unitatTipus", column = @Column(name = "unitip", length = 2, nullable = false)),
	@AttributeOverride(name = "embedded.unitatTipusDescripcio", column = @Column(name = "unitds", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.unitatDir3Codi", column = @Column(name = "unidi3", length = 9)),
	@AttributeOverride(name = "embedded.unitatNom", column = @Column(name = "uninom", length = 200, nullable = false)),
	@AttributeOverride(name = "embedded.projecteTitol", column = @Column(name = "prjtit", length = 2000, nullable = false)),
	@AttributeOverride(name = "embedded.projecteTipus", column = @Column(name = "prjtip", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.projecteTipusDescripcio", column = @Column(name = "prjtds", length = 1000, nullable = false)),
	@AttributeOverride(name = "embedded.projecteSubTipus", column = @Column(name = "prjsub", length = 4)),
	@AttributeOverride(name = "embedded.projecteSubTipusDescripcio", column = @Column(name = "prjsds", length = 1000)),
	@AttributeOverride(name = "embedded.projecteImportSenseTaxes", column = @Column(name = "impnot", precision = 17, scale = 2, nullable = false)),
	@AttributeOverride(name = "embedded.projecteImportTotal", column = @Column(name = "imptot", precision = 17, scale = 2, nullable = false)),
	@AttributeOverride(name = "embedded.projecteMoneda", column = @Column(name = "mon", length = 3, nullable = false)),
	@AttributeOverride(name = "embedded.projectePaisCodi", column = @Column(name = "paicod", length = 2)),
	@AttributeOverride(name = "embedded.projectePaisDescripcio", column = @Column(name = "paides", length = 200)),
	@AttributeOverride(name = "embedded.projecteProvinciaCodi", column = @Column(name = "prvcod", length = 5)),
	@AttributeOverride(name = "embedded.projecteProvinciaDescripcio", column = @Column(name = "prvdes", length = 200)),
	@AttributeOverride(name = "embedded.projecteTerminiExecucioNum", column = @Column(name = "terexn", precision = 10, scale = 0)),
	@AttributeOverride(name = "embedded.projecteTerminiExecucioUnitat", column = @Column(name = "terexu", length = 3)),
	@AttributeOverride(name = "embedded.procedimentTipus", column = @Column(name = "prctip", length = 3, nullable = false)),
	@AttributeOverride(name = "embedded.procedimentTipusDescripcio", column = @Column(name = "prctds", length = 1000, nullable = false)),
	@AttributeOverride(name = "embedded.urgenciaTipus", column = @Column(name = "urgtip", length = 2, nullable = false)),
	@AttributeOverride(name = "embedded.urgenciaTipusDescripcio", column = @Column(name = "urgtds", length = 1000, nullable = false)),
	@AttributeOverride(name = "embedded.nota", column = @Column(name = "nota", length = 2000, nullable = false)),
	@AttributeOverride(name = "embedded.dataLimit", column = @Column(name = "datlim")),
	@AttributeOverride(name = "embedded.destacada", column = @Column(name = "destac", nullable = false)),
	@AttributeOverride(name = "embedded.esborrada", column = @Column(name = "esborr", nullable = false))
})
public class LicitacioEntity extends AbstractAuditableVersionableEntity<Licitacio, Long> {

	@Embedded
	protected Licitacio embedded;

	@OneToMany(mappedBy="licitacio", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@OrderBy("codi asc")
	private Set<CpvEntity> cpvs;
	@OneToMany(mappedBy="licitacio", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@OrderBy("codi asc")
	private Set<DocumentEntity> documentsAddicionals;
	/*@Formula(value = " CASE WHEN ((SELECT "
			+ " CASE WHEN EXISTS "
				+ "   (SELECT tcom_par.par_val FROM tcom_par WHERE tcom_par.par_idf_cod = lic_idf_cod AND tcom_par.par_cod = 'LIC_FILTRE_PRV') "
			+ " THEN "
				 + "  (SELECT 1 FROM tcom_par WHERE tcom_par.par_val = lic_prvcod AND tcom_par.par_idf_cod = lic_idf_cod AND tcom_par.par_cod = 'LIC_FILTRE_PRV') "
			+ " ELSE 1 END "
				+ " FROM dual" + ") = 1) AND" + 
					" ((SELECT "
			+ " CASE WHEN EXISTS "
				+ "   (SELECT tcom_par.par_val FROM tcom_par WHERE tcom_par.par_idf_cod = lic_idf_cod AND tcom_par.par_cod = 'LIC_FILTRE_CPV') "
			+ " THEN "
				+ "   (SELECT 1 FROM tcom_par WHERE tcom_par.par_val IN (select tlic_cpv.cpv_cod from tlic_cpv WHERE tlic_cpv.cpv_lic_id = lic_id) AND lic_idf_cod IN (select tlic_cpv.cpv_idf_cod from tlic_cpv WHERE tlic_cpv.cpv_lic_id = lic_id) AND lic_emp_cod IN (select tlic_cpv.cpv_emp_cod from tlic_cpv WHERE tlic_cpv.cpv_lic_id = lic_id) AND lic_id IN (select tlic_cpv.cpv_lic_id from tlic_cpv WHERE tlic_cpv.cpv_lic_id = lic_id) AND tcom_par.par_idf_cod = lic_idf_cod AND tcom_par.par_cod = 'LIC_FILTRE_CPV') "
			+ " ELSE 1 END FROM dual " + 
			") = 1) THEN 1 ELSE 0 END ")
	@Transient
	private Boolean inFiltre;*/

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "licitacio_empresa_fk"))
	protected EmpresaEntity empresa;

	@Builder
    public LicitacioEntity(
    		Licitacio embedded,
    		EmpresaEntity empresa) {
        this.embedded = embedded;
        this.empresa = empresa;
    }

	@Override
	public void update(Licitacio embedded) {
		this.embedded = embedded;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}
