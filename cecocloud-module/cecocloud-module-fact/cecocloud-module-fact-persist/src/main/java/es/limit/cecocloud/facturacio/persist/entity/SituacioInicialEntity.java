/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial.SituacioInicialPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una situacio inicial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_sui",
		indexes = {
				@Index(name = "iges_sui_idf_fk", columnList = "sui_idf_cod"),
				@Index(name = "irges_sui_pk", columnList = "sui_idf_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "sui_idf_cod", length = 4)),
	@AttributeOverride(name = "id.articleCodi", column = @Column(name = "sui_art_cod", length = 6)),
	@AttributeOverride(name = "id.magatzemCodi", column = @Column(name = "sui_mag_cod", length = 6)),
	@AttributeOverride(name = "id.classe", column = @Column(name = "sui_cls", length = 6)),
	@AttributeOverride(name = "embedded.classe", column = @Column(name = "sui_cls", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.unitatsInicials", column = @Column(name = "sui_uniini", nullable = false)),
	@AttributeOverride(name = "embedded.unitatsMetriquesInicials", column = @Column(name = "sui_unimetini")),
	@AttributeOverride(name = "embedded.preuCostUnitari", column = @Column(name = "sui_prucosuni", nullable = false)),
	@AttributeOverride(name = "embedded.divisaCodi", column = @Column(name = "sui_div_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.familiaCodi", column = @Column(name = "sui_far_cod", length = 4, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "sui_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sui_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sui_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sui_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "sui_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_sui_idf_fk"))
})
public class SituacioInicialEntity extends AbstractWithIdentificadorEntity<SituacioInicial, SituacioInicialPk> {

	@Embedded
	protected SituacioInicial embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "sui_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sui_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_sui_art_fk"))			
	protected ArticleEntity article;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "sui_idf_cod", referencedColumnName = "pmg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sui_mag_cod", referencedColumnName = "pmg_mag_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sui_pmg_cod", referencedColumnName = "pmg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_sui_pmg_fk"))
	protected MagatzemPeriodeEntity magatzemPeriode;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "sui_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sui_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_sui_div_fk"))
	protected DivisaEntity divisa;	
	
	@Builder
	public SituacioInicialEntity(
			SituacioInicialPk pk,
			SituacioInicial embedded,
			IdentificadorEntity identificador,
			ArticleEntity article,
			MagatzemPeriodeEntity magatzemPeriode,
			DivisaEntity divisa) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.article = article;
		this.magatzemPeriode = magatzemPeriode;
		this.divisa = divisa;
	}

	@Override
	public void update(SituacioInicial embedded) {
		this.embedded = embedded;
	}

}
