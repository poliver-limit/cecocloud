/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.api.dto.SyncTable;
import es.limit.base.boot.logic.api.dto.SyncTransactionResponse;
import es.limit.cecocloud.logic.api.service.DatabaseSyncService;

/**
 * Implementació del servei de sincronització de base de dades pel mòdul de
 * ecommerce.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomDatabaseSyncServiceImpl")
public class DatabaseSyncServiceImpl implements DatabaseSyncService {

	@Override
	public boolean canSyncTableWithName(String tableName) {
		return false;
	}

	@Override
	public SyncTransactionResponse syncTable(SyncTable table) {
		return null;
	}

}