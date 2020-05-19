/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.PeuDocument;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de PeuDocument.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPeuDocumentController")
@RequestMapping(EcomModuleConfig.API_PATH + "/peusDocument")
public class PeuDocumentApiController extends AbstractIdentificableWithIdentificadorApiController<PeuDocument> {

}
