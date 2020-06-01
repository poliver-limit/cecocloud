/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.helper.CompositePkHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.HorariIntervalPk;
import es.limit.cecocloud.cita.logic.api.service.HorariIntervalService;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity;
import es.limit.cecocloud.cita.persist.repository.HorariIntervalRepository;
import es.limit.cecocloud.cita.persist.repository.HorariRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;

/**
 * Implementació del servei de gestió d'intervals horaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class HorariIntervalServiceImpl extends AbstractGenericCompositePkServiceImpl<HorariInterval, HorariIntervalEntity, HorariIntervalPk> implements HorariIntervalService {

	@Autowired
	private HorariRepository horariRepository;

	@Override
	protected HorariIntervalPk getPkFromDto(HorariInterval dto) {
		return new HorariIntervalPk(
				dto.getIdentificador().getId(),
				dto.getHorari().getPk().getCodi(),
				0);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HorariInterval> findByHorari(
			GenericReferenceWithCompositePk<Horari, WithIdentificadorAndCodiPk<String>> horariRef) throws EntityNotFoundException {
		@SuppressWarnings("unchecked")
		Optional<HorariEntity> horari = horariRepository.findById(
				CompositePkHelper.getCompositePkFromSerializedId(
						horariRef.getId(),
						WithIdentificadorAndCodiPk.class));
		return conversionHelper.toDto(
				((HorariIntervalRepository)getRepository()).findByHorari(horari.get()),
				HorariIntervalEntity.class,
				HorariInterval.class);
	}

}
