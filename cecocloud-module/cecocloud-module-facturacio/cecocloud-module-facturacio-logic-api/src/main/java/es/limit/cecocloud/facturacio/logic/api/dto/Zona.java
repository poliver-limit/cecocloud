/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecogest.comu.logic.api.dto.AbstractCompositePkAuditableDto;
import es.limit.cecogest.comu.logic.api.dto.annotations.RestapiField;
import es.limit.cecogest.comu.logic.api.dto.annotations.RestapiResource;
import es.limit.cecogest.comu.logic.api.dto.annotations.RestapiField.RestapiFieldType;
import es.limit.cecogest.comu.logic.api.pk.AbstractIdentificadorParentPk;
import es.limit.cecogest.comu.logic.api.pk.IdentificadorPk;
import es.limit.cecogest.facturacio.logic.api.dto.Zona.ZonaPk;

/**
 * Objecte de transferència que representa una zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestapiResource(
		descriptionField = "nom",
		grupPermissionRequired = true)
public class Zona extends AbstractCompositePkAuditableDto<IdentificadorPk, ZonaPk, String> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String nom;
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcio;
	@RestapiField(hiddenInGrid = true,
			sizeMax=4,
			hiddenInLov = true)
	private Integer radioKm;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 12, fraction = 2)
	private BigDecimal preu;

	public String getCodi() {
		return codi;
	}
	public void setCodi(String codi) {
		this.codi = codi;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public Integer getRadioKm() {
		return radioKm;
	}
	public void setRadioKm(Integer radioKm) {
		this.radioKm = radioKm;
	}
	public BigDecimal getPreu() {
		return preu;
	}
	public void setPreu(BigDecimal preu) {
		this.preu = preu;
	}
	

	@MappedSuperclass
	@SuppressWarnings("serial")
	public static class ZonaPk extends AbstractIdentificadorParentPk<String> {}

}
