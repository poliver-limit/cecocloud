/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificador;
import es.limit.cecocloud.logic.api.helper.FuncionalitatAcl;
import es.limit.cecocloud.logic.api.service.FuncionalitatIdentificadorService;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.repository.FuncionalitatIdentificadorRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei encarregat de gestionar relacions identificador-funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatIdentificadorServiceImpl extends AbstractGenericServiceImpl<FuncionalitatIdentificador, FuncionalitatIdentificadorEntity, Long> implements FuncionalitatIdentificadorService {

	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private FuncionalitatAcl funcionalitatAcl;

	@Override
	public List<Funcionalitat> funcionalitatFindByIdentificadorId(Long identificadorId) throws EntityNotFoundException {
		return toDto(
				((FuncionalitatIdentificadorRepository)getRepository()).findFuncionalitatByIdentificador(
						identificadorRepository.findById(identificadorId).get()),
				Funcionalitat.class);
	}

	@Override
	protected void afterDelete(FuncionalitatIdentificadorEntity entity) {
		super.afterDelete(entity);
		try {
			funcionalitatAcl.refreshPermisosIdentificador(entity.getIdentificador().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
