/**
 * 
 */
package es.limit.cecocloud.logic.api.exception;

/**
 * Excepció que es produeix al no trobar una propietat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SuppressWarnings("serial")
public class PropertyNotFoundException extends RuntimeException {

	private String propertyKey;

	public PropertyNotFoundException(
			String propertyKey) {
		super(getExceptionMessage(propertyKey));
		this.propertyKey = propertyKey;
	}

	public String getPropietatCodi() {
		return propertyKey;
	}

	private static String getExceptionMessage(String propertyKey) {
		return "La propietat \"" + propertyKey + "\" no està definida o no te valor";
	}

}
