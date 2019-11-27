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
import es.limit.cecocloud.facturacio.logic.api.dto.Magatzem;
import es.limit.cecocloud.facturacio.logic.api.dto.Magatzem.MagatzemPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
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
		
	
//    @Formula(value="( SELECT r.pmg_cod FROM tges_pmg r WHERE r.pmg_diaini = (SELECT MAX(r2.pmg_diaini) FROM tges_pmg r2 ))")
//	private String periodeActualCodi;
//    @Formula(value="( SELECT r.pmg_diaini FROM tges_pmg r WHERE r.pmg_diaini = (SELECT MAX(r2.pmg_diaini) FROM tges_pmg r2 ))")
//	private String periodeActualData;
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "mag_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mag_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mag_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mag_datmod"))
})
public class MagatzemEntity extends AbstractAuditableCompositePkEntity<Magatzem, MagatzemPk> {

	@Embedded
	protected Magatzem embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "mag_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_mag_idf_fk"))
	protected IdentificadorEntity identificador;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mag_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mag_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_mag_cpo_fk"))
	protected CodiPostalEntity codiPostal;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "mag_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "mag_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_mag_div_fk"))
	protected DivisaEntity divisa;

	@Builder
	public MagatzemEntity(
			MagatzemPk pk,
			Magatzem embedded,
			IdentificadorEntity identificador,
			CodiPostalEntity codiPostal,
			DivisaEntity divisa
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.codiPostal = codiPostal;
		this.divisa = divisa;
	}

	@Override
	public void update(Magatzem embedded) {
		this.embedded = embedded;
	}

}
