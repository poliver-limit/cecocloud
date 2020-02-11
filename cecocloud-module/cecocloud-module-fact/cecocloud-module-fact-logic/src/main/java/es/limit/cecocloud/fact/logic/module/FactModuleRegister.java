/**
 * 
 */
package es.limit.cecocloud.fact.logic.module;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.fact.logic.api.dto.Article;
import es.limit.cecocloud.fact.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.fact.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.fact.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.fact.logic.api.dto.ArticleModel;
import es.limit.cecocloud.fact.logic.api.dto.FamiliaCost;
import es.limit.cecocloud.fact.logic.api.dto.Iva;
import es.limit.cecocloud.fact.logic.api.dto.Zona;
import es.limit.cecocloud.fact.logic.service.EmpresaIdentificadorSyncServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatTipus;
import es.limit.cecocloud.logic.api.module.FuncionalitatCodiFontImpl;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.logic.api.module.ModuleInfo;
import es.limit.cecocloud.logic.api.module.Modules;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;

/**
 * Registre del mòdul de facturació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FactModuleRegister {

	private static ModuleInfo moduleInfo = new ModuleInfo(
			Modul.fact,
			Zona.class.getPackage().getName(),
			EmpresaIdentificadorSyncServiceImpl.class,
			Arrays.asList(
					new FuncionalitatCodiFontImpl(
							"ART",
							FuncionalitatTipus.MANTENIMENT,
							"Articles",
							Modul.fact,
							Arrays.asList(Article.class),
							Arrays.asList(ArticleFamilia.class, Iva.class, ArticleModel.class, ArticleGamma.class, ArticleMarca.class)),
					new FuncionalitatCodiFontImpl(
							"FART",
							FuncionalitatTipus.MANTENIMENT,
							"Famílies d'articles",
							Modul.fact,
							Arrays.asList(ArticleFamilia.class),
							Arrays.asList(RecursGrup.class, FamiliaCost.class)),
					new FuncionalitatCodiFontImpl(
							"GART",
							FuncionalitatTipus.MANTENIMENT,
							"Gammes d'articles",
							Modul.fact,
							Arrays.asList(ArticleGamma.class),
							Arrays.asList()),
					new FuncionalitatCodiFontImpl(
							"IVA",
							FuncionalitatTipus.MANTENIMENT,
							"IVAs",
							Modul.fact,
							Arrays.asList(Iva.class),
							Arrays.asList())
					));

	static {
		Modules.registerModule(moduleInfo);
	}

	public static ModuleInfo getModuleInfo() {
		return moduleInfo;
	}

}
