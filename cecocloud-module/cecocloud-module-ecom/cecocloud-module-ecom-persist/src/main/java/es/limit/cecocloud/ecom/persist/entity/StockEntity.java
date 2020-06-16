/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import es.limit.cecocloud.ecom.logic.api.dto.Stock;
import es.limit.cecocloud.ecom.logic.api.dto.Stock.StockPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una article familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomStockEntity")
@Table(
		name = "tcom_sto",
		indexes = {
				@Index(name = "icom_sto_idf_fk", columnList = "sto_idf_cod"),
				@Index(name = "ircom_sto_pk", columnList = "sto_idf_cod, sto_mag_cod, sto_pmg_cod, sto_art_cod, sto_tip", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "sto_idf_cod", length = 4)),
	@AttributeOverride(name = "id.magatzemCodi", column = @Column(name = "sto_mag_cod", length = 4)),
	@AttributeOverride(name = "id.magatzemPeriodeCodi", column = @Column(name = "sto_pmg_cod", length = 22, precision = 10)),
	@AttributeOverride(name = "id.articleCodi", column = @Column(name = "sto_art_cod", length = 15)),
	@AttributeOverride(name = "id.STO_TIP", column = @Column(name = "STO_TIP", length = 1)),	
	
	@AttributeOverride(name = "embedded.STO_TIP", column = @Column(name = "STO_TIP", length = 1, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.STO_UNIINI", column = @Column(name = "STO_UNIINI", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALINI", column = @Column(name = "STO_VALINI", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNICPRPRO", column = @Column(name = "STO_UNICPRPRO", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALCPRPRO", column = @Column(name = "STO_VALCPRPRO", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIENTALTMAG", column = @Column(name = "STO_UNIENTALTMAG", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALENTALTMAG", column = @Column(name = "STO_VALENTALTMAG", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIENTINV", column = @Column(name = "STO_UNIENTINV", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALENTINV", column = @Column(name = "STO_VALENTINV", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIPENREB", column = @Column(name = "STO_UNIPENREB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALPENREB", column = @Column(name = "STO_VALPENREB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIDIPPRO", column = @Column(name = "STO_UNIDIPPRO", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALDIPPRO", column = @Column(name = "STO_VALDIPPRO", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIFAB", column = @Column(name = "STO_UNIFAB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALFAB", column = @Column(name = "STO_VALFAB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORALB", column = @Column(name = "STO_UNISORALB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORALB", column = @Column(name = "STO_VALSORALB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIRSV", column = @Column(name = "STO_UNIRSV", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALUNIRSV", column = @Column(name = "STO_VALUNIRSV", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORMAG", column = @Column(name = "STO_UNISORMAG", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORMAG", column = @Column(name = "STO_VALSORMAG", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORINV", column = @Column(name = "STO_UNISORINV", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORINV", column = @Column(name = "STO_VALSORINV", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNICOMCLI", column = @Column(name = "STO_UNICOMCLI", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALCOMCLI", column = @Column(name = "STO_VALCOMCLI", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIDIPCLI", column = @Column(name = "STO_UNIDIPCLI", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALDIPCLI", column = @Column(name = "STO_VALDIPCLI", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIDEF", column = @Column(name = "STO_UNIDEF", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALDEF", column = @Column(name = "STO_VALDEF", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORFAB", column = @Column(name = "STO_UNISORFAB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORFAB", column = @Column(name = "STO_VALSORFAB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORFABALB", column = @Column(name = "STO_UNISORFABALB", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIINI002", column = @Column(name = "STO_UNIINI002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALINI002", column = @Column(name = "STO_VALINI002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNICPRPRO002", column = @Column(name = "STO_UNICPRPRO002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALCPRPRO002", column = @Column(name = "STO_VALCPRPRO002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIENTALTMAG002", column = @Column(name = "STO_UNIENTALTMAG002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALENTALTMAG002", column = @Column(name = "STO_VALENTALTMAG002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIENTINV002", column = @Column(name = "STO_UNIENTINV002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALENTINV002", column = @Column(name = "STO_VALENTINV002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORALB002", column = @Column(name = "STO_UNISORALB002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORALB002", column = @Column(name = "STO_VALSORALB002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIRSV002", column = @Column(name = "STO_UNIRSV002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALRSV002", column = @Column(name = "STO_VALRSV002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORALTMAG002", column = @Column(name = "STO_UNISORALTMAG002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORALTMAG002", column = @Column(name = "STO_VALSORALTMAG002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORINV002", column = @Column(name = "STO_UNISORINV002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORINV002", column = @Column(name = "STO_VALSORINV002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIDEF002", column = @Column(name = "STO_UNIDEF002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALDEF002", column = @Column(name = "STO_VALDEF002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORFABALB002", column = @Column(name = "STO_UNISORFABALB002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNIFAB002", column = @Column(name = "STO_UNIFAB002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALFAB002", column = @Column(name = "STO_VALFAB002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_UNISORFAB002", column = @Column(name = "STO_UNISORFAB002", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.STO_VALSORFAB002", column = @Column(name = "STO_VALSORFAB002", length = 22, precision = 15, scale = 3)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "sto_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "sto_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "sto_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "sto_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "sto_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_sto_idf_fk"))
})
public class StockEntity extends AbstractWithIdentificadorAuditableEntity<Stock, StockPk> {

	@Embedded
	protected Stock embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "sto_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sto_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_sto_mag_fk"))			
	protected MagatzemEntity magatzem;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "sto_idf_cod", referencedColumnName = "pmg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sto_mag_cod", referencedColumnName = "pmg_mag_cod", insertable = false, updatable = false),
					@JoinColumn(name = "sto_pmg_cod", referencedColumnName = "pmg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_sto_pmg_fk"))			
	protected MagatzemPeriodeEntity magatzemPeriode;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "sto_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "sto_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_sto_art_fk"))
	protected ArticleEntity article;
	
	@Builder
	public StockEntity(
			StockPk pk,			
			IdentificadorEntity identificador,
			Stock embedded,
			MagatzemEntity magatzem,
			MagatzemPeriodeEntity magatzemPeriode,
			ArticleEntity article) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.magatzem = magatzem;
		this.magatzemPeriode = magatzemPeriode;
		this.article = article;		

	}

	@Override
	public void update(Stock embedded) {
		this.embedded = embedded;
	}


}
