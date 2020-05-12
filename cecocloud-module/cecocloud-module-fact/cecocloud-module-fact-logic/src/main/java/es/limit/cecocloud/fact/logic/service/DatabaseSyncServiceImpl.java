/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.SyncTable;
import es.limit.base.boot.logic.api.dto.SyncTableResponse;
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
	public SyncTableResponse syncTable(SyncTable table) {
		return null;
	}

}
