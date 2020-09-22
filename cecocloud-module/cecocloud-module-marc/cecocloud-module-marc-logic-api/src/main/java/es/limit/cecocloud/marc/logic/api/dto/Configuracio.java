/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.Empresa;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una configuració del mòdul de marcatges per a una empresa.
 * 
 * Els paràmetres son:
 * - intervalValidacio: Diferència en minuts sobre l'hora del servidor per
 * a considerar un marcatge vàlid.
 * - offlinePermes: Indica si els marcatges offline estan permesos.
 * - validacioOfflineAutomatica: Indica si els marcatges s'han de validar
 * automàticament.
 * - mostrarTempsAcumulat: Indica si l'app mòbil ha de mostrar els temps
 * acumulats del dia, mes i any actuals.
 * - maxDistanciaInterval: Distància màxima en minuts entre dos marcatges per
 * a lligar-los en un interval.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource
public class Configuracio extends AbstractIdentificable<Long> {

	private Integer intervalValidacio = 5;
	private Boolean offlinePermes;
	private Boolean validacioOfflineAutomatica;
	private Boolean mostrarTempsAcumulat;
	private Integer maxDistanciaInterval;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true,
			includeInQuickFilter = false)
	private GenericReference<Empresa, Long> empresa;

}
