/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class PaycometNotification {
	
	
	
//	@NotNull
//	@Size(max = 255)
//	private String orderNumber;
	
	@NotNull
	private int transactionType;

	@NotNull
	@Size(max = 255)
	private String transactionName;
	
	@NotNull
	@Size(max = 255)
	private String cardCountry;
	
	@NotNull
	@Size(max = 255)
	private String bankDateTime;
	
	
	
	@NotNull
	@Size(max = 255)
	private String response;
	
	@NotNull
	private int errorID;
	
	@NotNull
	@Size(max = 255)
	private String errorDescription;
	
	@NotNull
	@Size(max = 255)
	private String authCode;
	
	@NotNull
	@Size(max = 255)
	private String currency;
	
	@NotNull
	private int amount;
	
	@NotNull
	private int amountEur;
	
	@NotNull
	@Size(max = 255)
	private String accountCode;
	
	@NotNull
	private int tpvID;
	
	@NotNull
	@Size(max = 255)
	private String concept;

	@NotNull
	private int idUser;
	
	@NotNull
	@Size(max = 255)
	private String tokenUser;
	
	@NotNull
	@Size(max = 255)
	private String securePayment;
	
	@NotNull
	@Size(max = 255)
	private String cardBrand;
	
	@NotNull
	@Size(max = 255)
	private String bicCode;
	
	@NotNull
	private int scoring;
	
	@NotNull
	@Size(max = 255)
	private String notificationHash;
	
	

	
	
	
	

}
