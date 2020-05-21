/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.exception.EntityAlreadyExistsException;
import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.PaycometNotification;
import es.limit.cecocloud.ecom.back.ecommerce.service.PaycometNotificationService;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("paycometNotificationEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/paycomet")
public class PaycometNotificationApiController {
	
	private final PaycometNotificationService paycometNotificationService;

	public PaycometNotificationApiController(PaycometNotificationService paycometNotificationService) {
		super();
		this.paycometNotificationService = paycometNotificationService;
	}

	@PostMapping(value = "/create")
    public void createProviderCodeHistory(@Valid @RequestBody final PaycometNotification paycometNotification) throws EntityAlreadyExistsException {
        this.paycometNotificationService.create(paycometNotification);
    }
    
	
	

}