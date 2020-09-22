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

import es.limit.cecocloud.fact.logic.api.dto.PreuPerZona;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerZona.PreuPerZonaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de preu per zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factPreuPerZonaEntity")
@Table(
		name = "tges_ppz",
		indexes = {
				@Index(name = "iges_ppz_idf_fk", columnList = "ppz_idf_cod"),
				@Index(name = "irges_ppz_pk", columnList = "ppz_idf_cod, ppz_zon_cod, ppz_tra_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ppz_idf_cod", length = 4)),
	@AttributeOverride(name = "id.zonaCodi", column = @Column(name = "ppz_zon_cod", length = 4)),
	@AttributeOverride(name = "id.transportistaCodi", column = @Column(name = "ppz_tra_cod", length = 15)),
	
	@AttributeOverride(name = "embedded.precio", column = @Column(name = "ppz_precio", length = 22, precision = 17, scale = 5, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "ppz_obs", length = 1000)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "ppz_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ppz_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ppz_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ppz_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ppz_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ppz_idf_fk"))
})
public class PreuPerZonaEntity extends AbstractWithIdentificadorAuditableEntity<PreuPerZona, PreuPerZonaPk> {

	@Embedded
	protected PreuPerZona embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ppz_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ppz_zon_cod", referencedColumnName = "zon_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_ppz_zon_fk"))			
	protected ZonaEntity zona;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "ppz_idf_cod", referencedColumnName = "tra_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ppz_tra_cod", referencedColumnName = "tra_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_ppz_tra_fk"))
	protected TransportistaEntity transportista;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "ppz_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "ppz_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "ppz_div_cod_fk"))
	private DivisaEntity divisa;
	@Column(name = "ppz_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@Builder
	public PreuPerZonaEntity(
			PreuPerZonaPk pk,			
			IdentificadorEntity identificador,
			PreuPerZona embedded,
			ZonaEntity zona,
			TransportistaEntity transportista,
			DivisaEntity divisa) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.zona = zona;
		this.transportista = transportista;		

		updateDivisa(divisa);
	}

	@Override
	public void update(PreuPerZona embedded) {
		this.embedded = embedded;
	}

	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getId().getCodi();
		}
	}

}
