/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

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

import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_mag",
		indexes = {
				@Index(name = "iges_mag_idf_fk", columnList = "mag_idf_cod"),
				@Index(name = "irges_mag_pk", columnList = "mag_idf_cod,mag_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mag_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "mag_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mag_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "mag_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "mag_dom", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.valoracioInventariTraspas", column = @Column(name = "mag_valinvtrs", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "mag_tel", length = 60)),
	@AttributeOverride(name = "embedded.fax", column = @Column(name = "mag_fax", length = 60)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "mag_eml", length = 60)),
	@AttributeOverride(name = "embedded.responsable", column = @Column(name = "mag_res", length = 30)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "mag_obs", length = 1000)),
	@AttributeOverride(name = "embedded.tipusAssentamentComptable", column = @Column(name = "mag_tipasicmp", length = 2)),
	@AttributeOverride(name = "embedded.diariComptableTraspassos1", column = @Column(name = "mag_dricmp1", length = 2)),
	@AttributeOverride(name = "embedded.diariComptableTraspassos2", column = @Column(name = "mag_dricmp2", length = 2)),
	@AttributeOverride(name = "embedded.compteTraspassos", column = @Column(name = "mag_ctetrs", length = 10)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "mag_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mag_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mag_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mag_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "mag_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_mag_idf_fk"))
})
public class MagatzemEntity extends AbstractWithIdentificadorAuditableEntity<Magatzem, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Magatzem embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mag_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mag_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_mag_cpo_fk"))
	protected CodiPostalEntity codiPostal;
	@Column(name = "mag_cpo_cod", length = 10)
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mag_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mag_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_mag_div_fk"))
	protected DivisaEntity divisa;
	@Column(name = "mag_div_cod", length = 10)
	private String divisaCodi;	
	
	@Formula(value="( SELECT r.pmg_cod FROM tges_pmg r WHERE r.pmg_diaini = (SELECT MAX(r2.pmg_diaini) FROM tges_pmg r2 ))")
	private String periodeActualCodi;	
	
	@Formula(value="( SELECT r.pmg_diaini FROM tges_pmg r WHERE r.pmg_diaini = (SELECT MAX(r2.pmg_diaini) FROM tges_pmg r2 ))")
	private String periodeActualData;

	@Builder
	public MagatzemEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Magatzem embedded,
			IdentificadorEntity identificador,
			CodiPostalEntity codiPostal,
			DivisaEntity divisa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.codiPostal = codiPostal;
		this.divisa = divisa;
		
//		this.setEmbeddedCodis();
		this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		this.divisaCodi = divisa.getEmbedded().getCodi();	
	}

	@Override
	public void update(Magatzem embedded) {
		
		this.embedded = embedded;
//		this.setEmbeddedCodis();
	}
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostalCodi = codiPostal.getEmbedded().getCodi();	
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisaCodi = divisa.getEmbedded().getCodi();	
	}
	
	
//	private void setEmbeddedCodis () {		
//		
//		// Referencies sobre camps obligatoris
//		this.divisaCodi = embedded.getDivisa().getPk().getCodi();
//		this.codiPostalCodi = embedded.getCodiPostal().getPk().getCodi();	
//		
//	}


}
