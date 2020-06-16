/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import java.math.BigDecimal;

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

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle.MagatzemArticlePk;
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
@Entity(name = "ecomMagatzemArticleEntity")
@Table(
		name = "tcom_mar",
		indexes = {
				@Index(name = "icom_mar_idf_fk", columnList = "mar_idf_cod"),
				@Index(name = "ircom_mar_pk", columnList = "mar_idf_cod, mar_mag_cod, mar_art_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mar_idf_cod", length = 4)),
	@AttributeOverride(name = "id.magatzemCodi", column = @Column(name = "mar_mag_cod", length = 4)),
	@AttributeOverride(name = "id.articleCodi", column = @Column(name = "mar_art_cod", length = 15)),
	
	@AttributeOverride(name = "embedded.ubicacio", column = @Column(name = "mar_llc", length = 30)),
	
	@AttributeOverride(name = "embedded.stockMinim", column = @Column(name = "mar_stomin", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.stockMaxim", column = @Column(name = "mar_stomax", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.preuCostExitencies", column = @Column(name = "mar_prucosexi", length = 22, precision = 17, scale = 5)),
	
	@AttributeOverride(name = "embedded.diaUltimaCompra", column = @Column(name = "mar_diaultcpr", length = 7)),
	@AttributeOverride(name = "embedded.ultimPreuCost", column = @Column(name = "mar_ultprucos", length = 22, precision = 17, scale = 5)),
	
	@AttributeOverride(name = "embedded.dataUltimAjustInventari", column = @Column(name = "mar_ultdiaivt", length = 7)),
	@AttributeOverride(name = "embedded.ultimPreuCostComplements", column = @Column(name = "mar_ultprucpl", length = 22, precision = 17, scale = 5)),
	
	@AttributeOverride(name = "embedded.dataUltimaImputacioCostosComplementaris", column = @Column(name = "mar_diaultcpl", length = 7)),
	@AttributeOverride(name = "embedded.preuCostExistenciesAmbComplements", column = @Column(name = "mar_pruexicpl", length = 22, precision = 17, scale = 5)),
	
	@AttributeOverride(name = "embedded.demandaMijaAnual", column = @Column(name = "mar_demmeanu", length = 22, precision = 17, scale = 3)),
	@AttributeOverride(name = "embedded.diesEsperaComanda", column = @Column(name = "mar_diaespcom", length = 22, precision = 4)),
	
	@AttributeOverride(name = "embedded.costEmmagatzemament", column = @Column(name = "mar_cosmag", length = 22, precision = 15, scale = 2)),
	@AttributeOverride(name = "embedded.lotEconomic", column = @Column(name = "mar_loteco", length = 22, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.stockSeguretat", column = @Column(name = "mar_stosgr", length = 22, precision = 15, scale = 3)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "mar_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mar_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mar_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mar_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "mar_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mar_idf_fk"))
})
public class MagatzemArticleEntity extends AbstractWithIdentificadorAuditableEntity<MagatzemArticle, MagatzemArticlePk> {

	@Embedded
	protected MagatzemArticle embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mar_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mar_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_mar_mag_fk"))			
	protected MagatzemEntity magatzem;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "mar_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "mar_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_mar_art_fk"))
	protected ArticleEntity article;
	
	@Formula (value ="(SELECT \r\n" + 
			"SUM(COALESCE(STO.STO_UNIINI,0)+COALESCE(STO.STO_UNIINI002,0)) +\r\n" + 
			"(SUM(COALESCE(STO.STO_UNICPRPRO,0)+COALESCE(STO.STO_UNICPRPRO002,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNIENTALTMAG,0)+COALESCE(STO.STO_UNIENTALTMAG002,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNIENTINV,0)+COALESCE(STO.STO_UNIENTINV002,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNIDIPPRO,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNIFAB,0) + COALESCE(STO.STO_UNIFAB002,0))) -\r\n" + 
			"(SUM(COALESCE(STO.STO_UNISORALB,0)+COALESCE(STO.STO_UNISORALB002,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNISORMAG,0)+COALESCE(STO.STO_UNISORALTMAG002,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNISORINV,0)+COALESCE(STO.STO_UNISORINV002,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNIDIPCLI,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNISORFAB,0) + COALESCE(STO.STO_UNISORFAB002,0)) +\r\n" + 
			"SUM(COALESCE(STO.STO_UNIDEF,0)+COALESCE(STO.STO_UNIDEF002,0)))\r\n" + 
			"FROM TCOM_STO STO, TCOM_MAR MAR\r\n" + 
			"WHERE STO.STO_TIP='1'\r\n" + 
			"AND STO.STO_PMG_COD=\r\n" + 
			"(SELECT PMG1.PMG_COD FROM TCOM_PMG PMG1\r\n" + 
			"     WHERE PMG1.PMG_DIAINI <= CURRENT_TIMESTAMP AND PMG1.PMG_DIAINI <\r\n" + 
			"(SELECT COALESCE(MIN(PMG2.PMG_DIAINI), TO_DATE('31/12/2050','DD/MM/YYYY'))\r\n" + 
			"   FROM TCOM_PMG PMG2\r\n" + 
			"  WHERE PMG2.PMG_DIAINI > CURRENT_TIMESTAMP AND\r\n" + 
			"        PMG2.PMG_IDF_COD=PMG1.PMG_IDF_COD AND\r\n" + 
			"        PMG2.PMG_MAG_COD = PMG1.PMG_MAG_COD)\r\n" + 
			"AND PMG1.PMG_DIAINI >=\r\n" + 
			"(SELECT COALESCE(MAX(PMG3.PMG_DIAINI), TO_DATE('01/01/1900','DD/MM/YYYY'))\r\n" + 
			"   FROM TCOM_PMG PMG3\r\n" + 
			"  WHERE PMG3.PMG_DIAINI <= CURRENT_TIMESTAMP AND\r\n" + 
			"        PMG3.PMG_IDF_COD=PMG1.PMG_IDF_COD AND\r\n" + 
			"        PMG3.PMG_MAG_COD = PMG1.PMG_MAG_COD)\r\n" + 
			"AND PMG1.PMG_IDF_COD = STO.STO_IDF_COD AND PMG1.PMG_MAG_COD = STO.STO_MAG_COD)\r\n" + 
			"AND MAR.MAR_IDF_COD = STO.STO_IDF_COD AND MAR.MAR_MAG_COD=STO.STO_MAG_COD AND\r\n" + 
			"MAR.MAR_ART_COD = STO.STO_ART_COD\r\n" + 
			"GROUP BY MAR.MAR_PRUCOSEXI)")
	private BigDecimal unitats;
	
	@Builder
	public MagatzemArticleEntity(
			MagatzemArticlePk pk,			
			IdentificadorEntity identificador,
			MagatzemArticle embedded,
			MagatzemEntity magatzem,
			ArticleEntity article) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.magatzem = magatzem;
		this.article = article;		

	}

	@Override
	public void update(MagatzemArticle embedded) {
		this.embedded = embedded;
	}


}
