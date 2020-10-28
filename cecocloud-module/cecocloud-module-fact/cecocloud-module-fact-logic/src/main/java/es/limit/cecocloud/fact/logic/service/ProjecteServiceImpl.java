/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.DynamicEnumItem;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Projecte;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.service.ProjecteService;
import es.limit.cecocloud.fact.persist.entity.ParameterEntity;
import es.limit.cecocloud.fact.persist.entity.ProjecteEntity;
import es.limit.cecocloud.fact.persist.repository.ParameterRepository;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteServiceImpl extends AbstractGenericCompositePkServiceImpl<Projecte, ProjecteEntity, ProjectePk> implements ProjecteService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private ParameterRepository parameterRepository;
	@Autowired
	private es.limit.cecocloud.fact.persist.repository.IdentificadorRepository identificadorRepositoryFact;

	@Override
	protected ProjectePk getPkFromDto(Projecte dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new ProjectePk(
				identificador.getEmbedded().getCodi(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}
	
	@Override
	protected List<DynamicEnumItem> getDynamicEnumValues(String code) {
		
		List<DynamicEnumItem> dynamicEnumItemList = null;
		
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		Optional<es.limit.cecocloud.fact.persist.entity.IdentificadorEntity> identificadorFactDb = identificadorRepositoryFact.findByEmbeddedCodi(identificador.getEmbedded().getCodi());
		es.limit.cecocloud.fact.persist.entity.IdentificadorEntity identificadorFact;			
		if (identificadorFactDb.isPresent()) {			
			identificadorFact = (es.limit.cecocloud.fact.persist.entity.IdentificadorEntity)identificadorFactDb.get();
			Optional<ParameterEntity> parameterDb = parameterRepository.findByIdentificadorAndEmbeddedCodi(identificadorFact,code);
			if (parameterDb.isPresent()) {			
				ParameterEntity parameter = (ParameterEntity)parameterDb.get();
				String valorsST = parameter.getEmbedded().getValue();
				int index = 1;
				String[] valors = valorsST.split(";");
				if (valors.length>0) {
					dynamicEnumItemList = new ArrayList<DynamicEnumItem>();	
					for (String valor: valors) {
						dynamicEnumItemList.add(new DynamicEnumItem(String.valueOf(index), valor));
						index++;
					}
				}
			}
		}			
		
		return dynamicEnumItemList;
	}

}