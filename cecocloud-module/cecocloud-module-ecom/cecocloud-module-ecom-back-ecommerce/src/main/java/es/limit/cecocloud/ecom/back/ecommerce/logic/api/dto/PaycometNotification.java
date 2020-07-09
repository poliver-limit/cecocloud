/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@JsonDeserialize(builder = PaycometNotification.PaycometNotificationBuilder.class)
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class PaycometNotification {	
	
	public PaycometNotification(){
		}
		
	@NotNull	
	@Size(max = 255)
	protected String Order;
	
	@NotNull
	private int TransactionType;

	@NotNull
	@Size(max = 255)
	private String TransactionName;
	
	@NotNull
	@Size(max = 255)
	private String CardCountry;
	
	@NotNull
	@Size(max = 255)
	private String BankDateTime;	
	
	@NotNull
	@Size(max = 255)
	private String Response;
	
	@NotNull
	private int ErrorID;
	
	@NotNull
	@Size(max = 255)
	private String ErrorDescription;
	
	@NotNull
	@Size(max = 255)
	private String AuthCode;
	
	@NotNull
	@Size(max = 255)
	private String Currency;
	
	@NotNull
	private int Amount;
	
	@NotNull
	private int AmountEur;
	
	@NotNull
	@Size(max = 255)
	private String AccountCode;
	
	@NotNull
	private int TpvID;
	
	@NotNull
	@Size(max = 255)
	private String Concept;

	@NotNull
	private int IdUser;
	
	@NotNull
	@Size(max = 255)
	private String TokenUser;
	
	@NotNull
	@Size(max = 255)
	private String SecurePayment;
	
	@NotNull
	@Size(max = 255)
	private String CardBrand;
	
	@NotNull
	@Size(max = 255)
	private String BicCode;
	
	@NotNull
	private int Scoring;
	
	@NotNull
	@Size(max = 255)
	private String NotificationHash;	
	
	@JsonPOJOBuilder(withPrefix = "")
    public static class PaycometNotificationBuilder {
    }

}