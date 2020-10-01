/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de usuari del grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factUsuariGrupController")
@RequestMapping(FactModuleConfig.API_PATH + "/usuarisGrup")
public class UsuariGrupApiController extends AbstractIdentificableWithIdentificadorApiController<UsuariGrup> {

}