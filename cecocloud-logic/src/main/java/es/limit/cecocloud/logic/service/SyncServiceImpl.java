/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.SyncParam;
import es.limit.base.boot.logic.api.dto.SyncProcess;
import es.limit.base.boot.logic.api.dto.SyncTable;
import es.limit.base.boot.logic.api.dto.SyncTableResponse;
import es.limit.base.boot.logic.api.exception.SyncTableException;
import es.limit.base.boot.logic.api.exception.SyncTransactionException;
import es.limit.base.boot.logic.service.AbstractSyncServiceImpl;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.logic.api.service.DatabaseSyncService;
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
	private ApplicationContext applicationContext;
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected void validateProcess(SyncProcess syncProcess) throws SyncTransactionException {
		SyncParam identificadorCodiParam = syncProcess.getParam(IDENTIFICADOR_CODI_PARAM);
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
	protected SyncTableResponse syncTable(SyncTable table) throws SyncTableException {
		DatabaseSyncService syncService = null;
		for (es.limit.base.boot.logic.api.module.ModuleInfo module: Modules.registeredFindAll()) {
			if (module instanceof ModuleInfo) {
				ModuleInfo cecocloudModule = (ModuleInfo)module;
				if (cecocloudModule.getEmpresaIdentificadorSyncServiceClass() != null) {
					DatabaseSyncService candidateSyncService = applicationContext.getBean(cecocloudModule.getDatabaseSyncServiceClass());
					if (candidateSyncService.canSyncTableWithName(table.getName())) {
						syncService = candidateSyncService;
					}
				}
			}
		}
		if (syncService != null) {
			return syncService.syncTable(table);
		} else {
			throw new SyncTransactionException("No s'ha trobat cap servei de sincronització per la taula " + table.getName());
		}
	}

}