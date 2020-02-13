/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.OperariEmpresaService;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.repository.OperariEmpresaRepository;

/**
 * Implementació del servei encarregat de gestionar relacions operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OperariEmpresaServiceImpl extends AbstractGenericServiceImpl<OperariEmpresa, OperariEmpresaEntity, Long> implements OperariEmpresaService {

	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Override
	public OperariEmpresa findByCurrentUserAndSession() {
		UserSession session = (UserSession)authenticationHelper.getSession();
		Optional<IdentificadorEntity> identificador = identificadorRepository.findById(session.getI());
		Optional<EmpresaEntity> empresa = empresaRepository.findById(session.getE());
		return toDto(
				((OperariEmpresaRepository)getRepository()).findByOperariIdentificadorAndOperariEmbeddedActiuAndOperariUsuariEmbeddedCodiAndEmpresaAndEmpresaActiva(
						identificador.get(),
						true,
						authenticationHelper.getPrincipalName(),
						empresa.get(),
						true).get());
	}

}

