/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.PaycometNotification;
import es.limit.cecocloud.ecom.back.ecommerce.service.PaycometNotificationService;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("paycometNotificationEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/paycomet")
@Slf4j

public class PaycometNotificationApiController {
	
	private final PaycometNotificationService paycometNotificationService;

	public PaycometNotificationApiController(PaycometNotificationService paycometNotificationService) {
		super();
		this.paycometNotificationService = paycometNotificationService;
	}

//	@PostMapping(value = "/create", produces = "application/json")
//	@ResponseBody
//    public  ResponseEntity<Object> create(final PaycometNotification paycometNotification) throws EntityAlreadyExistsException {
//		log.info("Notificacio de PayTPV rebuda: " + paycometNotification);
//		ResponseEntity<Object> resposta = new ResponseEntity<Object>("OK", HttpStatus.OK);
//		try {
//			this.paycometNotificationService.create(paycometNotification);
//		} catch(Exception e) {
//			log.error("Error processant la notificació de PayTPV: " + e.getMessage(), e);
//			resposta = new ResponseEntity<Object>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}	
//		
//		return resposta;
//	}
	
	/** Mètode per centralitzar les notificacions rebudes per part de PayTPV. Un exemple de notificació
	 * correcta de pagament seria la següent: 
	 * {TransactionType=1, TransactionName=Autorización, CardCountry=, BankDateTime=20190227092904, 
	 * Signature=d5cc5a3c8961d4a4d4a37d23374f5536, Order=1551256101, Response=OK, ErrorID=0, ErrorDescription=Sin error, 
	 * AuthCode=491538/543544003965196579516844890155, Currency=EUR, Amount=3000, AmountEur=30, Language=es, AccountCode=ktd5142s, 
	 * TpvID=6871, Concept=Tiquet coves, ExtendedSignature=2a0acea6c857de0155bdb6c0bfa89906, IdUser=16866788, 
	 * TokenUser=VGpaNVhTNXhXa0l, SecurePayment=1, CardBrand=VISA, BicCode=PAYTPVMMXXX, sepaCard=1, cardType=CREDIT, cardCategory=BUSINESS}
	 * 
	 * @param params
	 * @param request
	 * @throws InterruptedException
	 */
	@PostMapping( value = "/create", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> notificacionsPayTPV(
			@RequestParam(required = false) Map<String, String> params,
			HttpServletRequest request
			) throws InterruptedException {
		// Log de la petició
		log.info("Notificacio de PayTPV rebuda: " + params);
		
		
		ResponseEntity<Object> resposta = new ResponseEntity<Object>("OK", HttpStatus.OK);

		// Tractament de la notificació segons el tipus de notificació
		try {
			String transactionType = params.get("TransactionType");
			switch(transactionType) {
			case "1":
				// Autorització d'un pagament
				PaycometNotification paycometNotification = getNotificacion(params);
				this.paycometNotificationService.create(paycometNotification);
				break;
			case "2": // Devolución
			case "3": // Preautorización
			case "4": // Cancelación de preautorización
			case "6": // Confirmación de preautorización
			case "9": // Suscripción
			case "13": // Preautorización diferida
			case "14": // Cancelación de preautorización diferida
			case "16": // Confirmación de preautorización diferida
			case "106": // Retroceso
			case "107": // Alta de usuario Bankstore
			case "108": // Caducidad de Tarjeta
				break;
			default:
				// Opció no implementada
				resposta = new ResponseEntity<Object>("TransactionType no soportado", HttpStatus.NOT_IMPLEMENTED);
				break;
			}
		} catch(Exception e) {
			log.error("Error processant la notificació de PayTPV: " + e.getMessage(), e);
			resposta = new ResponseEntity<Object>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return resposta;
		
	}
	 private  PaycometNotification getNotificacion(Map<String, String> params) {
		 PaycometNotification paycometNotification = PaycometNotification.builder()
				 .TransactionType(Integer.parseInt(params.get("TransactionType")))
				 .TransactionName(params.get("TransactionName"))
				 .Order(params.get("Order"))
				 .Response(params.get("Response"))
				 .ErrorID(Integer.parseInt(params.get("ErrorID")))
				 .ErrorDescription(params.get("ErrorDescription"))
				 .AuthCode(params.get("AuthCode"))
				 .Currency(params.get("Currency"))
				 .Amount(Integer.parseInt(params.get("Amount")))
				 .AmountEur(Integer.parseInt(params.get("AmountEur")))
				 .AccountCode(params.get("AccountCode"))
				 .Concept(params.get("Concept"))
				 .NotificationHash(params.get("NotificationHash"))
				 .TokenUser(params.get("TokenUser"))
				 .CardBrand(params.get("CardBrand"))
				 .BicCode(params.get("BicCode"))
				 .SecurePayment(params.get("SecurePayment"))
				 .TokenUser(params.get("TokenUser"))
				 .BankDateTime(params.get("BankDateTime"))
				 .CardCountry(params.get("CardCountry").length()!=0?params.get("CardCountry"):"ES")
				 .TpvID(Integer.parseInt(params.get("TpvID")))
				 .IdUser(Integer.parseInt(params.get("IdUser")))
				 .build();
		 return paycometNotification;
		 
	 }
}
	

