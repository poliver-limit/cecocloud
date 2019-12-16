/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceWithPermissionsImpl;
import es.limit.cecocloud.logic.api.dto.Caracteristica;
import es.limit.cecocloud.logic.api.service.CaracteristicaService;
import es.limit.cecocloud.persist.entity.CaracteristicaEntity;

/**
 * Implementació del servei de gestió de caracteristiques.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CaracteristicaServiceImpl extends AbstractGenericServiceWithPermissionsImpl<Caracteristica, CaracteristicaEntity, Long> implements CaracteristicaService {

}
