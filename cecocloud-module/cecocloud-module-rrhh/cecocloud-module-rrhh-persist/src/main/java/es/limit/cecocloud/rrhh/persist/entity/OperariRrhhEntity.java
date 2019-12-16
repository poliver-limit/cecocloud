/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

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

import es.limit.cecocloud.rrhh.logic.api.dto.OperariRrhh;
import es.limit.cecocloud.rrhh.logic.api.dto.OperariRrhh.OperariRrhhPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "OperariRrhhEntity")
@Table(
		name = "trhu_ope",
		indexes = {
				@Index(name = "irhu_ope_idf_fk", columnList = "ope_idf_cod"),
				@Index(name = "irrhu_ope_pk", columnList = "ope_idf_cod,ope_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ope_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "ope_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ope_cod", length = 4, insertable = false, updatable = false)),		
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "ope_nom", length = 40, nullable = false)),	
	/*@AttributeOverride(name = "embedded.actiu", column = @Column(name = "ope_act",  nullable = false)),	
	@AttributeOverride(name = "embedded.entsor", column = @Column(name = "ope_entsor",  nullable = false)),	
	@AttributeOverride(name = "embedded.comercial", column = @Column(name = "ope_cml",  nullable = false)),	
	@AttributeOverride(name = "embedded.horariCodi", column = @Column(name = "ope_hor_cod", length = 4, nullable = false)),			
	@AttributeOverride(name = "embedded.mostrTurno", column = @Column(name = "ope_tor",  nullable = false)),			
	@AttributeOverride(name = "embedded.pin", column = @Column(name = "ope_pin", length = 25, nullable = false)),			
	@AttributeOverride(name = "embedded.enc", column = @Column(name = "ope_enc",  nullable = false)),			
	@AttributeOverride(name = "embedded.incidencia", column = @Column(name = "ope_ind",  nullable = false)),			
	@AttributeOverride(name = "embedded.horesp", column = @Column(name = "ope_horesp", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.aplicaDiesLab", column = @Column(name = "ope_apldia", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.laboralDilluns", column = @Column(name = "ope_dls", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.laboralDimarts", column = @Column(name = "ope_dms", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.laboralDimecres", column = @Column(name = "ope_dcs", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.laboralDijous", column = @Column(name = "ope_djs", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.laboralDivendres", column = @Column(name = "ope_dvs", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.laboralDissabte", column = @Column(name = "ope_dse", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.laboralDiumenge", column = @Column(name = "ope_dme", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.nonGrato", column = @Column(name = "ope_ngr", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.ptenmn", column = @Column(name = "ope_ptenmn", nullable = false)),			
	@AttributeOverride(name = "embedded.ado", column = @Column(name = "ope_ado", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.controlPartes", column = @Column(name = "ope_ctlffo", length = 1)),			
	@AttributeOverride(name = "embedded.controlHoresExtras", column = @Column(name = "ope_ctlhoe", length = 1)),			
	@AttributeOverride(name = "embedded.usuariCodi", column = @Column(name = "ope_usu_cod", length = 30)),*/
			
	@AttributeOverride(name = "createdBy", column = @Column(name = "ope_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ope_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ope_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ope_datmod"))
})
public class OperariRrhhEntity extends AbstractAuditableCompositePkEntity<OperariRrhh, OperariRrhhPk> {

	@Embedded
	protected OperariRrhh embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "ope_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_ope_idf_fk"))
	protected IdentificadorRrhhEntity identificador;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_hor_cod", referencedColumnName = "hor_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_hor_fk"))			
	protected HorariEntity horari;	
	
	@Builder
	public OperariRrhhEntity(
			OperariRrhhPk pk,
			OperariRrhh embedded,
			IdentificadorRrhhEntity identificador,
			HorariEntity horari
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.horari = horari;		
	}

	@Override
	public void update(OperariRrhh embedded) {
		this.embedded = embedded;
	}

}
