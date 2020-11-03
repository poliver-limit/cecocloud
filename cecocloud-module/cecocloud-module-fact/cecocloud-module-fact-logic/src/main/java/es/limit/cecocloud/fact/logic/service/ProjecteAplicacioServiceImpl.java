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
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio.ProjecteAplicacioPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AplicacioTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.service.ProjecteAplicacioService;
import es.limit.cecocloud.fact.persist.entity.ParameterEntity;
import es.limit.cecocloud.fact.persist.entity.ProjecteAplicacioEntity;
import es.limit.cecocloud.fact.persist.repository.ParameterRepository;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de projecte aplicacio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteAplicacioServiceImpl extends AbstractGenericCompositePkServiceImpl<ProjecteAplicacio, ProjecteAplicacioEntity, ProjecteAplicacioPk> implements ProjecteAplicacioService {
	
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
	protected ProjecteAplicacioPk getPkFromDto(ProjecteAplicacio dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());		
		return new ProjecteAplicacioPk(
				identificador.getEmbedded().getCodi(),
				empresa.getEmbedded().getCodi(),
				dto.getProjecte().getPk().getCodi(),
				dto.getCodi());
				
	}
	
	@Override
	protected List<DynamicEnumItem> getDynamicEnumValues(String code) {
		
		List<DynamicEnumItem> dynamicEnumItemList = null;
		
		AplicacioTipusEnumDto[] aplicacioTipusEnumDtoList = AplicacioTipusEnumDto.values();		
		
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
				int index = 0;
				String[] valors = valorsST.split(";");
				if (valors.length>0) {
					dynamicEnumItemList = new ArrayList<DynamicEnumItem>();	
					while ((index<aplicacioTipusEnumDtoList.length)&&(index<valors.length)){					
						dynamicEnumItemList.add(new DynamicEnumItem(aplicacioTipusEnumDtoList[index].name(), valors[index]));
						index++;
					}
				}
			}
		}			
		
		return dynamicEnumItemList;
	}


}
