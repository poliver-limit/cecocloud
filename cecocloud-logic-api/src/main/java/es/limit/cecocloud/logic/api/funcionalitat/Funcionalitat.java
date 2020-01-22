package es.limit.cecocloud.logic.api.funcionalitat;

import java.util.List;

import lombok.Data;

@Data
public class Funcionalitat {

	Long id;
	String codi;
	String descripcio;
	String modul;
	FuncionalitatTipus tipus;
	List<FuncionalitatPermisRecursos> permisRecursos;
	
}
