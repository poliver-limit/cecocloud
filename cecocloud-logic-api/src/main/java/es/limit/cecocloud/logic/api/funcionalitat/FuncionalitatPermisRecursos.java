package es.limit.cecocloud.logic.api.funcionalitat;

import java.util.List;

import lombok.Data;

@Data
public class FuncionalitatPermisRecursos {
	
	FuncionalitatPermis permis;
	List<RecursPermisos> recursPermisos;
}
