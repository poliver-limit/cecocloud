/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.GrupFestiu;
import es.limit.cecocloud.rrhh.logic.api.service.GrupFestiuService;
import es.limit.cecocloud.rrhh.persist.entity.GrupFestiuEntity;

/**
 * Implementació del servei de gestió de grups festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class GrupFestiuServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<GrupFestiu, GrupFestiuEntity, String> implements GrupFestiuService {

}
