/**
 * 
 */
package es.limit.cecocloud.lici.logic.api.dto;

/**
 * Objecte de transferència que informa dels resultats d'una
 * actualització des de la plataforma de contractació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class MergeResult {

	private int created;
	private int updated;
	private int error;
	private int total;
	private long timeElapsedMs;

	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public int getUpdated() {
		return updated;
	}
	public void setUpdated(int updated) {
		this.updated = updated;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public long getTimeElapsedMs() {
		return timeElapsedMs;
	}
	public void setTimeElapsedMs(long timeElapsedMs) {
		this.timeElapsedMs = timeElapsedMs;
	}

}
