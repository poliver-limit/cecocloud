/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.CompteCorrentEmpresa.CompteCorrentEmpresaPk;
import es.limit.cecocloud.fact.logic.api.service.CompteCorrentEmpresaService;
import es.limit.cecocloud.fact.persist.entity.CompteCorrentEmpresaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors-client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CompteCorrentEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<CompteCorrentEmpresa, CompteCorrentEmpresaEntity, CompteCorrentEmpresaPk> implements CompteCorrentEmpresaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected CompteCorrentEmpresaPk getPkFromDto(CompteCorrentEmpresa dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());	
		return new CompteCorrentEmpresaPk(
				identificador.getEmbedded().getCodi(),
				dto.getBanc().getPk().getCodi(),
				dto.getClient().getPk().getCodi(),
				dto.getEmpresa().getPk().getCodi(),
				dto.getOficinaBancaria().getPk().getCodi(),
				dto.getNumeroCompteCorrent(),
				dto.getDigitControl());
	}

}
