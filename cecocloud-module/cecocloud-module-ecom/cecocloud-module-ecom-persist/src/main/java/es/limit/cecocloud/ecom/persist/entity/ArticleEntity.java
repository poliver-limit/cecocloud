/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import java.math.BigDecimal;

//import java.math.BigDecimal;

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

//import org.hibernate.annotations.Formula;

import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleEntity")
@Table(
		name = "tcom_art",
		indexes = {
				@Index(name = "icom_art_idf_fk", columnList = "art_idf_cod"),
				@Index(name = "ircom_art_pk", columnList = "art_idf_cod,art_cod", unique = true)
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "art_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "art_cod", length = 15)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "art_cod", length = 15, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcioCurta", column = @Column(name = "art_descur", length = 60)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "art_des", length = 2000, nullable = false)),
	@AttributeOverride(name = "embedded.pvp", column = @Column(name = "art_pvp", precision = 25,  scale = 10, nullable = false)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "art_pruiva", precision = 25, scale = 10, nullable = false)),
	@AttributeOverride(name = "embedded.decimalsPreu", column = @Column(name = "art_decpru", nullable = false, length = 22, precision = 1, scale = 0)),
	@AttributeOverride(name = "embedded.decimalsPreuIva", column = @Column(name = "art_decpruiva", length = 22, precision = 1, scale = 0)),	
	@AttributeOverride(name = "embedded.rutaInforme", column = @Column(name = "art_rutinf", length = 1000, nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "art_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "art_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "art_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "art_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "art_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_idf_fk"))
})
public class ArticleEntity extends AbstractWithIdentificadorAuditableEntity<Article, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Article embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "far_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_far_cod", referencedColumnName = "far_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_far_fk"))	
	private ArticleFamiliaEntity familia;
	@Column(name = "art_far_cod", length = 6, nullable = false)
	private String familiaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "mod_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_mod_cod", referencedColumnName = "mod_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_mod_fk"))			
	private ArticleModelEntity model;	
	@Column(name = "art_mod_cod", length = 6, nullable = false)
	private String modelCodi;	
	
	@ManyToOne(optional = true,	fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "gma_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_gma_cod", referencedColumnName = "gma_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_gma_fk"))		
	private ArticleGammaEntity gamma;	
	@Column(name = "art_gma_cod", length = 6)
	private String gammaCodi;
	
	@ManyToOne(optional = true,	fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "mca_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_mca_cod", referencedColumnName = "mca_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_mca_fk"))		
	private ArticleMarcaEntity marca;
	@Column(name = "art_mca_cod", length = 6)
	private String marcaCodi;
	
	// TIPUS UNITATS
	@ManyToOne(optional = true,	fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "tun_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_tun_cod", referencedColumnName = "tun_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_tun_fk"))		
	private TipusUnitatEntity tipusUnitat;
	@Column(name = "art_tun_cod", length = 4)
	private String tipusUnitatCodi;
	
	// INFORMACIO "FOTOS i ALTRES" --> tges_ain
	
	// TRADUCCIONS --> tges_dar
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_iva_fk"))
	private IvaEntity iva;
	@Column(name = "art_iva_cod", length = 4, nullable = false)
	private String ivaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "ain_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_cod", referencedColumnName = "ain_art_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_ain_num", referencedColumnName = "ain_num", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_art_ain_fk"))
	private ArticleInformacioEntity articleInformacio;
	@Column(name = "art_ain_num", nullable = true)
	private Integer articleInformacioNumero;
	
