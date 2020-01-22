package es.limit.cecocloud.logic.api.funcionalitat;

import java.util.List;

import lombok.Data;

@Data
public class RecursPermisos {

	private String recursModul;
	private String recursName;
	// Possibles valors
	// - R: Read 
	// - W: Write 
	// - C: Create 
	// - D: Delete
	// - A: Administration
	// - S: Syncronization
	// - P: Print
	// - E: accEs
	private List<String> granted;
	
	public boolean isReadGranted() {
		return granted.contains("R");
	};
	public boolean isWriteGranted() {
		return granted.contains("W");
	};
	public boolean isCreateGranted() {
		return granted.contains("C");
	};
	public boolean isDeleteGranted() {
		return granted.contains("D");
	};
	public boolean isAdminGranted() {
		return granted.contains("A");
	};
	public boolean isSyncGranted() {
		return granted.contains("S");
	};
	public boolean isPrintGranted() {
		return granted.contains("P");
	};
	public boolean isAccessGranted() {
		return granted.contains("E");
	};
	
}
