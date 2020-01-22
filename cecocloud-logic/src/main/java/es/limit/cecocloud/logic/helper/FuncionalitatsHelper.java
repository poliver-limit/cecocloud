package es.limit.cecocloud.logic.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import es.limit.base.boot.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.funcionalitat.Funcionalitat;
import es.limit.cecocloud.logic.api.funcionalitat.FuncionalitatPermisRecursos;
import es.limit.cecocloud.logic.api.funcionalitat.RecursPermisos;
import es.limit.cecocloud.logic.api.module.Modules;

public class FuncionalitatsHelper {

	private static Map<ModuleInfo, List<Funcionalitat>> funcionalitats;
	
	public static Map<ModuleInfo, List<Funcionalitat>> getFuncionalitats() {
		
		if (funcionalitats == null) 
			carregaFuncionalitats();
			
		return funcionalitats;
		
	}
	
	public static List<Funcionalitat> getFuncionalitatsByModul(ModuleInfo modul) {
		
		if (funcionalitats == null)
			carregaFuncionalitats();
		
		return funcionalitats.get(modul);
	}
	
	private static void carregaFuncionalitats() {
		
		Constructor constructor = new Constructor(Funcionalitat.class);
		TypeDescription funcionalitatTypeDescription = new TypeDescription(Funcionalitat.class);
		TypeDescription funcionalitatPermisTypeDescription = new TypeDescription(FuncionalitatPermisRecursos.class);
		funcionalitatPermisTypeDescription.addPropertyParameters("recursPermisos", RecursPermisos.class);
		funcionalitatTypeDescription.addPropertyParameters("permisRecursos", FuncionalitatPermisRecursos.class);
		constructor.addTypeDescription(funcionalitatTypeDescription);
		constructor.addTypeDescription(funcionalitatPermisTypeDescription);
		Yaml yaml = new Yaml(constructor);
		
		InputStream inputStream = Funcionalitat.class
				.getClassLoader()
				.getResourceAsStream("funcionalitats.yaml");
		
		funcionalitats = new HashMap<ModuleInfo, List<Funcionalitat>>();
		List<ModuleInfo> registeredModules = Modules.registeredFindAll();
		
		for (ModuleInfo modul: registeredModules) {
			funcionalitats.put(modul, new ArrayList<Funcionalitat>());
		}
	 
	    Iterable<Object> itFunc = yaml.loadAll(inputStream);
	    itFunc.forEach(obj -> {
	    	Funcionalitat func = (Funcionalitat)obj;
	    	Optional<ModuleInfo> modul = Modules.registeredGetOne(func.getModul());
	    	if (modul.isPresent())
	    		funcionalitats.get(modul.get()).add(func);
	    });
	    
	}
	
}
