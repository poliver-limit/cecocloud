/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.dto.SyncParam;
import es.limit.base.boot.logic.api.dto.SyncProcess;
import es.limit.base.boot.logic.api.exception.SyncTransactionException;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractSyncServiceImpl;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei encarregat de sincronitzar informació.
 * 
 * @author Limit Tecnologies
 */
@Service
public class SyncServiceImpl extends AbstractSyncServiceImpl {

	private static final String IDENTIFICADOR_CODI_PARAM = "identificadorCodi";
	private static final String EMPRESA_CODI_PARAM = "empresaCodi";

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	@Transactional(readOnly = true)
	public void doBeforeTransaction(SyncProcess process) {
		SyncParam identificadorCodiParam = process.getParam(IDENTIFICADOR_CODI_PARAM);
		String identificadorCodi = (identificadorCodiParam != null) ? (String)identificadorCodiParam.getValue() : null;
		if (identificadorCodi != null) {
			Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(identificadorCodi);
			SyncParam empresaCodiParam = process.getParam(EMPRESA_CODI_PARAM);
			String empresaCodi = (empresaCodiParam != null) ? (String)empresaCodiParam.getValue() : null;
			UserSession session;
			if (empresaCodi != null) {
				Optional<EmpresaEntity> empresa = empresaRepository.findByIdentificadorAndEmbeddedCodi(
						identificador.get(),
						empresaCodi);
				session = new UserSession(
						identificador.get().getId(),
						empresa.get().getId());
			} else {
				session = new UserSession(
						identificador.get().getId(),
						null);
			}
			authenticationHelper.setSession(session);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public void validate(SyncProcess process) throws SyncTransactionException {
		SyncParam identificadorCodiParam = process.getParam(IDENTIFICADOR_CODI_PARAM);
		if (identificadorCodiParam == null || identificadorCodiParam.getValue() == null || identificadorCodiParam.getValue().toString().isEmpty()) {
			throw new SyncTransactionException("Error de validació de la transacció: no s'ha especificat el paràmetre " + IDENTIFICADOR_CODI_PARAM);
		} else {
			@SuppressWarnings("unused")
			Optional<IdentificadorEntity> identificador = identificadorRepository.findByEmbeddedCodi(
					identificadorCodiParam.getValue().toString());
			// TODO verificar permisos sobre l'identificador
		}
	}

	@Override
	public void doAfterTransaction(SyncProcess process) {
	}

	@Override
	public String getParams(SyncProcess process) {
		
		String paramsST = "";
		List<SyncParam> params = process.getParams();
		
		try {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream( baos );
	        oos.writeObject( params );
	        oos.close();
	        paramsST = Base64.getEncoder().encodeToString(baos.toByteArray());
		} catch (IOException ex) {
			throw new RuntimeException("Error al serialitzar els paràmetres: " + ex);
		}
	    
		return paramsST;
	}

}