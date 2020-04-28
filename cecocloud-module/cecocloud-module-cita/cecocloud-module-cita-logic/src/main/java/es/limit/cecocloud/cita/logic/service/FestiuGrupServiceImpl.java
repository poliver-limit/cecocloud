/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.cita.logic.api.dto.FestiuGrup;
import es.limit.cecocloud.cita.logic.api.service.FestiuGrupService;
import es.limit.cecocloud.cita.persist.entity.FestiuGrupEntity;
import es.limit.cecocloud.fact.logic.service.AbstractAmbIdentificadorICodiServiceImpl;

/**
 * Implementació del servei de gestió de grups de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FestiuGrupServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FestiuGrup, FestiuGrupEntity, String> implements FestiuGrupService {

}
