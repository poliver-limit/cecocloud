/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.DocumentPagamentCobrament;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesMarca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomDocumentPagamentCobramentController")
@RequestMapping(EcomModuleConfig.API_PATH + "/documentsPagamentCobrament")
public class DocumentPagamentCobramentApiController extends AbstractIdentificableWithIdentificadorApiController<DocumentPagamentCobrament> {

}
