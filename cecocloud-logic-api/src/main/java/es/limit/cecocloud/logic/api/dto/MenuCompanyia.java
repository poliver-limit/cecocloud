/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
public class MenuCompanyia {

	private Long id;
	private String codi;
	private String nom;
	private boolean administracio;
	
	private List<MenuEmpresa> empreses;

}
