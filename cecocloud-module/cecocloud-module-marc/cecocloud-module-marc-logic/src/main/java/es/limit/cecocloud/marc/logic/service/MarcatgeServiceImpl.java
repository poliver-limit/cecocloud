/**
 * 
 */
package es.limit.cecocloud.marc.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.ConversionHelper;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.logic.api.service.MarcatgeService;
import es.limit.cecocloud.marc.logic.helper.MarcatgeHelper;
import es.limit.cecocloud.marc.persist.entity.LlocFeinaEntity;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.marc.persist.repository.MarcatgeRepository;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.repository.OperariEmpresaRepository;

/**
 * Implementació del servei encarregat de gestionar les marcatges fets des de
 * la interfície web.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MarcatgeServiceImpl extends AbstractGenericServiceImpl<Marcatge, MarcatgeEntity, Long> implements MarcatgeService {

	@Autowired
	private OperariEmpresaRepository operariEmpresaRepository;
	@Autowired
	private ConversionHelper conversionHelper;
	@Autowired
	private MarcatgeHelper marcatgeHelper;

	@Override
	public Marcatge findDarrerMarcatgePerOperariEmpresa(Long operariEmpresaId) {
		OperariEmpresaEntity operari = operariEmpresaRepository.getOne(operariEmpresaId);
		return conversionHelper.toDto(
				((MarcatgeRepository)getRepository()).findFirstByOperariEmpresaOrderByEmbeddedDataDesc(operari),
				MarcatgeEntity.class,
				Marcatge.class);
	}

	@Override
	protected void afterCreate(MarcatgeEntity entity, Marcatge dto) {
		processarCanviMarcatges(entity, dto, true);
	}

	@Override
	protected void afterUpdate(MarcatgeEntity entity, Marcatge dto) {
		processarCanviMarcatges(entity, dto, false);
	}

	private void processarCanviMarcatges(
			MarcatgeEntity entity,
			Marcatge dto,
			boolean calcularValidesa) {
		OperariEmpresaEntity operariEmpresa = entity.getOperariEmpresa();
		LlocFeinaEntity llocFeina = marcatgeHelper.calcularForaLlocFeina(dto, operariEmpresa);
		if (calcularValidesa) {
			marcatgeHelper.calcularValidesa(dto, operariEmpresa.getEmpresa());
		}
		entity.updateLlocFeina(llocFeina);
		marcatgeHelper.recalcularIntervals(
				dto.getData(),
				entity,
				operariEmpresa);
		marcatgeHelper.recalcularAcumulatsAnyActual(operariEmpresa);
	}

}
