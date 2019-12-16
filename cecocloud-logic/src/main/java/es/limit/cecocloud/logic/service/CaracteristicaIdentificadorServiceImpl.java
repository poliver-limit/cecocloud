/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.CaracteristicaIdentificador;
import es.limit.cecocloud.logic.api.dto.CaracteristicaIdentificador.CaracteristicaIdentificadorPk;
import es.limit.cecocloud.logic.api.service.CaracteristicaIdentificadorService;
import es.limit.cecocloud.persist.entity.CaracteristicaIdentificadorEntity;

/**
 * Implementació del servei de gestió de la relació caracteristica-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CaracteristicaIdentificadorServiceImpl extends AbstractGenericCompositePkServiceImpl<CaracteristicaIdentificador, CaracteristicaIdentificadorEntity, CaracteristicaIdentificadorPk> implements CaracteristicaIdentificadorService {

}
