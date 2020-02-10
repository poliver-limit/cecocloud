/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.dto.ActionExecutionResult;
import es.limit.base.boot.logic.api.dto.ActionExecutionResult.ActionExecutionState;
import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Recurs;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.RecursService;
import es.limit.cecocloud.persist.entity.RecursEntity;
import es.limit.cecocloud.persist.repository.RecursRepository;

/**
 * Implementació del servei encarregat de gestionar recursos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RecursServiceImpl extends AbstractGenericServiceImpl<Recurs, RecursEntity, Long> implements RecursService {

	@Autowired
	private RecursRepository recursRepository;

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional
	public ActionExecutionResult execute(
			String action,
			Long id) {
		if ("sync".equals(action)) {
			List<es.limit.base.boot.logic.api.module.ModuleInfo> modules = Modules.registeredFindAll();
			for (es.limit.base.boot.logic.api.module.ModuleInfo moduleInfo: modules) {
				Reflections reflections = new Reflections(moduleInfo.getDtoPackage());
				Set<Class<? extends Identificable>> dtoClasses = reflections.getSubTypesOf(Identificable.class);
				// Elimina els recursos no utilitzats
				List<RecursEntity> recursEntities = recursRepository.findByEmbeddedClassNameStartingWith(moduleInfo.getDtoPackage());
				for (RecursEntity recursEntity: recursEntities) {
					boolean trobat = false;
					for (Class<? extends Identificable> dtoClass: dtoClasses) {
						if (dtoClass.getName().equals(recursEntity.getEmbedded().getClassName())) {
							trobat = true;
							break;
						}
					}
					if (!trobat) {
						recursRepository.delete(recursEntity);
					}
				}
				// Crea o modifica els demés recursos
				for (Class<? extends Identificable> dtoClass: dtoClasses) {
					Optional<RecursEntity> recursEntity = recursRepository.findByEmbeddedClassName(dtoClass.getName());
					if (!recursEntity.isPresent()) {
						recursEntity.get().getEmbedded().setNom(dtoClass.getSimpleName());
					} else {
						Recurs recurs = new Recurs();
						recurs.setNom(dtoClass.getSimpleName());
						recurs.setClassName(dtoClass.getName());
						recursRepository.save(RecursEntity.builder().embedded(recurs).build());
					}
				}
			}
			return new ActionExecutionResult(ActionExecutionState.OK, null, 0);
		} else {
			return super.execute(action, id);
		}
	}

}
