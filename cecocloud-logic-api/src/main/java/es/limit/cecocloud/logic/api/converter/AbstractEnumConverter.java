package es.limit.cecocloud.logic.api.converter;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;

/**
 *  Classe abstracta que implementa la funcionalitat bàsica dels conversors dels enumerats.
 *  -------------------------------------------------------------------------------------------------------
 *  Els enumerats que pot convertir aquesta classe han d'implementar la interfície ConvertedEnumInterface,
 * 	que obliga a l'enumerat a definir un paràmetre (valor de l'enumerat a base de dades), i una funció
 * 	toDbValue(), que obté el valor de base de dades de l'enumerat
 *  
 * @author Limit Tecnologies
 *
 * @param <X> Enumerat a convertir
 * @param <Y> Tipus de dades de l'enumerat a BBDD
 */
public abstract class AbstractEnumConverter<X extends ConvertedEnumInterface<Y>, Y> implements AttributeConverter<X, Y> {

	private final String classCanonicalName;
	private final Map<Y, X> dbValues = new HashMap<>();

	// Constructor genèric que crea un mapa dels enumerats
	// El mapa té la forma Valor BBDD --> Enumerat
	public AbstractEnumConverter(Class<X> enumClass) {
		classCanonicalName = enumClass.getCanonicalName();
		for (X x : enumClass.getEnumConstants()) {
			dbValues.put(x.toDbValue(), x);
		}
	}

	// Funció que donat un enumerat, retorna el seu valor de BBDD
	@Override
    public Y convertToDatabaseColumn(X enumValue) {
		// Si el camp de l'enumerat es null, a BBDD es desarà null
        if(enumValue == null) 
        	return null;
        // En cas contrari es desarà el valor que l'enumerat té configurat com a valor de BBDD
        return enumValue.toDbValue();
    }

	// Funció que donat un valor, retorna l'enumerat que té aquest valor a BBDD
    @Override
    public X convertToEntityAttribute(Y dbValue) {
    	// Si el valor de BBDD es null, no es retorna cap enumerat
    	if (dbValue == null)
    		return null;
    	// En cas contrari s'obté l'enumerat del mapa que el contructor ha generat
    	X enumValue = dbValues.get(dbValue);
		if (enumValue == null) {
			throw new IllegalArgumentException("No enum constant for dbValue " + dbValue + " in " + classCanonicalName);
		}
		return enumValue;
    }
}
