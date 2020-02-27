package es.limit.cecocloud.logic.api.converter;

/**
 *  Interfície a implementar els enumerats pels que volem crear un conversor per a hibernate.
 *  
 *  Aquesta interfície implica que l'enumerat definirà un paràmetre amb un tipus a definir Y,
 *	i una funció, que donat un enumerat retornarà el seu valor a BBDD
 *  
 * @author Limit Tecnologies
 *
 * @param <Y> el tipus de dades de l'enumerat a BBDD
 */

public interface ConvertedEnumInterface<Y> {
	Y toDbValue();
}
