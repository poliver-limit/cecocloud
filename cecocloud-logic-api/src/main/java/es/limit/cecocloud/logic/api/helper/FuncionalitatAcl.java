package es.limit.cecocloud.logic.api.helper;

public interface FuncionalitatAcl {
	
	public void updatePermisosRemoveRecurs(String resourceClassName);
	public void updatePermisosFuncionalitatRecurs(Long funcionalitatId) throws ClassNotFoundException;
	public void refreshPermisosIdentificador(Long identificadorId) throws ClassNotFoundException;
	public void refreshPermisosPerfil(Long perfilId) throws ClassNotFoundException;

}
