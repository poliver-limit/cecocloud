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
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleFamilia.ArticleFamiliaPk;
import es.limit.cecocloud.rrhh.persist.entity.RecursGrupEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article familia
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_far",
		indexes = {
				@Index(name = "iges_far_idf_fk", columnList = "far_idf_cod"),
				@Index(name = "irges_far_pk", columnList = "far_idf_cod,far_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "far_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "far_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "far_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "far_des", length = 30, nullable = false)),	
	@AttributeOverride(name = "embedded.tipus", column = @Column(name = "far_tip", length = 1, nullable = false)),			
	@AttributeOverride(name = "embedded.lotNavegable", column = @Column(name = "far_lotnav", length = 1, nullable = false)),	
	@AttributeOverride(name = "embedded.ubicacioNavegable", column = @Column(name = "far_ubinav", length = 1, nullable = false)),	
	@AttributeOverride(name = "embedded.avisAlbaraClient", column = @Column(name = "far_avialb", length = 1, nullable = false)),	
	@AttributeOverride(name = "embedded.excloureAlGenerarAlbara", column = @Column(name = "far_blogenalb", length = 1, nullable = false)),	
	@AttributeOverride(name = "embedded.margeSobreCost", column = @Column(name = "far_marpvpcos")),	
	@AttributeOverride(name = "embedded.valorPercentual", column = @Column(name = "far_cmiven")),	
	@AttributeOverride(name = "embedded.compteExistencies", column = @Column(name = "far_ctecmpexi", length = 500)),	
	@AttributeOverride(name = "embedded.compteCompres", column = @Column(name = "far_ctacprcmp", length = 10)),
	@AttributeOverride(name = "embedded.compteVentes", column = @Column(name = "far_ctavencmp", length = 10)),	
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "far_obs", length = 1000)),	
	@AttributeOverride(name = "embedded.productePropi", column = @Column(name = "far_pop", length = 1)),	
	@AttributeOverride(name = "embedded.tempsFabricacioUnitatsMetriques", column = @Column(name = "far_fabunimet", length = 1)),	
	@AttributeOverride(name = "embedded.distribuirCostAdicional", column = @Column(name = "far_discos", length = 1)),	
	@AttributeOverride(name = "embedded.sequenciaOrdenacio", column = @Column(name = "far_seqord")),	
	@AttributeOverride(name = "embedded.margeMinim", column = @Column(name = "far_marmin")),
	@AttributeOverride(name = "embedded.tipusServei", column = @Column(name = "far_tipser", length = 1)),
	@AttributeOverride(name = "embedded.percentatgePenalitzacioDevolucio", column = @Column(name = "far_ptependev")),
	@AttributeOverride(name = "embedded.descOperacio", column = @Column(name = "far_desope", length = 500)),
	@AttributeOverride(name = "embedded.artExportables", column = @Column(name = "far_pda", length = 1)),
	@AttributeOverride(name = "embedded.familiaCostCodi", column = @Column(name = "far_fct_cod",  length = 4)),	
	@AttributeOverride(name = "embedded.recursGrupCodi", column = @Column(name = "far_gre_cod", length = 4)),			

	
	@AttributeOverride(name = "createdBy", column = @Column(name = "far_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "far_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "far_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "far_datmod"))
})
public class ArticleFamiliaEntity extends AbstractAuditableCompositePkEntity<ArticleFamilia, ArticleFamiliaPk> {

	@Embedded
	protected ArticleFamilia embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "far_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_far_idf_fk"))
	protected IdentificadorEntity identificador;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
			value = { 
			@JoinColumn(name = "far_idf_cod", referencedColumnName = "gre_idf_cod", insertable = false,	updatable = false),
			@JoinColumn(name = "far_gre_cod", referencedColumnName = "gre_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rges_far_gre_fk"))
	protected RecursGrupEntity recursGrup;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
			@JoinColumn(name = "far_idf_cod", referencedColumnName = "fct_idf_cod", insertable = false, updatable = false),
			@JoinColumn(name = "far_fct_cod", referencedColumnName = "fct_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_far_fct_fk"))
	protected FamiliaCostEntity familiaCost;	

	@Builder
	public ArticleFamiliaEntity(
			ArticleFamiliaPk pk,
			ArticleFamilia embedded,
			IdentificadorEntity identificador,
			RecursGrupEntity recursGrup,
			FamiliaCostEntity familiaCost
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.recursGrup = recursGrup;
		this.familiaCost = familiaCost;
	}

	@Override
	public void update(ArticleFamilia embedded) {
		this.embedded = embedded;
	}

}
