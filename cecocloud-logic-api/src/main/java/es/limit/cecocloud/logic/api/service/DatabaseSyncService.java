/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import es.limit.base.boot.logic.api.dto.SyncTable;
<<<<<<< HEAD
import es.limit.base.boot.logic.api.dto.SyncTransactionResponse;
=======
import es.limit.base.boot.logic.api.dto.SyncTableResponse;
>>>>>>> modul_cites

/**
 * Servei encarregat de sincronitzar les taules de base de dades.
 * 
 * @author Limit Tecnologies
 */
public interface DatabaseSyncService {

	/**
	 * Indica si aquest servei pot sincronitzar una taula donat el seu nom.
	 * 
	 * @param tableName
	 *            el nom de la taula.
	 * @return true si pot sincronitzar la taula o false en cas contrari.
	 */
	public boolean canSyncTableWithName(String tableName);

	/**
	 * Sincronitza files d'una taula de base de dades.
	 * 
	 * @param table
	 *            informació de sincronització de la taula.
	 * @return el resultat del procés de sincronització.
	 */
<<<<<<< HEAD
	public SyncTransactionResponse syncTable(SyncTable table);
=======
	public SyncTableResponse syncTable(SyncTable table);
>>>>>>> modul_cites

}
