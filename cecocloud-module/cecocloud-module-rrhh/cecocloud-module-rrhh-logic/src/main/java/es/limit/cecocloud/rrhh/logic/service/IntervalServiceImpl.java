/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Interval;
import es.limit.cecocloud.rrhh.logic.api.service.IntervalService;
import es.limit.cecocloud.rrhh.persist.entity.IntervalEntity;

/**
 * Implementació del servei de gestió de intervals.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IntervalServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Interval, IntervalEntity, String> implements IntervalService {

}
