/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import es.limit.cecocloud.ecom.back.ecommerce.logic.api.dto.PaycometNotification;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomPaycometNotification")
@Table(
		name = "paycomet_notification",
		indexes = {
				@Index(name = "orderNumber_fk", columnList = "orderNumber")
		}
)
@AttributeOverrides({

	@AttributeOverride(name = "embedded.transactionType", column = @Column(name = "transactionType", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.transactionName", column = @Column(name = "transactionName", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.cardCountry", column = @Column(name = "cardCountry", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.bankDateTime", column = @Column(name = "bankDateTime", length = 255, updatable = false, nullable = false)),
//	@AttributeOverride(name = "orderNumber", column = @Column(name = "orderNumber", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.response", column = @Column(name = "response", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.errorID", column = @Column(name = "errorID", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.errorDescription", column = @Column(name = "errorDescription", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.authCode", column = @Column(name = "authCode", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.currency", column = @Column(name = "currency", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.amount", column = @Column(name = "amount", updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.amountEur", column = @Column(name = "amountEur",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.accountCode", column = @Column(name = "accountCode",  length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.tpvID", column = @Column(name = "tpvID",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.concept", column = @Column(name = "concept", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.idUser", column = @Column(name = "idUser",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.tokenUser", column = @Column(name = "tokenUser", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.securePayment", column = @Column(name = "securePayment",  updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.cardBrand", column = @Column(name = "cardBrand", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.bicCode", column = @Column(name = "bicCode", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.scoring", column = @Column(name = "scoring", length = 255, updatable = false, nullable = false)),
	@AttributeOverride(name = "embedded.notificationHash", column = @Column(name = "notificationHash", length = 255, updatable = false, nullable = false))


})
public class PaycometNotificationEntity{

	@NotNull
	@Id
	@Column(name = "orderNumber")
	private String orderNumber;

	@Embedded
	protected PaycometNotification embedded;
	
	@Builder
	public PaycometNotificationEntity(			
			PaycometNotification embedded
			) {
	this.embedded = embedded;	
		
	}


}
