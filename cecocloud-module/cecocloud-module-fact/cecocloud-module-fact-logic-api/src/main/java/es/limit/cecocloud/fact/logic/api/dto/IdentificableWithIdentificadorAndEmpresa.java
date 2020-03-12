/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.MappedSuperclass;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndEmpresa.WithIdentificadorAndEmpresaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Interfície pels DTOs amb identificador i empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableWithIdentificadorAndEmpresa<PK extends WithIdentificadorAndEmpresaPk> extends IdentificableWithIdentificador<PK> {

	public GenericReference<Empresa, String> getEmpresa();
	public void setEmpresa(GenericReference<Empresa, String> empresa);

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@Setter
	@SuppressWarnings("serial")
	@MappedSuperclass
	@ToString
	public static class WithIdentificadorAndEmpresaPk extends WithIdentificadorPk {
		private String empresaCodi;
	}

}
