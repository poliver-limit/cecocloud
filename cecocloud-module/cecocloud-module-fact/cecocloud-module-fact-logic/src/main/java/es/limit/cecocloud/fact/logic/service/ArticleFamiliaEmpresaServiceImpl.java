/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.ArticleFamiliaEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.ArticleFamiliaEmpresa.ArticleFamiliaEmpresaPk;
import es.limit.cecocloud.fact.logic.api.service.ArticleFamiliaEmpresaService;
import es.limit.cecocloud.fact.persist.entity.ArticleFamiliaEmpresaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.entity.EmpresaEntity;


/**
 * Implementació del servei de gestió de articles familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleFamiliaEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleFamiliaEmpresa, ArticleFamiliaEmpresaEntity, ArticleFamiliaEmpresaPk> implements ArticleFamiliaEmpresaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected ArticleFamiliaEmpresaPk getPkFromDto(ArticleFamiliaEmpresa dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new ArticleFamiliaEmpresaPk(
				dto.getIdentificador().getId(),				
				dto.getArticleFamilia().getPk().getCodi(),
				empresa.getEmbedded().getCodi());
	}

}
