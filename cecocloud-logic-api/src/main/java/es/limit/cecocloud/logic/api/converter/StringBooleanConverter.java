/**
 * 
 */
package es.limit.cecocloud.logic.api.converter;

import javax.persistence.AttributeConverter;

/**
 * Conversor pels camp de tipus text de base de dades que corresponen a un
 * tipus booleà. Els possibles valors son "S" i "N".
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class StringBooleanConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute == null) {
			return null;
		} else {
			return (attribute) ? "S": "N";
		}
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		} else {
			return dbData.equalsIgnoreCase("S");
		}
	}

}
