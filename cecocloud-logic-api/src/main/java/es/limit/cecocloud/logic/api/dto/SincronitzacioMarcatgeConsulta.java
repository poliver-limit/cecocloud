/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a consultar els marcatges des de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioMarcatgeConsulta {

	@NotNull
	@Size(max = 30)
	private String companyiaCodi;
	@NotNull
	private List<SincronitzacioEmpresa> empreses;
	@NotNull
	private Date dataInici;
	private Date dataFi;

}
