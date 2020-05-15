/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.base.boot.logic.api.dto.SyncParam;
import es.limit.base.boot.logic.api.dto.SyncProcess;
import es.limit.base.boot.logic.api.exception.SyncTransactionException;
import es.limit.base.boot.logic.service.AbstractSyncServiceImpl;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei encarregat de sincronitzar informació.
 * 
 * @author Limit Tecnologies
 */
@Service
public class SyncServiceImpl extends AbstractSyncServiceImpl {

	private static final String IDENTIFICADOR_CODI_PARAM = "identificadorCodi";

	@Autowired
	private IdentificadorRepository identificadorRepository;

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

}
