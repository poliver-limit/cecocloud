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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.Seccio;
import es.limit.cecocloud.facturacio.logic.api.dto.Seccio.SeccioPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una seccio.
 * 
 * PROPI DEL MÒDUL DE RRHH (FUTURIBLEMENT MOVIBLE)
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_sec",
		indexes = {
				@Index(name = "iges_sec_idf_fk", columnList = "sec_idf_cod"),
				@Index(name = "irges_sec_pk", columnList = "sec_idf_cod,sec_cod", unique = true)
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
	@AttributeOverride(name = "embedded.seccioGrupCodi", column = @Column(name = "sec_gse_cod", length = 4)),			
	@AttributeOverride(name = "embedded.observaciones", column = @Column(name = "sec_obs", length = 1000)),			
	@AttributeOverride(name = "embedded.rolVistas", column = @Column(name = "sec_rolvis", length = 15)),
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "sec_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sec_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sec_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sec_datmod"))
})
public class SeccioEntity extends AbstractAuditableCompositePkEntity<Seccio, SeccioPk> {

	@Embedded
	protected Seccio embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "sec_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_sec_idf_fk"))
	protected IdentificadorEntity identificador;	
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
					@JoinColumn(name = "sec_idf_cod", referencedColumnName = "gse_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sec_emp_cod", referencedColumnName = "gse_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sec_gse_cod", referencedColumnName = "gse_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_sec_gse_fk"))
	protected SeccioGrupEntity seccioGrup;	

	@Builder
	public SeccioEntity(
			SeccioPk pk,
			Seccio embedded,
			IdentificadorEntity identificador,
			SeccioGrupEntity seccioGrup) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.seccioGrup = seccioGrup;
	}

	@Override
	public void update(Seccio embedded) {
		this.embedded = embedded;
	}

}
