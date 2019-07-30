/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date dataInici;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date dataFi;

}