//	@Formula(value ="(SELECT TCA.art_pvp/((TCI.iva_pte/100)+1) FROM tcom_iva TCI left join tcom_art TCA on TCI.iva_idf_cod = TCA.art_idf_cod and TCI.iva_cod = TCA.art_iva_cod where TCA.art_cod = art_cod and TCA.art_idf_cod = art_idf_cod)")
//	private BigDecimal preuSenseIva;
	
	@Formula(value ="(SELECT TCA.art_pvp FROM tcom_art TCA WHERE TCA.art_cod = art_cod and TCA.art_idf_cod = art_idf_cod)")
	private BigDecimal fixedPvp;
	
	@Formula(value ="(SELECT TCA.art_pruiva FROM tcom_art TCA WHERE TCA.art_cod = art_cod and TCA.art_idf_cod = art_idf_cod)")
	private BigDecimal fixedPreuAmbIva;
	
	@Formula(value ="(SELECT TCI.iva_pte FROM tcom_iva TCI left join tcom_art TCA on TCI.iva_idf_cod = TCA.art_idf_cod and TCI.iva_cod = TCA.art_iva_cod where TCA.art_cod = art_cod and TCA.art_idf_cod = art_idf_cod)")
	private BigDecimal ivaValue;
	
	@Builder
	public ArticleEntity(			
			WithIdentificadorAndCodiPk<String> pk,
			Article embedded,
			IdentificadorEntity identificador,			
			ArticleFamiliaEntity familia,
			ArticleGammaEntity gamma,
			ArticleMarcaEntity marca,
			ArticleModelEntity model,		
			IvaEntity iva,
			ArticleInformacioEntity articleInformacio,
			TipusUnitatEntity tipusUnitat
			) {
		
		setId(pk);		
		
		this.embedded = embedded;
		this.identificador = identificador;		
		
		this.updateFamilia(familia);		
		this.updateModel(model);
		this.updateGamma(gamma);
		this.updateMarca(marca);
		this.updateIva(iva);
		this.updateArticleInformacio(articleInformacio);
		this.updateTipusUnitat(tipusUnitat);
	}

	@Override
	public void update(Article embedded) {
		this.embedded = embedded;
	}
	
	public void updateFamilia(ArticleFamiliaEntity familia) {
		this.familia = familia;		
		if (familia!=null) this.familiaCodi = familia.getEmbedded().getCodi();
	}
	
	public void updateModel(ArticleModelEntity model) {
		this.model = model;	
		if (model!=null) this.modelCodi = model.getEmbedded().getCodi();
	}
	
	public void updateGamma(ArticleGammaEntity gamma) {
		this.gamma = gamma;	
		if (gamma!=null) this.gammaCodi = gamma.getEmbedded().getCodi();		
	}
	
	public void updateMarca(ArticleMarcaEntity marca) {
		this.marca = marca;		
		if (marca!=null) this.marcaCodi = marca.getEmbedded().getCodi();		
	}
	
	public void updateIva(IvaEntity iva) {
		this.iva = iva;		
		if (iva!=null) this.ivaCodi = iva.getEmbedded().getCodi();
	}
	
	public void updateArticleInformacio(ArticleInformacioEntity articleInformacio) {
		this.articleInformacio = articleInformacio;		
		if (articleInformacio!=null) this.articleInformacioNumero = articleInformacio.getEmbedded().getReferenciaSequencial();
	}
	
	public void updateTipusUnitat(TipusUnitatEntity tipusUnitat) {
		this.tipusUnitat = tipusUnitat;		
		if (tipusUnitat!=null) this.tipusUnitatCodi = tipusUnitat.getEmbedded().getCodi();
	}
	
	/* ADATACIÓ DE LA QUERY D'EXISTENCIES DEL FUNCIONAL COMPATIBLE PER A ORACLE I POSTGREE:
	 * 
		SELECT STO_MAG_COD,
		SUM(COALESCE(STO_UNIINI,0)+COALESCE(STO_UNIINI002,0)) AS UNIINI,
		SUM(COALESCE(STO_UNICPRPRO,0)+COALESCE(STO_UNICPRPRO002,0)) AS UNICPRPRO,
		SUM(COALESCE(STO_UNIENTALTMAG,0)+COALESCE(STO_UNIENTALTMAG002,0)) AS UNIENTALTMAG,
		SUM(COALESCE(STO_UNIENTINV,0)+COALESCE(STO_UNIENTINV002,0)) AS UNIENTINV,
		SUM(COALESCE(STO_UNIDIPPRO,0)) AS UNIDIPPRO,
		SUM(COALESCE(STO_UNIFAB,0) + COALESCE(STO_UNIFAB002,0)) AS UNIFAB,
		SUM(COALESCE(STO_UNISORALB,0)+COALESCE(STO_UNISORALB002,0)) AS UNISORALB,
		SUM(COALESCE(STO_UNISORMAG,0)+COALESCE(STO_UNISORALTMAG002,0)) AS UNISORMAG,
		SUM(COALESCE(STO_UNISORINV,0)+COALESCE(STO_UNISORINV002,0)) AS UNISORINV,
		SUM(COALESCE(STO_UNIDIPCLI,0)) AS UNIDIPCLI,
		SUM(COALESCE(STO_UNISORFAB,0) + COALESCE(STO_UNISORFAB002,0)) AS UNISORFAB,
		SUM(COALESCE(STO_UNIDEF,0)+COALESCE(STO_UNIDEF002,0)) AS UNIDEF,
		SUM(COALESCE(STO_UNIPENREB,0)) AS UNIPENREB,
		SUM(COALESCE(STO_UNICOMCLI,0)) AS UNICOMCLI,
		SUM(COALESCE(STO_VALINI,0)+COALESCE(STO_VALINI002,0)) AS VALINI,
		SUM(COALESCE(STO_VALCPRPRO,0)+COALESCE(STO_VALCPRPRO002,0)) AS VALCPRPRO,
		SUM(COALESCE(STO_VALENTALTMAG,0)+COALESCE(STO_VALENTALTMAG002,0)) AS VALENTALTMAG,
		SUM(COALESCE(STO_VALENTINV,0)+COALESCE(STO_VALENTINV002,0)) AS VALENTINV,
		SUM(COALESCE(STO_VALDIPPRO,0)) AS VALDIPPRO,
		SUM(COALESCE(STO_VALFAB,0) + COALESCE(STO_VALFAB002,0)) AS VALFAB,
		SUM(COALESCE(STO_VALSORALB,0)+COALESCE(STO_VALSORALB002,0)) AS VALSORALB,
		SUM(COALESCE(STO_VALSORMAG,0)+COALESCE(STO_VALSORALTMAG002,0)) AS VALSORMAG,
		SUM(COALESCE(STO_VALSORINV,0)+COALESCE(STO_VALSORINV002,0)) AS VALSORINV,
		SUM(COALESCE(STO_VALDIPCLI,0)) AS VALDIPCLI,
		SUM(COALESCE(STO_VALSORFAB,0) + COALESCE(STO_VALSORFAB002,0)) AS VALSORFAB,
		SUM(COALESCE(STO_VALDEF,0)+COALESCE(STO_VALDEF002,0)) AS VALDEF,
		SUM(COALESCE(STO_UNIRSV,0)+COALESCE(STO_UNIRSV002,0)) AS UNIRSV, MAR_PRUCOSEXI
		FROM TGES_STO, TGES_MAR
		WHERE STO_TIP='1' AND STO_IDF_COD='LIM' AND STO_ART_COD='125'
		AND STO_PMG_COD=
		(SELECT PMG_COD FROM TGES_PMG PMG1
		     WHERE PMG_DIAINI <= CURRENT_TIMESTAMP AND PMG_DIAINI <
		(SELECT COALESCE(MIN(PMG2.PMG_DIAINI), TO_DATE('31/12/2050','DD/MM/YYYY'))
		   FROM TGES_PMG PMG2
		  WHERE PMG2.PMG_DIAINI > CURRENT_TIMESTAMP AND
		        PMG2.PMG_IDF_COD=PMG1.PMG_IDF_COD AND
		        PMG2.PMG_MAG_COD = PMG1.PMG_MAG_COD)
		AND PMG_DIAINI >=
		(SELECT COALESCE(MAX(PMG3.PMG_DIAINI), TO_DATE('01/01/1900','DD/MM/YYYY'))
		   FROM TGES_PMG PMG3
		  WHERE PMG3.PMG_DIAINI <= CURRENT_TIMESTAMP AND
		        PMG3.PMG_IDF_COD=PMG1.PMG_IDF_COD AND
		        PMG3.PMG_MAG_COD = PMG1.PMG_MAG_COD)
		AND PMG_IDF_COD = STO_IDF_COD AND PMG_MAG_COD = STO_MAG_COD)
		AND MAR_IDF_COD = STO_IDF_COD AND MAR_MAG_COD=STO_MAG_COD AND
		MAR_ART_COD = STO_ART_COD
		GROUP BY STO_MAG_COD, MAR_PRUCOSEXI
		order by sto_mag_cod

*/
	 
}
