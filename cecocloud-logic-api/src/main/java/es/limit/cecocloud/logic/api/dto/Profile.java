/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import org.springframework.hateoas.alps.Alps;

/**
 * Informació del profile.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class Profile {

	private Alps alps;
	private ProfileForm form;

	public Alps getAlps() {
		return alps;
	}
	public void setAlps(Alps alps) {
		this.alps = alps;
	}
	public ProfileForm getForm() {
		return form;
	}
	public void setForm(ProfileForm form) {
		this.form = form;
	}

}
