/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController("ecomInitialController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/init")
public class InitialApiController {
	
	/**
	 * Obtenició de les variables d'inicialització	 
	 * 
	 */
	@GetMapping(	
			produces = "application/json")
	public ResponseEntity<InitialPropertiesResponse> init() {		
		InitialPropertiesResponse initialPropertiesResponse = new InitialPropertiesResponse();		
		
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("init.properties"));
		  initialPropertiesResponse.setPuntVendaId(properties.getProperty("puntVendaId"));
		  initialPropertiesResponse.setIdentificadorId(properties.getProperty("identificadorId"));
		  initialPropertiesResponse.setEmpresaId(properties.getProperty("empresaId"));		
		} catch (IOException e) {			
			log.error("No s'ha trobat el fitxer: init.properties");
			return ResponseEntity.notFound().build();
		}
		
		
			
		return ResponseEntity.ok(initialPropertiesResponse);
	}
	
	@Getter @Setter
	@NoArgsConstructor
	public class InitialPropertiesResponse {

		private String puntVendaId;
		private String identificadorId;
		private String empresaId;		

	}

}