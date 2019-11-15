/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import es.limit.cecogest.facturacio.logic.api.dto.Zona.ZonaPk;

/**
 * Classe de model de dades que conté la informació d'una zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Entity(name = "factZonaEntity")
@Table(name = TaulesPrefix.ESQ_FACTURACIO + TaulesPrefix.ZONA)
@AttributeOverrides({
	@AttributeOverride(
			name = "pk.identificadorCodi",
			column = @Column(name = TaulesPrefix.ZONA_ + TaulesPrefix.IDENTIFICADOR_ + "cod", length = 4)),
	@AttributeOverride(
			name = "pk.id",
			column = @Column(name = TaulesPrefix.ZONA_ + "cod", length = 4)),
	@AttributeOverride(
			name = "identificadorCodi",
			column = @Column(name = TaulesPrefix.ZONA_ + TaulesPrefix.IDENTIFICADOR_ + "cod", insertable = false, updatable = false)),
	@AttributeOverride(
			name = "creacioUsuari",
			column = @Column(name = TaulesPrefix.ZONA_ + "usucre")),
	@AttributeOverride(
			name = "creacioData",
			column = @Column(name = TaulesPrefix.ZONA_ + "datcre")),
	@AttributeOverride(
			name = "modificacioUsuari",
			column = @Column(name = TaulesPrefix.ZONA_ + "usumod")),
	@AttributeOverride(
			name = "modificacioData",
			column = @Column(name = TaulesPrefix.ZONA_ + "datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = TaulesPrefix.ZONA_ + TaulesPrefix.IDENTIFICADOR_ + "cod", insertable = false, updatable = false)
			})
})
public class ZonaEntity extends AbstractIdentificadorParentEntity<ZonaPk> {

	@Column(name = TaulesPrefix.ZONA_ + "cod", insertable = false, updatable = false)
	private String codi;
	@Column(name = TaulesPrefix.ZONA_ + "nom", length = 30, nullable = false)
	private String nom;
	@Column(name = TaulesPrefix.ZONA_ + "des", length = 1000)
	private String descripcio;
	@Column(name = TaulesPrefix.ZONA_ + "radio_km")
	private Integer radioKm;
	@Column(name = TaulesPrefix.ZONA_ + "precio")
	private BigDecimal preu;

	public String getCodi() {
		return codi;
	}
	public String getNom() {
		return nom;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public Integer getRadioKm() {
		return radioKm;
	}
	public BigDecimal getPreu() {
		return preu;
	}

	public void update(
			String nom,
			String descripcio,
			Integer radioKm,
			BigDecimal preu) {
		this.nom = nom;
		this.descripcio = descripcio;
		this.radioKm = radioKm;
		this.preu = preu;
	}

	public static Builder getBuilder(
			ZonaPk pk,
			String nom) {
		return new Builder(
				pk,
				nom);
	}
	public static class Builder extends AbstractIdentificadorParentEntity.Builder<ZonaEntity, ZonaPk> {
		Builder(
				ZonaPk pk,
				String nom) {
			super(pk, ZonaEntity.class);
			built.codi = pk.getId();
			built.nom = nom;
		}
		public Builder descripcio(String descripcio) {
			built.descripcio = descripcio;
			return this;
		}
		public Builder radioKm(Integer radioKm) {
			built.radioKm = radioKm;
			return this;
		}
		public Builder preu(BigDecimal preu) {
			built.preu = preu;
			return this;
		}
	}

}
