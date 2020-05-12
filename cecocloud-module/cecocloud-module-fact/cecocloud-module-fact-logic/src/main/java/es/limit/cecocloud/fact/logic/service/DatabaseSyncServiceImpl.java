/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.SyncTable;
<<<<<<< HEAD
import es.limit.base.boot.logic.api.dto.SyncTransactionResponse;
=======
import es.limit.base.boot.logic.api.dto.SyncTableResponse;
>>>>>>> modul_cites
import es.limit.cecocloud.logic.api.service.DatabaseSyncService;

/**
 * Implementació del servei de sincronització de base de dades pel mòdul de
 * facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factDatabaseSyncServiceImpl")
public class DatabaseSyncServiceImpl implements DatabaseSyncService {

	@Override
	public boolean canSyncTableWithName(String tableName) {
		return false;
	}

	@Override
<<<<<<< HEAD
	public SyncTransactionResponse syncTable(SyncTable table) {
=======
	public SyncTableResponse syncTable(SyncTable table) {
>>>>>>> modul_cites
		return null;
	}

}
