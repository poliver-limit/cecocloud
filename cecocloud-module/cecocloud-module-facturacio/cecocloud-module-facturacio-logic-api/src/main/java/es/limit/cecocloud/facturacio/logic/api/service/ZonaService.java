/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.service;

import es.limit.cecogest.comu.logic.api.pk.IdentificadorPk;
import es.limit.cecogest.comu.logic.api.service.CompositePkService;
import es.limit.cecogest.facturacio.logic.api.dto.Zona;
import es.limit.cecogest.facturacio.logic.api.dto.Zona.ZonaPk;

/**
 * Servei per a la gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ZonaService extends CompositePkService<Zona, IdentificadorPk, ZonaPk, String> {

}
